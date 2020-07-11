package com.finbarre.starwarsnask.helper;

import java.io.Serializable;
import java.util.List;

import com.finbarre.starwarsnask.payload.Character;

import lombok.Data;

@Data
public class CharactersHelper implements Serializable{


	private static final long serialVersionUID = 1L;
	private long count;
	private int pages;
	private List<Character> elements;
	public CharactersHelper(long count, int pages, List<Character> elements) {
		super();
		this.count = count;
		this.pages = pages;
		this.elements = elements;
	}
}