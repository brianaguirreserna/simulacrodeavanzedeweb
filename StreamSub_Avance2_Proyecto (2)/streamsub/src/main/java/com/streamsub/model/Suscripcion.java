package com.streamsub.model;

import java.time.LocalDate;

public class Suscripcion {
    private Long idSuscripcion;
    private Long idUsuario;
    private Long idPlan;
    private Long idMetodoPago;
    private LocalDate fechaInicio = LocalDate.now();
    private LocalDate fechaFin = LocalDate.now().plusMonths(1);
    private boolean renovacionAutomatica = true;
    private String estado = "Activa"; // Activa, Cancelada, Vencida

    public Suscripcion() {}

    public Suscripcion(Long idSuscripcion, Long idUsuario, Long idPlan, Long idMetodoPago,
                        LocalDate fechaInicio, LocalDate fechaFin, boolean renovacionAutomatica, String estado) {
        this.idSuscripcion = idSuscripcion;
        this.idUsuario = idUsuario;
        this.idPlan = idPlan;
        this.idMetodoPago = idMetodoPago;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.renovacionAutomatica = renovacionAutomatica;
        this.estado = estado;
    }

    public Long getIdSuscripcion() { return idSuscripcion; }
    public void setIdSuscripcion(Long idSuscripcion) { this.idSuscripcion = idSuscripcion; }
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public Long getIdPlan() { return idPlan; }
    public void setIdPlan(Long idPlan) { this.idPlan = idPlan; }
    public Long getIdMetodoPago() { return idMetodoPago; }
    public void setIdMetodoPago(Long idMetodoPago) { this.idMetodoPago = idMetodoPago; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public boolean isRenovacionAutomatica() { return renovacionAutomatica; }
    public void setRenovacionAutomatica(boolean renovacionAutomatica) { this.renovacionAutomatica = renovacionAutomatica; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
