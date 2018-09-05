package com.honeybridge.clinique.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.honeybridge.clinique.model.Docter;
import com.honeybridge.clinique.repositeries.DocterRepositery;
@Service
public class DocterService {
	
	@Autowired 
	DocterRepositery docterRepositery;
	
	public java.util.List<Docter> findAll() {
		return docterRepositery.findAll();
	}
	
	public void addDocter(Docter docter) {
         docterRepositery.save(docter);	
	}
	
	public Docter getDocterById(String id) {
		java.util.List<Docter> docters= docterRepositery.findAll();
		if(docters!=null)
		{
			for(Docter docter:docters)
			{
				if(docter.getId().equals(id))
					return docter;
			}
		}
		return null;
	}
	
	public List<Docter> getDocterByName(String name) {
		ArrayList<Docter>doctersList=new ArrayList<Docter>();
		java.util.List<Docter> docters= docterRepositery.findAll();
		if(docters!=null)
		{
			for(Docter docter:docters)
			{
				if(docter.getName().equals(name))
					doctersList.add(docter);			
		    }
		}
		return doctersList;
		}
	
	public List<Docter> getDocterByAvalability(String avalability) {
		ArrayList<Docter>doctersList=new ArrayList<Docter>();
		java.util.List<Docter> docters= docterRepositery.findAll();
		if(docters!=null)
		{
			for(Docter docter:docters)
			{
				if(docter.getAvalability().equals(avalability))
					doctersList.add(docter);			
		    }
		}
		return doctersList;
	}
	
	public void AddNewDocter(Docter docter) {
		docterRepositery.save(docter);
	}

	public void updateDocter(Docter NewDocter) {
        List<Docter> docters=docterRepositery.findAll();
        for(Docter docter:docters) {
        	if (docter.getId().equals(NewDocter.getId())) {
				addDocter(NewDocter);
			}
        	
        }
	}
}
