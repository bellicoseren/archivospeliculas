package mx.com.bellicose.peliculas.exceptions;

public class AccesoDatosEx extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mensaje;
	
	public AccesoDatosEx(String mensaje) {
		this.mensaje=mensaje;
	}
}
