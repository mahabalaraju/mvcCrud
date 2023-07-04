package com.worker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worker.entity.employee;

@Repository
public interface employeeRepository extends JpaRepository<employee, Integer>{

}
