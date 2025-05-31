package com.farmacia.gui;

import com.farmacia.dao.ProductoDAO;

import javax.swing.*;
import java.awt.*;

public class VenderProducto extends JFrame {

    public VenderProducto(ProductoDAO productoDAO) {
        setTitle("Vender Producto");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        JLabel lblCodigo = new JLabel("Código de Barras:");
        JTextField txtCodigo = new JTextField();
        JLabel lblCantidad = new JLabel("Cantidad a Vender:");
        JTextField txtCantidad = new JTextField();

        JButton btnVender = new JButton("Vender");

        add(lblCodigo);
        add(txtCodigo);
        add(lblCantidad);
        add(txtCantidad);
        add(new JLabel()); // espacio vacío
        add(btnVender);

        btnVender.addActionListener(e -> {
            String codigo = txtCodigo.getText().trim();
            int cantidad;
            try {
                cantidad = Integer.parseInt(txtCantidad.getText().trim());
                boolean exito = productoDAO.venderProducto(codigo, cantidad);

                if (exito) {
                    JOptionPane.showMessageDialog(this, "Venta realizada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error: No se pudo vender el producto.\nRevise el código o la cantidad.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad válida.");
            }
        });
    }
}
