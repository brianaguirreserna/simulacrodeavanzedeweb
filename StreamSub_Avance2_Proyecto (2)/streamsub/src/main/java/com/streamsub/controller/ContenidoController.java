package com.streamsub.controller;

import com.streamsub.model.Contenido;
import com.streamsub.service.CategoriaService;
import com.streamsub.service.ContenidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contenidos")
public class ContenidoController {

    private final ContenidoService service;
    private final CategoriaService categoriaService;

    public ContenidoController(ContenidoService service, CategoriaService categoriaService) {
        this.service = service;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("contenidos", service.listar());
        return "contenidos/list";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("contenido", new Contenido());
        model.addAttribute("categorias", categoriaService.listar());
        return "contenidos/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contenido contenido) {
        if (contenido.getIdContenido() == null) service.crear(contenido);
        else service.actualizar(contenido);
        return "redirect:/contenidos";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        model.addAttribute("contenido", service.buscar(id));
        model.addAttribute("categorias", categoriaService.listar());
        return "contenidos/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/contenidos";
    }
}
