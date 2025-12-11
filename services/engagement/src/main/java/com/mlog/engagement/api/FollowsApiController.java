package com.mlog.engagement.api;

import org.springframework.lang.Nullable;
import com.mlog.engagement.model.UserListResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T14:36:31.411887001+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
@Controller
@RequestMapping("${openapi.mlog.base-path:}")
public class FollowsApiController implements FollowsApi {

    private final FollowsApiDelegate delegate;

    public FollowsApiController(@Autowired(required = false) FollowsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new FollowsApiDelegate() {});
    }

    @Override
    public FollowsApiDelegate getDelegate() {
        return delegate;
    }

}
