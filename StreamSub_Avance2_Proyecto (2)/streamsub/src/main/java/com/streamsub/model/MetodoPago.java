package com.streamsub.model;

public class MetodoPago {
    private Long idMetodoPago;
    private Long idUsuario;
    private String tipo; // Tarjeta credito/debito, Billetera digital
    private String titular;
    private String numeroEnmascarado;
    private String fechaVencimiento; // MM/AA
    private String estado = "Vigente";

    public MetodoPago() {}

    public MetodoPago(Long idMetodoPago, Long idUsuario, String tipo, String titular, String numeroEnmascarado, String fechaVencimiento, String estado) {
        this.idMetodoPago = idMetodoPago;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.titular = titular;
        this.numeroEnmascarado = numeroEnmascarado;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }

    public Long getIdMetodoPago() { return idMetodoPago; }
    public void setIdMetodoPago(Long idMetodoPago) { this.idMetodoPago = idMetodoPago; }
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }
    public String getNumeroEnmascarado() { return numeroEnmascarado; }
    public void setNumeroEnmascarado(String numeroEnmascarado) { this.numeroEnmascarado = numeroEnmascarado; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
