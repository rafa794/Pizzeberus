package com.hiberus.feignClient;

import com.hiberus.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-crud")
public interface UserFeignClient {

    @GetMapping(value = "/users/{id}")
    Usuario getUserById(@PathVariable Long id); // Define los métodos que necesitas
}
