package com.streamsub.controller;

import com.streamsub.model.MetodoPago;
import com.streamsub.service.MetodoPagoService;
import com.streamsub.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/metodos-pago")
public class MetodoPagoController {

    private final MetodoPagoService service;
    private final UsuarioService usuarioService;

    public MetodoPagoController(MetodoPagoService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("metodosPago", service.listar());
        return "metodospago/list";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("metodoPago", new MetodoPago());
        model.addAttribute("usuarios", usuarioService.listar());
        return "metodospago/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute MetodoPago metodoPago) {
        if (metodoPago.getIdMetodoPago() == null) service.crear(metodoPago);
        else service.actualizar(metodoPago);
        return "redirect:/metodos-pago";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        model.addAttribute("metodoPago", service.buscar(id));
        model.addAttribute("usuarios", usuarioService.listar());
        return "metodospago/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/metodos-pago";
    }
}
