package com.mlog.backend.content_service.config;

import com.mlog.backend.content_service.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AuditorAwareImpl implements AuditorAware<String> {

    private final HttpServletRequest request;
    private final JwtUtils jwtUtils;

    @Override
    public Optional<String> getCurrentAuditor() {
        // 1. Lấy Header Authorization từ request hiện tại
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // 2. Loại bỏ tiền tố "Bearer " để lấy chuỗi JWT
            String token = authHeader.substring(7);

            // 3. Phân tách JWT để lấy phần Payload (Phần thứ 2)
            // JWT có cấu trúc: Header.Payload.Signature
            String[] parts = token.split("\\.");
            if (parts.length < 2) {
                return Optional.of("SYSTEM");
            }

            String payload = parts[1];

            // 4. Sử dụng JwtUtils để parse "sub" (thường là User ID) từ Payload
            // Nếu bạn dùng key khác như "user_id" hoặc "id", hãy thay thế vào đây
            return jwtUtils.getClaimAsString(payload, "sub")
                    .or(() -> Optional.of("SYSTEM"));
        }

        // Trả về SYSTEM nếu không có token (ví dụ: các tác vụ hệ thống tự động)
        return Optional.of("SYSTEM");
    }
}