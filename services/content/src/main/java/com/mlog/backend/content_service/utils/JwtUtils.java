package com.mlog.backend.content_service.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Map;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    private final ObjectMapper objectMapper;

    /**
     * Decodes a base64-encoded user info header and retrieves a specific claim.
     * This method is generic and can return complex types like Lists or Maps.
     *
     * @param userInfoHeader The base64-encoded header string.
     * @param key            The key of the claim to retrieve (e.g., "sub", "realm_access").
     * @param valueType      The class of the value you expect to get back.
     * @param <T>            The generic type of the claim value.
     * @return An Optional containing the claim value if found and valid, otherwise empty.
     */
    public <T> Optional<T> getClaim(String userInfoHeader, String key, Class<T> valueType) {
        if (userInfoHeader == null || userInfoHeader.isBlank()) {
            return Optional.empty();
        }

        try {
            // 1. Decode the Base64 Header
            byte[] decodedBytes = Base64.getDecoder().decode(userInfoHeader);
            String userInfoJson = new String(decodedBytes);

            // 2. Parse into a generic Map
            Map<String, Object> claims = objectMapper.readValue(userInfoJson, new TypeReference<>() {
            });

            // 3. Get the specific claim by key
            Object claimValue = claims.get(key);
            if (claimValue == null) {
                return Optional.empty();
            }

            // 4. Convert the object to the desired type and return
            return Optional.of(objectMapper.convertValue(claimValue, valueType));

        } catch (IllegalArgumentException | JsonProcessingException e) {
            logger.error("Failed to decode or parse user info header", e);
            return Optional.empty();
        }
    }

    /**
     * A convenience method to get a claim's value directly as a String.
     *
     * @param userInfoHeader The base64-encoded header string.
     * @param key            The key of the claim to retrieve.
     * @return An Optional containing the claim value as a String if found, otherwise empty.
     */
    public Optional<String> getClaimAsString(String userInfoHeader, String key) {
        return getClaim(userInfoHeader, key, String.class);
    }
}
