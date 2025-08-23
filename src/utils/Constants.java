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
    public static double DESCUENTO_1_A_5 = 7.5;
    
    /** Descuento para 6 a 10 unidades (por defecto 10%) */
    public static double DESCUENTO_6_A_10 = 10.0;
    
    /** Descuento para 11 a 15 unidades (por defecto 12.5%) */
    public static double DESCUENTO_11_A_15 = 12.5;
    
    /** Descuento para más de 15 unidades (por defecto 15%) */
    public static double DESCUENTO_MAS_15 = 15.0;
    
    // ========================================
    // CONSTANTES DE OBSEQUIOS
    // ========================================
    
    /** Obsequio para 1 unidad (por defecto: Funda) */
    public static String OBSEQUIO_1_UNIDAD = "Funda";
    
    /** Obsequio para 2 a 5 unidades (por defecto: Protector de pantalla) */
    public static String OBSEQUIO_2_A_5 = "Protector de pantalla";
    
    /** Obsequio para 6 o más unidades (por defecto: Audífonos) */
    public static String OBSEQUIO_6_MAS = "Audífonos";
    
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
    
    // Modelo 1: Redmi A3 (modificables)
    public static String CELULAR_1_MARCA = "Xiaomi";
    public static String CELULAR_1_MODELO = "Redmi A3";
    public static double CELULAR_1_PRECIO = 650.0;
    public static String CELULAR_1_RAM = "4 GB";
    public static String CELULAR_1_ALMACENAMIENTO = "128 GB";
    
    // Modelo 2: Redmi 12C (modificables)
    public static String CELULAR_2_MARCA = "Xiaomi";
    public static String CELULAR_2_MODELO = "Redmi 12C";
    public static double CELULAR_2_PRECIO = 780.0;
    public static String CELULAR_2_RAM = "4 GB";
    public static String CELULAR_2_ALMACENAMIENTO = "128 GB";
    
    // Modelo 3: Redmi Note 12 (modificables)
    public static String CELULAR_3_MARCA = "Xiaomi";
    public static String CELULAR_3_MODELO = "Redmi Note 12";
    public static double CELULAR_3_PRECIO = 950.0;
    public static String CELULAR_3_RAM = "6 GB";
    public static String CELULAR_3_ALMACENAMIENTO = "128 GB";
    
    // Modelo 4: Redmi Note 13 (modificables)
    public static String CELULAR_4_MARCA = "Xiaomi";
    public static String CELULAR_4_MODELO = "Redmi Note 13";
    public static double CELULAR_4_PRECIO = 1150.0;
    public static String CELULAR_4_RAM = "8 GB";
    public static String CELULAR_4_ALMACENAMIENTO = "256 GB";
    
    // ========================================
    // CONSTANTES PARA CANTIDAD DE MODELOS
    // ========================================
    
    /** Número total de modelos de celulares disponibles */
    public static final int TOTAL_MODELOS = 4;

    // ========================================
    // CONSTANTES DE AUTORES
    // ========================================
    
    /** Autores del proyecto */
    public static final String AUTOR_1 = "Jorge Enrique Bastidas Ureta";
    public static final String AUTOR_2 = "Fiorela Clariza Quispe Quispe";
    public static final String AUTOR_3 = "Ever García";
    
    
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
    
    // ========================================
    // MÉTODOS PARA CONFIGURACIÓN DE DESCUENTOS
    // ========================================
    
    /**
     * Actualiza los porcentajes de descuento por volumen
     * @param descuento1a5 Descuento para 1 a 5 unidades
     * @param descuento6a10 Descuento para 6 a 10 unidades
     * @param descuento11a15 Descuento para 11 a 15 unidades
     * @param descuentoMas15 Descuento para más de 15 unidades
     */
    public static void actualizarDescuentos(double descuento1a5, double descuento6a10, 
                                          double descuento11a15, double descuentoMas15) {
        DESCUENTO_1_A_5 = descuento1a5;
        DESCUENTO_6_A_10 = descuento6a10;
        DESCUENTO_11_A_15 = descuento11a15;
        DESCUENTO_MAS_15 = descuentoMas15;
    }
    
    // ========================================
    // MÉTODOS PARA CONFIGURACIÓN DE OBSEQUIOS
    // ========================================
    
    /**
     * Actualiza los obsequios por cantidad
     * @param obsequio1 Obsequio para 1 unidad
     * @param obsequio2a5 Obsequio para 2 a 5 unidades
     * @param obsequio6Mas Obsequio para 6 o más unidades
     */
    public static void actualizarObsequios(String obsequio1, String obsequio2a5, String obsequio6Mas) {
        OBSEQUIO_1_UNIDAD = obsequio1;
        OBSEQUIO_2_A_5 = obsequio2a5;
        OBSEQUIO_6_MAS = obsequio6Mas;
    }
    
    // ========================================
    // MÉTODOS PARA ACCESO A DATOS DE CELULARES (SIN ARREGLOS)
    // ========================================
    
    /**
     * Obtiene la marca de un celular por índice
     * @param indice Índice del celular (0-3)
     * @return Marca del celular
     */
    public static String obtenerMarca(int indice) {
        switch (indice) {
            case 0: return CELULAR_1_MARCA;
            case 1: return CELULAR_2_MARCA;
            case 2: return CELULAR_3_MARCA;
            case 3: return CELULAR_4_MARCA;
            default: return "";
        }
    }
    
    /**
     * Obtiene el modelo de un celular por índice
     * @param indice Índice del celular (0-3)
     * @return Modelo del celular
     */
    public static String obtenerModelo(int indice) {
        switch (indice) {
            case 0: return CELULAR_1_MODELO;
            case 1: return CELULAR_2_MODELO;
            case 2: return CELULAR_3_MODELO;
            case 3: return CELULAR_4_MODELO;
            default: return "";
        }
    }
    
    /**
     * Obtiene el precio de un celular por índice
     * @param indice Índice del celular (0-3)
     * @return Precio del celular
     */
    public static double obtenerPrecio(int indice) {
        switch (indice) {
            case 0: return CELULAR_1_PRECIO;
            case 1: return CELULAR_2_PRECIO;
            case 2: return CELULAR_3_PRECIO;
            case 3: return CELULAR_4_PRECIO;
            default: return 0.0;
        }
    }
    
    /**
     * Obtiene la RAM de un celular por índice
     * @param indice Índice del celular (0-3)
     * @return RAM del celular
     */
    public static String obtenerRAM(int indice) {
        switch (indice) {
            case 0: return CELULAR_1_RAM;
            case 1: return CELULAR_2_RAM;
            case 2: return CELULAR_3_RAM;
            case 3: return CELULAR_4_RAM;
            default: return "";
        }
    }
    
    /**
     * Obtiene el almacenamiento de un celular por índice
     * @param indice Índice del celular (0-3)
     * @return Almacenamiento del celular
     */
    public static String obtenerAlmacenamiento(int indice) {
        switch (indice) {
            case 0: return CELULAR_1_ALMACENAMIENTO;
            case 1: return CELULAR_2_ALMACENAMIENTO;
            case 2: return CELULAR_3_ALMACENAMIENTO;
            case 3: return CELULAR_4_ALMACENAMIENTO;
            default: return "";
        }
    }
    
    /**
     * Actualiza los datos de un celular específico
     * @param indice Índice del celular (0-3)
     * @param marca Nueva marca
     * @param modelo Nuevo modelo
     * @param precio Nuevo precio
     * @param ram Nueva RAM (con "GB" incluido)
     * @param almacenamiento Nuevo almacenamiento (con "GB" incluido)
     */
    public static void actualizarCelular(int indice, String marca, String modelo, 
                                        double precio, String ram, String almacenamiento) {
        switch (indice) {
            case 0:
                CELULAR_1_MARCA = marca;
                CELULAR_1_MODELO = modelo;
                CELULAR_1_PRECIO = precio;
                CELULAR_1_RAM = ram;
                CELULAR_1_ALMACENAMIENTO = almacenamiento;
                break;
            case 1:
                CELULAR_2_MARCA = marca;
                CELULAR_2_MODELO = modelo;
                CELULAR_2_PRECIO = precio;
                CELULAR_2_RAM = ram;
                CELULAR_2_ALMACENAMIENTO = almacenamiento;
                break;
            case 2:
                CELULAR_3_MARCA = marca;
                CELULAR_3_MODELO = modelo;
                CELULAR_3_PRECIO = precio;
                CELULAR_3_RAM = ram;
                CELULAR_3_ALMACENAMIENTO = almacenamiento;
                break;
            case 3:
                CELULAR_4_MARCA = marca;
                CELULAR_4_MODELO = modelo;
                CELULAR_4_PRECIO = precio;
                CELULAR_4_RAM = ram;
                CELULAR_4_ALMACENAMIENTO = almacenamiento;
                break;
        }
    }
}
