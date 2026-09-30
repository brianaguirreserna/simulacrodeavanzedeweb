package com.streamsub.controller;

import com.streamsub.model.Suscripcion;
import com.streamsub.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/suscripciones")
public class SuscripcionController {

    private final SuscripcionService service;
    private final UsuarioService usuarioService;
    private final PlanService planService;
    private final MetodoPagoService metodoPagoService;

    public SuscripcionController(SuscripcionService service, UsuarioService usuarioService,
                                  PlanService planService, MetodoPagoService metodoPagoService) {
        this.service = service;
        this.usuarioService = usuarioService;
        this.planService = planService;
        this.metodoPagoService = metodoPagoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("suscripciones", service.listar());
        return "suscripciones/list";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("suscripcion", new Suscripcion());
        cargarCombos(model);
        return "suscripciones/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Suscripcion suscripcion) {
        if (suscripcion.getIdSuscripcion() == null) service.crear(suscripcion);
        else service.actualizar(suscripcion);
        return "redirect:/suscripciones";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        model.addAttribute("suscripcion", service.buscar(id));
        cargarCombos(model);
        return "suscripciones/form";
    }

    @GetMapping("/cancelar/{id}")
    public String cancelar(@PathVariable Long id) {
        service.cancelar(id);
        return "redirect:/suscripciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/suscripciones";
    }

    private void cargarCombos(Model model) {
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("planes", planService.listar());
        model.addAttribute("metodosPago", metodoPagoService.listar());
    }
}
