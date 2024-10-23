package br.com.fabiopereira.casamento_api.controllers;

import br.com.fabiopereira.casamento_api.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaService service;
}
