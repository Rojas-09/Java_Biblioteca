public class Pelicula extends MaterialBibliografico {
    // Atributos específicos de la Pelicula
    private int duracionMinutos;
    private String director;

    // Constantes para el préstamo de películas
    private static final int DIAS_MAXIMO_PRESTAMO = 3;
    private static final double MULTA_POR_DIA = 10000; // En pesos colombianos

    // Constructor
    public Pelicula(String id, String titulo, int anioPublicacion, int duracionMinutos, String director) {
        super(id, titulo, anioPublicacion);
        this.setDuracionMinutos(duracionMinutos);
        this.setDirector(director);
    }

    // Getters y Setters con validaciones
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException("La duración debe ser un valor positivo");
        }
        this.duracionMinutos = duracionMinutos;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        if (director == null || director.trim().isEmpty()) {
            throw new IllegalArgumentException("El director no puede ser nulo o vacío");
        }
        this.director = director;
    }

    // Implementación específica del método abstracto calcularMulta
    @Override
    public double calcularMulta(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0;
        }
        return diasRetraso * MULTA_POR_DIA;
    }

    // Implementación específica del método abstracto mostrarInformacion
    @Override
    public void mostrarInformacion() {
        System.out.println("\n🎬 ===== PELÍCULA =====");
        System.out.println("   ID: " + this.getId());
        System.out.println("   Título: " + this.getTitulo());
        System.out.println("   Director: " + this.getDirector());
        System.out.println("   Año: " + this.getAnioPublicacion());
        System.out.println("   Duración: " + this.getDuracionMinutos() + " minutos");
        System.out.println("   Estado: " + (this.isPrestado() ? "PRESTADO" : "DISPONIBLE"));
        System.out.println("   Días máx. de préstamo: " + DIAS_MAXIMO_PRESTAMO);
        System.out.println("   Multa por día de retraso: $" + String.format("%,d", (long) MULTA_POR_DIA).replace(",", "."));
        System.out.println("===================\n");
    }

    // Implementación específica del método abstracto getDiasMaximoPrestamo
    @Override
    public int getDiasMaximoPrestamo() {
        return DIAS_MAXIMO_PRESTAMO;
    }
}
