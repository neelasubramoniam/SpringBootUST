package com.example.PMS;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.PMS.AddResponse;
import com.example.PMS.GetAndSet;
import com.example.PMS.PMS;
import com.example.PMS.PMSAddService;
import com.example.PMS.PMSController;
import com.example.PMS.PMSRepository;

@SpringBootTest
class PMSApplicationTests 
{
	
	AtomicInteger counter = new AtomicInteger();
	@Autowired 
	PMSController con;
	
	@MockBean
	PMSAddService PMService;
	
	@MockBean
	PMSRepository repository;
	
	void contextLoads() 
	{
		
	}
	
	@Test
	public void TS001()
	{
		GetAndSet GS=new GetAndSet();
		GS.setColor("RED");
		System.out.println(GS.getColor());
		assertEquals("RED", GS.getColor());
		
	}
	
	 
	  public void AddEmployee()
	  
	  {
	   //This is without mockito
	  ResponseEntity response=con.addPizza(PMSDataPayload());
	  System.out.println(response.getStatusCode());
	  assertEquals(HttpStatus.CREATED, response.getStatusCode());
	  }
	  
	  @Test
      public void AddPizzawithMockito()

	  {
    	 // when(PMService.checkEMPAlreadyExist(PMSDataPayload().getpNAME()+counter.getAndIncrement())).thenReturn(false);
    	 when(PMService.checkEMPAlreadyExist(PMSDataPayload().getpNAME()+counter.getAndIncrement())).thenReturn(true);
	  ResponseEntity response=con.addPizza(PMSDataPayload());
	  System.out.println(response.getStatusCode());
	  assertEquals(HttpStatus.CREATED, response.getStatusCode());
	  AddResponse ad = (AddResponse)response.getBody();
	  //assertEquals("Success: Pizza is Added", ad.getMsg());
	  assertEquals("Pizza Already exists", ad.getMsg());
	  }
	 
	
	
	@Test
	  public PMS PMSDataPayload()
	  { 
		  PMS pms=new PMS();
	      pms.setpNAME("cheese");
	      pms.setpSIZE("Large"); 
	      return pms; }
	   
	
	
	// Mockito ---> Framework for mocking external dependencies 
	
	
	

}
