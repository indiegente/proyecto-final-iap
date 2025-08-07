# 📱 Sistema de Gestión de Tienda de Celulares - Xiaomi

## 🎯 Descripción del Proyecto

Sistema de gestión integral para tienda especializada en celulares de gama media-baja, desarrollado en Java con interfaz gráfica Swing. El sistema facilita la administración de inventario, procesamiento de ventas y configuración de políticas comerciales.

### 🏪 Modelo de Negocio
- **Objetivo**: Democratizar el acceso a tecnología móvil asequible
- **Segmento**: Dispositivos entre S/. 600 - S/. 1,200
- **Propuesta de valor**: Calidad accesible con servicio personalizado
- **Beneficiarios**: Vendedores, administradores, clientes

## 🛠️ Especificaciones Técnicas

- **Lenguaje**: Java
- **GUI**: Swing (JFrame, JTabbedPane, JMenu, JDialog)
- **Arquitectura**: Aplicación de escritorio con variables globales
- **Patrón**: Métodos modulares (obligatorio)
- **Validaciones**: Manejo completo de errores
- **Calidad**: Código sin advertencias

## 📁 Estructura del Proyecto

```
ProyectoFinal/
├── src/
│   ├── gui/                          # Interfaz gráfica
│   │   ├── MainWindow.java           # Ventana principal con JMenu
│   │   ├── panels/                   # Paneles de interfaz
│   │   │   ├── InventoryPanel.java   # Gestión de inventario
│   │   │   ├── SalesPanel.java       # Sistema de ventas
│   │   │   ├── ConfigPanel.java      # Configuración comercial
│   │   │   └── HelpPanel.java        # Panel de ayuda
│   │   └── dialogs/                  # Diálogos modales (JDialog)
│   │       ├── ProductDialog.java    # Diálogo de producto
│   │       ├── SaleDialog.java       # Diálogo de venta
│   │       ├── ConfigDialog.java     # Diálogo de configuración
│   │       ├── HistorialDialog.java  # Diálogo de historial
│   │       └── ReportDialog.java     # Diálogo de reportes
│   ├── model/                        # Modelos de datos
│   │   ├── Product.java              # Clase Producto
│   │   ├── Sale.java                 # Clase Venta
│   │   ├── Discount.java             # Clase Descuento
│   │   └── Gift.java                 # Clase Obsequio
│   ├── controller/                   # Controladores
│   │   ├── InventoryController.java  # Controlador de inventario
│   │   ├── SalesController.java      # Controlador de ventas
│   │   └── ConfigController.java     # Controlador de configuración
│   ├── utils/                        # Utilidades
│   │   ├── Validator.java            # Validaciones
│   │   ├── Calculator.java           # Cálculos comerciales
│   │   ├── FileManager.java          # Gestión de archivos
│   │   └── Constants.java            # Constantes globales
│   └── data/                         # Datos y persistencia
│       ├── ProductData.java          # Datos de productos
│       ├── SalesData.java            # Datos de ventas
│       └── ConfigData.java           # Datos de configuración
├── bin/                              # Archivos compilados
├── docs/                             # Documentación
├── .gitignore                        # Archivos ignorados por Git
└── README.md                         # Este archivo
```

## 🔧 Funcionalidades Principales

### 📋 Gestión de Inventario
- ✅ Consulta de especificaciones técnicas (RAM, almacenamiento, precio)
- ✅ Modificación de datos de productos
- ✅ Listado completo del catálogo disponible
- ✅ Validación de datos de entrada
- ✅ Persistencia de información

### 💰 Sistema de Ventas
- ✅ Procesamiento de ventas con cálculo automático de totales
- ✅ Sistema de descuentos progresivos por volumen (7.5% - 15%)
- ✅ Asignación automática de obsequios (fundas, protectores, audífonos)
- ✅ Generación de boletas detalladas
- ✅ Alertas de progreso cada 5 ventas
- ✅ Historial de ventas

### ⚙️ Configuración Comercial
- ✅ Personalización de porcentajes de descuento
- ✅ Configuración de catálogo de obsequios
- ✅ Políticas comerciales flexibles
- ✅ Persistencia de configuraciones

## 🎨 Interfaz de Usuario

### Barra de Menú (JMenu)
El sistema implementa una barra de menú completa con las siguientes opciones:

#### 📁 Menú Archivo
- **Respaldar Datos** (Ctrl+S): Crear copia de seguridad
- **Restaurar Datos** (Ctrl+O): Recuperar datos de respaldo
- **Salir** (Ctrl+Q): Cerrar la aplicación

####  Menú Mantenimiento
- **Consultar Producto** (F1): Acceso directo a consulta
- **Modificar Producto** (F2): Acceso directo a modificación
- **Listar Productos** (F3): Acceso directo a listado

#### 💰 Menú Ventas
- **Nueva Venta** (F4): Iniciar nueva transacción
- **Historial de Ventas** (F5): Ver historial completo
- **Reportes** (F6): Generar reportes de ventas

#### ⚙️ Menú Configuración
- **Configurar Descuentos**: Ajustar porcentajes
- **Configurar Obsequios**: Gestionar catálogo de regalos
- **Preferencias**: Configuraciones del sistema

#### ❓ Menú Ayuda
- **Manual de Usuario** (Shift+F1): Documentación
- **Acerca de...**: Información del sistema

### Pestañas Principales:
1. **Archivo**: Salida del sistema
2. **Mantenimiento**: Gestión de inventario
   - Consultar: Ver especificaciones de productos
   - Modificar: Editar datos de productos
   - Listar: Mostrar catálogo completo
3. **Ventas**: Procesamiento de transacciones
4. **Configuración**: Políticas comerciales
   - Descuentos: Porcentajes por volumen
   - Obsequios: Catálogo de regalos
5. **Ayuda**: Información del sistema y autores

### Diálogos Modales (JDialog)
El sistema utiliza diálogos modales para operaciones específicas:
- **Diálogo de Producto**: Para agregar/modificar productos
- **Diálogo de Venta**: Para procesar transacciones
- **Diálogo de Configuración**: Para ajustar parámetros
- **Diálogo de Historial**: Para mostrar historial de ventas
- **Diálogo de Reportes**: Para generar reportes

## 🚀 Cómo Ejecutar

1. **Compilar el proyecto**:
   ```bash
   javac -d bin src/**/*.java
   ```

2. **Ejecutar la aplicación**:
   ```bash
   java -cp bin gui.MainWindow
   ```

## 📊 Características Técnicas

### Variables Globales
- Configuración de descuentos
- Catálogo de obsequios
- Contador de ventas
- Configuraciones del sistema

### Métodos Modulares
- `validarDatos()`: Validación de entrada
- `calcularDescuento()`: Cálculo de descuentos
- `asignarObsequio()`: Asignación de regalos
- `generarBoleta()`: Generación de comprobantes
- `guardarConfiguracion()`: Persistencia de datos

### Manejo de Errores
- Validación de campos numéricos
- Verificación de rangos válidos
- Mensajes de error descriptivos
- Prevención de datos inválidos

## 🎯 Componentes Swing Implementados

### JMenu y JMenuBar
- **Navegación intuitiva**: Acceso directo a todas las funcionalidades
- **Atajos de teclado**: Teclas de función y combinaciones Ctrl
- **Organización lógica**: Menús agrupados por funcionalidad
- **Separadores visuales**: JSeparator para mejor organización

### JDialog
- **Diálogos modales**: Bloquean la ventana principal hasta completar la operación
- **Validación en tiempo real**: Verificación de datos antes de cerrar
- **Interfaz específica**: Cada diálogo optimizado para su función
- **Confirmaciones**: Diálogos de confirmación para operaciones críticas

### JTabbedPane
- **Navegación por pestañas**: Organización clara de funcionalidades
- **Sub-pestañas**: Agrupación lógica de operaciones relacionadas
- **Integración con menú**: Los elementos del menú cambian automáticamente a la pestaña correspondiente

## 👥 Autores

- **Alfredo Condori**
- **Ever García**
- **Fiorela Quispe**
- **Jorge Bastidas**

## 📝 Notas de Desarrollo

- Código optimizado sin advertencias
- Interfaz intuitiva y responsiva con JMenu y JDialog
- Validaciones robustas
- Documentación completa
- Estructura modular escalable
- Implementación de componentes Swing avanzados (JMenu, JDialog, JTabbedPane)

---

*Proyecto desarrollado para el curso de Introducción a la Algoritmia - Cibertec*
