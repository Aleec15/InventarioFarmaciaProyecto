package com.farmacia.dto;

public class ProductoDTO {
    private String nombre;
    private String codigoBarras;
    private double precioUnitario;
    private int cantidadStock;

    // Constructor vacío
    public ProductoDTO() {
    }

    // Constructor completo
    public ProductoDTO(String nombre, String codigoBarras, double precioUnitario, int cantidadStock) {
        this.nombre = nombre;
        this.codigoBarras = codigoBarras;
        this.precioUnitario = precioUnitario;
        this.cantidadStock = cantidadStock;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "nombre='" + nombre + '\'' +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", cantidadStock=" + cantidadStock +
                '}';
    }
}
