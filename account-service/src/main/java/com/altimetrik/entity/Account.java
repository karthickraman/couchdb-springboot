package com.altimetrik.entity;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.UUID;

@Document
@Data
public class Account {
    @Id
    private String accountId = UUID.randomUUID().toString();

    private String accountName;
    private String industry;
    private double revenue;
    private String accountManager;
}
