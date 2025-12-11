package com.mlog.backend.content_service.config;

import org.jspecify.annotations.NullMarked;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // Trong ví dụ này, chúng ta giả lập là "system" hoặc một ID người dùng cố định.
        // Bạn có thể thay đổi để lấy author_id nếu bạn có cơ chế xác thực.
        // TODO: Lấy author_id từ ngữ cảnh bảo mật hoặc phiên người dùng hiện tại
        return Optional.of("SYSTEM_USER_001");
    }
}