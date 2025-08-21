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
    
    /**
     * Valida que la pantalla no esté vacía
     * @param pantalla Pantalla a validar
     * @return true si es válida, false en caso contrario
     */
    public static boolean validarPantalla(String pantalla) {
        if (pantalla == null || pantalla.trim().isEmpty()) {
            mostrarError("La pantalla no puede estar vacía");
            return false;
        }
        return true;
    }
    
    /**
     * Valida que la RAM sea un número válido
     * @param ramStr RAM como string
     * @return La RAM como int si es válida, -1 si no lo es
     */
    public static int validarRam(String ramStr) {
        try {
            int ram = Integer.parseInt(ramStr);
            if (ram <= 0) {
                mostrarError("La RAM debe ser mayor a 0");
                return -1;
            }
            if (ram > 32) {
                mostrarError("La RAM no puede ser mayor a 32 GB");
                return -1;
            }
            return ram;
        } catch (NumberFormatException e) {
            mostrarError("La RAM debe ser un número entero válido");
            return -1;
        }
    }
    
    /**
     * Valida que la ROM sea un número válido
     * @param romStr ROM como string
     * @return La ROM como int si es válida, -1 si no lo es
     */
    public static int validarRom(String romStr) {
        try {
            int rom = Integer.parseInt(romStr);
            if (rom <= 0) {
                mostrarError("La ROM debe ser mayor a 0");
                return -1;
            }
            if (rom > 1024) {
                mostrarError("La ROM no puede ser mayor a 1024 GB");
                return -1;
            }
            return rom;
        } catch (NumberFormatException e) {
            mostrarError("La ROM debe ser un número entero válido");
            return -1;
        }
    }
    
    /**
     * Valida que la carga rápida no esté vacía
     * @param carga Carga rápida a validar
     * @return true si es válida, false en caso contrario
     */
    public static boolean validarCargaRapida(String carga) {
        if (carga == null || carga.trim().isEmpty()) {
            mostrarError("La carga rápida no puede estar vacía");
            return false;
        }
        return true;
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
    
    /**
     * Valida que se haya seleccionado un producto
     * @param productoSeleccionado Producto seleccionado
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarProductoSeleccionado(String productoSeleccionado) {
        if (productoSeleccionado == null || productoSeleccionado.trim().isEmpty()) {
            mostrarError("Debe seleccionar un producto");
            return false;
        }
        return true;
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
    
    /**
     * Valida que un número sea positivo
     * @param numero Número a validar
     * @param nombreCampo Nombre del campo para el mensaje de error
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarNumeroPositivo(double numero, String nombreCampo) {
        if (numero <= 0) {
            mostrarError("El campo '" + nombreCampo + "' debe ser mayor a 0");
            return false;
        }
        return true;
    }
    
    /**
     * Valida que un número entero sea positivo
     * @param numero Número a validar
     * @param nombreCampo Nombre del campo para el mensaje de error
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarNumeroEnteroPositivo(int numero, String nombreCampo) {
        if (numero <= 0) {
            mostrarError("El campo '" + nombreCampo + "' debe ser mayor a 0");
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
    
    /**
     * Muestra un mensaje de información
     * @param mensaje Mensaje a mostrar
     */
    public static void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(
            null, 
            mensaje, 
            "Información", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    /**
     * Muestra un mensaje de confirmación
     * @param mensaje Mensaje a mostrar
     * @return true si el usuario confirma, false en caso contrario
     */
    public static boolean mostrarConfirmacion(String mensaje) {
        int respuesta = JOptionPane.showConfirmDialog(
            null, 
            mensaje, 
            "Confirmación", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        return respuesta == JOptionPane.YES_OPTION;
    }
    
    /**
     * Limpia un string eliminando espacios en blanco
     * @param texto Texto a limpiar
     * @return Texto limpio
     */
    public static String limpiarTexto(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.trim();
    }
    
    /**
     * Convierte un string a double de forma segura
     * @param texto Texto a convertir
     * @return El número como double, 0.0 si no es válido
     */
    public static double stringToDouble(String texto) {
        try {
            return Double.parseDouble(texto.trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    
    /**
     * Convierte un string a int de forma segura
     * @param texto Texto a convertir
     * @return El número como int, 0 si no es válido
     */
    public static int stringToInt(String texto) {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
