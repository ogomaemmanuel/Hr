package com.ogoma.hr_core.boundaries.documents.services;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.UUID;

@Service
public class DocumentsService {
    private final MinioClient minioClient;
    @Autowired
    public DocumentsService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }
    public void createDocumemnt(String bucketName, MultipartFile file) throws Exception {
        String fileName = UUID.randomUUID().toString();
        minioClient.putObject(bucketName, fileName, file.getInputStream(), (long) file.getSize(), new HashMap<>(), null, file.getContentType());
    }
    public void deleteDocument(String bucketName, String fileName) throws Exception {
        minioClient.removeObject(bucketName, fileName);
    }


}
