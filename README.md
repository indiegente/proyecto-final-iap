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
- **GUI**: Swing
- **Arquitectura**: Aplicación de escritorio con variables globales
- **Patrón**: Métodos modulares (obligatorio)
- **Validaciones**: Manejo completo de errores
- **Calidad**: Código sin advertencias

## 📁 Estructura del Proyecto

```
ProyectoFinal/
├── src/
│   ├── gui/                          # Interfaz gráfica
│   │   ├── MainWindow.java           # Ventana principal
│   │   ├── panels/                   # Paneles de interfaz
│   │   │   ├── InventoryPanel.java   # Gestión de inventario
│   │   │   ├── SalesPanel.java       # Sistema de ventas
│   │   │   ├── ConfigPanel.java      # Configuración comercial
│   │   │   └── HelpPanel.java        # Panel de ayuda
│   │   └── dialogs/                  # Diálogos modales
│   │       ├── ProductDialog.java    # Diálogo de producto
│   │       ├── SaleDialog.java       # Diálogo de venta
│   │       └── ConfigDialog.java     # Diálogo de configuración
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

## 👥 Autores

- **Alfredo Condori**
- **Ever García**
- **Fiorela Quispe**
- **Jorge Bastidas**

## 📝 Notas de Desarrollo

- Código optimizado sin advertencias
- Interfaz intuitiva y responsiva
- Validaciones robustas
- Documentación completa
- Estructura modular escalable

---

*Proyecto desarrollado para el curso de Introducción a la Algoritmia - Cibertec*
