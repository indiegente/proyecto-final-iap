package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import utils.Constants;
import utils.Validator;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

/**
 * Ventana principal del sistema de gestión de tienda de celulares Xiaomi.
 * Esta clase integra todas las funcionalidades del sistema en una interfaz
 * unificada con pestañas para cada módulo.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
public class MainWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    
    // ========================================
    // COMPONENTES DE LA INTERFAZ
    // ========================================
    
    /** Panel principal de contenido */
    private JPanel contentPane;
    
    /** Panel de pestañas principal */
    private JTabbedPane tabbedPane;
    
    /** Panel de archivo */
    private JPanel panelArchivo;
    
    /** Panel de mantenimiento */
    private JPanel panelMantenimiento;
    
    /** Panel de ventas */
    private JPanel panelVentas;
    
    /** Panel de configuración */
    private JPanel panelConfiguracion;
    
    /** Panel de ayuda */
    private JPanel panelAyuda;
    
    // ========================================
    // COMPONENTES DEL MENÚ
    // ========================================
    
    /** Barra de menú principal */
    private JMenuBar menuBar;
    
    /** Menú Archivo */
    private JMenu menuArchivo;
    private JMenuItem menuItemSalir;
    private JMenuItem menuItemRespaldar;
    private JMenuItem menuItemRestaurar;
    
    /** Menú Mantenimiento */
    private JMenu menuMantenimiento;
    private JMenuItem menuItemConsultar;
    private JMenuItem menuItemModificar;
    private JMenuItem menuItemListar;
    
    /** Menú Ventas */
    private JMenu menuVentas;
    private JMenuItem menuItemNuevaVenta;
    private JMenuItem menuItemHistorial;
    private JMenuItem menuItemReportes;
    
    /** Menú Configuración */
    private JMenu menuConfiguracion;
    private JMenuItem menuItemDescuentos;
    private JMenuItem menuItemObsequios;
    private JMenuItem menuItemPreferencias;
    
    /** Menú Ayuda */
    private JMenu menuAyuda;
    private JMenuItem menuItemAcercaDe;
    private JMenuItem menuItemManual;
    
    // ========================================
    // CONSTRUCTOR Y MÉTODO MAIN
    // ========================================
    
    /**
     * Método principal para ejecutar la aplicación
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Constructor de la ventana principal
     */
    public MainWindow() {
        initializeComponents();
        setupEventHandlers();
        loadInitialData();
    }
    
    // ========================================
    // INICIALIZACIÓN DE COMPONENTES
    // ========================================
    
    /**
     * Inicializa todos los componentes de la interfaz
     */
    private void initializeComponents() {
        // Configuración básica de la ventana
        setTitle(Constants.TITULO_APLICACION);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, Constants.ANCHO_VENTANA, Constants.ALTO_VENTANA);
        setLocationRelativeTo(null); // Centrar en pantalla
        setResizable(true);
        
        // Crear y configurar la barra de menú
        createMenuBar();
        
        // Panel principal
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Panel de pestañas principal
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, Constants.ANCHO_VENTANA - 40, Constants.ALTO_VENTANA - 80);
        contentPane.add(tabbedPane);
        
        // Crear todas las pestañas
        createArchivoTab();
        createMantenimientoTab();
        createVentasTab();
        createConfiguracionTab();
        createAyudaTab();
    }
    
    /**
     * Crea y configura la barra de menú principal
     */
    private void createMenuBar() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        // Crear menús
        createArchivoMenu();
        createMantenimientoMenu();
        createVentasMenu();
        createConfiguracionMenu();
        createAyudaMenu();
    }
    
    /**
     * Crea el menú Archivo
     */
    private void createArchivoMenu() {
        menuArchivo = new JMenu("Archivo");
        menuArchivo.setMnemonic('A');
        
        menuItemRespaldar = new JMenuItem("Respaldar Datos", 'R');
        menuItemRespaldar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        menuItemRespaldar.addActionListener(e -> handleRespaldarDatos());
        
        menuItemRestaurar = new JMenuItem("Restaurar Datos", 'T');
        menuItemRestaurar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        menuItemRestaurar.addActionListener(e -> handleRestaurarDatos());
        
        menuItemSalir = new JMenuItem("Salir", 'S');
        menuItemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
        menuItemSalir.addActionListener(e -> handleWindowClosing());
        
        menuArchivo.add(menuItemRespaldar);
        menuArchivo.add(menuItemRestaurar);
        menuArchivo.add(new JSeparator());
        menuArchivo.add(menuItemSalir);
        
        menuBar.add(menuArchivo);
    }
    
    /**
     * Crea el menú Mantenimiento
     */
    private void createMantenimientoMenu() {
        menuMantenimiento = new JMenu("Mantenimiento");
        menuMantenimiento.setMnemonic('M');
        
        menuItemConsultar = new JMenuItem("Consultar Producto", 'C');
        menuItemConsultar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        menuItemConsultar.addActionListener(e -> switchToConsultarTab());
        
        menuItemModificar = new JMenuItem("Modificar Producto", 'M');
        menuItemModificar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
        menuItemModificar.addActionListener(e -> switchToModificarTab());
        
        menuItemListar = new JMenuItem("Listar Productos", 'L');
        menuItemListar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        menuItemListar.addActionListener(e -> switchToListarTab());
        
        menuMantenimiento.add(menuItemConsultar);
        menuMantenimiento.add(menuItemModificar);
        menuMantenimiento.add(menuItemListar);
        
        menuBar.add(menuMantenimiento);
    }
    
    /**
     * Crea el menú Ventas
     */
    private void createVentasMenu() {
        menuVentas = new JMenu("Ventas");
        menuVentas.setMnemonic('V');
        
        menuItemNuevaVenta = new JMenuItem("Nueva Venta", 'N');
        menuItemNuevaVenta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
        menuItemNuevaVenta.addActionListener(e -> switchToVentasTab());
        
        menuItemHistorial = new JMenuItem("Historial de Ventas", 'H');
        menuItemHistorial.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
        menuItemHistorial.addActionListener(e -> mostrarHistorialVentas());
        
        menuItemReportes = new JMenuItem("Reportes", 'R');
        menuItemReportes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
        menuItemReportes.addActionListener(e -> mostrarReportes());
        
        menuVentas.add(menuItemNuevaVenta);
        menuVentas.add(new JSeparator());
        menuVentas.add(menuItemHistorial);
        menuVentas.add(menuItemReportes);
        
        menuBar.add(menuVentas);
    }
    
    /**
     * Crea el menú Configuración
     */
    private void createConfiguracionMenu() {
        menuConfiguracion = new JMenu("Configuración");
        menuConfiguracion.setMnemonic('C');
        
        menuItemDescuentos = new JMenuItem("Configurar Descuentos", 'D');
        menuItemDescuentos.addActionListener(e -> switchToDescuentosTab());
        
        menuItemObsequios = new JMenuItem("Configurar Obsequios", 'O');
        menuItemObsequios.addActionListener(e -> switchToObsequiosTab());
        
        menuItemPreferencias = new JMenuItem("Preferencias", 'P');
        menuItemPreferencias.addActionListener(e -> mostrarPreferencias());
        
        menuConfiguracion.add(menuItemDescuentos);
        menuConfiguracion.add(menuItemObsequios);
        menuConfiguracion.add(new JSeparator());
        menuConfiguracion.add(menuItemPreferencias);
        
        menuBar.add(menuConfiguracion);
    }
    
    /**
     * Crea el menú Ayuda
     */
    private void createAyudaMenu() {
        menuAyuda = new JMenu("Ayuda");
        menuAyuda.setMnemonic('Y');
        
        menuItemManual = new JMenuItem("Manual de Usuario", 'M');
        menuItemManual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, KeyEvent.SHIFT_DOWN_MASK));
        menuItemManual.addActionListener(e -> mostrarManualUsuario());
        
        menuItemAcercaDe = new JMenuItem("Acerca de...", 'A');
        menuItemAcercaDe.addActionListener(e -> mostrarAcercaDe());
        
        menuAyuda.add(menuItemManual);
        menuAyuda.add(new JSeparator());
        menuAyuda.add(menuItemAcercaDe);
        
        menuBar.add(menuAyuda);
    }
    
    /**
     * Crea la pestaña de Archivo
     */
    private void createArchivoTab() {
        panelArchivo = new JPanel();
        panelArchivo.setLayout(null);
        
        // Aquí se pueden agregar componentes específicos del panel de archivo
        // Por ejemplo: botones para importar/exportar datos, respaldos, etc.
        
        tabbedPane.addTab("Archivo", null, panelArchivo, null);
    }
    
    /**
     * Crea la pestaña de Mantenimiento
     */
    private void createMantenimientoTab() {
        panelMantenimiento = new JPanel();
        panelMantenimiento.setLayout(null);
        
        // Crear sub-pestañas para mantenimiento
        JTabbedPane subTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        subTabbedPane.setBounds(10, 10, Constants.ANCHO_VENTANA - 60, Constants.ALTO_VENTANA - 120);
        panelMantenimiento.add(subTabbedPane);
        
        // Sub-pestaña Consultar
        createConsultarSubTab(subTabbedPane);
        
        // Sub-pestaña Modificar
        createModificarSubTab(subTabbedPane);
        
        // Sub-pestaña Listar
        createListarSubTab(subTabbedPane);
        
        tabbedPane.addTab("Mantenimiento", null, panelMantenimiento, null);
    }
    
    /**
     * Crea la sub-pestaña de Consultar
     * @param parentTabbedPane Panel padre de pestañas
     */
    private void createConsultarSubTab(JTabbedPane parentTabbedPane) {
        JPanel panelConsultar = new JPanel();
        panelConsultar.setLayout(null);
        
        // Aquí se implementarán los componentes para consultar productos
        // Campos: Modelo (ComboBox), Precio, Pantalla, RAM, ROM, Carga Rápida
        // Botones: Cerrar, Guardar
        
        parentTabbedPane.addTab("Consultar", null, panelConsultar, null);
    }
    
    /**
     * Crea la sub-pestaña de Modificar
     * @param parentTabbedPane Panel padre de pestañas
     */
    private void createModificarSubTab(JTabbedPane parentTabbedPane) {
        JPanel panelModificar = new JPanel();
        panelModificar.setLayout(null);
        
        // Aquí se implementarán los componentes para modificar productos
        // Similar a consultar pero con campos editables
        
        parentTabbedPane.addTab("Modificar", null, panelModificar, null);
    }
    
    /**
     * Crea la sub-pestaña de Listar
     * @param parentTabbedPane Panel padre de pestañas
     */
    private void createListarSubTab(JTabbedPane parentTabbedPane) {
        JPanel panelListar = new JPanel();
        panelListar.setLayout(null);
        
        // Aquí se implementará un área de texto para mostrar la lista de productos
        // Botones: Listar, Cerrar
        
        parentTabbedPane.addTab("Listar", null, panelListar, null);
    }
    
    /**
     * Crea la pestaña de Ventas
     */
    private void createVentasTab() {
        panelVentas = new JPanel();
        panelVentas.setLayout(null);
        
        // Aquí se implementarán los componentes para el sistema de ventas
        // Campos: Modelo (ComboBox), Precio, Cantidad (Spinner)
        // Botones: Vender, Cerrar
        // Área de texto para mostrar historial de ventas
        
        tabbedPane.addTab("Ventas", null, panelVentas, null);
    }
    
    /**
     * Crea la pestaña de Configuración
     */
    private void createConfiguracionTab() {
        panelConfiguracion = new JPanel();
        panelConfiguracion.setLayout(null);
        
        // Crear sub-pestañas para configuración
        JTabbedPane subTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        subTabbedPane.setBounds(10, 10, Constants.ANCHO_VENTANA - 60, Constants.ALTO_VENTANA - 120);
        panelConfiguracion.add(subTabbedPane);
        
        // Sub-pestaña Descuentos
        createDescuentosSubTab(subTabbedPane);
        
        // Sub-pestaña Obsequios
        createObsequiosSubTab(subTabbedPane);
        
        tabbedPane.addTab("Configuración", null, panelConfiguracion, null);
    }
    
    /**
     * Crea la sub-pestaña de Descuentos
     * @param parentTabbedPane Panel padre de pestañas
     */
    private void createDescuentosSubTab(JTabbedPane parentTabbedPane) {
        JPanel panelDescuentos = new JPanel();
        panelDescuentos.setLayout(null);
        
        // Aquí se implementarán los campos para configurar descuentos
        // Campos: 1-5 unidades, 6-10 unidades, 11-15 unidades, Más de 15 unidades
        // Botones: Aceptar, Cancelar
        
        parentTabbedPane.addTab("Descuentos", null, panelDescuentos, null);
    }
    
    /**
     * Crea la sub-pestaña de Obsequios
     * @param parentTabbedPane Panel padre de pestañas
     */
    private void createObsequiosSubTab(JTabbedPane parentTabbedPane) {
        JPanel panelObsequios = new JPanel();
        panelObsequios.setLayout(null);
        
        // Aquí se implementarán los campos para configurar obsequios
        // Campos: 1 unidad, 2-5 unidades, 6 o más unidades
        // Botones: Aceptar, Cancelar
        
        parentTabbedPane.addTab("Obsequios", null, panelObsequios, null);
    }
    
    /**
     * Crea la pestaña de Ayuda
     */
    private void createAyudaTab() {
        panelAyuda = new JPanel();
        panelAyuda.setLayout(null);
        
        // Aquí se implementará la información de ayuda y autores
        // Título, información del sistema, lista de autores
        
        tabbedPane.addTab("Ayuda", null, panelAyuda, null);
    }
    
    // ========================================
    // CONFIGURACIÓN DE EVENTOS
    // ========================================
    
    /**
     * Configura todos los manejadores de eventos
     */
    private void setupEventHandlers() {
        // Evento de cierre de ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleWindowClosing();
            }
        });
        
        // Aquí se configurarán los eventos para todos los componentes
        // ActionListeners para botones, etc.
    }
    
    /**
     * Maneja el evento de cierre de ventana
     */
    private void handleWindowClosing() {
        if (Validator.mostrarConfirmacion(Constants.CONFIRMAR_SALIDA)) {
            saveDataBeforeExit();
            System.exit(0);
        }
    }
    
    // ========================================
    // CARGA Y GUARDADO DE DATOS
    // ========================================
    
    /**
     * Carga los datos iniciales del sistema
     */
    private void loadInitialData() {
        try {
            // Aquí se cargarán los datos iniciales
            // - Productos del catálogo
            // - Configuraciones de descuentos y obsequios
            // - Historial de ventas
            
            Validator.mostrarInformacion("Sistema cargado exitosamente");
        } catch (Exception e) {
            Validator.mostrarError("Error al cargar datos iniciales: " + e.getMessage());
        }
    }
    
    /**
     * Guarda los datos antes de salir del sistema
     */
    private void saveDataBeforeExit() {
        try {
            // Aquí se guardarán todos los datos del sistema
            // - Productos modificados
            // - Configuraciones actualizadas
            // - Historial de ventas
            
            Validator.mostrarInformacion("Datos guardados exitosamente");
        } catch (Exception e) {
            Validator.mostrarError("Error al guardar datos: " + e.getMessage());
        }
    }
    
    // ========================================
    // MÉTODOS PÚBLICOS
    // ========================================
    
    /**
     * Actualiza la interfaz después de cambios en los datos
     */
    public void refreshInterface() {
        // Actualizar componentes que muestran datos
        repaint();
        revalidate();
    }
    
    /**
     * Cambia a una pestaña específica
     * @param tabIndex Índice de la pestaña (0-4)
     */
    public void switchToTab(int tabIndex) {
        if (tabIndex >= 0 && tabIndex < tabbedPane.getTabCount()) {
            tabbedPane.setSelectedIndex(tabIndex);
        }
    }
    
    /**
     * Obtiene el panel de pestañas principal
     * @return Panel de pestañas
     */
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
    
    /**
     * Obtiene el panel de archivo
     * @return Panel de archivo
     */
    public JPanel getPanelArchivo() {
        return panelArchivo;
    }
    
    /**
     * Obtiene el panel de mantenimiento
     * @return Panel de mantenimiento
     */
    public JPanel getPanelMantenimiento() {
        return panelMantenimiento;
    }
    
    /**
     * Obtiene el panel de ventas
     * @return Panel de ventas
     */
    public JPanel getPanelVentas() {
        return panelVentas;
    }
    
    /**
     * Obtiene el panel de configuración
     * @return Panel de configuración
     */
    public JPanel getPanelConfiguracion() {
        return panelConfiguracion;
    }
    
    /**
     * Obtiene el panel de ayuda
     * @return Panel de ayuda
     */
    public JPanel getPanelAyuda() {
        return panelAyuda;
    }
    
    // ========================================
    // MÉTODOS DE NAVEGACIÓN POR MENÚ
    // ========================================
    
    /**
     * Cambia a la pestaña de consultar productos
     */
    private void switchToConsultarTab() {
        tabbedPane.setSelectedIndex(1); // Pestaña Mantenimiento
        // Aquí podrías agregar lógica para seleccionar la sub-pestaña Consultar
        refreshInterface();
    }
    
    /**
     * Cambia a la pestaña de modificar productos
     */
    private void switchToModificarTab() {
        tabbedPane.setSelectedIndex(1); // Pestaña Mantenimiento
        // Aquí podrías agregar lógica para seleccionar la sub-pestaña Modificar
        refreshInterface();
    }
    
    /**
     * Cambia a la pestaña de listar productos
     */
    private void switchToListarTab() {
        tabbedPane.setSelectedIndex(1); // Pestaña Mantenimiento
        // Aquí podrías agregar lógica para seleccionar la sub-pestaña Listar
        refreshInterface();
    }
    
    /**
     * Cambia a la pestaña de ventas
     */
    private void switchToVentasTab() {
        tabbedPane.setSelectedIndex(2); // Pestaña Ventas
        refreshInterface();
    }
    
    /**
     * Cambia a la pestaña de descuentos
     */
    private void switchToDescuentosTab() {
        tabbedPane.setSelectedIndex(3); // Pestaña Configuración
        // Aquí podrías agregar lógica para seleccionar la sub-pestaña Descuentos
        refreshInterface();
    }
    
    /**
     * Cambia a la pestaña de obsequios
     */
    private void switchToObsequiosTab() {
        tabbedPane.setSelectedIndex(3); // Pestaña Configuración
        // Aquí podrías agregar lógica para seleccionar la sub-pestaña Obsequios
        refreshInterface();
    }
    
    // ========================================
    // MÉTODOS DE ACCIÓN DEL MENÚ
    // ========================================
    
    /**
     * Maneja la acción de respaldar datos
     */
    private void handleRespaldarDatos() {
        // Aquí implementarías la lógica para respaldar datos
        // Podrías usar un JDialog para mostrar progreso
        System.out.println("Respaldando datos...");
    }
    
    /**
     * Maneja la acción de restaurar datos
     */
    private void handleRestaurarDatos() {
        // Aquí implementarías la lógica para restaurar datos
        System.out.println("Restaurando datos...");
    }
    
    /**
     * Muestra el historial de ventas
     */
    private void mostrarHistorialVentas() {
        // Aquí podrías abrir un JDialog con el historial
        System.out.println("Mostrando historial de ventas...");
    }
    
    /**
     * Muestra los reportes
     */
    private void mostrarReportes() {
        // Aquí podrías abrir un JDialog con los reportes
        System.out.println("Mostrando reportes...");
    }
    
    /**
     * Muestra las preferencias
     */
    private void mostrarPreferencias() {
        // Aquí podrías abrir un JDialog con las preferencias
        System.out.println("Mostrando preferencias...");
    }
    
    /**
     * Muestra el manual de usuario
     */
    private void mostrarManualUsuario() {
        // Aquí podrías abrir un JDialog con el manual
        System.out.println("Mostrando manual de usuario...");
    }
    
    /**
     * Muestra la información "Acerca de"
     */
    private void mostrarAcercaDe() {
        // Aquí podrías abrir un JDialog con la información
        System.out.println("Mostrando información del sistema...");
    }
}
