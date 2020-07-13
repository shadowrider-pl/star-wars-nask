package com.finbarre.starwarsnask.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finbarre.starwarsnask.helper.CharactersHelper;
import com.finbarre.starwarsnask.payload.Character;
import com.finbarre.starwarsnask.repository.CharacterRepository;
import com.finbarre.starwarsnask.service.CharacterService;

@RestController
@RequestMapping("/characters")
public class CharacterResource {

	private final Logger log = LoggerFactory.getLogger(CharacterResource.class);

	private final CharacterRepository characterRepository;

	private final CharacterService characterService;

	public CharacterResource(CharacterRepository characterRepository, CharacterService characterService) {
		this.characterRepository = characterRepository;
		this.characterService=characterService;
	}

	@GetMapping
	public ResponseEntity<CharactersHelper> getAllCharacters(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
		log.debug("REST request to get a page of Characters. page=" + page);
		CharactersHelper characterHelper = characterService.getAllCharacters(page, pageSize, sortBy);
		return new ResponseEntity<CharactersHelper>(characterHelper, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Character> getCharacter(@PathVariable Long id) {
		Optional<Character> character = characterRepository.findById(id);
		return character.map(response -> ResponseEntity.ok().body(response))
	            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
