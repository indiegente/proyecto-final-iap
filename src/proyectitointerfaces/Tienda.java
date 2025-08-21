package proyectitointerfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

// Importa todos los JDialogs
import gui.dialogs.DialogConsultarProducto;
import gui.dialogs.DialogModificarProducto;
import gui.dialogs.DialogListarProductos;
import gui.dialogs.DialogNuevaVenta;
import gui.dialogs.DialogDescuentos;
import gui.dialogs.DialogObsequios;
import gui.dialogs.DialogAcercaDe;

/**
 * Ventana principal del sistema de gestión de tienda de celulares Xiaomi.
 * Versión simplificada para introducción a la algoritmia.
 */
public class Tienda extends JFrame {

    // Variables globales (campos de clase)
    private JPanel contentPane;
    private JTabbedPane tabbedPane;

    // Constantes simples
    public static final int ANCHO_VENTANA = 800;
    public static final int ALTO_VENTANA = 600;

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Tienda frame = new Tienda();
                frame.setVisible(true);
            }
        });
    }

    // Constructor de la ventana principal
    public Tienda() {
        // Configuración básica de la ventana
        setTitle("Sistema de Tienda Xiaomi");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, ANCHO_VENTANA, ALTO_VENTANA);
        setLocationRelativeTo(null); // Centrar en pantalla

        // Crear y configurar la barra de menú
        crearMenu();

        // Panel principal
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel de pestañas principal
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, ANCHO_VENTANA - 40, ALTO_VENTANA - 80);
        contentPane.add(tabbedPane);

        // Crear todas las pestañas
        // crearPestanas();
    }

    // Método para crear la barra de menú y sus opciones
    private void crearMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        menuBar.add(menuArchivo);

        JMenuItem menuItemSalir = new JMenuItem("Salir");
        menuArchivo.add(menuItemSalir);
        menuItemSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (r == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Menú Mantenimiento
        JMenu menuMantenimiento = new JMenu("Mantenimiento");
        menuBar.add(menuMantenimiento);

        JMenuItem menuItemConsultar = new JMenuItem("Consultar Celular");
        menuMantenimiento.add(menuItemConsultar);
        menuItemConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogConsultarProducto(Tienda.this).setVisible(true);
            }
        });

        JMenuItem menuItemModificar = new JMenuItem("Modificar Celular");
        menuMantenimiento.add(menuItemModificar);
        menuItemModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogModificarProducto(Tienda.this).setVisible(true);
            }
        });

        JMenuItem menuItemListar = new JMenuItem("Listar Celular");
        menuMantenimiento.add(menuItemListar);
        menuItemListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogListarProductos(Tienda.this).setVisible(true);
            }
        });

        // Menú Ventas
        JMenu menuVentas = new JMenu("Ventas");
        menuBar.add(menuVentas);

        JMenuItem menuItemNuevaVenta = new JMenuItem("Vender");
        menuVentas.add(menuItemNuevaVenta);
        menuItemNuevaVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogNuevaVenta(Tienda.this).setVisible(true);
            }
        });

        // Menú Configuración
        JMenu menuConfiguracion = new JMenu("Configuración");
        menuBar.add(menuConfiguracion);

        JMenuItem menuItemDescuentos = new JMenuItem("Configurar Descuentos");
        menuConfiguracion.add(menuItemDescuentos);
        menuItemDescuentos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogDescuentos(Tienda.this).setVisible(true);
            }
        });

        JMenuItem menuItemObsequios = new JMenuItem("Configurar Obsequios");
        menuConfiguracion.add(menuItemObsequios);
        menuItemObsequios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogObsequios(Tienda.this).setVisible(true);
            }
        });

        // Menú Ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        menuBar.add(menuAyuda);

        JMenuItem menuItemAcerca = new JMenuItem("Acerca de Tienda");
        menuAyuda.add(menuItemAcerca);
        menuItemAcerca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogAcercaDe(Tienda.this).setVisible(true);
            }
        });
    }

}
