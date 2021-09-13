package com.example.PMS;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PMSAddService 
{
	
	@Autowired
	PMSRepository repository;
	
	public boolean checkEMPAlreadyExist(String id)
	{
				Optional<PMS> ems=repository.findById(id);
				
				if(ems.isPresent())
				{
					return true;
				}
				
				else
				{
					return false;
				}
				
				//The Optional type was introduced in Java 8. It provides a clear and explicit way to convey the message that there may not be a value, without using null. 
	}
	

}
