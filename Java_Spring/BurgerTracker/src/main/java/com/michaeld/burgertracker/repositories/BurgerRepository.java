package com.michaeld.burgertracker.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michaeld.burgertracker.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
	ArrayList<Burger> findAll();
	ArrayList<Burger> findByName(String search);
}
