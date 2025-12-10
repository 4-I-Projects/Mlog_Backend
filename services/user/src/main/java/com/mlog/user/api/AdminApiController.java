package com.mlog.user.api;

import com.mlog.user.model.BanUserRequest;
import com.mlog.user.model.UnbanUserRequest;


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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-04T10:07:53.173542+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
@Controller
@RequestMapping("${openapi.mlog.base-path:}")
public class AdminApiController implements AdminApi {

    private final AdminApiDelegate delegate;

    public AdminApiController(@Autowired(required = false) AdminApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new AdminApiDelegate() {});
    }

    @Override
    public AdminApiDelegate getDelegate() {
        return delegate;
    }

}
