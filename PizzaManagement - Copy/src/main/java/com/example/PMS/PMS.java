package com.example.PMS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//@Component
@Entity 
// This tells the JPA that this class contains all the details of Tables

@Table (name="pms_tn")

public class PMS 
{
	@Id
	@Column(name="id")
	private String pID;
	
	@Column (name="pname")
	private String pNAME;
	
	@Column (name="rate")
	private String rate;
	
	@Column (name="psize")
	private String pSIZE;
	
	
	public String getpSIZE() {
		return pSIZE;
	}

	public void setpSIZE(String pSIZE) {
		this.pSIZE = pSIZE;
	}

	public String getpID() 
	{
		return pID;
	}
	
	public void setpID(String pID) 
	{
		this.pID = pID;
	}
	
	public String getpNAME() 
	{
		return pNAME;
	}
	public void setpNAME(String pNAME) 
	{
		this.pNAME = pNAME;
	}
	
	public String getRate() 
	{
		return rate;
	}
	
	public void setRate(String rate) 
	{
		this.rate = rate;
	}
	
	

}
