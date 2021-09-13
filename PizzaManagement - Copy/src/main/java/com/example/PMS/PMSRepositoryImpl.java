package com.example.PMS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class PMSRepositoryImpl implements PMSRepositoryCustom 
{

	@Autowired
	PMSRepository repository;
	
	
	@Override
	public List<PMS> findAllByeName(String eName) 
	{
	
		List<PMS> eNames=new ArrayList<PMS>();
		List<PMS> emps=repository.findAll();
		
		for(PMS items:emps)
		{
			if(items.getpNAME().equalsIgnoreCase(eName))
			{
				eNames.add(items);
			}
			
		}
		return eNames;

	}
	

}
