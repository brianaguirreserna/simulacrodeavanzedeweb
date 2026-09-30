package com.streamsub.service;

import com.streamsub.model.Suscripcion;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SuscripcionService {
    private final Map<Long, Suscripcion> data = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public SuscripcionService() {
        crear(new Suscripcion(null, 1L, 3L, 1L, LocalDate.now().minusDays(10), LocalDate.now().plusDays(20), true, "Activa"));
        crear(new Suscripcion(null, 2L, 2L, 2L, LocalDate.now().minusDays(5), LocalDate.now().plusDays(25), true, "Activa"));
    }

    public List<Suscripcion> listar() { return new ArrayList<>(data.values()); }
    public Suscripcion buscar(Long id) { return data.get(id); }

    public Suscripcion crear(Suscripcion s) {
        s.setIdSuscripcion(seq.getAndIncrement());
        data.put(s.getIdSuscripcion(), s);
        return s;
    }

    public void actualizar(Suscripcion s) { data.put(s.getIdSuscripcion(), s); }
    public void eliminar(Long id) { data.remove(id); }

    /** Cancelar: solo se apaga la renovación automática (mantiene acceso hasta fechaFin). */
    public void cancelar(Long id) {
        Suscripcion s = data.get(id);
        if (s != null) s.setRenovacionAutomatica(false);
    }
}
