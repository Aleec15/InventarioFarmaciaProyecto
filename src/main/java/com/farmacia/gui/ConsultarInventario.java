package com.farmacia.gui;

import com.farmacia.dao.ProductoDAO;
import com.farmacia.dto.ProductoDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ConsultarInventario extends JFrame {

    public ConsultarInventario(ProductoDAO productoDAO) {
        setTitle("Inventario de Productos");
        setSize(600, 400);
        setLocationRelativeTo(null);

        String[] columnas = {"Código", "Nombre", "Precio Unitario", "Cantidad"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modelo);

        List<ProductoDTO> lista = productoDAO.obtenerTodosLosProductos();
        for (ProductoDTO p : lista) {
            Object[] fila = {
                    p.getCodigoBarras(),
                    p.getNombre(),
                    p.getPrecioUnitario(),
                    p.getCantidadStock()
            };
            modelo.addRow(fila);
        }

        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
    }
}
