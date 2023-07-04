package com.worker.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worker.Service.service;
import com.worker.entity.employee;
import com.worker.repository.employeeRepository;

@RestController
@RequestMapping("/employee")
public class controller {

	@Autowired
	private service empser;
	
	@PostMapping("/upsert")
	public ResponseEntity<String> upsert(@RequestBody employee employee){
		String asf=empser.upsert(employee);
		return new ResponseEntity<String>(asf, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<employee>> getall() {
		return ResponseEntity.ok(empser.getall());
	}

	@GetMapping("/getby/{id}")
	public ResponseEntity<Optional<employee>> getbyid(@PathVariable("id") int id) {
		return ResponseEntity.ok(empser.getbyid(id));
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody employee employee) {
		String empl = empser.add(employee);
		return new ResponseEntity<>(empl, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody employee employee) {
		String empl = empser.update(employee);
		return new ResponseEntity<>(empl, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		String empl = empser.delete(id);
		return new ResponseEntity<>(empl, HttpStatus.OK);
	}

}
