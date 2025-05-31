package com.farmacia.gui;

import com.farmacia.dao.ProductoDAO;
import com.farmacia.dto.ProductoDTO;

import javax.swing.*;
import java.awt.*;

public class BuscarProducto extends JFrame {

    public BuscarProducto(ProductoDAO productoDAO) {
        setTitle("Buscar Producto por Código");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        JTextField txtCodigo = new JTextField();
        JButton btnBuscar = new JButton("Buscar");
        JTextArea resultado = new JTextArea();
        resultado.setEditable(false);

        add(new JLabel("Ingrese el código de barras:"));
        add(txtCodigo);
        add(btnBuscar);
        add(new JScrollPane(resultado));

        btnBuscar.addActionListener(e -> {
            String codigo = txtCodigo.getText().trim();
            ProductoDTO producto = productoDAO.buscarProducto(codigo);

            if (producto != null) {
                resultado.setText("Nombre: " + producto.getNombre() +
                        "\nPrecio: Q" + producto.getPrecioUnitario() +
                        "\nCantidad en stock: " + producto.getCantidadStock());
            } else {
                resultado.setText("Producto no encontrado.");
            }
        });
    }
}
