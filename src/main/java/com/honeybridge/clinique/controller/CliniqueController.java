package com.honeybridge.clinique.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.honeybridge.clinique.model.Appointment;
import com.honeybridge.clinique.model.Docter;
import com.honeybridge.clinique.model.Patient;
import com.honeybridge.clinique.repositeries.AppaointmentRepositery;
import com.honeybridge.clinique.service.DocterService;
import com.honeybridge.clinique.service.PatientService;
@RestController
public class CliniqueController {
	@RequestMapping("/")
    public String wellCome() {
		return "WELL COME TO OUR HOSPITAL";
	}
	
	@Autowired
	DocterService docterService;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	AppaointmentRepositery appointmentRepo;
	
	@RequestMapping(value="/docters")
	public List<Docter> getAllDocters(){return docterService.findAll();
	}
	
	@RequestMapping(value="/docters/{id}",method=RequestMethod.GET)
	public Docter getDocterById(@PathVariable("id")String id){return docterService.getDocterById(id);
	}
	
    @RequestMapping(value="/docters",method=RequestMethod.POST)
    public void addDocter(@RequestBody Docter docter){docterService.AddNewDocter(docter);
    }
    
    @RequestMapping(value="/docters/{avalability}")
    public List<Docter> getDoctersByAvalability(@PathVariable("avalability")String avalability) {return docterService.getDocterByAvalability(avalability);	
    }
    
    @RequestMapping(value="/docters/name/{name}")
    public List<Docter> getDoctersByName(@PathVariable("name")String name) {return docterService.getDocterByName(name);	
    }

    @RequestMapping(value="/docters",method=RequestMethod.PUT)
    public void updateDocters(@RequestBody Docter docter) {docterService.updateDocter(docter);
    }
    
    @RequestMapping(value="/patients",method=RequestMethod.GET)
    public List<Patient> getAllPatient(){return patientService.getAllPatientDetailes();
    }
    
    @RequestMapping(value="/patients",method=RequestMethod.POST)
    public void addnewPatient(@RequestBody Patient patient){patientService.AddNewPatient(patient);
    }
    
    @RequestMapping(value="/patients/{id}",method=RequestMethod.GET)
    public Patient getPatientById(@PathVariable("id")String id) {return patientService.getPatientById(id);
    }
    
   @RequestMapping(value="/patients",method=RequestMethod.PUT)
   public void updatePatient(@RequestBody Patient newPatient) {
	   patientService.updatePatient(newPatient);
   }
   @RequestMapping(value="/appointment")
   public Appointment takeAppointment(@RequestBody Appointment appointment ) {
	List<Docter> docters=docterService.findAll();
	for(Docter docter:docters)
	{
		if(docter.getId().equals(appointment.getDocterId())&&(docter.getName().equals(appointment.getDocterName()))) {
			appointmentRepo.save(appointment);
			return appointment;
		}
	}
	
	return appointment;
	   
   }
   
}
