package com.streamsub.controller;

import com.streamsub.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginasController {

    private final CategoriaService categoriaService;
    private final ContenidoService contenidoService;
    private final PlanService planService;
    private final UsuarioService usuarioService;
    private final MetodoPagoService metodoPagoService;
    private final SuscripcionService suscripcionService;

    public PaginasController(CategoriaService categoriaService, ContenidoService contenidoService,
                              PlanService planService, UsuarioService usuarioService,
                              MetodoPagoService metodoPagoService, SuscripcionService suscripcionService) {
        this.categoriaService = categoriaService;
        this.contenidoService = contenidoService;
        this.planService = planService;
        this.usuarioService = usuarioService;
        this.metodoPagoService = metodoPagoService;
        this.suscripcionService = suscripcionService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("totalCategorias", categoriaService.listar().size());
        model.addAttribute("totalContenidos", contenidoService.listar().size());
        model.addAttribute("totalPlanes", planService.listar().size());
        model.addAttribute("totalUsuarios", usuarioService.listar().size());
        model.addAttribute("totalMetodosPago", metodoPagoService.listar().size());
        model.addAttribute("totalSuscripciones", suscripcionService.listar().size());
        return "index";
    }

    @GetMapping("/publicidad")
    public String publicidad() {
        return "publicidad";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }
}
