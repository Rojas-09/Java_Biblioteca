# 🎓 GUÍA DETALLADA: PILARES DE POO IMPLEMENTADOS

## 📌 Los 4 Pilares de la Programación Orientada a Objetos

Este documento explica cómo cada pilar de POO se demuestra en el Sistema de Gestión de Biblioteca.

---

## 1️⃣ ABSTRACCIÓN

### ¿Qué es?
La abstracción es el principio de ocultar los detalles complejos de implementación y exponer solo lo esencial a través de una interfaz clara.

### Implementación en el Proyecto

```java
// Clase abstracta que define el CONTRATO
public abstract class MaterialBibliografico {
    // Métodos abstractos - definen QUÉ debe hacer cada subclase
    public abstract double calcularMulta(int diasRetraso);
    public abstract void mostrarInformacion();
    public abstract int getDiasMaximoPrestamo();
    
    // Métodos concretos comunes - CÓMO lo hace
    public void prestar() { /* ... */ }
    public void devolver() { /* ... */ }
}
```

### Beneficios:
✓ Define un contrato que todas las subclases DEBEN cumplir  
✓ Oculta la complejidad de cada tipo de material  
✓ Facilita la mantenibilidad y extensión del código  
✓ Permite que el código cliente trabaje con una interfaz común  

### En la Práctica:
```java
// El cliente no necesita saber si es Libro, Revista o Pelicula
MaterialBibliografico material = new Libro(...);
material.mostrarInformacion();  // Llama la versión específica del Libro
```

---

## 2️⃣ ENCAPSULAMIENTO

### ¿Qué es?
El encapsulamiento es el principio de agrupar datos y métodos dentro de una clase, controlando el acceso a través de getters y setters.

### Implementación en el Proyecto

```java
public class MaterialBibliografico {
    // ATRIBUTOS PRIVADOS - Encapsulados
    private String id;
    private String titulo;
    private int anioPublicacion;
    private boolean prestado;
    
    // GETTERS - Acceso controlado de lectura
    public String getId() {
        return id;
    }
    
    // SETTERS - Acceso controlado de escritura CON VALIDACIÓN
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede ser nulo o vacío");
        }
        this.id = id;
    }
}
```

### Validaciones Implementadas:

| Atributo | Validación |
|----------|-----------|
| id | No puede ser nulo o vacío |
| titulo | No puede ser nulo o vacío |
| anioPublicacion | Debe ser positivo |
| numeroPaginas | Debe ser positivo |
| duracionMinutos | Debe ser positivo |
| numeroEdicion | Debe ser positivo |

### Beneficios:
✓ Protege la integridad de los datos  
✓ Valida entrada antes de almacenarla  
✓ Permite cambiar la implementación interna sin afectar código cliente  
✓ Centraliza la lógica de validación  

### En la Práctica:
```java
Libro libro = new Libro("L001", "1984", 1949, "George Orwell", 328);

// ✓ CORRECTO: Usando setter con validación
libro.setTitulo("Nuevo Título");  // Validado ✓

// ✗ INCORRECTO: Intentar acceso directo (imposible - es privado)
// libro.titulo = "Nuevo Título";  // ERROR DE COMPILACIÓN

// ✓ Lectura mediante getter
String titulo = libro.getTitulo();
```

---

## 3️⃣ HERENCIA

### ¿Qué es?
La herencia es el principio de crear nuevas clases basadas en clases existentes, reutilizando código y estableciendo relaciones jerárquicas.

### Jerarquía de Clases en el Proyecto

```
                    MaterialBibliografico (Clase Abstracta Base)
                            ▲
                            │
                ┌───────────┼───────────┐
                │           │           │
              Libro      Revista      Pelicula
```

### Implementación:

```java
// Clase Base - Define lo común
public abstract class MaterialBibliografico {
    private String id;
    private String titulo;
    private int anioPublicacion;
    private boolean prestado;
}

// HERENCIA 1
public class Libro extends MaterialBibliografico {
    private String autor;          // Específico del Libro
    private int numeroPaginas;     // Específico del Libro
}

// HERENCIA 2
public class Revista extends MaterialBibliografico {
    private String periodicidad;   // Específico de Revista
    private int numeroEdicion;     // Específico de Revista
}

// HERENCIA 3
public class Pelicula extends MaterialBibliografico {
    private int duracionMinutos;   // Específico de Pelicula
    private String director;       // Específico de Pelicula
}
```

### Relación IS-A (Es-Un):
```
Un Libro IS-A MaterialBibliografico  ✓
Una Revista IS-A MaterialBibliografico  ✓
Una Pelicula IS-A MaterialBibliografico  ✓
```

### Beneficios:
✓ Reutiliza código de la clase base  
✓ Establece relaciones lógicas entre clases  
✓ Permite trabajar con diferentes tipos de forma uniforme  
✓ Facilita el mantenimiento y las extensiones futuras  

### En la Práctica:
```java
Libro libro = new Libro("L001", "1984", 1949, "George Orwell", 328);
Revista revista = new Revista("R001", "Time", 2024, "semanal", 1);
Pelicula pelicula = new Pelicula("P001", "Matrix", 1999, 136, "Wachowski");

// Todos heredan metodos de MaterialBibliografico
libro.prestar();
revista.devolver();
pelicula.setPrestado(false);
```

---

## 4️⃣ POLIMORFISMO

### ¿Qué es?
El polimorfismo es la capacidad de objetos de diferentes clases de responder al mismo mensaje (llamada de método) de formas diferentes.

### Tipos de Polimorfismo Implementados:

#### A) Polimorfismo de Sobrescritura (Override)

```java
// Clase Base
public abstract class MaterialBibliografico {
    public abstract double calcularMulta(int diasRetraso);
}

// LIBRO: Implementación específica
public class Libro extends MaterialBibliografico {
    @Override
    public double calcularMulta(int diasRetraso) {
        return diasRetraso * 5000;  // $5.000 por día
    }
}

// REVISTA: Implementación específica
public class Revista extends MaterialBibliografico {
    @Override
    public double calcularMulta(int diasRetraso) {
        return diasRetraso * 3000;  // $3.000 por día
    }
}

// PELICULA: Implementación específica
public class Pelicula extends MaterialBibliografico {
    @Override
    public double calcularMulta(int diasRetraso) {
        return diasRetraso * 10000;  // $10.000 por día
    }
}
```

#### B) Polimorfismo de Colecciones

```java
// POLIMORFISMO: Mismo ArrayList trabajando con diferentes tipos
ArrayList<MaterialBibliografico> biblioteca = new ArrayList<>();

// Agregar diferentes tipos
biblioteca.add(new Libro("L001", "1984", 1949, "George Orwell", 328));
biblioteca.add(new Revista("R001", "Time", 2024, "semanal", 1));
biblioteca.add(new Pelicula("P001", "Matrix", 1999, 136, "Wachowski"));

// Polimorfismo en acción: Cada objeto responde diferente
for (MaterialBibliografico material : biblioteca) {
    // Cada tipo ejecuta SU PROPIA versión del método
    material.mostrarInformacion();      // Diferente para cada tipo
    double multa = material.calcularMulta(5); // Diferente cálculo
    int diasMax = material.getDiasMaximoPrestamo(); // Diferente límite
}
```

### Beneficios del Polimorfismo:

✓ **Flexibilidad**: El código funciona con referencias de tipo base  
✓ **Extensibilidad**: Agregar nuevas subclases sin cambiar código existente  
✓ **Mantenibilidad**: Reducción de código duplicado  
✓ **Reutilización**: Mismo código para diferentes tipos  

### Ejemplo de Ejecución Polimórfica:

```java
// MISMO MÉTODO, COMPORTAMIENTO DIFERENTE

MaterialBibliografico material1 = new Libro(...);
MaterialBibliografico material2 = new Revista(...);
MaterialBibliografico material3 = new Pelicula(...);

// Todas estas llamadas se comportan diferente
double multa1 = material1.calcularMulta(5);  // Libro: 5 × 5.000 = 25.000
double multa2 = material2.calcularMulta(5);  // Revista: 5 × 3.000 = 15.000
double multa3 = material3.calcularMulta(5);  // Pelicula: 5 × 10.000 = 50.000

// El compilador no sabe qué versión ejecutar hasta RUNTIME
// Se dice que el tipo se "resuelve dinámicamente"
```

---

## 📊 Tabla Comparativa: Los 4 Pilares

| Pilar | Concepto | Implementación | Beneficio |
|-------|----------|---|---|
| **Abstracción** | Ocultar complejidad | Clase abstracta con métodos abstractos | Define contratos claros |
| **Encapsulamiento** | Control de acceso | Atributos privados + getters/setters | Protege integridad de datos |
| **Herencia** | Reutilización de código | extends MaterialBibliografico | Evita duplicación |
| **Polimorfismo** | Mismo nombre, diferente comportamiento | Sobrescritura de métodos | Máxima flexibilidad |

---

## 🔍 Diagrama de Relaciones

```
┌─────────────────────────────────────────────────────────┐
│          SISTEMA DE GESTIÓN DE BIBLIOTECA             │
└─────────────────────────────────────────────────────────┘

                  Main (Cliente)
                      ▲
                      │ usa
                      │
                ArrayList<MaterialBibliografico>
                      ▲
                      │
        ┌─────────────┼─────────────┐
        │             │             │
        ▼             ▼             ▼
      Libro       Revista       Pelicula
        ▲             ▲             ▲
        └─────────────┴─────────────┘
                 HERENCIA
                      │
                      │ implementan
                      │
        MaterialBibliografico (Abstracta)
        - calcularMulta()
        - mostrarInformacion()
        - getDiasMaximoPrestamo()
```

---

## 💡 Conclusión

Este sistema demuestra cómo los 4 pilares de POO trabajan juntos:

1. **ABSTRACCIÓN** define QUÉ debe hacerse
2. **ENCAPSULAMIENTO** controla CÓMO se acceden los datos
3. **HERENCIA** permite REUTILIZACIÓN de código
4. **POLIMORFISMO** permite COMPORTAMIENTO FLEXIBLE

El resultado es un código:
- ✓ Mantenible
- ✓ Extensible
- ✓ Reutilizable
- ✓ Comprensible
- ✓ Seguro

---

**¡Este es el poder de la Programación Orientada a Objetos!**
