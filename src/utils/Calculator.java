package utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que maneja todos los cálculos comerciales del sistema
 * de gestión de tienda de celulares Xiaomi.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
public class Calculator {
    
    // ========================================
    // VARIABLES GLOBALES DE CONFIGURACIÓN
    // ========================================
    
    /** Contador global de ventas */
    private static int contadorVentas = 0;
    
    /** Descuentos configurables */
    private static double descuento1a5 = Constants.DESCUENTO_1_A_5;
    private static double descuento6a10 = Constants.DESCUENTO_6_A_10;
    private static double descuento11a15 = Constants.DESCUENTO_11_A_15;
    private static double descuentoMas15 = Constants.DESCUENTO_MAS_15;
    
    /** Obsequios configurables */
    private static String obsequio1 = Constants.OBSEQUIO_1_UNIDAD;
    private static String obsequio2a5 = Constants.OBSEQUIO_2_A_5;
    private static String obsequio6mas = Constants.OBSEQUIO_6_MAS;
    
    // ========================================
    // CÁLCULOS DE DESCUENTOS
    // ========================================
    
    /**
     * Calcula el descuento según la cantidad de unidades
     * @param cantidad Cantidad de unidades
     * @return Porcentaje de descuento
     */
    public static double calcularDescuento(int cantidad) {
        if (cantidad >= 1 && cantidad <= 5) {
            return descuento1a5;
        } else if (cantidad >= 6 && cantidad <= 10) {
            return descuento6a10;
        } else if (cantidad >= 11 && cantidad <= 15) {
            return descuento11a15;
        } else if (cantidad > 15) {
            return descuentoMas15;
        }
        return 0.0;
    }
    
    /**
     * Calcula el monto del descuento
     * @param precioUnitario Precio unitario del producto
     * @param cantidad Cantidad de unidades
     * @return Monto del descuento
     */
    public static double calcularMontoDescuento(double precioUnitario, int cantidad) {
        double subtotal = precioUnitario * cantidad;
        double porcentajeDescuento = calcularDescuento(cantidad);
        return subtotal * (porcentajeDescuento / 100.0);
    }
    
    /**
     * Calcula el subtotal (sin descuento)
     * @param precioUnitario Precio unitario del producto
     * @param cantidad Cantidad de unidades
     * @return Subtotal
     */
    public static double calcularSubtotal(double precioUnitario, int cantidad) {
        return precioUnitario * cantidad;
    }
    
    /**
     * Calcula el total con descuento aplicado
     * @param precioUnitario Precio unitario del producto
     * @param cantidad Cantidad de unidades
     * @return Total con descuento
     */
    public static double calcularTotal(double precioUnitario, int cantidad) {
        double subtotal = calcularSubtotal(precioUnitario, cantidad);
        double descuento = calcularMontoDescuento(precioUnitario, cantidad);
        return subtotal - descuento;
    }
    
    /**
     * Calcula el ahorro total
     * @param precioUnitario Precio unitario del producto
     * @param cantidad Cantidad de unidades
     * @return Monto ahorrado
     */
    public static double calcularAhorro(double precioUnitario, int cantidad) {
        return calcularMontoDescuento(precioUnitario, cantidad);
    }
    
    // ========================================
    // ASIGNACIÓN DE OBSEQUIOS
    // ========================================
    
    /**
     * Asigna el obsequio correspondiente según la cantidad
     * @param cantidad Cantidad de unidades
     * @return Nombre del obsequio
     */
    public static String asignarObsequio(int cantidad) {
        if (cantidad == 1) {
            return obsequio1;
        } else if (cantidad >= 2 && cantidad <= 5) {
            return obsequio2a5;
        } else if (cantidad >= 6) {
            return obsequio6mas;
        }
        return "Sin obsequio";
    }
    
    /**
     * Verifica si se debe mostrar alerta de progreso
     * @return true si se debe mostrar alerta, false en caso contrario
     */
    public static boolean debeMostrarAlerta() {
        contadorVentas++;
        return contadorVentas % Constants.ALERTA_CADA_VENTAS == 0;
    }
    
    // ========================================
    // GENERACIÓN DE BOLETAS
    // ========================================
    
    /**
     * Genera el contenido de la boleta
     * @param modelo Modelo del producto
     * @param precioUnitario Precio unitario
     * @param cantidad Cantidad vendida
     * @param subtotal Subtotal
     * @param descuento Monto del descuento
     * @param total Total final
     * @param obsequio Obsequio asignado
     * @return Contenido de la boleta
     */
    public static String generarBoleta(String modelo, double precioUnitario, 
                                     int cantidad, double subtotal, double descuento, 
                                     double total, String obsequio) {
        
        DecimalFormat df = new DecimalFormat("#,##0.00");
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORMATO_FECHA);
        
        StringBuilder boleta = new StringBuilder();
        boleta.append("=".repeat(50)).append("\n");
        boleta.append("           TIENDA DISTRIBUIDORA XIAOMI\n");
        boleta.append("=".repeat(50)).append("\n");
        boleta.append("Fecha: ").append(sdf.format(new Date())).append("\n");
        boleta.append("Venta #: ").append(contadorVentas).append("\n");
        boleta.append("-".repeat(50)).append("\n");
        boleta.append("PRODUCTO: ").append(modelo).append("\n");
        boleta.append("Precio unitario: ").append(Constants.MONEDA).append(" ").append(df.format(precioUnitario)).append("\n");
        boleta.append("Cantidad: ").append(cantidad).append(" unidades\n");
        boleta.append("Subtotal: ").append(Constants.MONEDA).append(" ").append(df.format(subtotal)).append("\n");
        boleta.append("Descuento (").append(calcularDescuento(cantidad)).append("%): ").append(Constants.MONEDA).append(" ").append(df.format(descuento)).append("\n");
        boleta.append("-".repeat(50)).append("\n");
        boleta.append("TOTAL: ").append(Constants.MONEDA).append(" ").append(df.format(total)).append("\n");
        boleta.append("Obsequio: ").append(obsequio).append("\n");
        boleta.append("=".repeat(50)).append("\n");
        boleta.append("¡Gracias por su compra!\n");
        boleta.append("=".repeat(50)).append("\n");
        
        return boleta.toString();
    }
    
    /**
     * Genera un resumen de la venta
     * @param modelo Modelo del producto
     * @param cantidad Cantidad vendida
     * @param total Total de la venta
     * @return Resumen de la venta
     */
    public static String generarResumenVenta(String modelo, int cantidad, double total) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return String.format("Venta #%d: %s - %d unidades - Total: %s %s", 
                           contadorVentas, modelo, cantidad, Constants.MONEDA, df.format(total));
    }
    
    // ========================================
    // CONFIGURACIÓN DE DESCUENTOS
    // ========================================
    
    /**
     * Actualiza los descuentos configurables
     * @param desc1a5 Descuento para 1 a 5 unidades
     * @param desc6a10 Descuento para 6 a 10 unidades
     * @param desc11a15 Descuento para 11 a 15 unidades
     * @param descMas15 Descuento para más de 15 unidades
     */
    public static void actualizarDescuentos(double desc1a5, double desc6a10, 
                                          double desc11a15, double descMas15) {
        descuento1a5 = desc1a5;
        descuento6a10 = desc6a10;
        descuento11a15 = desc11a15;
        descuentoMas15 = descMas15;
    }
    
    /**
     * Obtiene el descuento actual para 1 a 5 unidades
     * @return Porcentaje de descuento
     */
    public static double getDescuento1a5() {
        return descuento1a5;
    }
    
    /**
     * Obtiene el descuento actual para 6 a 10 unidades
     * @return Porcentaje de descuento
     */
    public static double getDescuento6a10() {
        return descuento6a10;
    }
    
    /**
     * Obtiene el descuento actual para 11 a 15 unidades
     * @return Porcentaje de descuento
     */
    public static double getDescuento11a15() {
        return descuento11a15;
    }
    
    /**
     * Obtiene el descuento actual para más de 15 unidades
     * @return Porcentaje de descuento
     */
    public static double getDescuentoMas15() {
        return descuentoMas15;
    }
    
    // ========================================
    // CONFIGURACIÓN DE OBSEQUIOS
    // ========================================
    
    /**
     * Actualiza los obsequios configurables
     * @param obs1 Obsequio para 1 unidad
     * @param obs2a5 Obsequio para 2 a 5 unidades
     * @param obs6mas Obsequio para 6 o más unidades
     */
    public static void actualizarObsequios(String obs1, String obs2a5, String obs6mas) {
        obsequio1 = obs1;
        obsequio2a5 = obs2a5;
        obsequio6mas = obs6mas;
    }
    
    /**
     * Obtiene el obsequio actual para 1 unidad
     * @return Nombre del obsequio
     */
    public static String getObsequio1() {
        return obsequio1;
    }
    
    /**
     * Obtiene el obsequio actual para 2 a 5 unidades
     * @return Nombre del obsequio
     */
    public static String getObsequio2a5() {
        return obsequio2a5;
    }
    
    /**
     * Obtiene el obsequio actual para 6 o más unidades
     * @return Nombre del obsequio
     */
    public static String getObsequio6mas() {
        return obsequio6mas;
    }
    
    // ========================================
    // CONTROL DE VENTAS
    // ========================================
    
    /**
     * Obtiene el contador actual de ventas
     * @return Número de ventas realizadas
     */
    public static int getContadorVentas() {
        return contadorVentas;
    }
    
    /**
     * Reinicia el contador de ventas
     */
    public static void reiniciarContadorVentas() {
        contadorVentas = 0;
    }
    
    /**
     * Incrementa el contador de ventas
     */
    public static void incrementarContadorVentas() {
        contadorVentas++;
    }
    
    // ========================================
    // MÉTODOS DE UTILIDAD
    // ========================================
    
    /**
     * Formatea un número como moneda
     * @param cantidad Cantidad a formatear
     * @return String formateado como moneda
     */
    public static String formatearMoneda(double cantidad) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return Constants.MONEDA + " " + df.format(cantidad);
    }
    
    /**
     * Formatea un porcentaje
     * @param porcentaje Porcentaje a formatear
     * @return String formateado como porcentaje
     */
    public static String formatearPorcentaje(double porcentaje) {
        DecimalFormat df = new DecimalFormat("#0.0");
        return df.format(porcentaje) + "%";
    }
    
    /**
     * Calcula el porcentaje de descuento aplicado
     * @param precioOriginal Precio original
     * @param precioFinal Precio final
     * @return Porcentaje de descuento
     */
    public static double calcularPorcentajeDescuento(double precioOriginal, double precioFinal) {
        if (precioOriginal <= 0) return 0.0;
        return ((precioOriginal - precioFinal) / precioOriginal) * 100.0;
    }
}
