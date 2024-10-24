package com.utkarsh01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@Table(name = "ems_employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty @Size(max = 30)
	@Column(length = 50)
	private String name;
	
	@NotEmpty @Size(max = 30)
	@Column(length = 50)
	private String address;
	
	@NotEmpty
	private String gender;
	
	@NotEmpty @Size(max = 30)
	@Column(length = 50)
	private String department;
	
	@Positive
	private Double salary;
}
