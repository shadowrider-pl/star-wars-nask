package com.finbarre.starwarsnask.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.finbarre.starwarsnask.helper.CharactersHelper;
import com.finbarre.starwarsnask.helper.SwapiHelper;
import com.finbarre.starwarsnask.helper.SwapiHomeworld;
import com.finbarre.starwarsnask.helper.SwapiStarship;
import com.finbarre.starwarsnask.payload.Character;
import com.finbarre.starwarsnask.payload.Homeworld;
import com.finbarre.starwarsnask.payload.Starship;
import com.finbarre.starwarsnask.payload.SwapiCharacter;
import com.finbarre.starwarsnask.service.CharacterService;

@Service
public class CharacterServiceImpl implements CharacterService {


	@Autowired
	RestTemplate restTemplate;

	String swURL = "https://swapi.dev/api/";

	public CharactersHelper getAllCharacters(Integer pageNo, Integer pageSize, String sortBy) {

		SwapiHelper swresult = restTemplate.getForObject("https://swapi.dev/api/people/?page=" + pageNo,
				SwapiHelper.class);

		CharactersHelper characterHelper2 = createCharactersHelper(swresult);

		return characterHelper2;
	}

	private CharactersHelper createCharactersHelper(SwapiHelper swresult) {
		CharactersHelper characterHelper = new CharactersHelper();
		characterHelper.setCount(swresult.getCount());
		characterHelper
				.setPages(swresult.getCount() % 10 > 0 ? (swresult.getCount()) / 10 + 1 : (swresult.getCount()) / 10);
		ArrayList<SwapiCharacter> swapiCharacters = swresult.getResults();
		ArrayList<Character> characters = new ArrayList<>();
		for (SwapiCharacter swapiCharacter : swapiCharacters) {
			characters.add(convertCharacter(swapiCharacter));
		}
		characterHelper.setElements(characters);
		return characterHelper;
	}

	private Character convertCharacter(SwapiCharacter swapiCharacter) {
		Character character = new Character();
		character.setBirthYear(swapiCharacter.getBirth_year() == "unknown" ? swapiCharacter.getBirth_year() : null);
		character.setEyeColor(swapiCharacter.getEye_color() == "unknown" ? swapiCharacter.getEye_color() : null);
		character.setGender(swapiCharacter.getGender());
		character.setHairColor(swapiCharacter.getHair_color());
		character.setHeight(
				swapiCharacter.getHeight() == "unknown" ? Integer.parseInt(swapiCharacter.getHeight()) : null);
		character.setHomeworld(getHomewold(swapiCharacter.getHomeworld()));
		character.setMass(swapiCharacter.getMass() == "unknown" ? Double.parseDouble(swapiCharacter.getMass()) : null);
		character.setName(swapiCharacter.getName());
		character.setSkinColor(swapiCharacter.getSkin_color());
		character.setStarships(getStarships(swapiCharacter.getStarships()));
		return character;
	}

	private List<Starship> getStarships(ArrayList<String> swstarshipsUris) {
		ArrayList<Starship> starships = new ArrayList<>();
		for (String swstarshipsUri : swstarshipsUris) {
			SwapiStarship swstarship = restTemplate.getForObject(swstarshipsUri, SwapiStarship.class);
			Starship starship = new Starship();
			starship.setCargoCapacity(
					swstarship.getCargo_capacity() == "unknown" ? Integer.parseInt(swstarship.getCargo_capacity())
							: null);
			starship.setConsumables(swstarship.getConsumables() == "unknown" ? swstarship.getConsumables() : null);
			starship.setCostInCredits(
					swstarship.getCost_in_credits() == "unknown" ? Integer.parseInt(swstarship.getCost_in_credits())
							: null);
			starship.setCrew((Integer.parseInt(swstarship.getCrew())));
			starship.setMaxAtmosphericSpeed((Integer.parseInt(swstarship.getMax_atmosphering_speed())));
			starship.setPassengers(Integer.parseInt(swstarship.getPassengers()));
			starship.setMglt(swstarship.getMGLT() != null ? (Integer.parseInt(swstarship.getMGLT())) : null);
			starship.setHyperdriveRating(Double.parseDouble(swstarship.getHyperdrive_rating()));
			starship.setLength((Double.parseDouble(swstarship.getLength())));
			starship.setModel(swstarship.getModel());
			starship.setName(swstarship.getName());
			starship.setStarshipClass(swstarship.getStarship_class());
			starship.setManufacturer(swstarship.getManufacturer());
			starships.add(starship);

		}
		return starships;
	}

	private Homeworld getHomewold(String homeworldUri) {
		SwapiHomeworld swHomeworld = restTemplate.getForObject(homeworldUri, SwapiHomeworld.class);
		Homeworld homeworld = new Homeworld();
		homeworld.setClimate(swHomeworld.getClimate());
		homeworld.setDiameter(Integer.parseInt(swHomeworld.getDiameter()));
		homeworld.setGravity(swHomeworld.getGravity());
		homeworld.setName(swHomeworld.getName());
		homeworld.setOrbitalPeriod(
				swHomeworld.getOrbital_period() == "unknown" ? Integer.parseInt(swHomeworld.getOrbital_period())
						: null);
		homeworld.setPopulation(
				swHomeworld.getPopulation() == "unknown" ? Long.parseLong(swHomeworld.getPopulation()) : null);
		homeworld.setRotationPeriod(
				swHomeworld.getRotation_period() == "unknown" ? Integer.parseInt(swHomeworld.getRotation_period())
						: null);
		homeworld.setSurfaceWater(
				swHomeworld.getSurface_water() == "unknown" ? Integer.parseInt(swHomeworld.getSurface_water()) : null);
		homeworld.setTerrain(swHomeworld.getTerrain());
		return homeworld;
	}

	@Override
	public Optional<Character> findById(Long id) {
		SwapiCharacter swapiCharacter;
		try {
			swapiCharacter = restTemplate.getForObject("https://swapi.dev/api/people/" + id,
					SwapiCharacter.class);
			return Optional.ofNullable(convertCharacter(swapiCharacter));
		} catch (HttpClientErrorException e) {
			return Optional.ofNullable(null);
		}
	}
}
