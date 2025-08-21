package gui;

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
import gui.dialogs.DialogRespaldarDatos;
import gui.dialogs.DialogRestaurarDatos;
import gui.dialogs.DialogConsultarProducto;
import gui.dialogs.DialogModificarProducto;
import gui.dialogs.DialogListarProductos;
import gui.dialogs.DialogNuevaVenta;
import gui.dialogs.DialogHistorialVentas;
import gui.dialogs.DialogReportes;
import gui.dialogs.DialogDescuentos;
import gui.dialogs.DialogObsequios;
import gui.dialogs.DialogPreferencias;
import gui.dialogs.DialogManualUsuario;
import gui.dialogs.DialogAcercaDe;

/**
 * Ventana principal del sistema de gestión de tienda de celulares Xiaomi.
 * Versión simplificada para introducción a la algoritmia.
 */
public class MainWindow extends JFrame {

    // Variables globales (campos de clase)
    private JPanel contentPane;
    private JTabbedPane tabbedPane;
    private JPanel panelArchivo;
    private JPanel panelMantenimiento;
    private JPanel panelVentas;
    private JPanel panelConfiguracion;
    private JPanel panelAyuda;

    // Constantes simples
    public static final int ANCHO_VENTANA = 800;
    public static final int ALTO_VENTANA = 600;

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow frame = new MainWindow();
                frame.setVisible(true);
            }
        });
    }

    // Constructor de la ventana principal
    public MainWindow() {
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
        crearPestanas();
    }

    // Método para crear la barra de menú y sus opciones
    private void crearMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        menuBar.add(menuArchivo);

        JMenuItem menuItemRespaldar = new JMenuItem("Respaldar Datos");
        menuArchivo.add(menuItemRespaldar);
        menuItemRespaldar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogRespaldarDatos(MainWindow.this).setVisible(true);
            }
        });

        JMenuItem menuItemRestaurar = new JMenuItem("Restaurar Datos");
        menuArchivo.add(menuItemRestaurar);
        menuItemRestaurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogRestaurarDatos(MainWindow.this).setVisible(true);
            }
        });

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

        JMenuItem menuItemConsultar = new JMenuItem("Consultar Producto");
        menuMantenimiento.add(menuItemConsultar);
        menuItemConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogConsultarProducto(MainWindow.this).setVisible(true);
            }
        });

        JMenuItem menuItemModificar = new JMenuItem("Modificar Producto");
        menuMantenimiento.add(menuItemModificar);
        menuItemModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogModificarProducto(MainWindow.this).setVisible(true);
            }
        });

        JMenuItem menuItemListar = new JMenuItem("Listar Productos");
        menuMantenimiento.add(menuItemListar);
        menuItemListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogListarProductos(MainWindow.this).setVisible(true);
            }
        });

        // Menú Ventas
        JMenu menuVentas = new JMenu("Ventas");
        menuBar.add(menuVentas);

        JMenuItem menuItemNuevaVenta = new JMenuItem("Nueva Venta");
        menuVentas.add(menuItemNuevaVenta);
        menuItemNuevaVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogNuevaVenta(MainWindow.this).setVisible(true);
            }
        });

        JMenuItem menuItemHistorial = new JMenuItem("Historial de Ventas");
        menuVentas.add(menuItemHistorial);
        menuItemHistorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogHistorialVentas(MainWindow.this).setVisible(true);
            }
        });

        JMenuItem menuItemReportes = new JMenuItem("Reportes");
        menuVentas.add(menuItemReportes);
        menuItemReportes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogReportes(MainWindow.this).setVisible(true);
            }
        });

        // Menú Configuración
        JMenu menuConfiguracion = new JMenu("Configuración");
        menuBar.add(menuConfiguracion);

        JMenuItem menuItemDescuentos = new JMenuItem("Configurar Descuentos");
        menuConfiguracion.add(menuItemDescuentos);
        menuItemDescuentos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogDescuentos(MainWindow.this).setVisible(true);
            }
        });

        JMenuItem menuItemObsequios = new JMenuItem("Configurar Obsequios");
        menuConfiguracion.add(menuItemObsequios);
        menuItemObsequios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogObsequios(MainWindow.this).setVisible(true);
            }
        });

        JMenuItem menuItemPreferencias = new JMenuItem("Preferencias");
        menuConfiguracion.add(menuItemPreferencias);
        menuItemPreferencias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogPreferencias(MainWindow.this).setVisible(true);
            }
        });

        // Menú Ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        menuBar.add(menuAyuda);

        JMenuItem menuItemManual = new JMenuItem("Manual de Usuario");
        menuAyuda.add(menuItemManual);
        menuItemManual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogManualUsuario(MainWindow.this).setVisible(true);
            }
        });

        JMenuItem menuItemAcerca = new JMenuItem("Acerca de...");
        menuAyuda.add(menuItemAcerca);
        menuItemAcerca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogAcercaDe(MainWindow.this).setVisible(true);
            }
        });
    }

    // Método para crear las pestañas principales
    private void crearPestanas() {
        // Pestaña Archivo
        panelArchivo = new JPanel();
        panelArchivo.setLayout(null);
        tabbedPane.addTab("Archivo", null, panelArchivo, null);

        // Pestaña Mantenimiento
        panelMantenimiento = new JPanel();
        panelMantenimiento.setLayout(null);
        tabbedPane.addTab("Mantenimiento", null, panelMantenimiento, null);

        // Pestaña Ventas
        panelVentas = new JPanel();
        panelVentas.setLayout(null);
        tabbedPane.addTab("Ventas", null, panelVentas, null);

        // Pestaña Configuración
        panelConfiguracion = new JPanel();
        panelConfiguracion.setLayout(null);
        tabbedPane.addTab("Configuración", null, panelConfiguracion, null);

        // Pestaña Ayuda
        panelAyuda = new JPanel();
        panelAyuda.setLayout(null);
        tabbedPane.addTab("Ayuda", null, panelAyuda, null);

        // Puedes agregar aquí componentes básicos a cada panel según avance el curso
    }
}
