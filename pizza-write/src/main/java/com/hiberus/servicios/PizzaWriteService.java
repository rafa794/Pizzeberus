package com.hiberus.servicios;

import com.hiberus.excepciones.PizzaNotFoundException;
import com.hiberus.Pizza;
import com.hiberus.repositorios.PizzaWriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PizzaWriteService {

    private final PizzaWriteRepository pizzaWriteRepository;

    @Autowired
    public PizzaWriteService(PizzaWriteRepository pizzaWriteRepository) {
        this.pizzaWriteRepository = pizzaWriteRepository;
    }

    @Transactional
    public Pizza crearPizza(Pizza pizza) {

        return pizzaWriteRepository.save(pizza);
    }

    @Transactional
    public Pizza modificarPizza(Long id, Pizza pizza) throws PizzaNotFoundException {

        Pizza pizzaExistente = pizzaWriteRepository.findById(id).orElse(null);

        if (pizzaExistente != null) {
            pizzaExistente.setNombre(pizza.getNombre());

            return pizzaWriteRepository.save(pizzaExistente);
        } else {

            throw new PizzaNotFoundException("La pizza con ID " + id + " no se encontró.");
        }
    }
    public void eliminarPizza(Long id) throws PizzaNotFoundException {
        if (!pizzaWriteRepository.existsById(id)) {
            throw new PizzaNotFoundException("Pizza con ID " + id + " no encontrada.");
        }
        pizzaWriteRepository.deleteById(id);
    }

}
