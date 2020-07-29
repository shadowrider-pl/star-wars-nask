package com.finbarre.starwarsnask.helper;

import java.io.Serializable;
import java.util.List;

import com.finbarre.starwarsnask.payload.Character;

import lombok.Data;

@Data
public class CharactersHelper implements Serializable{


	private static final long serialVersionUID = 1L;
	private long count;
	private long pages;
	private List<Character> elements;
	public CharactersHelper(long l, Integer pages, List<Character> elements) {
		this.count = l;
		this.pages = pages;
		this.elements = elements;
	}
	public CharactersHelper() {	}
}