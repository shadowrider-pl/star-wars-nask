package com.finbarre.starwarsnask.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.finbarre.starwarsnask.helper.CharactersHelper;
import com.finbarre.starwarsnask.payload.Character;
import com.finbarre.starwarsnask.repository.CharacterRepository;
import com.finbarre.starwarsnask.service.CharacterService;

@Service
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	CharacterRepository characterRepository;

	public CharactersHelper getAllCharacters(Integer pageNo, Integer pageSize, String sortBy) {

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Character> pagedResult = characterRepository.findAll(paging);

		CharactersHelper characterHelper = new CharactersHelper(pagedResult.getTotalElements(),
				pagedResult.getTotalPages(), pagedResult.getContent());

		return characterHelper;
	}
}
