package com.farmacia.gui;

import com.farmacia.dao.ProductoDAO;

import javax.swing.*;
import java.awt.*;

public class EliminarProducto extends JFrame {

    public EliminarProducto(ProductoDAO productoDAO) {
        setTitle("Eliminar Producto");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel lblCodigo = new JLabel("Código de Barras:");
        JTextField txtCodigo = new JTextField();

        JButton btnEliminar = new JButton("Eliminar Producto");

        add(lblCodigo);
        add(txtCodigo);
        add(new JLabel());
        add(btnEliminar);

        btnEliminar.addActionListener(e -> {
            String codigo = txtCodigo.getText().trim();

            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el producto?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                boolean eliminado = productoDAO.eliminarProducto(codigo);
                if (eliminado) {
                    JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró el producto o no se pudo eliminar.");
                }
            }
        });
    }
}
