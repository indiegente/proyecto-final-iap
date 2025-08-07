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
}
