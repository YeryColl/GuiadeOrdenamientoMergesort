import java.util.Scanner;

public class App {

    // Función principal para ordenar la lista de artículos utilizando MergeSort
    public static void mergeSort(String[] nombres, int[] cantidades, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSort(nombres, cantidades, inicio, medio);
            mergeSort(nombres, cantidades, medio + 1, fin);
            merge(nombres, cantidades, inicio, medio, fin);
        }
    }

    // Función auxiliar para combinar dos subarreglos ordenados
    public static void merge(String[] nombres, int[] cantidades, int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        // Crear arreglos temporales
        String[] nombresIzquierda = new String[n1];
        String[] nombresDerecha = new String[n2];
        int[] cantidadesIzquierda = new int[n1];
        int[] cantidadesDerecha = new int[n2];

        // Copiar datos a los arreglos temporales
        System.arraycopy(nombres, inicio, nombresIzquierda, 0, n1);
        System.arraycopy(nombres, medio + 1, nombresDerecha, 0, n2);
        System.arraycopy(cantidades, inicio, cantidadesIzquierda, 0, n1);
        System.arraycopy(cantidades, medio + 1, cantidadesDerecha, 0, n2);

        // Combinar los arreglos temporales
        int i = 0, j = 0;
        int k = inicio;
        while (i < n1 && j < n2) {
            if (cantidadesIzquierda[i] <= cantidadesDerecha[j]) {
                cantidades[k] = cantidadesIzquierda[i];
                nombres[k] = nombresIzquierda[i];
                i++;
            } else {
                cantidades[k] = cantidadesDerecha[j];
                nombres[k] = nombresDerecha[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de nombresIzquierda[] y cantidadesIzquierda[] si hay alguno
        while (i < n1) {
            nombres[k] = nombresIzquierda[i];
            cantidades[k] = cantidadesIzquierda[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de nombresDerecha[] y cantidadesDerecha[] si hay alguno
        while (j < n2) {
            nombres[k] = nombresDerecha[j];
            cantidades[k] = cantidadesDerecha[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el número de artículos
        System.out.print("Ingrese el número de artículos: ");
        int numArticulos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Crear arreglos para los nombres y cantidades de los artículos
        String[] nombres = new String[numArticulos];
        int[] cantidades = new int[numArticulos];

        // Pedir al usuario los nombres y cantidades de los artículos
        for (int i = 0; i < numArticulos; i++) {
            System.out.print("Ingrese el nombre del artículo " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
            System.out.print("Ingrese la cantidad del artículo " + (i + 1) + ": ");
            cantidades[i] = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
        }

        // Aplicar MergeSort para ordenar los artículos por cantidad
        mergeSort(nombres, cantidades, 0, numArticulos - 1);

        // Mostrar los artículos ordenados
        System.out.println("\nArtículos ordenados por cantidad (de menor a mayor):");
        for (int i = 0; i < numArticulos; i++) {
            System.out.println(nombres[i] + ": " + cantidades[i]);
        }
        scanner.close();
    }
}
