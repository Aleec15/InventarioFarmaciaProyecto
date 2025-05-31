package com.farmacia.gui;

import com.farmacia.dao.ProductoDAO;

import javax.swing.*;
import java.awt.*;

public class ActualizarPrecio extends JFrame {

    public ActualizarPrecio(ProductoDAO productoDAO) {
        setTitle("Actualizar Precio de Producto");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        JLabel lblCodigo = new JLabel("Código de Barras:");
        JTextField txtCodigo = new JTextField();

        JLabel lblNuevoPrecio = new JLabel("Nuevo Precio:");
        JTextField txtPrecio = new JTextField();

        JButton btnActualizar = new JButton("Actualizar Precio");

        add(lblCodigo);
        add(txtCodigo);
        add(lblNuevoPrecio);
        add(txtPrecio);
        add(new JLabel());
        add(btnActualizar);

        btnActualizar.addActionListener(e -> {
            String codigo = txtCodigo.getText().trim();
            try {
                double nuevoPrecio = Double.parseDouble(txtPrecio.getText().trim());

                boolean actualizado = productoDAO.actualizarPrecio(codigo, nuevoPrecio);

                if (actualizado) {
                    JOptionPane.showMessageDialog(this, "Precio actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró el producto o no se pudo actualizar.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un precio válido.");
            }
        });
    }
}
