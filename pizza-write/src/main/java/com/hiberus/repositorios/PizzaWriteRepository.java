package com.hiberus.repositorios;
import com.hiberus.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaWriteRepository extends JpaRepository<Pizza, Long> {
    Pizza save(Pizza pizza);
}

