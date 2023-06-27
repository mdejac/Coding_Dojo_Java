package com.michaeld.burgertracker.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.michaeld.burgertracker.models.Burger;
import com.michaeld.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	public Burger create(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public ArrayList<Burger> allBurgers() {
		return burgerRepository.findAll();
	}
	
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        return optionalBurger.isPresent() ? optionalBurger.get() : null;
    }
	
	public ArrayList<Burger> findByName(String search){
		return burgerRepository.findByName(search);
	}
}
