package proyectitointerfaces;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gui.dialogs.DialogConsultarProducto;
import gui.dialogs.DialogModificarCelular;
import gui.dialogs.DialogListarProductos;
import gui.dialogs.DialogNuevaVenta;
import gui.dialogs.DialogDescuentos;
import gui.dialogs.DialogObsequios;
import gui.dialogs.DialogStocks;
import gui.dialogs.DialogAcercaDe;

public class Tienda extends JFrame {

    public static final int ANCHO_VENTANA = 800;
    public static final int ALTO_VENTANA = 600;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tienda frame = new Tienda();
            frame.setVisible(true);
        });
    }

    public Tienda() {
        setTitle("Sistema de Tienda Xiaomi");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, ANCHO_VENTANA, ALTO_VENTANA);
        setLocationRelativeTo(null);

        // Fondo general blanco
        getContentPane().setBackground(Color.WHITE);

        crearMenu();
    }

    private void crearMenu() {
        // Colores Xiaomi
        Color naranjaXiaomi = new Color(0xFF6900);
        Color blanco = Color.WHITE;
        Color negro = new Color(0x333333);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(naranjaXiaomi);
        menuBar.setForeground(blanco);
        setJMenuBar(menuBar);

        // Método auxiliar para estilizar menús
        Font fuenteMenu = new Font("Segoe UI", Font.BOLD, 14);

        JMenu menuArchivo = crearMenu("Archivo", fuenteMenu, blanco, naranjaXiaomi);
        JMenu menuMantenimiento = crearMenu("Mantenimiento", fuenteMenu, blanco, naranjaXiaomi);
        JMenu menuVentas = crearMenu("Ventas", fuenteMenu, blanco, naranjaXiaomi);
        JMenu menuConfiguracion = crearMenu("Configuración", fuenteMenu, blanco, naranjaXiaomi);
        JMenu menuAyuda = crearMenu("Ayuda", fuenteMenu, blanco, naranjaXiaomi);

        menuBar.add(menuArchivo);
        menuBar.add(menuMantenimiento);
        menuBar.add(menuVentas);
        menuBar.add(menuConfiguracion);
        menuBar.add(menuAyuda);

        // --- Archivo ---
        JMenuItem menuItemSalir = crearMenuItem("Salir", negro, blanco);
        menuArchivo.add(menuItemSalir);
        menuItemSalir.addActionListener(e -> {
            int r = JOptionPane.showConfirmDialog(
                null, "¿Desea salir?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) System.exit(0);
        });

        // --- Mantenimiento ---
        JMenuItem menuItemConsultar = crearMenuItem("Consultar Celular", negro, blanco);
        menuItemConsultar.addActionListener(e -> new DialogConsultarProducto(Tienda.this).setVisible(true));
        menuMantenimiento.add(menuItemConsultar);

        JMenuItem menuItemModificar = crearMenuItem("Modificar Celular", negro, blanco);
        menuItemModificar.addActionListener(e -> new DialogModificarCelular(Tienda.this).setVisible(true));
        menuMantenimiento.add(menuItemModificar);

        JMenuItem menuItemListar = crearMenuItem("Listar Celular", negro, blanco);
        menuItemListar.addActionListener(e -> new DialogListarProductos(Tienda.this).setVisible(true));
        menuMantenimiento.add(menuItemListar);

        // --- Ventas ---
        JMenuItem menuItemNuevaVenta = crearMenuItem("Vender", negro, blanco);
        menuItemNuevaVenta.addActionListener(e -> new DialogNuevaVenta(Tienda.this).setVisible(true));
        menuVentas.add(menuItemNuevaVenta);

        // --- Configuración ---
        JMenuItem menuItemDescuentos = crearMenuItem("Configurar Descuentos", negro, blanco);
        menuItemDescuentos.addActionListener(e -> new DialogDescuentos(Tienda.this).setVisible(true));
        menuConfiguracion.add(menuItemDescuentos);

        JMenuItem menuItemObsequios = crearMenuItem("Configurar Obsequios", negro, blanco);
        menuItemObsequios.addActionListener(e -> new DialogObsequios(Tienda.this).setVisible(true));
        menuConfiguracion.add(menuItemObsequios);

        JMenuItem menuItemStocks = crearMenuItem("Configurar Stocks", negro, blanco);
        menuItemStocks.addActionListener(e -> new DialogStocks(Tienda.this).setVisible(true));
        menuConfiguracion.add(menuItemStocks);

        // --- Ayuda ---
        JMenuItem menuItemAcerca = crearMenuItem("Acerca de Tienda", negro, blanco);
        menuItemAcerca.addActionListener(e -> new DialogAcercaDe(Tienda.this).setVisible(true));
        menuAyuda.add(menuItemAcerca);
    }

    // 🔹 Métodos auxiliares para estilo
    private JMenu crearMenu(String texto, Font fuente, Color fg, Color bg) {
        JMenu menu = new JMenu(texto);
        menu.setFont(fuente);
        menu.setForeground(fg);
        menu.getPopupMenu().setBackground(bg);
        menu.getPopupMenu().setForeground(fg);
        return menu;
    }

    private JMenuItem crearMenuItem(String texto, Color fg, Color bg) {
        JMenuItem item = new JMenuItem(texto);
        item.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        item.setForeground(fg);
        item.setBackground(bg);
        return item;
    }
}
