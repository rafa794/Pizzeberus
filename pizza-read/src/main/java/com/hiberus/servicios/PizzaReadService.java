package com.hiberus.servicios;

import com.hiberus.Pizza;
import com.hiberus.repositorios.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaReadService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaReadService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }


    public List<Pizza> listarPizzas() {
        return pizzaRepository.findAll();
    }


    public Pizza getPizzaById(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }
}
