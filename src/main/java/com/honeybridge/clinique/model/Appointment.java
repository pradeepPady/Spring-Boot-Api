package com.honeybridge.clinique.model;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Appointment {
	private String appointmentId;
	private String docterName;
	private String docterId;
	private String patientName;
	private String appointmentDate;
	public String getDocterName() {
		return docterName;
	}
	public void setDocterName(String docterName) {
		this.docterName = docterName;
	}
	public String getDocterId() {
		return docterId;
	}
	public void setDocterId(String docterId) {
		this.docterId = docterId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
}
