# Sistema de Gestión de Tienda de Celulares - Xiaomi

## 📋 Descripción del Proyecto

Sistema de gestión integral para tienda especializada en celulares de gama media-baja, desarrollado en Java con interfaz gráfica Swing. El sistema facilita la administración de inventario, procesamiento de ventas y configuración de políticas comerciales.

### 🎯 Modelo de Negocio
- **Objetivo**: Democratizar el acceso a tecnología móvil asequible
- **Segmento**: Dispositivos entre S/. 600 - S/. 1,200
- **Propuesta de valor**: Calidad accesible con servicio personalizado
- **Beneficiarios**: Vendedores, administradores, clientes

## 🛠️ Especificaciones Técnicas

- **Lenguaje**: Java 8 o superior
- **GUI Framework**: Swing (JFrame, JMenuBar, JMenu, JDialog)
- **Arquitectura**: Aplicación de escritorio con patrón MVC
- **Componentes**: JTabbedPane, JComboBox, JSpinner, JTextArea
- **Validaciones**: Manejo completo de errores y validaciones robustas
- **Persistencia**: Variables globales con métodos modulares

## 🔧 Funcionalidades Principales

### 📦 Gestión de Inventario
- ✅ Consulta de especificaciones técnicas (RAM, almacenamiento, precio)
- ✅ Modificación de datos de productos
- ✅ Listado completo del catálogo disponible
- ✅ Validación de datos de entrada
- ✅ Control de stock

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

## 🏗️ Estructura del Proyecto

```
src/
├── proyectitointerfaces/
│   └── Tienda.java           # Ventana principal con JMenuBar
├── gui/
│   └── dialogs/              # Diálogos modales (JDialog)
│       ├── DialogAcercaDe.java
│       ├── DialogConsultarProducto.java
│       ├── DialogDescuentos.java
│       ├── DialogListarProductos.java
│       ├── DialogModificarCelular.java
│       ├── DialogNuevaVenta.java
│       └── DialogObsequios.java
└── utils/                    # Utilidades y helpers
    ├── Calculator.java       # Cálculos comerciales
    ├── Constants.java        # Constantes globales
    └── Validator.java        # Validaciones
```

## 🚀 Compilación y Ejecución

### Método Rápido
```bash
# Ejecutar script automatizado
./compile_and_run.sh
```

### Método Manual
```bash
# Compilar proyecto
javac -d bin -cp "src" src/**/*.java

# Ejecutar aplicación
java -cp bin proyectitointerfaces.Tienda
```

### Requisitos del Sistema
- Java 8 o superior
- Mínimo 512MB RAM
- 100MB espacio en disco
- Resolución mínima 800x600

## 📊 Estado del Proyecto

- **Versión**: 1.0 ✅
- **Estado**: Funcional y completo ✅
- **Última actualización**: 2025
- **Documentación**: Completa ✅

### Funcionalidades Implementadas
- [x] Interfaz gráfica con JMenu y JDialog
- [x] Gestión completa de inventario
- [x] Sistema de ventas con descuentos automáticos
- [x] Configuración de políticas comerciales
- [x] Validaciones robustas de datos
- [x] Cálculos comerciales automatizados
- [x] Persistencia de configuraciones

## Autores

- **Alfredo Condori**
- **Ever García**
- **Fiorela Quispe**
- **Jorge Bastidas**
