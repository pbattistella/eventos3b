package br.senai.controller;

import br.senai.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
    @Autowired
    ClienteServiceImpl clienteService;

    @GetMapping("/cliente/list")
    public String findAll(Model model){
        model.addAttribute("clientes", clienteService.findAll());
        return "cliente/list";

    }
}
