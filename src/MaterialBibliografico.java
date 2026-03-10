/**
 * PILAR POO: ABSTRACCIÓN Y ENCAPSULAMIENTO
 * 
 * Clase abstracta que define el contrato para todos los materiales bibliográficos.
 * - ABSTRACCIÓN: Define métodos abstractos que deben implementar las subclases
 * - ENCAPSULAMIENTO: Atributos privados con getters/setters validados
 */
public abstract class MaterialBibliografico {
    // PILAR POO: ENCAPSULAMIENTO
    // Atributos privados - solo accesibles dentro de esta clase
    private String id;
    private String titulo;
    private int anioPublicacion;
    private boolean prestado;

    // Constructor con parámetros
    public MaterialBibliografico(String id, String titulo, int anioPublicacion) {
        this.setId(id);
        this.setTitulo(titulo);
        this.setAnioPublicacion(anioPublicacion);
        this.prestado = false;
    }

    // PILAR POO: ENCAPSULAMIENTO
    // Getters y Setters con validaciones
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede ser nulo o vacío");
        }
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser nulo o vacío");
        }
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        if (anioPublicacion <= 0) {
            throw new IllegalArgumentException("El año de publicación debe ser positivo");
        }
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    // PILAR POO: ABSTRACCIÓN
    // Métodos abstractos que definen el contrato para las subclases
    // Cada subclase DEBE implementar estos métodos
    
    /**
     * Calcula la multa por días de retraso.
     * La multa varía según el tipo de material.
     * @param diasRetraso Número de días de retraso
     * @return Monto de la multa en pesos colombianos
     */
    public abstract double calcularMulta(int diasRetraso);

    /**
     * Muestra la información del material de forma detallada.
     * Cada tipo de material mostrará información específica.
     */
    public abstract void mostrarInformacion();

    /**
     * Retorna el número máximo de días que se puede prestar este material.
     * Varía según el tipo de material.
     * @return Número de días máximo de préstamo
     */
    public abstract int getDiasMaximoPrestamo();

    // Métodos concretos (misma implementación para todas las subclases)
    /**
     * Marca el material como prestado
     */
    public void prestar() {
        if (this.prestado) {
            System.out.println("El material ya está prestado");
        } else {
            this.prestado = true;
            System.out.println("Material prestado exitosamente");
        }
    }

    /**
     * Marca el material como devuelto
     */
    public void devolver() {
        if (!this.prestado) {
            System.out.println("El material no estaba prestado");
        } else {
            this.prestado = false;
            System.out.println("Material devuelto exitosamente");
        }
    }
}
