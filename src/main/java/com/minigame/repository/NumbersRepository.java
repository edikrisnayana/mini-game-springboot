package com.minigame.repository;

import com.minigame.Numbers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NumbersRepository extends MongoRepository<Numbers, String> {
}
