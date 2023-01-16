import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;

public class S3UploadExample {
    public static void main(String[] args) {
        // Replace with your own access key and secret key
        String accessKey = "ACCESS_KEY";
        String secretKey = "SECRET_KEY";

        // Create the AWS credentials
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        // Create an S3 client
        AmazonS3 s3Client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        // The name of the bucket
        String bucketName = "my-bucket";

        // The name of the file you want to upload
        String fileName = "path/to/file.txt";

        // Create a PutObjectRequest to upload the file
        PutObjectRequest request = new PutObjectRequest(bucketName, fileName, new File(fileName));

        // Upload the file
        s3Client.putObject(request);
    }
}
