package com.example.PMS;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PMSController {

	AtomicInteger counter = new AtomicInteger();

	@Autowired
	PMSRepository repository;

	@Autowired
	PMSAddService pmsservice;

	@PostMapping("/addPizza")
	public ResponseEntity<AddResponse> addPizza(@RequestBody PMS pms) {
		HttpHeaders headers = new HttpHeaders();
		//String id = pms.getpNAME() + counter.getAndIncrement();
		String id = "1";
		AddResponse add = new AddResponse();

		if (!pmsservice.checkEMPAlreadyExist(id)) {
			pms.setpID(id);
			repository.save(pms);
			add.setId(id);
			add.setMsg("Success : Pizza is Added");
			headers.add("Unique", id);
			return new ResponseEntity<AddResponse>(add, headers, HttpStatus.CREATED);
		} else {
			add.setId(id);
			add.setMsg("Pizza Info. Already Exists");

			return new ResponseEntity<AddResponse>(add, headers, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/getPizza/{id}")
	public PMS getPizzaByID(@PathVariable(value = "id") String id) {
		try {
			PMS pms = repository.findById(id).get();

			return pms;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getPizza")
	public List<PMS> getPizzaByName(@RequestParam(value = "PizzaName") String pizzaName) {
		return repository.findAllByeName(pizzaName);

	}

	@PutMapping("/updatePizzaInfo/{id}")
	public ResponseEntity<PMS> updatePizzaInfo(@PathVariable(value = "id") String id, @RequestBody PMS pms) {
		PMS pizzaInfo = repository.findById(id).get();
		pizzaInfo.setpNAME(pms.getpNAME());
		pizzaInfo.setRate(pms.getRate());
		pizzaInfo.setpSIZE(pms.getpSIZE());
		repository.save(pizzaInfo);
		return new ResponseEntity<PMS>(pizzaInfo, HttpStatus.OK);

	}

	@DeleteMapping("/deletePizzaInfo")
	public ResponseEntity<String> deletePizzaInfo(@RequestBody PMS pms) {
		PMS delID = repository.findById(pms.getpID()).get();
		repository.delete(delID);
		return new ResponseEntity<>("PIZZA Info Deleted", HttpStatus.CREATED);

	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllPizzaInfo() {
		repository.deleteAll();
		return new ResponseEntity<>("All PIZZA informations Deleted", HttpStatus.CREATED);
	}

}
