package com.finbarre.starwarsnask.payload;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "homeworld")
@Data
public class Homeworld implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "rotation_period")
	private Integer rotationPeriod;

	@Column(name = "orbital_period")
	private Integer orbitalPeriod;

	@Column(name = "diameter")
	private Integer diameter;

	@Column(name = "climate")
	private String climate;

	@Column(name = "gravity")
	private String gravity;

	@Column(name = "terrain")
	private String terrain;

	@Column(name = "surface_water")
	private Integer surfaceWater;

	@Column(name = "population")
	private Long population;

}
