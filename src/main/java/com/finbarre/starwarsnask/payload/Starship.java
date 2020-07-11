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
@Table(name = "starship")
@Data
public class Starship implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "model")
	private String model;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "cost_in_credits")
	private Integer costInCredits;

	@Column(name = "length")
	private Double length;

	@Column(name = "max_atmospheric_speed")
	private Integer maxAtmosphericSpeed;

	@Column(name = "crew")
	private Integer crew;

	@Column(name = "passengers")
	private Integer passengers;

	@Column(name = "cargo_capacity")
	private Integer cargoCapacity;

	@Column(name = "consumables")
	private String consumables;

	@Column(name = "hyperdrive_rating")
	private Double hyperdriveRating;

	@Column(name = "mglt")
	private Integer mglt;

	@Column(name = "starship_class")
	private String starshipClass;

}
