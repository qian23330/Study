package com.aliyun.oss;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {
    private String endpoint;
    private  String bucketName;

    public AliOSSProperties() {
    }

    public AliOSSProperties(String endpoint, String bucketName) {
        this.endpoint = endpoint;
        this.bucketName = bucketName;
    }

    /**
     * 获取
     * @return endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * 设置
     * @param endpoint
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * 获取
     * @return bucketName
     */
    public String getBucketName() {
        return bucketName;
    }

    /**
     * 设置
     * @param bucketName
     */
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String toString() {
        return "AliOSSProperties{endpoint = " + endpoint + ", bucketName = " + bucketName + "}";
    }
}
