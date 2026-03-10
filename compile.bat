@echo off
REM Script para compilar el proyecto Java
REM Este archivo compila todos los archivos .java en la carpeta src
REM y coloca los archivos compilados (.class) en la carpeta bin

echo =========================================
echo  Compilando proyecto Java...
echo =========================================
echo.

REM Ir a la carpeta del proyecto
cd /d "%~dp0"

REM Compilar todos los archivos Java
echo Compilando archivos...
javac -d bin src\*.java

REM Verificar si la compilación fue exitosa
if %errorlevel% == 0 (
    echo.
    echo ✓ Compilación exitosa!
    echo Los archivos compilados están en la carpeta 'bin'
    echo.
    echo Para ejecutar el programa, use: run.bat
) else (
    echo.
    echo ✗ Error durante la compilación
    echo Verifique que Java esté instalado y configurado correctamente
)

pause
