package com.altimetrik.repository;

import com.altimetrik.entity.Account;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CouchbaseRepository<Account, String> {
}
