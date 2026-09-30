package com.streamsub.service;

import com.streamsub.model.MetodoPago;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MetodoPagoService {
    private final Map<Long, MetodoPago> data = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public MetodoPagoService() {
        crear(new MetodoPago(null, 1L, "Tarjeta de crédito", "María Fernández Ruiz", "**** **** **** 4521", "09/28", "Vigente"));
        crear(new MetodoPago(null, 2L, "Billetera digital", "Carlos Huamán Torres", "Yape - 987***321", "N/A", "Vigente"));
        crear(new MetodoPago(null, 3L, "Tarjeta de débito", "Lucía Vega Paredes", "**** **** **** 7788", "01/24", "Vencido"));
    }

    public List<MetodoPago> listar() { return new ArrayList<>(data.values()); }
    public MetodoPago buscar(Long id) { return data.get(id); }

    public MetodoPago crear(MetodoPago m) {
        m.setIdMetodoPago(seq.getAndIncrement());
        data.put(m.getIdMetodoPago(), m);
        return m;
    }

    public void actualizar(MetodoPago m) { data.put(m.getIdMetodoPago(), m); }
    public void eliminar(Long id) { data.remove(id); }
}
