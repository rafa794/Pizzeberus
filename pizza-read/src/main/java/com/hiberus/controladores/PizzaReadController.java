package com.hiberus.controladores;

import com.hiberus.feignClient.UserFeignClient;
import com.hiberus.Pizza;
import com.hiberus.servicios.PizzaReadService;
import com.hiberus.excepciones.PizzaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@ControllerAdvice
@RestController
@RequestMapping("api/pizzas")
public class PizzaReadController {

    private final PizzaReadService pizzaService;
    private final UserFeignClient userFeignClient;

    @Autowired
    public PizzaReadController(PizzaReadService pizzaService, UserFeignClient userFeignClient) {
        this.pizzaService = pizzaService;
        this.userFeignClient = userFeignClient;
    }

    @GetMapping("/{id}")
    public Pizza getPizzaById(@PathVariable Long id) throws PizzaNotFoundException {
        Pizza pizza = pizzaService.getPizzaById(id);
        return pizza;
    }



    @GetMapping
    public List<Pizza> listarPizzas() {
        return pizzaService.listarPizzas();
    }
}


