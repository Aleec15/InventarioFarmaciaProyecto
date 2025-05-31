package com.farmacia.dao;

import com.farmacia.dto.ProductoDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private final String URL = "jdbc:mysql://localhost:3306/farmacia";
    private final String USER = "root";
    private final String PASSWORD = ""; // Cambia esto si tienes contraseña

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public boolean agregarProducto(ProductoDTO producto) {
        String sql = "INSERT INTO productos (codigo_barras, nombre, precio_unitario, cantidad_stock) VALUES (?, ?, ?, ?)";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getCodigoBarras());
            stmt.setString(2, producto.getNombre());
            stmt.setDouble(3, producto.getPrecioUnitario());
            stmt.setInt(4, producto.getCantidadStock());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ProductoDTO buscarProducto(String codigo) {
        String sql = "SELECT * FROM productos WHERE codigo_barras = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ProductoDTO(
                        rs.getString("nombre"),
                        rs.getString("codigo_barras"),
                        rs.getDouble("precio_unitario"),
                        rs.getInt("cantidad_stock")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ProductoDTO> obtenerTodosLosProductos() {
        List<ProductoDTO> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection conn = conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ProductoDTO producto = new ProductoDTO(
                        rs.getString("nombre"),
                        rs.getString("codigo_barras"),
                        rs.getDouble("precio_unitario"),
                        rs.getInt("cantidad_stock")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public boolean actualizarPrecio(String codigo, double nuevoPrecio) {
        String sql = "UPDATE productos SET precio_unitario = ? WHERE codigo_barras = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, nuevoPrecio);
            stmt.setString(2, codigo);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean venderProducto(String codigo, int cantidadVendida) {
        String sql = "UPDATE productos SET cantidad_stock = cantidad_stock - ? WHERE codigo_barras = ? AND cantidad_stock >= ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cantidadVendida);
            stmt.setString(2, codigo);
            stmt.setInt(3, cantidadVendida);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProducto(String codigo) {
        String sql = "DELETE FROM productos WHERE codigo_barras = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
