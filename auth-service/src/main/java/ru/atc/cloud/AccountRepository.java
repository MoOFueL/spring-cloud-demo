package ru.atc.cloud;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by Дмитрий on 08.02.2017.
 */
public interface AccountRepository extends MongoRepository<Account, ObjectId> {

    Optional<Account> findByUsername(String username);
}
