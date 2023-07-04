package com.worker.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.worker.Exception.NosuchEmployeefoundException;
import com.worker.Exception.employeeAlreadyfoundException;
import com.worker.Exception.employeenotfoundException;
import com.worker.entity.employee;
import com.worker.repository.employeeRepository;
@Service
public class serviceImpl implements service {

	@Autowired
	private employeeRepository emprepo;

	@Override
	public List<employee> getall() {
		return emprepo.findAll();
	}

	@Override
	public String delete(int id) {
		Optional<employee> find = emprepo.findById(id);
		if (find.isPresent()) {
			emprepo.deleteById(id);
			return "delete successful";
		} else
			throw new NosuchEmployeefoundException("no record found with given id" + id);
	}

	@Override
	
	public String upsert(employee employee) {
		emprepo.save(employee);
		return "success";
	}

	@Override
	public Optional<employee> getbyid(int id) {
		return Optional.ofNullable(emprepo.findById(id))
				.orElseThrow(() ->  new NosuchEmployeefoundException("no record found with given id" + id));
				
	}

	@Override
	public String update(employee employee) {
	employee existingemployee =emprepo.findById(employee.getId()).orElse(null);
		if(existingemployee==null) {
			 throw new NosuchEmployeefoundException("no record found with given id" + employee.getId());
 }else {
	 existingemployee.setName(employee.getName());
	 existingemployee.setDept(employee.getDept());
	 existingemployee.setSalary(employee.getSalary());

emprepo.save(existingemployee);
 return "updated record successfullly";
 
 }
	}

	@Override
	public String add(employee employee) {
		Optional<employee> exitingemployee=emprepo.findById(employee.getId());
		if(exitingemployee.isPresent()) {
			emprepo.save(employee);
			return "success";
		}
		else
			throw new  employeeAlreadyfoundException("employee already present with given id" + employee.getId());

	}

	
	

}
