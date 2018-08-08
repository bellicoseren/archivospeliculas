package mx.com.bellicose.peliculas.negocio;

public interface ICatalogoPeliculas {

	void agregarPelicula(String nombrePelicula, String nombreArchivo);
	void listarPeliculas(String nombreArchivo);
	void buscarPelicula(String nombreArchivo, String buscar);
	void iniciarArchivo(String nombreArchivo);
}
