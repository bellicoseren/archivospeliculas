package mx.com.bellicose.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import mx.com.bellicose.peliculas.domain.Pelicula;

public class AccesoDatosImp implements IAccesoDatos {

	@Override
	public boolean existe(String nombreArchivo) {

		File archivo = new File(nombreArchivo);
		
		return archivo.exists();
	}

	@Override
	public List<Pelicula> listar(String nombreArchivo) {

		File archivo = new File(nombreArchivo);
		List<Pelicula> peliculas = new ArrayList<>();
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(archivo));
			String linea = input.readLine();
			
			Pelicula pelicula = null;
			while(linea != null) {
				pelicula = new Pelicula(linea);
				peliculas.add(pelicula);
				linea = input.readLine();
			}
			input.close();
		} catch (IOException e) {
			System.out.println("Estoy en el catch");
			e.printStackTrace();
		}
		return peliculas;
	}

	@Override
	public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {

		File archivo = new File(nombreArchivo);
		
		try {
			PrintWriter out = new PrintWriter(new FileWriter(archivo, anexar));
			out.println(pelicula.toString());
			out.close();
			System.out.println("Se guardó en archivo correctamente");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String buscar(String buscar, String nombreArchivo) {

		File archivo = new File(nombreArchivo);
		String resultado = null;
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(archivo));
			String linea = null;
			int i = 0;
			
			linea = input.readLine();
			while(linea != null) {
				if(buscar != null && buscar.equalsIgnoreCase(linea)) {
					resultado = "Pelicula " + linea + " encontrada en la fila: " + i;
					break;
				}
				linea = input.readLine();
				i++;
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public void crear(String nombreArchivo) {

		File archivo = new File(nombreArchivo);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo));
			salida.close();
			System.out.println("Se creó archivo correctamente");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void borrar(String nombreArchivo) {

		File archivo = new File(nombreArchivo);
		archivo.delete();
		System.out.println("Archivo borrado exitosamente");
	}

}
