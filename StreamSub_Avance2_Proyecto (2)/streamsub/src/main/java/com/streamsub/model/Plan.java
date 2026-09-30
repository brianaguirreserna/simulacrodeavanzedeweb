package com.streamsub.model;

public class Plan {
    private Long idPlan;
    private String nombre;
    private double precioMensual;
    private String calidadVideo; // SD, HD, 4K
    private int pantallasSimultaneas;
    private String descripcion;

    public Plan() {}

    public Plan(Long idPlan, String nombre, double precioMensual, String calidadVideo, int pantallasSimultaneas, String descripcion) {
        this.idPlan = idPlan;
        this.nombre = nombre;
        this.precioMensual = precioMensual;
        this.calidadVideo = calidadVideo;
        this.pantallasSimultaneas = pantallasSimultaneas;
        this.descripcion = descripcion;
    }

    public Long getIdPlan() { return idPlan; }
    public void setIdPlan(Long idPlan) { this.idPlan = idPlan; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecioMensual() { return precioMensual; }
    public void setPrecioMensual(double precioMensual) { this.precioMensual = precioMensual; }
    public String getCalidadVideo() { return calidadVideo; }
    public void setCalidadVideo(String calidadVideo) { this.calidadVideo = calidadVideo; }
    public int getPantallasSimultaneas() { return pantallasSimultaneas; }
    public void setPantallasSimultaneas(int pantallasSimultaneas) { this.pantallasSimultaneas = pantallasSimultaneas; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
