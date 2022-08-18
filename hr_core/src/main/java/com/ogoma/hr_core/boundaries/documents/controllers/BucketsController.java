package com.ogoma.hr_core.boundaries.documents.controllers;

import com.ogoma.hr_core.boundaries.documents.services.BucketsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cloud-buckets")
public class BucketsController {
    private final BucketsService bucketsService;


    public BucketsController(BucketsService bucketsService) {
        this.bucketsService = bucketsService;
    }

    @PostMapping
    public ResponseEntity<?> createBucket(@RequestBody String bucketName) throws Exception {
        this.bucketsService.createBucket(bucketName);
        return ResponseEntity.noContent().build();
    }
}
