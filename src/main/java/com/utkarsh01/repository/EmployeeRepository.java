package com.utkarsh01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utkarsh01.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByNameLike(String name);
	List<Employee> findByAddressLike(String address);
	List<Employee> findBySalaryLessThan(Double salary);
}
