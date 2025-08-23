package utils;

/**
 * Clase que contiene todas las constantes globales del sistema
 * de gestión de tienda de celulares Xiaomi.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
public class Constants {
    
    // ========================================
    // CONSTANTES DE DESCUENTOS POR VOLUMEN
    // ========================================
    
    /** Descuento para 1 a 5 unidades (por defecto 7.5%) */
    public static final double DESCUENTO_1_A_5 = 7.5;
    
    /** Descuento para 6 a 10 unidades (por defecto 10%) */
    public static final double DESCUENTO_6_A_10 = 10.0;
    
    /** Descuento para 11 a 15 unidades (por defecto 12.5%) */
    public static final double DESCUENTO_11_A_15 = 12.5;
    
    /** Descuento para más de 15 unidades (por defecto 15%) */
    public static final double DESCUENTO_MAS_15 = 15.0;
    
    // ========================================
    // CONSTANTES DE OBSEQUIOS
    // ========================================
    
    /** Obsequio para 1 unidad (por defecto: Funda) */
    public static final String OBSEQUIO_1_UNIDAD = "Funda";
    
    /** Obsequio para 2 a 5 unidades (por defecto: Protector de pantalla) */
    public static final String OBSEQUIO_2_A_5 = "Protector de pantalla";
    
    /** Obsequio para 6 o más unidades (por defecto: Audífonos) */
    public static final String OBSEQUIO_6_MAS = "Audífonos";
    
    // ========================================
    // CONSTANTES DE VALIDACIÓN
    // ========================================
    
    /** Precio mínimo de celulares (S/. 600) */
    public static final double PRECIO_MINIMO = 600.0;
    
    /** Precio máximo de celulares (S/. 1,200) */
    public static final double PRECIO_MAXIMO = 1200.0;
    
    /** Cantidad máxima de unidades por venta */
    public static final int CANTIDAD_MAXIMA = 50;
    
    /** Cantidad mínima de unidades por venta */
    public static final int CANTIDAD_MINIMA = 1;
    
    // ========================================
    // CONSTANTES DE INTERFAZ
    // ========================================
    
    /** Título principal de la aplicación */
    public static final String TITULO_APLICACION = "TIENDA DISTRIBUIDORA XIAOMI";
    
    /** Ancho de la ventana principal */
    public static final int ANCHO_VENTANA = 800;
    
    /** Alto de la ventana principal */
    public static final int ALTO_VENTANA = 600;
    
    /** Fuente principal del sistema */
    public static final String FUENTE_PRINCIPAL = "Tahoma";
    
    /** Tamaño de fuente normal */
    public static final int TAMANO_FUENTE_NORMAL = 13;
    
    /** Tamaño de fuente título */
    public static final int TAMANO_FUENTE_TITULO = 18;
    
    // ========================================
    // CONSTANTES DE ARCHIVOS
    // ========================================
    
    /** Archivo de productos */
    public static final String ARCHIVO_PRODUCTOS = "productos.dat";
    
    /** Archivo de ventas */
    public static final String ARCHIVO_VENTAS = "ventas.dat";
    
    /** Archivo de configuración */
    public static final String ARCHIVO_CONFIG = "configuracion.dat";
    
    /** Directorio de datos */
    public static final String DIRECTORIO_DATOS = "data/";
    
    // ========================================
    // CONSTANTES DE MENSAJES
    // ========================================
    
    /** Mensaje de error de precio inválido */
    public static final String ERROR_PRECIO = "El precio debe estar entre S/. " + 
                                             PRECIO_MINIMO + " y S/. " + PRECIO_MAXIMO;
    
    /** Mensaje de error de cantidad inválida */
    public static final String ERROR_CANTIDAD = "La cantidad debe estar entre " + 
                                               CANTIDAD_MINIMA + " y " + CANTIDAD_MAXIMA;
    
    /** Mensaje de éxito al guardar */
    public static final String EXITO_GUARDAR = "Datos guardados exitosamente";
    
    /** Mensaje de error al guardar */
    public static final String ERROR_GUARDAR = "Error al guardar los datos";
    
    /** Mensaje de confirmación de salida */
    public static final String CONFIRMAR_SALIDA = "¿Está seguro que desea salir del sistema?";
    
    // ========================================
    // CONSTANTES DE VENTAS
    // ========================================
    
    /** Contador de ventas para mostrar alertas */
    public static final int ALERTA_CADA_VENTAS = 5;
    
    /** Moneda del sistema */
    public static final String MONEDA = "S/.";
    
    /** Formato de fecha para boletas */
    public static final String FORMATO_FECHA = "dd/MM/yyyy HH:mm:ss";
    
    // ========================================
    // CONSTANTES DE CELULARES - GAMA MEDIA-BAJA
    // ========================================
    
    // Modelo 1: Redmi A3
    public static final String CELULAR_1_MARCA = "Xiaomi";
    public static final String CELULAR_1_MODELO = "Redmi A3";
    public static final double CELULAR_1_PRECIO = 650.0;
    public static final String CELULAR_1_RAM = "4 GB";
    public static final String CELULAR_1_ALMACENAMIENTO = "128 GB";
    
    // Modelo 2: Redmi 12C
    public static final String CELULAR_2_MARCA = "Xiaomi";
    public static final String CELULAR_2_MODELO = "Redmi 12C";
    public static final double CELULAR_2_PRECIO = 780.0;
    public static final String CELULAR_2_RAM = "4 GB";
    public static final String CELULAR_2_ALMACENAMIENTO = "128 GB";
    
    // Modelo 3: Redmi Note 12
    public static final String CELULAR_3_MARCA = "Xiaomi";
    public static final String CELULAR_3_MODELO = "Redmi Note 12";
    public static final double CELULAR_3_PRECIO = 950.0;
    public static final String CELULAR_3_RAM = "6 GB";
    public static final String CELULAR_3_ALMACENAMIENTO = "128 GB";
    
    // Modelo 4: Redmi Note 13
    public static final String CELULAR_4_MARCA = "Xiaomi";
    public static final String CELULAR_4_MODELO = "Redmi Note 13";
    public static final double CELULAR_4_PRECIO = 1150.0;
    public static final String CELULAR_4_RAM = "8 GB";
    public static final String CELULAR_4_ALMACENAMIENTO = "256 GB";
    
    // Arreglos para facilitar el manejo de los celulares
    public static final String[] CELULARES_MODELOS = {
        CELULAR_1_MODELO, CELULAR_2_MODELO, CELULAR_3_MODELO, CELULAR_4_MODELO
    };
    
    public static final String[] CELULARES_MARCAS = {
        CELULAR_1_MARCA, CELULAR_2_MARCA, CELULAR_3_MARCA, CELULAR_4_MARCA
    };
    
    public static final double[] CELULARES_PRECIOS = {
        CELULAR_1_PRECIO, CELULAR_2_PRECIO, CELULAR_3_PRECIO, CELULAR_4_PRECIO
    };
    
    public static final String[] CELULARES_RAM = {
        CELULAR_1_RAM, CELULAR_2_RAM, CELULAR_3_RAM, CELULAR_4_RAM
    };
    
    public static final String[] CELULARES_ALMACENAMIENTO = {
        CELULAR_1_ALMACENAMIENTO, CELULAR_2_ALMACENAMIENTO, CELULAR_3_ALMACENAMIENTO, CELULAR_4_ALMACENAMIENTO
    };

    // ========================================
    // CONSTANTES DE AUTORES
    // ========================================
    
    /** Autores del proyecto */
    public static final String[] AUTORES = {
        "Alfredo Condori",
        "Ever García", 
        "Fiorela Quispe",
        "Jorge Bastidas"
    };
    
    /** Versión del sistema */
    public static final String VERSION = "1.0";
    
    /** Institución educativa */
    public static final String INSTITUCION = "Cibertec";
    
    /** Curso */
    public static final String CURSO = "Introducción a la Algoritmia";
    
    // ========================================
    // MÉTODOS UTILITARIOS
    // ========================================
    
    /**
     * Obtiene el descuento correspondiente según la cantidad
     * @param cantidad Cantidad de unidades
     * @return Porcentaje de descuento
     */
    public static double obtenerDescuento(int cantidad) {
        if (cantidad >= 1 && cantidad <= 5) {
            return DESCUENTO_1_A_5;
        } else if (cantidad >= 6 && cantidad <= 10) {
            return DESCUENTO_6_A_10;
        } else if (cantidad >= 11 && cantidad <= 15) {
            return DESCUENTO_11_A_15;
        } else if (cantidad > 15) {
            return DESCUENTO_MAS_15;
        }
        return 0.0;
    }
    
    /**
     * Obtiene el obsequio correspondiente según la cantidad
     * @param cantidad Cantidad de unidades
     * @return Nombre del obsequio
     */
    public static String obtenerObsequio(int cantidad) {
        if (cantidad == 1) {
            return OBSEQUIO_1_UNIDAD;
        } else if (cantidad >= 2 && cantidad <= 5) {
            return OBSEQUIO_2_A_5;
        } else if (cantidad >= 6) {
            return OBSEQUIO_6_MAS;
        }
        return "Sin obsequio";
    }
    
    /**
     * Valida si un precio está en el rango válido
     * @param precio Precio a validar
     * @return true si es válido, false en caso contrario
     */
    public static boolean esPrecioValido(double precio) {
        return precio >= PRECIO_MINIMO && precio <= PRECIO_MAXIMO;
    }
    
    /**
     * Valida si una cantidad está en el rango válido
     * @param cantidad Cantidad a validar
     * @return true si es válida, false en caso contrario
     */
    public static boolean esCantidadValida(int cantidad) {
        return cantidad >= CANTIDAD_MINIMA && cantidad <= CANTIDAD_MAXIMA;
    }
}
