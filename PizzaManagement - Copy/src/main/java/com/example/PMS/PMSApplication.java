package com.example.PMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PMSApplication
{

	
	//@Autowired
	//EMSRepository repository;
	
	
	public static void main(String[] args) 
	{
		SpringApplication.run(PMSApplication.class, args);
	}

	//@Override
	//public void run(String... args) throws Exception 
	//{
	
		//EMS ems= repository.findById("JIM1").get();
		//System.out.println(ems.geteID());
		//System.out.println(ems.geteNAME());
		//System.out.println(ems.geteSAL());
		
		//EMS ems1= new EMS();
		//ems1.seteID("Azees1");
		//ems1.seteNAME("Azees");
		//ems1.seteSAL("50000");
		//repository.save(ems1);	
		
		/*
		 * List<EMS> allrecords=repository.findAll();
		 * 
		 * for (EMS items: allrecords) { System.out.println(items.geteNAME()); }
		 * 
		 * repository.delete(ems1);
		 */
		
		
		
		
		
	}
	
	
	
	


