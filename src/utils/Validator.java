package utils;

import javax.swing.JOptionPane;

/**
 * Clase que maneja todas las validaciones del sistema
 * de gestión de tienda de celulares Xiaomi.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
public class Validator {
    
    // ========================================
    // VALIDACIONES DE PRODUCTOS
    // ========================================
    
    /**
     * Valida que el modelo no esté vacío
     * @param modelo Modelo a validar
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            mostrarError("El modelo no puede estar vacío");
            return false;
        }
        if (modelo.trim().length() < 3) {
            mostrarError("El modelo debe tener al menos 3 caracteres");
            return false;
        }
        return true;
    }
    
    /**
     * Valida que el precio esté en el rango correcto
     * @param precio Precio a validar
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarPrecio(double precio) {
        if (!Constants.esPrecioValido(precio)) {
            mostrarError(Constants.ERROR_PRECIO);
            return false;
        }
        return true;
    }
    
    /**
     * Valida que el precio sea un número válido
     * @param precioStr Precio como string
     * @return El precio como double si es válido, -1 si no lo es
     */
    public static double validarPrecioString(String precioStr) {
        try {
            double precio = Double.parseDouble(precioStr);
            if (validarPrecio(precio)) {
                return precio;
            }
        } catch (NumberFormatException e) {
            mostrarError("El precio debe ser un número válido");
        }
        return -1;
    }
    
    
    
    
    
    // ========================================
    // VALIDACIONES DE VENTAS
    // ========================================
    
    /**
     * Valida que la cantidad esté en el rango correcto
     * @param cantidad Cantidad a validar
     * @return true si es válida, false en caso contrario
     */
    public static boolean validarCantidad(int cantidad) {
        if (!Constants.esCantidadValida(cantidad)) {
            mostrarError(Constants.ERROR_CANTIDAD);
            return false;
        }
        return true;
    }
    
    /**
     * Valida que la cantidad sea un número válido
     * @param cantidadStr Cantidad como string
     * @return La cantidad como int si es válida, -1 si no lo es
     */
    public static int validarCantidadString(String cantidadStr) {
    	
        try {
            int cantidad = Integer.parseInt(cantidadStr);
            if (validarCantidad(cantidad)) {
                return cantidad;
            }
        } catch (NumberFormatException e) {
            mostrarError("La cantidad debe ser un número entero válido");
        }
        return -1;
    }
    
    
    // ========================================
    // VALIDACIONES DE CONFIGURACIÓN
    // ========================================
    
    /**
     * Valida que un porcentaje de descuento sea válido
     * @param porcentajeStr Porcentaje como string
     * @return El porcentaje como double si es válido, -1 si no lo es
     */
    public static double validarPorcentajeDescuento(String porcentajeStr) {
        try {
            double porcentaje = Double.parseDouble(porcentajeStr);
            if (porcentaje < 0 || porcentaje > 100) {
                mostrarError("El porcentaje debe estar entre 0 y 100");
                return -1;
            }
            return porcentaje;
        } catch (NumberFormatException e) {
            mostrarError("El porcentaje debe ser un número válido");
            return -1;
        }
    }
    /**
     * Valida que stock  sea válido
     * @param stockStr Stock como string
     * @return El stock como int si es válido, -1 si no lo es
     */
    public static int validarStock(int stock) {
        try {
            
            if (stock < 0 ) {
                mostrarError("El stock debe ser mayor que 0");
                return -1;
            }
            return stock;
        } catch (NumberFormatException e) {
            mostrarError("El porcentaje debe ser un número válido");
            return -1;
        }
    }
    
    /**
     * Valida que un obsequio no esté vacío
     * @param obsequio Obsequio a validar
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarObsequio(String obsequio) {
        if (obsequio == null || obsequio.trim().isEmpty()) {
            mostrarError("El obsequio no puede estar vacío");
            return false;
        }
        return true;
    }
    
    // ========================================
    // VALIDACIONES GENERALES
    // ========================================
    
    /**
     * Valida que un campo no esté vacío
     * @param campo Campo a validar
     * @param nombreCampo Nombre del campo para el mensaje de error
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarCampoNoVacio(String campo, String nombreCampo) {
        if (campo == null || campo.trim().isEmpty()) {
            mostrarError("El campo '" + nombreCampo + "' no puede estar vacío");
            return false;
        }
        return true;
    }
    
    
    
    // ========================================
    // MÉTODOS DE UTILIDAD
    // ========================================
    
    /**
     * Muestra un mensaje de error
     * @param mensaje Mensaje a mostrar
     */
    public static void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
            null, 
            mensaje, 
            "Error de Validación", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    
    
    
    
}
