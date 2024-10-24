package com.utkarsh01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utkarsh01.entity.Employee;
import com.utkarsh01.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> showAllEmp(){
		return repository.findAll();
	}
	
	public Employee showOneEmp(Integer id) {
		return repository.findById(id).get();
	}
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public Employee inserEmp(Employee emp) {
		return repository.save(emp);
	}
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public Employee updateEmp(Employee emp) {
		return repository.save(emp);
	}
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public void deleteEmp(Integer id) {
		repository.deleteById(id);
	}
	
	public List<Employee> searchEmpbyName(String name){
		return repository.findByNameLike(name);
	}
	
	public List<Employee> searchEmpByAddress(String address){
		return repository.findByAddressLike(address);
	}
	
	public List<Employee> searchEmpySal(Double salary){
		return repository.findBySalaryLessThan(salary);
	}
}
