package com.streamsub.service;

import com.streamsub.model.Plan;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PlanService {
    private final Map<Long, Plan> data = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public PlanService() {
        crear(new Plan(null, "Básico", 19.90, "SD", 1, "Ideal para un usuario, calidad estándar."));
        crear(new Plan(null, "Estándar", 29.90, "HD", 2, "Dos pantallas simultáneas en alta definición."));
        crear(new Plan(null, "Premium", 39.90, "4K", 4, "Cuatro pantallas simultáneas en calidad 4K."));
    }

    public List<Plan> listar() { return new ArrayList<>(data.values()); }
    public Plan buscar(Long id) { return data.get(id); }

    public Plan crear(Plan p) {
        p.setIdPlan(seq.getAndIncrement());
        data.put(p.getIdPlan(), p);
        return p;
    }

    public void actualizar(Plan p) { data.put(p.getIdPlan(), p); }
    public void eliminar(Long id) { data.remove(id); }
}
