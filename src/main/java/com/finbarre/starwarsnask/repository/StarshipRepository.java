package com.finbarre.starwarsnask.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finbarre.starwarsnask.payload.Character;
import com.finbarre.starwarsnask.payload.Homeworld;
import com.finbarre.starwarsnask.payload.Starship;

@SuppressWarnings("unused")
@Repository
public interface StarshipRepository extends JpaRepository<Starship, Long> {

}
