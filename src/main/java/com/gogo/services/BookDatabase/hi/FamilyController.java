package com.gogo.services.BookDatabase.hi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyController {
	
	@Autowired
	private FamilyService familyservices;
	
	@RequestMapping("/hi")
	public String helloPrint() {
		return "Hi";
	}
	
	@RequestMapping("/familydetails")
	public List<FamilyDetail> GetFamily() {
		return familyservices.GetFamilyDetails() ;
	}
	
	@RequestMapping("/familydetails/{id}")
	public FamilyDetail SpecificFamily(@PathVariable String id){
		return familyservices.SpecificFamilyMember(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addfamily"	)
	public void postMethod(@RequestBody FamilyDetail body){
		familyservices.addFamily(body);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updatefamily/{id}")
	public void PUTMethod(@PathVariable String id, @RequestBody FamilyDetail body){
		familyservices.updateFamily(id,body);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deletefamily/{id}"	)
	public void DeleteMethod(@PathVariable String id){
		familyservices.deleteFamily(id);
	}

}
