#!/bin/bash

# Script para compilar y ejecutar el Sistema de Gestión de Tienda de Celulares Xiaomi
# Autor: Equipo de Desarrollo
# Versión: 1.0

echo "=========================================="
echo "  SISTEMA DE GESTIÓN DE TIENDA XIAOMI"
echo "=========================================="
echo ""

# Verificar si Java está instalado
if ! command -v javac &> /dev/null; then
    echo "❌ Error: Java no está instalado o no está en el PATH"
    echo "Por favor, instale Java Development Kit (JDK)"
    exit 1
fi

# Verificar versión de Java
echo "📋 Información del sistema:"
echo "   Java version: $(java -version 2>&1 | head -n 1)"
echo "   Java compiler: $(javac -version 2>&1)"
echo ""

# Crear directorio bin si no existe
if [ ! -d "bin" ]; then
    echo "📁 Creando directorio bin..."
    mkdir -p bin
fi

# Limpiar archivos compilados anteriores
echo "🧹 Limpiando archivos compilados anteriores..."
rm -rf bin/*

# Compilar el proyecto
echo "🔨 Compilando el proyecto..."
javac -d bin -cp "src" src/**/*.java

# Verificar si la compilación fue exitosa
if [ $? -eq 0 ]; then
    echo "✅ Compilación exitosa!"
    echo ""
    
    # Preguntar si desea ejecutar la aplicación
    read -p "¿Desea ejecutar la aplicación? (s/n): " -n 1 -r
    echo ""
    
    if [[ $REPLY =~ ^[Ss]$ ]]; then
        echo "🚀 Ejecutando la aplicación..."
        echo ""
        java -cp bin proyectitointerfaces.Tienda
    else
        echo "👋 Compilación completada. Para ejecutar manualmente use:"
        echo "   java -cp bin proyectitointerfaces.Tienda"
    fi
else
    echo "❌ Error en la compilación. Revise los errores arriba."
    exit 1
fi

echo ""
echo "=========================================="
echo "  ¡Gracias por usar el sistema!"
echo "=========================================="
