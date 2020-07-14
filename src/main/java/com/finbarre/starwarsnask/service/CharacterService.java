package com.finbarre.starwarsnask.service;

import com.finbarre.starwarsnask.helper.CharactersHelper;

public interface CharacterService {

	CharactersHelper getAllCharacters(Integer pageNo, Integer pageSize, String sortBy);

}
