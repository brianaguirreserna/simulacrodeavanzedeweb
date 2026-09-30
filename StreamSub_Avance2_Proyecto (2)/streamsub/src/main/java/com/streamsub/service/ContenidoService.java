package com.streamsub.service;

import com.streamsub.model.Contenido;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ContenidoService {
    private final Map<Long, Contenido> data = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public ContenidoService() {
        crear(new Contenido(null, "Fuerza Máxima", "Película", 2024, 118, "Un agente encubierto evita un ataque a la ciudad.", 1L));
        crear(new Contenido(null, "El Planeta Azul", "Serie", 2023, 45, "Documental sobre los océanos del mundo.", 2L));
        crear(new Contenido(null, "Aventuras de Coco", "Serie", 2022, 22, "Serie infantil sobre un pequeño explorador.", 3L));
        crear(new Contenido(null, "Noches de Invierno", "Película", 2021, 105, "Drama familiar ambientado en los Andes.", 4L));
    }

    public List<Contenido> listar() { return new ArrayList<>(data.values()); }
    public Contenido buscar(Long id) { return data.get(id); }

    public Contenido crear(Contenido c) {
        c.setIdContenido(seq.getAndIncrement());
        data.put(c.getIdContenido(), c);
        return c;
    }

    public void actualizar(Contenido c) { data.put(c.getIdContenido(), c); }
    public void eliminar(Long id) { data.remove(id); }
}
