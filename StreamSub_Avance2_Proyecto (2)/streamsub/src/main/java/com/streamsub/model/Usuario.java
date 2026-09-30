package com.streamsub.model;

import java.time.LocalDate;

public class Usuario {
    private Long idUsuario;
    private String nombreCompleto;
    private String email;
    private LocalDate fechaRegistro = LocalDate.now();
    private String estado = "Activo";

    public Usuario() {}

    public Usuario(Long idUsuario, String nombreCompleto, String email, LocalDate fechaRegistro, String estado) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
