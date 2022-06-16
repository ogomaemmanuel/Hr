package com.ogoma.hr_core.boundaries.documents.services;

import com.ogoma.hr_core.boundaries.documents.entities.Bucket;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.RemoveBucketArgs;
import io.minio.errors.*;
import org.springframework.stereotype.Service;


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

    public void createBucket(String name) throws Exception  {
        BucketExistsArgs bucketExistsArgs= BucketExistsArgs.builder().bucket(name).build();
        if (!minioClient.bucketExists(bucketExistsArgs)) {
            MakeBucketArgs makeBucketArgs= MakeBucketArgs.builder().bucket(name).build();
            minioClient.makeBucket(makeBucketArgs);
        }
    }

    public void deleteBucket(String name) throws Exception    {
        if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(name).build())) {
            RemoveBucketArgs removeBucketArgs = RemoveBucketArgs.builder().bucket(name).build();
            minioClient.removeBucket(removeBucketArgs);
        }
    }
    public List<Bucket> getBuckets() throws Exception   {
        return minioClient.listBuckets().stream().map(x -> new Bucket(x.name(),null, null)).collect(Collectors.toList());
    }
}
