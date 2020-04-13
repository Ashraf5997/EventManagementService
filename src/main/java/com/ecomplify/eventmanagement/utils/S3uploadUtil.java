package com.ecomplify.eventmanagement.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

@Component
public class S3uploadUtil {
	
    @Autowired
    private S3Client awsS3Client;

    @Value("${aws.s3.report.bucket}")
    private String reportBucketName;
    
    public void uploadFile(String filename,File struploadFile) {
    	System.out.println("for the file upload utility");
    	
    	System.out.println("a = "+awsS3Client);
    	System.out.println("b = "+reportBucketName);
    	
    	System.out.println("Before the file upload process ");
    	
    	PutObjectResponse putObjectResponse = awsS3Client.putObject(PutObjectRequest.builder().bucket(reportBucketName).key(filename).build(), RequestBody.fromFile(struploadFile));
    	
    	
    	System.out.println("The S3 bucket response = "+putObjectResponse.versionId());
    	System.out.println("After the file upload process ");
    	
    }

}
