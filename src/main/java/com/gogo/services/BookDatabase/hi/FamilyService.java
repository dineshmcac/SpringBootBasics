package com.gogo.services.BookDatabase.hi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FamilyService {
	
	List<FamilyDetail> family =new ArrayList<>(Arrays.asList(new FamilyDetail("1","Dinesh","Father of the family"),
			new FamilyDetail("2","Mother","Mother of the family")));
	
	public List<FamilyDetail> GetFamilyDetails(){
		return family;
	}
	
	public FamilyDetail SpecificFamilyMember(String id){
		return family.stream().filter(a -> a.getId().equals(id)).findFirst().get();
	}
	
	public void addFamily(FamilyDetail body){
		family.add(body);
	}
	
	public void updateFamily(String id, FamilyDetail fam){
		for(int i=0; i< family.size(); i++) {
			if(family.get(i).getId().equals(id)) {
				family.set(i, fam);
			}
		}
	}

	public void deleteFamily(String id){
		family.removeIf(b->b.getId().equals(id));
	}
}
