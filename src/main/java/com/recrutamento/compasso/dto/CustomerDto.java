package com.recrutamento.compasso.dto;

import java.util.Date;

import javax.persistence.Entity;

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
public class CustomerDto {

	private String nome;
	private String sexo;
	private Date dataNascimento;
	private Integer idade;
	private CityDto cidade;

}