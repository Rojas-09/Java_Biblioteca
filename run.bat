@echo off
chcp 65001 > nul
REM Script para ejecutar el programa Java compilado

echo =========================================
echo  Sistema de Gestión de Biblioteca
echo =========================================
echo.

REM Ir a la carpeta del proyecto
cd /d "%~dp0"

REM Verificar si la carpeta bin existe y contiene archivos compilados
if not exist "bin\Main.class" (
    echo ✗ Error: Main.class no encontrado
    echo Por favor, primero compile el proyecto usando: compile.bat
    pause
    exit /b 1
)

REM Ejecutar el programa
echo Iniciando aplicación...
echo.
java -Dfile.encoding=UTF-8 -cp bin Main

pause
