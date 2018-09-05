package com.honeybridge.clinique.repositeries;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.honeybridge.clinique.model.Patient;

public interface PatientRepositery extends MongoRepository<Patient,String> {


}
