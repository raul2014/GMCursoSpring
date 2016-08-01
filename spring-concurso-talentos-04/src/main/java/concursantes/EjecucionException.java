package concursantes;

/**
 * Clase utilizada para simular una excepcion en ejecución
 * 
 * @author Dell rjc
 *
 */
@SuppressWarnings("serial")
public class EjecucionException extends RuntimeException {
	public EjecucionException() {
	}
	
	public EjecucionException(String msg) {
		super(msg);
	}
}
