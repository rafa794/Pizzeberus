package com.hiberus.controladores;

import com.hiberus.excepciones.PizzaNotFoundException;
import com.hiberus.Pizza;
import com.hiberus.servicios.PizzaWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
@RestController
@RequestMapping("/api/pizzas")
public class PizzaWriteController {

    private final PizzaWriteService pizzaWriteService;

    @Autowired
    public PizzaWriteController(PizzaWriteService pizzaWriteService) {
        this.pizzaWriteService = pizzaWriteService;
    }


    @PostMapping
    public Pizza crearPizza(@RequestBody Pizza pizza) {
        return pizzaWriteService.crearPizza(pizza);
    }


    @PutMapping("/{id}")
    public Pizza modificarPizza(@PathVariable Long id, @RequestBody Pizza pizza) throws PizzaNotFoundException {
        return pizzaWriteService.modificarPizza(id, pizza);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPizza(@PathVariable Long id) throws PizzaNotFoundException {
        pizzaWriteService.eliminarPizza(id);
        return ResponseEntity.noContent().build();
    }
    @ExceptionHandler(PizzaNotFoundException.class)
    public ResponseEntity<String> handlePizzaNotFoundException(PizzaNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

