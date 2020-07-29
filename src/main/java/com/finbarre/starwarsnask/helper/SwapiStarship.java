package com.finbarre.starwarsnask.helper;

import java.util.ArrayList;

import lombok.Data;
@Data
public class SwapiStarship {
	private String name;
	  private String model;
	  private String manufacturer;
	  private String cost_in_credits;
	  private String length;
	  private String max_atmosphering_speed;
	  private String crew;
	  private String passengers;
	  private String cargo_capacity;
	  private String consumables;
	  private String hyperdrive_rating;
	  private String MGLT;
	  private String starship_class;
	  ArrayList<Object> pilots = new ArrayList<Object>();
	  ArrayList<Object> films = new ArrayList<Object>();
	  private String created;
	  private String edited;
	  private String url;
}
