package com.farmacia.gui;

import com.farmacia.dao.ProductoDAO;
import com.farmacia.dto.ProductoDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegistrarProducto extends JFrame {

    public RegistrarProducto(ProductoDAO productoDAO) {
        setTitle("Registrar Producto");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        JLabel lblCodigo = new JLabel("Código de Barras:");
        JTextField txtCodigo = new JTextField();
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblPrecio = new JLabel("Precio Unitario:");
        JTextField txtPrecio = new JTextField();
        JLabel lblCantidad = new JLabel("Cantidad en Stock:");
        JTextField txtCantidad = new JTextField();

        JButton btnRegistrar = new JButton("Registrar");

        add(lblCodigo);
        add(txtCodigo);
        add(lblNombre);
        add(txtNombre);
        add(lblPrecio);
        add(txtPrecio);
        add(lblCantidad);
        add(txtCantidad);
        add(new JLabel()); // vacío para alinear
        add(btnRegistrar);

        btnRegistrar.addActionListener((ActionEvent e) -> {
            String codigo = txtCodigo.getText().trim();
            String nombre = txtNombre.getText().trim();
            double precio;
            int cantidad;
            try {
                precio = Double.parseDouble(txtPrecio.getText().trim());
                cantidad = Integer.parseInt(txtCantidad.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Precio o cantidad inválida.");
                return;
            }

            ProductoDTO nuevoProducto = new ProductoDTO(codigo, nombre, precio, cantidad);
            boolean exito = productoDAO.agregarProducto(nuevoProducto);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Producto registrado correctamente.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el producto.");
            }
        });
    }
}
