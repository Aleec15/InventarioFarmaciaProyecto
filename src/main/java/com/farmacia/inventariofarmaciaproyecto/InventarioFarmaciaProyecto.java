package com.farmacia.inventariofarmaciaproyecto;

import com.farmacia.gui.MenuPrincipal;
import javax.swing.SwingUtilities;

public class InventarioFarmaciaProyecto {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }
}
