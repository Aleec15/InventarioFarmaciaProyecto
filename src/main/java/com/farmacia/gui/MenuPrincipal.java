package com.farmacia.gui;

import com.farmacia.dao.ProductoDAO;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    private final ProductoDAO productoDAO;

    public MenuPrincipal() {
        productoDAO = new ProductoDAO();

        setTitle("Sistema de Inventario de Farmacia");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 3, 10, 10));

        JButton btnRegistrar = new JButton("Registrar Producto");
        JButton btnConsultar = new JButton("Consultar Inventario");
        JButton btnBuscar = new JButton("Buscar Producto");
        JButton btnVender = new JButton("Vender Producto");
        JButton btnActualizar = new JButton("Actualizar Precio");
        JButton btnEliminar = new JButton("Eliminar Producto");

        add(btnRegistrar);
        add(btnConsultar);
        add(btnBuscar);
        add(btnVender);
        add(btnActualizar);
        add(btnEliminar);

        // Acciones
        btnRegistrar.addActionListener(e -> new RegistrarProducto(productoDAO).setVisible(true));
        btnConsultar.addActionListener(e -> new ConsultarInventario(productoDAO).setVisible(true));
        btnBuscar.addActionListener(e -> new BuscarProducto(productoDAO).setVisible(true));
        btnVender.addActionListener(e -> new VenderProducto(productoDAO).setVisible(true));
        btnActualizar.addActionListener(e -> new ActualizarPrecio(productoDAO).setVisible(true));
        btnEliminar.addActionListener(e -> new EliminarProducto(productoDAO).setVisible(true));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}

