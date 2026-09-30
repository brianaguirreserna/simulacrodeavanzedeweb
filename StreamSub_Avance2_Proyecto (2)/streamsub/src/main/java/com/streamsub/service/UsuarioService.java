package com.streamsub.service;

import com.streamsub.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuarioService {
    private final Map<Long, Usuario> data = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public UsuarioService() {
        crear(new Usuario(null, "María Fernández Ruiz", "maria.fernandez@correo.com", LocalDate.of(2024, 3, 12), "Activo"));
        crear(new Usuario(null, "Carlos Huamán Torres", "carlos.huaman@correo.com", LocalDate.of(2024, 6, 2), "Activo"));
        crear(new Usuario(null, "Lucía Vega Paredes", "lucia.vega@correo.com", LocalDate.of(2025, 1, 20), "Activo"));
    }

    public List<Usuario> listar() { return new ArrayList<>(data.values()); }
    public Usuario buscar(Long id) { return data.get(id); }

    public Usuario crear(Usuario u) {
        u.setIdUsuario(seq.getAndIncrement());
        data.put(u.getIdUsuario(), u);
        return u;
    }

    public void actualizar(Usuario u) { data.put(u.getIdUsuario(), u); }
    public void eliminar(Long id) { data.remove(id); }
}
