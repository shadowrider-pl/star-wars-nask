package com.finbarre.starwarsnask.helper;

import java.util.ArrayList;

import com.finbarre.starwarsnask.payload.SwapiCharacter;

import lombok.Data;

@Data
public class SwapiHelper{


	private long count;
	private String next;
	private String previous;
	private ArrayList<SwapiCharacter> results;
}