# 📚 SISTEMA DE GESTIÓN DE BIBLIOTECA - JAVA POO

## Descripción

Sistema interactivo de gestión de biblioteca que demuestra los 4 pilares de la Programación Orientada a Objetos en Java:

1. **ABSTRACCIÓN**: Clase abstracta `MaterialBibliografico` con métodos abstractos que definen el contrato
2. **ENCAPSULAMIENTO**: Atributos privados con getters/setters validados
3. **HERENCIA**: Las clases `Libro`, `Revista` y `Pelicula` heredan de `MaterialBibliografico`
4. **POLIMORFISMO**: Uso de `ArrayList<MaterialBibliografico>` que contiene diferentes tipos de materiales

---

## Estructura del Proyecto

```
Java_Biblioteca/
│
├── src/                           # Código fuente
│   ├── MaterialBibliografico.java  # Clase abstracta base
│   ├── Libro.java                  # Clase que extiende MaterialBibliografico
│   ├── Revista.java                # Clase que extiende MaterialBibliografico
│   ├── Pelicula.java               # Clase que extiende MaterialBibliografico
│   └── Main.java                   # Clase principal con menú interactivo
│
├── bin/                            # Archivos compilados
│
├── compile.bat                     # Script para compilar
├── run.bat                         # Script para ejecutar
└── README.md                       # Este archivo
```

---

## 🎯 Pilares de POO Implementados

### 1. ABSTRACCIÓN
- **Clase Base**: `MaterialBibliografico` es una clase abstracta que define el contrato
- **Métodos Abstractos**: 
  - `calcularMulta(int diasRetraso)` - Varía por tipo de material
  - `mostrarInformacion()` - Cada tipo muestra información diferente
  - `getDiasMaximoPrestamo()` - Diferentes límites según el tipo

```java
public abstract class MaterialBibliografico {
    public abstract double calcularMulta(int diasRetraso);
    public abstract void mostrarInformacion();
    public abstract int getDiasMaximoPrestamo();
}
```

### 2. ENCAPSULAMIENTO
- **Atributos Privados**: Acceso controlado mediante getters/setters
- **Validaciones**: Validación de datos en los setters

```java
private String titulo;
private int anioPublicacion;

public void setTitulo(String titulo) {
    if (titulo == null || titulo.trim().isEmpty()) {
        throw new IllegalArgumentException("El título no puede ser nulo o vacío");
    }
    this.titulo = titulo;
}
```

### 3. HERENCIA
- **Tres Subclases**: Libro, Revista y Pelicula heredan de MaterialBibliografico
- **Reutilización de Código**: Las subclases heredan métodos comunes
- **Extensión**: Cada subclase agrega atributos específicos

```java
public class Libro extends MaterialBibliografico {
    private String autor;
    private int numeroPaginas;
    // ...
}
```

### 4. POLIMORFISMO
- **ArrayList Polimórfico**: `ArrayList<MaterialBibliografico>` contiene diferentes tipos
- **Comportamiento Dinámico**: Cada objeto ejecuta su propia versión de los métodos

```java
ArrayList<MaterialBibliografico> biblioteca = new ArrayList<>();
biblioteca.add(new Libro(...));     // Libro IS-A MaterialBibliografico
biblioteca.add(new Revista(...));   // Revista IS-A MaterialBibliografico
biblioteca.add(new Pelicula(...));  // Pelicula IS-A MaterialBibliografico

// Llamada polimórfica - cada objeto ejecuta su propia versión
for (MaterialBibliografico material : biblioteca) {
    material.mostrarInformacion();  // Comportamiento diferente según el tipo
}
```

---

## 📋 Características del Sistema

### Tipos de Materiales

#### 📚 LIBRO
- Atributos: ID, Título, Año, Autor, Número de Páginas
- Días máximo de préstamo: **14 días**
- Multa por retraso: **$5.000 por día**

#### 📰 REVISTA
- Atributos: ID, Título, Año, Periodicidad, Número de Edición
- Días máximo de préstamo: **7 días**
- Multa por retraso: **$3.000 por día**

#### 🎬 PELÍCULA
- Atributos: ID, Título, Año, Duración (minutos), Director
- Días máximo de préstamo: **3 días**
- Multa por retraso: **$10.000 por día**

### Operaciones del Sistema

1. **Agregar nuevo material**
   - Seleccionar tipo (Libro, Revista, Película)
   - Ingresar datos con validaciones
   - Almacenar en la biblioteca

2. **Listar todos los materiales**
   - Mostrar información detallada de cada material
   - Validar disponibilidad (prestado/disponible)

3. **Simular préstamo y calcular multa**
   - Seleccionar material
   - Prestar material
   - Ingresar días de retraso
   - Calcular multa automáticamente
   - Devolver material

4. **Salir**
   - Cerrar la aplicación

---

## 🚀 Compilación y Ejecución

### Opción 1: Usando Scripts Batch (Windows)

#### Compilar:
```bash
compile.bat
```

#### Ejecutar:
```bash
run.bat
```

### Opción 2: Manualmente en Terminal

#### Compilar todos los archivos:
```bash
javac -d bin src\*.java
```

#### Ejecutar:
```bash
java -cp bin Main
```

---

## 💻 Ejemplo de Uso

```
╔════════════════════════════════════════════════════╗
║   SISTEMA DE GESTIÓN DE BIBLIOTECA - JAVA POO     ║
║   Demostrando los 4 Pilares de POO                ║
╚════════════════════════════════════════════════════╝

📚 Inicializando biblioteca con materiales de ejemplo...
✓ Libro agregado: Cien Años de Soledad
✓ Revista agregada: National Geographic
✓ Película agregada: El Señor de los Anillos

==================================================
              MENÚ PRINCIPAL
==================================================
1. Agregar nuevo material (Libro, Revista o Película)
2. Listar todos los materiales
3. Simular préstamo y calcular multa
4. Salir
==================================================
Ingrese su opción: 2

==================================================
         MATERIALES EN LA BIBLIOTECA
==================================================
Total de materiales: 3

📚 ===== LIBRO =====
   ID: L001
   Título: Cien Años de Soledad
   Autor: Gabriel García Márquez
   Año: 1967
   Páginas: 417
   Estado: DISPONIBLE
   Días máx. de préstamo: 14
   Multa por día de retraso: $5.000
===================
```

---

## 📝 Validaciones Implementadas

- ✓ ID no puede ser nulo o vacío
- ✓ Título no puede ser nulo o vacío
- ✓ Año de publicación debe ser positivo
- ✓ Número de páginas debe ser positivo
- ✓ Duración de películas debe ser positiva
- ✓ Periodicidad válida (semanal, mensual, trimestral)
- ✓ Número de edición debe ser positivo
- ✓ Entrada del usuario validada

---

## 🎓 Aprendizajes Clave de POO

| Pilar | Concepto | Implementación |
|-------|----------|-----------------|
| **Abstracción** | Ocultar complejidad | Clase abstracta con métodos abstractos |
| **Encapsulamiento** | Control de acceso | Atributos privados + getters/setters validados |
| **Herencia** | Reutilización de código | Libro, Revista, Pelicula heredan de MaterialBibliografico |
| **Polimorfismo** | Mismo nombre, diferente comportamiento | ArrayList<MaterialBibliografico> con comportamiento dinámico |

---

## 📌 Notas Importantes

- La aplicación usa `Scanner` para la entrada de datos
- Los materiales se cargan en memoria durante la sesión
- Las multas se calculan automáticamente según el tipo de material
- Todas las validaciones lanzan excepciones con mensajes descriptivos
- El formato de moneda es colombiano ($ X.XXX)

---

## ✅ Requisitos Cumplidos

- ✓ Clase abstracta `MaterialBibliografico` con métodos abstractos
- ✓ Tres subclases que extienden la clase base
- ✓ Encapsulamiento con getters/setters validados
- ✓ Polimorfismo usando ArrayList<MaterialBibliografico>
- ✓ Menú interactivo con Scanner
- ✓ Validaciones de entrada del usuario
- ✓ 3 materiales de ejemplo al iniciar
- ✓ Cálculo automático de multas
- ✓ Formato de moneda colombiana
- ✓ Comentarios explicativos sobre cada pilar de POO

---

**Autor**: Creado para demostrar los fundamentos de POO en Java
**Año**: 2024
