/**
 * PILAR POO: HERENCIA
 * 
 * Clase Libro que extiende MaterialBibliografico.
 * - HERENCIA: Extiende la clase abstracta MaterialBibliografico
 * - POLIMORFISMO: Implementa de forma específica los métodos abstractos
 */
public class Libro extends MaterialBibliografico {
    // Atributos específicos del Libro
    private String autor;
    private int numeroPaginas;

    // Constantes para el préstamo de libros
    private static final int DIAS_MAXIMO_PRESTAMO = 14;
    private static final double MULTA_POR_DIA = 5000; // En pesos colombianos

    // Constructor
    public Libro(String id, String titulo, int anioPublicacion, String autor, int numeroPaginas) {
        super(id, titulo, anioPublicacion);
        this.setAutor(autor);
        this.setNumeroPaginas(numeroPaginas);
    }

    // PILAR POO: ENCAPSULAMIENTO
    // Getters y Setters con validaciones
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede ser nulo o vacío");
        }
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("El número de páginas debe ser positivo");
        }
        this.numeroPaginas = numeroPaginas;
    }

    // PILAR POO: POLIMORFISMO
    // Implementación específica del método abstracto calcularMulta
    @Override
    public double calcularMulta(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0;
        }
        return diasRetraso * MULTA_POR_DIA;
    }

    // PILAR POO: POLIMORFISMO
    // Implementación específica del método abstracto mostrarInformacion
    @Override
    public void mostrarInformacion() {
        System.out.println("\n📚 ===== LIBRO =====");
        System.out.println("   ID: " + this.getId());
        System.out.println("   Título: " + this.getTitulo());
        System.out.println("   Autor: " + this.getAutor());
        System.out.println("   Año: " + this.getAnioPublicacion());
        System.out.println("   Páginas: " + this.getNumeroPaginas());
        System.out.println("   Páginas del libro");
        System.out.println("   Estado: " + (this.isPrestado() ? "PRESTADO" : "DISPONIBLE"));
        System.out.println("   Días máx. de préstamo: " + DIAS_MAXIMO_PRESTAMO);
        System.out.println("   Multa por día de retraso: $" + String.format("%,d", (long) MULTA_POR_DIA).replace(",", "."));
        System.out.println("===================\n");
    }

    // PILAR POO: POLIMORFISMO
    // Implementación específica del método abstracto getDiasMaximoPrestamo
    @Override
    public int getDiasMaximoPrestamo() {
        return DIAS_MAXIMO_PRESTAMO;
    }
}
