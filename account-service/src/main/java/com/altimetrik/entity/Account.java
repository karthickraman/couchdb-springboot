package com.altimetrik.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.UUID;

@Document
@Data
public class Account {

    @Id
    private String accountId = UUID.randomUUID().toString();

    @NotBlank(message = "Account name is mandatory")
    @Size(max = 100, message = "Account name cannot exceed 100 characters")
    private String accountName;

    @NotBlank(message = "Industry is mandatory")
    @Size(max = 50, message = "Industry cannot exceed 50 characters")
    private String industry;

    @NotNull(message = "Revenue is mandatory")
    @Min(value = 0, message = "Revenue must be a positive value")
    private double revenue;

    @NotBlank(message = "Account manager is mandatory")
    @Size(max = 100, message = "Account manager name cannot exceed 100 characters")
    private String accountManager;
}
