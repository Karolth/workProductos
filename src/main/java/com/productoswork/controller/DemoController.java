package com.productoswork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/api/saludo")
    public String saludo() {
        return "👋 Hola! Tu petición fue aceptada.";
    }
}