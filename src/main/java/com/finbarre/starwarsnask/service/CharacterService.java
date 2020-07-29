package com.finbarre.starwarsnask.service;

import java.util.Optional;

import com.finbarre.starwarsnask.helper.CharactersHelper;
import com.finbarre.starwarsnask.payload.Character;

public interface CharacterService {

	CharactersHelper getAllCharacters(Integer pageNo, Integer pageSize, String sortBy);

	Optional<Character> findById(Long id);

}
