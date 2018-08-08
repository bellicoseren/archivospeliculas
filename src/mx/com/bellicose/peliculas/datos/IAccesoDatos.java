package mx.com.bellicose.peliculas.datos;

import java.util.List;

import mx.com.bellicose.peliculas.domain.Pelicula;

public interface IAccesoDatos {
	
	boolean existe(String nombreArchivo);
	List<Pelicula> listar(String nombreArchivo);
	void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar);
	String buscar(String nombreArchivo, String buscar);
	void crear(String nombreArchivo);
	void borrar(String nombreArchivo);
}
