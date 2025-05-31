package com.farmacia.logica;

import com.farmacia.dto.ProductoDTO;

import java.io.*;
import java.util.ArrayList;

public class InventarioFarmacia {
    private ArrayList<ProductoDTO> productos;

    public InventarioFarmacia() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(ProductoDTO producto) {
        productos.add(producto);
    }

    public ProductoDTO buscarProductoPorCodigo(String codigoBarras) {
        for (ProductoDTO producto : productos) {
            if (producto.getCodigoBarras().equalsIgnoreCase(codigoBarras)) {
                return producto;
            }
        }
        return null;
    }

    public boolean venderProducto(String codigoBarras, int cantidadVendida) {
        ProductoDTO producto = buscarProductoPorCodigo(codigoBarras);
        if (producto != null && producto.getCantidadStock() >= cantidadVendida) {
            producto.setCantidadStock(producto.getCantidadStock() - cantidadVendida);
            return true;
        }
        return false;
    }

    public boolean actualizarPrecio(String codigoBarras, double nuevoPrecio) {
        ProductoDTO producto = buscarProductoPorCodigo(codigoBarras);
        if (producto != null) {
            producto.setPrecioUnitario(nuevoPrecio);
            return true;
        }
        return false;
    }

    public boolean eliminarProducto(String codigoBarras) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigoBarras().equalsIgnoreCase(codigoBarras)) {
                productos.remove(i);
                return true;
            }
        }
        return false;
    }

    public void guardarInventarioEnArchivo(File archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (ProductoDTO producto : productos) {
                writer.write(producto.getNombre() + "," +
                        producto.getCodigoBarras() + "," +
                        producto.getPrecioUnitario() + "," +
                        producto.getCantidadStock());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarInventarioDesdeArchivo(File archivo) {
        productos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String nombre = partes[0];
                    String codigoBarras = partes[1];
                    double precio = Double.parseDouble(partes[2]);
                    int cantidad = Integer.parseInt(partes[3]);
                    ProductoDTO producto = new ProductoDTO(nombre, codigoBarras, precio, cantidad);
                    productos.add(producto);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ProductoDTO> getProductos() {
        return productos;
    }
}
