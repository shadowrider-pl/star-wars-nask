package com.finbarre.starwarsnask;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.finbarre.starwarsnask.helper.CharactersHelper;
import com.finbarre.starwarsnask.payload.Character;
import com.finbarre.starwarsnask.payload.Homeworld;
import com.finbarre.starwarsnask.payload.Starship;
import com.finbarre.starwarsnask.repository.CharacterRepository;
import com.finbarre.starwarsnask.repository.HomeworldRepository;
import com.finbarre.starwarsnask.repository.StarshipRepository;
import com.finbarre.starwarsnask.service.CharacterService;

@SpringBootTest
@AutoConfigureMockMvc
class StarWarsNaskApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private EntityManager em;

	@Autowired
	private CharacterRepository characterRepository;

	@Autowired
	private HomeworldRepository homeworldRepository;

	@Autowired
	private StarshipRepository starshipRepository;

	@Autowired
	CharacterService characterService;

	private Character character = new Character();
	private Homeworld homeworld = new Homeworld();
	private Starship starship = new Starship();

	private static final String NAME = "Gowron";
	private static final String HOMEWORLD = "Klingon";
	private static final String SHIP = "Bird of Prey";

	public static Homeworld createHomeworldEntity(EntityManager em) {
		Homeworld homeworld = new Homeworld();
		homeworld.setName(HOMEWORLD);
		return homeworld;
	}

	public static Starship createStarshipEntity(EntityManager em) {
		Starship starship = new Starship();
		starship.setModel(SHIP);
		return starship;
	}

	public static Character createCharacterEntity(EntityManager em, Homeworld homeworld, Starship starship) {
		Character character = new Character();
		List<Starship> starships = new ArrayList<Starship>();
		starships.add(starship);

		character.setName(NAME);
		character.setHomeworld(homeworld);
		character.setStarships(starships);
		return character;
	}

	@BeforeEach
	public void initTest() {
		homeworld = createHomeworldEntity(em);
		starship = createStarshipEntity(em);
		character = createCharacterEntity(em, homeworld, starship);
	}

	@Test
	@Transactional
	void getCharactersHelper() throws Exception {
		Integer count=1;
		Integer pages=10;
		String sortBy="id";
		assertTrue(characterService.getAllCharacters(count, pages, sortBy) instanceof CharactersHelper);
	}

	@Test
	@Transactional
	void getAllCharacters() throws Exception {
		homeworldRepository.saveAndFlush(homeworld);
		starshipRepository.saveAndFlush(starship);
		characterRepository.saveAndFlush(character);
		mockMvc.perform(get("/characters").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.elements.[*].name").value(hasItem(NAME)))
				.andExpect(jsonPath("$.elements.[*].homeworld.name").value(hasItem(HOMEWORLD)))
				.andExpect(jsonPath("$.elements.[*].starships.[*].model").value(hasItem(SHIP)));
	}

	@Test
	@Transactional
	void getCharacter() throws Exception {

		homeworldRepository.saveAndFlush(homeworld);
		starshipRepository.saveAndFlush(starship);
		characterRepository.saveAndFlush(character);
		mockMvc.perform(get("/characters/{id}", character.getId()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.name").value(NAME))
				.andExpect(jsonPath("$.homeworld.name").value(HOMEWORLD))
				.andExpect(jsonPath("$.starships.[*].model").value(hasItem(SHIP)));
	}

	@Test
	@Transactional
	public void getNonExistingCharacter() throws Exception {
		mockMvc.perform(get("/characters/{id}", Long.MAX_VALUE)).andExpect(status().isNotFound());
	}

}
