package com.mlog.backend.content_service.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class CloudStorageService {

    @Value("${gcp.storage.bucket-name}")
    private String bucketName;

    @Value("${gcp.storage.credentials-path}")
    private String credentialsPath;

    private final ResourceLoader resourceLoader;

    public CloudStorageService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String uploadFile(MultipartFile file) throws IOException {
        // 1. Khởi tạo Storage với file credentials
        Resource resource = resourceLoader.getResource(credentialsPath);
        Storage storage = StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(resource.getInputStream()))
                .build()
                .getService();

//        // Nếu không tìm thấy file credentials, mặc định nó sẽ dùng tài khoản đã login trên máy
//        Storage storage = StorageOptions.getDefaultInstance().getService();

        // 2. Tạo tên file duy nhất để tránh trùng lặp
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        // 3. Cấu hình thông tin file (BlobId và BlobInfo)
        BlobId blobId = BlobId.of(bucketName, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(file.getContentType())
                .build();

        // 4. Upload lên GCS
        storage.create(blobInfo, file.getBytes());

        // 5. Trả về URL công khai
        // Format: https://storage.googleapis.com/BUCKET_NAME/FILE_NAME
        return String.format("https://storage.googleapis.com/%s/%s", bucketName, fileName);
    }
}