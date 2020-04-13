package com.ecomplify.eventmanagement.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsS3Configuration {
	
    @Value("${aws.s3.full_access.access_key_id}")
    private String awsId;

    @Value("${aws.s3.full_access.secret_access_key}")
    private String awsKey;
    
    @Bean
    public S3Client awsS3Client() {
    	
    	S3Client s3client = null;
    	
    	try {
    			AwsCredentials awsCreds = AwsBasicCredentials.create(awsId,awsKey);
    			return S3Client.builder()
    							.credentialsProvider(StaticCredentialsProvider.create(awsCreds))
    							.region(Region.EU_WEST_2)
    							.build();
    	}catch(AwsServiceException ex) {
    		ex.printStackTrace();
    		System.out.println("AwsServiceException");
    		
    	}catch(SdkClientException ex) {
    		ex.printStackTrace();
    		System.out.println("SdkClientException");
    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		System.out.println("Exception");
    		
    	}
    	
    	return s3client;
    }

}
