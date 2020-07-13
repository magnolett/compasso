package com.recrutamento.compasso.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "BIRTHDAY")
	private Date birthday;
	
	@Column(name = "AGE")
	private Integer age;
	
	@ManyToOne
	@Column(name = "CITY")
	private City city;

}