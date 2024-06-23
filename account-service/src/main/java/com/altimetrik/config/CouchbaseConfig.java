package com.altimetrik.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;


@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "admin";
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public String getBucketName() {
        return "account_strategy";
    }

    @Override
    public String getScopeName() {
        return "_default";
    }
    
    @Override
    protected String getMappingBasePackage() {
        return "com.altimetrik"; // Package where your entities are located
    }
}