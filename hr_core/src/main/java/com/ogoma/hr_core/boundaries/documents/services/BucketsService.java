package com.ogoma.hr_core.boundaries.documents.services;

import com.ogoma.hr_core.boundaries.documents.entities.Bucket;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BucketsService {
    private final MinioClient minioClient;

    public BucketsService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    public void createBucket(String name) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InvalidResponseException, ErrorResponseException, NoResponseException, InvalidBucketNameException, XmlPullParserException, InternalException, RegionConflictException {
        if (!minioClient.bucketExists(name)) {
            minioClient.makeBucket(name);
        }
    }

    public void deleteBucket(String name) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InvalidResponseException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException {
        if (!minioClient.bucketExists(name)) {
            minioClient.removeBucket(name);
        }
    }
    public List<Bucket> getBuckets() throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InvalidResponseException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException {
        return minioClient.listBuckets().stream().map(x -> new Bucket(x.name(), x.creationDate(), null)).collect(Collectors.toList());
    }
}
