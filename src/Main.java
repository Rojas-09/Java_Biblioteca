import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    // ArrayList que puede contener referencias a cualquier subclase de MaterialBibliografico
    private static ArrayList<MaterialBibliografico> biblioteca = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║   BIBLIOTECA - MENU PRINCIPAL                      ║");
        System.out.println("║   Demostrando los 4 Pilares de POO                 ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        // Agregar materiales de ejemplo al iniciar
        agregarMaterialesEjemplo();

        int opcion = 0;
        do {
            mostrarMenu();
            System.out.print("Ingrese su opción: ");
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        agregarNuevoMaterial();
                        break;
                    case 2:
                        listarTodosMateriales();
                        break;
                    case 3:
                        simularPrestamoYMulta();
                        break;
                    case 4:
                        System.out.println("\n¡Gracias por usar el Sistema de Gestión de Biblioteca!");
                        System.out.println("Hasta luego...\n");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.\n");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido.\n");
                scanner.nextLine(); // Limpiar el buffer
                opcion = 0;
            }
        } while (opcion != 4);

        scanner.close();
    }

    /**
     * Muestra el menú principal
     */
    private static void mostrarMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("=".repeat(50));
        System.out.println("1. Agregar nuevo material (Libro, Revista o Película)");
        System.out.println("2. Listar todos los materiales");
        System.out.println("3. Simular préstamo y calcular multa");
        System.out.println("4. Salir");
        System.out.println("=".repeat(50));
    }

    /**
     * Agrega materiales de ejemplo a la biblioteca
     */
    private static void agregarMaterialesEjemplo() {
        System.out.println("Inicializando biblioteca con materiales de ejemplo...\n");

        // Agregar un Libro
        Libro libro1 = new Libro("L001", "Cien Años de Soledad", 1967, "Gabriel García Márquez", 417);
        biblioteca.add(libro1);
        System.out.println("✓ Libro agregado: Cien Años de Soledad");

        // Agregar una Revista
        Revista revista1 = new Revista("R001", "National Geographic", 2024, "mensual", 258);
        biblioteca.add(revista1);
        System.out.println("✓ Revista agregada: National Geographic");

        // Agregar una Película
        Pelicula pelicula1 = new Pelicula("P001", "El Señor de los Anillos: La Comunidad del Anillo", 2001, 178, "Peter Jackson");
        biblioteca.add(pelicula1);
        System.out.println("✓ Película agregada: El Señor de los Anillos\n");
    }

    /**
     * Menú para agregar un nuevo material a la biblioteca
     */
    private static void agregarNuevoMaterial() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("AGREGAR NUEVO MATERIAL");
        System.out.println("=".repeat(50));
        System.out.println("1. Agregar Libro");
        System.out.println("2. Agregar Revista");
        System.out.println("3. Agregar Película");
        System.out.println("4. Volver al menú principal");
        System.out.println("=".repeat(50));
        System.out.print("Seleccione el tipo de material: ");

        try {
            int tipo = scanner.nextInt();
            scanner.nextLine();

            switch (tipo) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    agregarRevista();
                    break;
                case 3:
                    agregarPelicula();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...\n");
                    break;
                default:
                    System.out.println("❌ Opción inválida.\n");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: Ingrese un número válido.\n");
            scanner.nextLine();
        }
    }

    /**
     * Agrega un nuevo Libro a la biblioteca
     */
    private static void agregarLibro() {
        try {
            System.out.println("\n📚 Ingrese los datos del Libro:");
            System.out.print("ID (ej: L002): ");
            String id = validarEntradaNoVacia(scanner.nextLine());

            System.out.print("Título: ");
            String titulo = validarEntradaNoVacia(scanner.nextLine());

            System.out.print("Año de Publicación: ");
            int anio = validarEntradaPositiva(scanner.nextInt());
            scanner.nextLine();

            System.out.print("Autor: ");
            String autor = validarEntradaNoVacia(scanner.nextLine());

            System.out.print("Número de Páginas: ");
            int paginas = validarEntradaPositiva(scanner.nextInt());
            scanner.nextLine();

            // Se crea un Libro pero se almacena como MaterialBibliografico
            Libro libro = new Libro(id, titulo, anio, autor, paginas);
            biblioteca.add(libro);
            System.out.println("✓ Libro agregado exitosamente.\n");

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage() + "\n");
        }
    }

    /**
     * Agrega una nueva Revista a la biblioteca
     */
    private static void agregarRevista() {
        try {
            System.out.println("\nIngrese los datos de la Revista:");
            System.out.print("ID (ej: R002): ");
            String id = validarEntradaNoVacia(scanner.nextLine());

            System.out.print("Título: ");
            String titulo = validarEntradaNoVacia(scanner.nextLine());

            System.out.print("Año de Publicación: ");
            int anio = validarEntradaPositiva(scanner.nextInt());
            scanner.nextLine();

            System.out.print("Periodicidad (semanal/mensual/trimestral): ");
            String periodicidad = validarEntradaNoVacia(scanner.nextLine());

            System.out.print("Número de Edición: ");
            int edicion = validarEntradaPositiva(scanner.nextInt());
            scanner.nextLine();

            // Se crea una Revista pero se almacena como MaterialBibliografico
            Revista revista = new Revista(id, titulo, anio, periodicidad, edicion);
            biblioteca.add(revista);
            System.out.println("Revista agregada exitosamente.\n");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    /**
     * Agrega una nueva Película a la biblioteca
     */
    private static void agregarPelicula() {
        try {
            System.out.println("\nIngrese los datos de la Película:");
            System.out.print("ID (ej: P002): ");
            String id = validarEntradaNoVacia(scanner.nextLine());

            System.out.print("Título: ");
            String titulo = validarEntradaNoVacia(scanner.nextLine());

            System.out.print("Año de Publicación: ");
            int anio = validarEntradaPositiva(scanner.nextInt());
            scanner.nextLine();

            System.out.print("Duración (minutos): ");
            int duracion = validarEntradaPositiva(scanner.nextInt());
            scanner.nextLine();

            System.out.print("Director: ");
            String director = validarEntradaNoVacia(scanner.nextLine());

            // Se crea una Película pero se almacena como MaterialBibliografico
            Pelicula pelicula = new Pelicula(id, titulo, anio, duracion, director);
            biblioteca.add(pelicula);
            System.out.println("Película agregada exitosamente.\n");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    /**
     * todos se tratan como MaterialBibliografico en el ArrayList.
     */
    private static void listarTodosMateriales() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("MATERIALES EN LA BIBLIOTECA");
        System.out.println("=".repeat(50));

        if (biblioteca.isEmpty()) {
            System.out.println("La biblioteca está vacía.\n");
            return;
        }

        System.out.println("Total de materiales: " + biblioteca.size() + "\n");

        for (MaterialBibliografico material : biblioteca) {
            material.mostrarInformacion();
        }
    }

    /**
     * todos tienen el método calcularMulta() pero con comportamientos diferentes.
     */
    private static void simularPrestamoYMulta() {
        if (biblioteca.isEmpty()) {
            System.out.println("\n❌ La biblioteca está vacía.\n");
            return;
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("SIMULAR PRÉSTAMO Y CALCULAR MULTA");
        System.out.println("=".repeat(50));

        // Mostrar lista de materiales
        System.out.println("\nMateriales disponibles:");
        for (int i = 0; i < biblioteca.size(); i++) {
            System.out.println((i + 1) + ". " + biblioteca.get(i).getTitulo() + "(" + biblioteca.get(i).getId() + ")");
        }

        System.out.print("\nSeleccione el número del material: ");
        try {
            int indice = scanner.nextInt() - 1;
            scanner.nextLine();

            if (indice < 0 || indice >= biblioteca.size()) {
                System.out.println("Selección inválida.\n");
                return;
            }

            // Se obtiene una referencia a MaterialBibliografico pero puede ser cualquier subtipo
            MaterialBibliografico material = biblioteca.get(indice);

            // Prestar el material
            System.out.print("\n¿Prestar este material? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("s")) {
                material.prestar();
            } else {
                System.out.println("Operación cancelada.\n");
                return;
            }

            // Ingresar días de retraso
            System.out.print("Ingrese los días de retraso: ");
            int diasRetraso = validarEntradaPositiva(scanner.nextInt());
            scanner.nextLine();

            // Se llama a calcularMulta() pero cada tipo tiene su propia implementación
            double multa = material.calcularMulta(diasRetraso);

            // Devolver el material
            material.devolver();

            // Mostrar resultado
            System.out.println("\n" + "=".repeat(50));
            System.out.println("RESULTADO DEL PRÉSTAMO");
            System.out.println("=".repeat(50));
            System.out.println("Material: " + material.getTitulo());
            System.out.println("Días máximo de préstamo: " + material.getDiasMaximoPrestamo() + " días");
            System.out.println("Días de retraso: " + diasRetraso + " días");
            System.out.println("Multa calculada: $" + formatearMoneda(multa));
            System.out.println("=".repeat(50) + "\n");

        } catch (Exception e) {
            System.out.println("Error: Ingrese un valor válido.\n");
            scanner.nextLine();
        }
    }

    /**
     * Valida que una entrada no sea nula o vacía
     */
    private static String validarEntradaNoVacia(String entrada) {
        if (entrada == null || entrada.trim().isEmpty()) {
            throw new IllegalArgumentException("La entrada no puede estar vacía");
        }
        return entrada;
    }

    /**
     * Valida que una entrada sea un número positivo
     */
    private static int validarEntradaPositiva(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("El valor debe ser positivo");
        }
        return valor;
    }

    /**
     * Formatea un número como moneda*/
    private static String formatearMoneda(double valor) {
        return String.format("%,d", (long) valor).replace(",", ".");
    }
}
