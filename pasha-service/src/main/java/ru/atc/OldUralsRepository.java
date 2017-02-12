package ru.atc;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

/**
 * Created by Дмитрий on 09.02.2017.
 */
public interface OldUralsRepository extends MongoRepository<OldUral, ObjectId> {

    Collection<OldUral> findByName(String name);
}
