import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        Tree inventario = new Tree(null, 0);
        List historial = new List();
        Integer opcion = 1;

        do {
            menu();
            try {
                opcion = Integer.parseInt(consola.nextLine());
                switch (opcion) {
                    case 1:
                        inventario = agregarProducto(inventario, historial);
                        break;
                    case 2:
                        inventario = eliminarProducto(inventario);
                        break;
                    case 3:
                        buscarProducto(inventario);
                        break;
                    case 4:
                        if (inventario.getRoot().getData() == null) {
                            System.out.println("No hay productos en el inventario.");
                        } else {
                            inventario.print();
                        }
                        break;

                    case 5:
                        imprimirHistorial(historial);
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Opcion invalida. Ingrese un numero entero.");
            }

        } while (opcion != 0);

        consola.close();
    }

    private static void buscarProducto(Tree inventario) {
        Scanner consola = new Scanner(System.in);
        Node nodo;
        String saux;
        System.out.println("Ingrese el nombre del producto que desea buscar.");
        saux = consola.nextLine().toLowerCase();
        nodo = inventario.search(saux);
        if (nodo == null) {
            System.out.println("No se encontro el producto.");
        } else {
            System.out.println("Producto\t\tStock");
            System.out.println(nodo.getData() + "\t\t" + nodo.getStock());
        }

    }

    private static Tree eliminarProducto(Tree inventario) {
        Scanner consola = new Scanner(System.in);
        String saux;
        System.out.println("Ingrese el nombre del producto que desea eliminar.");
        saux = consola.nextLine().toLowerCase();
        inventario.delete(saux);
        return inventario;
    }

    private static Tree agregarProducto(Tree inventario, List historial) {
        Scanner consola = new Scanner(System.in);
        String saux;
        int iuax;
        System.out.println("Ingrese el nombre del producto.");
        saux = consola.nextLine().toLowerCase();
        System.out.println("Ingrese la cantidad de " + saux + " en stock.");
        try {
            iuax = Integer.parseInt(consola.nextLine());
            if (inventario.getRoot().getData() == null) {
                inventario.getRoot().setData(saux);
                inventario.getRoot().setStock(iuax);
            } else {
                inventario.insert(saux, iuax);
            }
            historial.insert(saux, iuax);
            System.out.println("Producto agregado con exito.");
        } catch (Exception e) {
            System.out.println("Producto no agregado. Verifique que el stock ingresado sea un entero.");
        }
        return inventario;
    }

    private static void imprimirHistorial(List historial) {
        if (historial.head == null) {
            System.out.println("El historial esta vacio.");
        } else {
            ListNode pointer = historial.head;
            System.out.println("Producto\tStock");
            while (pointer.next != null) {
                System.out.println(pointer.getData() + "\t\t" + pointer.getStock());
                pointer = pointer.next;
            }
            System.out.println(pointer.getData() + "\t\t" + pointer.getStock());

        }
    }

    public static void menu() {
        System.out.println("\nElija una opcion.");
        System.out.println("1)Agregar un producto al inventario.");
        System.out.println("2)Eliminar un producto del inventario.");
        System.out.println("3)Buscar un producto en el inventario.");
        System.out.println("4)Imprimir inventario.");
        System.out.println("5)Imprimir historial de agregados recientemente.");
        System.out.println("0)Salir.\n");
    }
}
