package com.honeybridge.clinique.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybridge.clinique.model.Patient;
import com.honeybridge.clinique.repositeries.PatientRepositery;
@Service
public class PatientService {
	
    @Autowired
    PatientRepositery patientRepositery;
	public List<Patient> getAllPatientDetailes() {
		return patientRepositery.findAll();
	}
	public void addPatient(Patient patient) {
		patientRepositery.save(patient);	
	}
	
	public Patient getPatientById(String id) {
		java.util.List<Patient> patients= patientRepositery.findAll();
		if(patients!=null)
		{
			for(Patient patient:patients)
			{
				if(patient.getId().equals(id))
					return patient;
			}
		}
		return null;
	}
	
	public List<Patient> getPatientByMobileNumber(long mobileNumber) {
		ArrayList<Patient>patientList=new ArrayList<Patient>();
		java.util.List<Patient> patients= patientRepositery.findAll();
		if(patients!=null)
		{
			for(Patient patient:patients)
			{
				if(patient.getMobileNumber()==mobileNumber)
					patientList.add(patient);			
		    }
		}
		return patientList;
	}
	
	public void AddNewPatient(Patient patient) {
		patientRepositery.save(patient);
	}

	public void updatePatient(Patient newPatient) {
       List<Patient> patients=patientRepositery.findAll();
       if (patients!=null) {
       for(Patient patient:patients) {
       	if (patient.getId().equals(newPatient.getId())) {
				addPatient(newPatient);
			}
       }
       }
	}


}
