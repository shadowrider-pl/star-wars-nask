package com.finbarre.starwarsnask.helper;

import java.util.ArrayList;

import lombok.Data;
@Data
public class SwapiHomeworld {
	  private String name;
	  private String rotation_period;
	  private String orbital_period;
	  private String diameter;
	  private String climate;
	  private String gravity;
	  private String terrain;
	  private String surface_water;
	  private String population;
	  ArrayList<Object> residents = new ArrayList<Object>();
	  ArrayList<Object> films = new ArrayList<Object>();
	  private String created;
	  private String edited;
	  private String url;
}
