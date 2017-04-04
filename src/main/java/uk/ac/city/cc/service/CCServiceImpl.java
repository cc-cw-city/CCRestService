package uk.ac.city.cc.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.util.EC2MetadataUtils;
import uk.ac.city.cc.dto.ServiceResponse;
import org.springframework.stereotype.Service;
import uk.ac.city.cc.utils.AppUtils;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by santiagoginzburg on 11/03/2017.
 */
@Service
public class CCServiceImpl implements CCService {
    @Override
    public ServiceResponse processService() {
        String ec2Id = "No EC2 found";
        String myCredentials = "credentials not found locally.";
        String [] credentials = null;

        StringBuilder sb = new StringBuilder();

        try {
            credentials = AppUtils.readFile(new File("/home/ec2-user/.aws/credentials"));
            BasicAWSCredentials awsCreds = new BasicAWSCredentials(credentials[0], credentials[1]);
            if (Optional.ofNullable(credentials).isPresent()) {
                AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                        .build();

                for (Bucket bucket : s3Client.listBuckets()) {
                    sb.append(bucket.getName());
                    sb.append(' ');
                }

                myCredentials = "credentials found and my buckets are " + sb.toString().trim();
            }
        } catch (Exception e) {
            myCredentials = "error " + e.getMessage() + " with crd: " + credentials;
        }

        try {
            ec2Id = EC2MetadataUtils.getData("/latest/meta-data/public-ipv4");
        } catch (com.amazonaws.SdkClientException ex) {
            //do nothing
        }

        String msg = new StringBuilder()
                .append("msg: ")
                .append(ec2Id)
                .append(' ')
                .append(myCredentials)
                .toString();

        return new ServiceResponse(msg);
    }
}
