package com.honeybridge.clinique.repositeries;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.honeybridge.clinique.model.Docter;

public interface DocterRepositery extends MongoRepository<Docter, String> {
public Docter findByName();
public Docter findById();
public Docter findBySpecilization();
}
