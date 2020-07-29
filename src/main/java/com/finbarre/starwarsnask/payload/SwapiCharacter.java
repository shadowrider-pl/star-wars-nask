package com.finbarre.starwarsnask.payload;

import java.util.ArrayList;

import com.finbarre.starwarsnask.helper.SwapiStarship;

import lombok.Data;

@Data
public class SwapiCharacter {
	  private String name;
	  private String height;
	  private String mass;
	  private String hair_color;
	  private String skin_color;
	  private String eye_color;
	  private String birth_year;
	  private String gender;
	  private String homeworld;
	  ArrayList<Object> films = new ArrayList<Object>();
	  ArrayList<Object> species = new ArrayList<Object>();
	  ArrayList<Object> vehicles = new ArrayList<Object>();
	  ArrayList<String> starships = new ArrayList<String>();
	  private String created;
	  private String edited;
	  private String url;
}
