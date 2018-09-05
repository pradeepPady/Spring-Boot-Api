package com.honeybridge.clinique.repositeries;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.honeybridge.clinique.model.Appointment;

public interface AppaointmentRepositery extends MongoRepository<Appointment, String> {

}
