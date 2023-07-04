package com.worker.Service;

import java.util.List;
import java.util.Optional;

import com.worker.entity.employee;

public interface service {

	public List<employee> getall();
	
	public String delete(int id);
	
	public String upsert(employee employee);
	
	public Optional<employee> getbyid(int id);
	
	
	
	public String add(employee employee);

	String update(employee employee);
}
