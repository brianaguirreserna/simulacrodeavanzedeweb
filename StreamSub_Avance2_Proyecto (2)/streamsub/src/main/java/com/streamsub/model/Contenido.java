package com.streamsub.model;

public class Contenido {
    private Long idContenido;
    private String titulo;
    private String tipo; // Pelicula / Serie
    private int anioLanzamiento;
    private int duracionMin;
    private String sinopsis;
    private Long idCategoria;

    public Contenido() {}

    public Contenido(Long idContenido, String titulo, String tipo, int anioLanzamiento, int duracionMin, String sinopsis, Long idCategoria) {
        this.idContenido = idContenido;
        this.titulo = titulo;
        this.tipo = tipo;
        this.anioLanzamiento = anioLanzamiento;
        this.duracionMin = duracionMin;
        this.sinopsis = sinopsis;
        this.idCategoria = idCategoria;
    }

    public Long getIdContenido() { return idContenido; }
    public void setIdContenido(Long idContenido) { this.idContenido = idContenido; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getAnioLanzamiento() { return anioLanzamiento; }
    public void setAnioLanzamiento(int anioLanzamiento) { this.anioLanzamiento = anioLanzamiento; }
    public int getDuracionMin() { return duracionMin; }
    public void setDuracionMin(int duracionMin) { this.duracionMin = duracionMin; }
    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
    public Long getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Long idCategoria) { this.idCategoria = idCategoria; }
}
