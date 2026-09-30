package com.streamsub.controller;

import com.streamsub.model.Plan;
import com.streamsub.service.PlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/planes")
public class PlanController {

    private final PlanService service;

    public PlanController(PlanService service) { this.service = service; }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("planes", service.listar());
        return "planes/list";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("plan", new Plan());
        return "planes/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Plan plan) {
        if (plan.getIdPlan() == null) service.crear(plan);
        else service.actualizar(plan);
        return "redirect:/planes";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        model.addAttribute("plan", service.buscar(id));
        return "planes/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/planes";
    }
}
