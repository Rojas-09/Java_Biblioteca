public class Revista extends MaterialBibliografico {
    // Atributos específicos de la Revista
    private String periodicidad; // "semanal", "mensual", "trimestral"
    private int numeroEdicion;

    // Constantes para el préstamo de revistas
    private static final int DIAS_MAXIMO_PRESTAMO = 7;
    private static final double MULTA_POR_DIA = 3000; // En pesos colombianos

    // Constructor
    public Revista(String id, String titulo, int anioPublicacion, String periodicidad, int numeroEdicion) {
        super(id, titulo, anioPublicacion);
        this.setPeriodicidad(periodicidad);
        this.setNumeroEdicion(numeroEdicion);
    }

    // Getters y Setters con validaciones
    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        if (periodicidad == null || periodicidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La periodicidad no puede ser nula o vacía");
        }
        String per = periodicidad.toLowerCase().trim();
        if (!per.equals("semanal") && !per.equals("mensual") && !per.equals("trimestral")) {
            throw new IllegalArgumentException("Periodicidad inválida. Debe ser: semanal, mensual o trimestral");
        }
        this.periodicidad = per;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        if (numeroEdicion <= 0) {
            throw new IllegalArgumentException("El número de edición debe ser positivo");
        }
        this.numeroEdicion = numeroEdicion;
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
        System.out.println("\n📰 ===== REVISTA =====");
        System.out.println("   ID: " + this.getId());
        System.out.println("   Título: " + this.getTitulo());
        System.out.println("   Periodicidad: " + this.getPeriodicidad());
        System.out.println("   Edición: " + this.getNumeroEdicion());
        System.out.println("   Año: " + this.getAnioPublicacion());
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
