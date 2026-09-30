package com.streamsub.service;

import com.streamsub.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CategoriaService {
    private final Map<Long, Categoria> data = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public CategoriaService() {
        crear(new Categoria(null, "Acción", "Películas y series de acción y aventura", true));
        crear(new Categoria(null, "Documentales", "Contenido documental y no ficción", true));
        crear(new Categoria(null, "Series Infantiles", "Contenido para el público infantil", true));
        crear(new Categoria(null, "Drama", "Series y películas dramáticas", true));
    }

    public List<Categoria> listar() { return new ArrayList<>(data.values()); }
    public Categoria buscar(Long id) { return data.get(id); }

    public Categoria crear(Categoria c) {
        c.setIdCategoria(seq.getAndIncrement());
        data.put(c.getIdCategoria(), c);
        return c;
    }

    public void actualizar(Categoria c) { data.put(c.getIdCategoria(), c); }
    public void eliminar(Long id) { data.remove(id); }
}
