# 📋 Especificaciones Técnicas - Sistema de Gestión de Tienda Xiaomi

## 🎯 Información General

**Proyecto**: Sistema de Gestión Integral para Tienda de Celulares Xiaomi  
**Curso**: Introducción a la Algoritmia  
**Institución**: Cibertec  
**Versión**: 1.0  
**Fecha**: 2024  

## 👥 Equipo de Desarrollo

- **Alfredo Condori**
- **Ever García**
- **Fiorela Quispe**
- **Jorge Bastidas**

## 🛠️ Stack Tecnológico

### Lenguaje y Plataforma
- **Lenguaje**: Java 8 o superior
- **GUI Framework**: Swing (javax.swing)
- **Componentes Principales**: JFrame, JTabbedPane, JMenu, JDialog
- **Arquitectura**: Aplicación de escritorio monolítica
- **Patrón de Diseño**: MVC (Model-View-Controller)

### Herramientas de Desarrollo
- **IDE**: Eclipse, IntelliJ IDEA, o cualquier editor compatible
- **Compilador**: javac
- **Runtime**: JRE 8+
- **Sistema Operativo**: Windows, macOS, Linux

## 🏗️ Arquitectura del Sistema

### Estructura de Paquetes
```
src/
├── gui/                    # Capa de presentación
│   ├── MainWindow.java     # Ventana principal con JMenu
│   ├── panels/            # Paneles específicos
│   └── dialogs/           # Diálogos modales (JDialog)
│       ├── ProductDialog.java
│       ├── SaleDialog.java
│       ├── ConfigDialog.java
│       ├── HistorialDialog.java
│       └── ReportDialog.java
├── model/                 # Capa de modelo de datos
│   ├── Product.java       # Entidad Producto
│   └── Sale.java          # Entidad Venta
├── controller/            # Capa de controladores
│   ├── InventoryController.java
│   ├── SalesController.java
│   └── ConfigController.java
├── utils/                 # Utilidades y helpers
│   ├── Constants.java     # Constantes globales
│   ├── Validator.java     # Validaciones
│   └── Calculator.java    # Cálculos comerciales
└── data/                  # Capa de persistencia
    ├── ProductData.java   # Gestión de datos de productos
    ├── SalesData.java     # Gestión de datos de ventas
    └── ConfigData.java    # Gestión de configuraciones
```

### Patrón MVC Implementado

#### Model (Modelo)
- **Product**: Representa un celular con todas sus especificaciones
- **Sale**: Representa una transacción de venta
- **Discount**: Configuración de descuentos
- **Gift**: Configuración de obsequios

#### View (Vista)
- **MainWindow**: Ventana principal con JMenu y JTabbedPane
- **Panels**: Paneles específicos para cada funcionalidad
- **Dialogs**: Diálogos modales (JDialog) para operaciones específicas

#### Controller (Controlador)
- **InventoryController**: Maneja operaciones de inventario
- **SalesController**: Maneja operaciones de ventas
- **ConfigController**: Maneja configuraciones del sistema

## 📊 Variables Globales

### Configuración de Descuentos
```java
// Porcentajes de descuento por volumen
public static final double DESCUENTO_1_A_5 = 7.5;    // 1-5 unidades
public static final double DESCUENTO_6_A_10 = 10.0;  // 6-10 unidades
public static final double DESCUENTO_11_A_15 = 12.5; // 11-15 unidades
public static final double DESCUENTO_MAS_15 = 15.0;  // Más de 15 unidades
```

### Configuración de Obsequios
```java
// Obsequios por volumen de compra
public static final String OBSEQUIO_1_UNIDAD = "Funda";
public static final String OBSEQUIO_2_A_5 = "Protector de pantalla";
public static final String OBSEQUIO_6_MAS = "Audífonos";
```

### Validaciones de Negocio
```java
// Rangos de precios válidos
public static final double PRECIO_MINIMO = 600.0;  // S/. 600
public static final double PRECIO_MAXIMO = 1200.0; // S/. 1,200

// Límites de cantidad
public static final int CANTIDAD_MINIMA = 1;
public static final int CANTIDAD_MAXIMA = 50;
```

## 🔧 Métodos Modulares

### Validaciones (`Validator.java`)
```java
// Validaciones de productos
public static boolean validarModelo(String modelo)
public static boolean validarPrecio(double precio)
public static int validarRam(String ramStr)
public static int validarRom(String romStr)

// Validaciones de ventas
public static boolean validarCantidad(int cantidad)
public static boolean validarProductoSeleccionado(String producto)

// Validaciones de configuración
public static double validarPorcentajeDescuento(String porcentajeStr)
public static boolean validarObsequio(String obsequio)
```

### Cálculos Comerciales (`Calculator.java`)
```java
// Cálculos de descuentos
public static double calcularDescuento(int cantidad)
public static double calcularMontoDescuento(double precioUnitario, int cantidad)
public static double calcularTotal(double precioUnitario, int cantidad)

// Asignación de obsequios
public static String asignarObsequio(int cantidad)

// Generación de boletas
public static String generarBoleta(String modelo, double precioUnitario, ...)
```

### Gestión de Datos
```java
// Persistencia
public static void guardarProductos(List<Product> productos)
public static List<Product> cargarProductos()
public static void guardarVentas(List<Sale> ventas)
public static List<Sale> cargarVentas()
```

## 🎨 Interfaz de Usuario

### Estructura de Pestañas
1. **Archivo**: Operaciones de archivo y salida del sistema
2. **Mantenimiento**: Gestión de inventario
   - Consultar: Ver especificaciones de productos
   - Modificar: Editar datos de productos
   - Listar: Mostrar catálogo completo
3. **Ventas**: Procesamiento de transacciones
4. **Configuración**: Políticas comerciales
   - Descuentos: Porcentajes por volumen
   - Obsequios: Catálogo de regalos
5. **Ayuda**: Información del sistema y autores

### Componentes de Interfaz
- **JTabbedPane**: Navegación principal
- **JMenuBar**: Barra de menú con navegación
- **JDialog**: Diálogos modales para operaciones específicas
- **JComboBox**: Selección de productos
- **JTextField**: Campos de entrada de datos
- **JSpinner**: Control de cantidades
- **JTextArea**: Áreas de texto para listados
- **JButton**: Botones de acción
- **JScrollPane**: Áreas con scroll
- **JTable**: Tablas de datos (historial, reportes)

## 📈 Funcionalidades Principales

### Gestión de Inventario
- ✅ Consulta de especificaciones técnicas
- ✅ Modificación de datos de productos
- ✅ Listado completo del catálogo
- ✅ Validación de datos de entrada
- ✅ Control de stock

### Sistema de Ventas
- ✅ Procesamiento de ventas con cálculo automático
- ✅ Sistema de descuentos progresivos (7.5% - 15%)
- ✅ Asignación automática de obsequios
- ✅ Generación de boletas detalladas
- ✅ Alertas de progreso cada 5 ventas
- ✅ Historial de ventas

### Configuración Comercial
- ✅ Personalización de porcentajes de descuento
- ✅ Configuración de catálogo de obsequios
- ✅ Políticas comerciales flexibles
- ✅ Persistencia de configuraciones

## 🔒 Manejo de Errores

### Validaciones Implementadas
- **Campos numéricos**: Verificación de rangos válidos
- **Campos de texto**: Validación de longitud y contenido
- **Selecciones**: Verificación de elementos seleccionados
- **Stock**: Control de disponibilidad de productos

### Mensajes de Error
- Mensajes descriptivos y específicos
- Indicación clara del problema
- Sugerencias de corrección cuando es posible

### Prevención de Errores
- Validación en tiempo real
- Campos de solo lectura cuando corresponde
- Confirmaciones para operaciones críticas

## 📁 Persistencia de Datos

### Archivos de Datos
- `productos.dat`: Catálogo de productos
- `ventas.dat`: Historial de ventas
- `configuracion.dat`: Configuraciones del sistema

### Formato de Datos
- Serialización de objetos Java
- Estructura jerárquica de datos
- Backup automático de configuraciones

## 🚀 Compilación y Ejecución

### Compilación Manual
```bash
# Compilar todo el proyecto
javac -d bin -cp "src" src/**/*.java

# Ejecutar la aplicación
java -cp bin gui.MainWindow
```

### Script Automatizado
```bash
# Usar el script proporcionado
./compile_and_run.sh
```

### Requisitos del Sistema
- Java 8 o superior
- Mínimo 512MB RAM
- 100MB espacio en disco
- Resolución mínima 800x600

## 📊 Métricas de Calidad

### Código
- ✅ Sin advertencias de compilación
- ✅ Documentación JavaDoc completa
- ✅ Nombres de variables y métodos descriptivos
- ✅ Estructura modular y escalable

### Funcionalidad
- ✅ Todas las especificaciones implementadas
- ✅ Validaciones robustas
- ✅ Manejo completo de errores
- ✅ Interfaz intuitiva con JMenu y JDialog

### Rendimiento
- ✅ Respuesta inmediata en operaciones
- ✅ Uso eficiente de memoria
- ✅ Carga rápida de datos

## 🔄 Ciclo de Desarrollo

### Fases del Proyecto
1. **Análisis**: Definición de requerimientos
2. **Diseño**: Arquitectura y estructura
3. **Implementación**: Desarrollo del código
4. **Pruebas**: Validación de funcionalidades
5. **Documentación**: Manuales y especificaciones
6. **Entrega**: Sistema funcional completo

### Control de Versiones
- Uso de Git para control de versiones
- Commits descriptivos y frecuentes
- Branching para funcionalidades específicas

## 📝 Notas de Implementación

### Consideraciones Técnicas
- Uso de Swing para compatibilidad multiplataforma
- Implementación de patrones de diseño estándar
- Código optimizado para mantenibilidad
- Documentación exhaustiva
- **Integración de JMenu y JDialog**: Componentes avanzados de Swing

### Mejoras Futuras
- Base de datos relacional (MySQL/PostgreSQL)
- Interfaz web (Spring Boot)
- Reportes avanzados
- Integración con sistemas externos
- **Menús contextuales**: Menús emergentes con clic derecho
- **Tooltips avanzados**: Información contextual en componentes

---

*Documento técnico del Sistema de Gestión de Tienda de Celulares Xiaomi*  
*Versión 1.0 - Cibertec 2024*
