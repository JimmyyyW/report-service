package com.fdm0506.stockify.reportservice.repository;

import com.fdm0506.stockify.reportservice.share.Shares;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SharesRepository extends MongoRepository<Shares, String> {
    Shares findByUser(String username);
}
