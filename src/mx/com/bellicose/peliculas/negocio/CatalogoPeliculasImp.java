package mx.com.bellicose.peliculas.negocio;

import java.util.List;

import mx.com.bellicose.peliculas.datos.AccesoDatosImp;
import mx.com.bellicose.peliculas.datos.IAccesoDatos;
import mx.com.bellicose.peliculas.domain.Pelicula;

public class CatalogoPeliculasImp implements ICatalogoPeliculas {
	
	private final IAccesoDatos accesoDatos;
	
	public CatalogoPeliculasImp() {

		this.accesoDatos = new AccesoDatosImp();
	}

	@Override
	public void agregarPelicula(String nombrePelicula, String nombreArchivo) {

		Pelicula pelicula = new Pelicula(nombrePelicula);
		
		boolean anexar = accesoDatos.existe(nombreArchivo);
		
		accesoDatos.escribir(pelicula, nombreArchivo, anexar);
	}

	@Override
	public void listarPeliculas(String nombreArchivo) {

		List<Pelicula> peliculas = accesoDatos.listar(nombreArchivo);
		
		for (Pelicula pelicula : peliculas) {
			System.out.println("Pelicula: " + pelicula);
		}
	}

	@Override
	public void buscarPelicula(String nombreArchivo, String buscar) {

		String resultado = null;
		
		resultado = accesoDatos.buscar(buscar, nombreArchivo);
		System.out.println("Resultado de la busqueda: " + resultado);
	}

	@Override
	public void iniciarArchivo(String nombreArchivo) {

		if(accesoDatos.existe(nombreArchivo)) {
			accesoDatos.borrar(nombreArchivo);
			accesoDatos.crear(nombreArchivo);
		}else {
			accesoDatos.crear(nombreArchivo);
		}
	}

}
