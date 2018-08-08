package mx.com.bellicose.peliculas.main;

import java.util.Scanner;

import mx.com.bellicose.peliculas.negocio.CatalogoPeliculasImp;

public class CatalogoPeliculas {
	
	private static final Scanner sc = new Scanner(System.in);
	private static int opcion = -1;
	private static final String nombreArchivo = "/Users/bellicose/Documents/java-practice/archivos/proyectoarchivos/peliculas.txt";
	private static final CatalogoPeliculasImp catalogoPeliculas = new CatalogoPeliculasImp();

	public static void main(String[] args) {

		while(opcion != 0) {
            System.out.println("Menu\n"
            		+ "1.- Iniciar catalogo peliculas\n"
                    + "2.- Agregar pelicula\n"
                    + "3.- Listar Peliculas\n"
                    + "4.- Buscar Pelicula\n"
                    + "0.- Salir\n\n"
                    + "Elige una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());
            
            switch(opcion){
            	case 1: catalogoPeliculas.iniciarArchivo(nombreArchivo);
            			break;
            	case 2:
            			System.out.println("Ingresa nombre de pelicula");
            			String nombre = sc.nextLine();
            			catalogoPeliculas.agregarPelicula(nombre, nombreArchivo);
            			break;
            	case 3: catalogoPeliculas.listarPeliculas(nombreArchivo);
            			break;
            			
            	case 4: System.out.println("Que pelicula buscas? ");
            			String buscar = sc.nextLine();
            			catalogoPeliculas.buscarPelicula(nombreArchivo, buscar);
            			break;
            	case 0:
            			System.out.println("Hasta pronto...");
            			break;
            	default:
            			System.out.println("Opcion incorrecta");
            			break;
            		
            }
		}
	}

}
