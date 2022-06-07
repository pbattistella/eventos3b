package br.senai.controller;

import br.senai.model.Evento;
import br.senai.service.ClienteServiceImpl;
import br.senai.service.EventoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventoController {
    @Autowired
    EventoServiceImpl eventoService;

    @Autowired
    ClienteServiceImpl clienteService;

    @GetMapping("/evento/list")
    public String findAll(Model model){
        model.addAttribute("eventos", eventoService.findAll());
        return "evento/list";
    }

    @GetMapping("/evento/add")
    public String add(Model model){
        model.addAttribute("evento", new Evento());
        model.addAttribute("clientes", clienteService.findAll());
        return "evento/add";
    }

    @GetMapping("/evento/edit/{id}")
    public String edit(Model model, @PathVariable long id){
        model.addAttribute("evento", eventoService.findById(id));
        model.addAttribute("clientes", clienteService.findAll());
        return "evento/edit";
    }

    @PostMapping("/evento/save")
    public String save(Evento evento, Model model){
        try{
            Evento newEvento = eventoService.save(evento);
            model.addAttribute("evento", newEvento);
            model.addAttribute("isSave", true);
            model.addAttribute("isError", false);
            model.addAttribute("clientes", clienteService.findAll());
            return "/evento/add";
        }catch (Exception e){
            model.addAttribute("evento", evento);
            model.addAttribute("isSave", false);
            model.addAttribute("isError", true);
            model.addAttribute("clientes", clienteService.findAll());
            return "/evento/add";
        }
    }


    @GetMapping("/evento/delete/{id}")
    public String delete(@PathVariable long id){
        try{
            eventoService.deleteById(id);
        }catch (Exception e){
            System.out.println("Erro ao deletar" + e.getMessage());
        }
        return "redierct:/evento/list";
    }

}
