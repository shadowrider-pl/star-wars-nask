package com.finbarre.starwarsnask.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "swcharacter")
@Data
public class Character implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "height")
	private Integer height;
	
	@Column(name = "mass")
	private Integer mass;
	
	@Column(name = "hair_color")
	private String hairColor;
	
	@Column(name = "skin_color")
	private String skinColor;
	
	@Column(name = "eye_color")
	private String eyeColor;
	
	@Column(name = "birth_year")
	private String birthYear;

    @Column(name = "gender")
	private String gender;
    
    @ManyToOne
	Homeworld homeworld;
    
    @OneToMany
	List<Starship> starships = new ArrayList<Starship>();
}
