package concursantes;

import org.springframework.stereotype.Component;


/**
 * Clase aspecto
 */

/**
 * '@Component' indica que esta clase en automatico sera un bean de la fabrica de spring
 * por que en el archivo applicationContext se configuro auto scan asi:
 * '<context:component-scan base-package="concursantes"/>'
 * Aplica para las clases que estan en el paquete 'concursantes' por eso esta aplica.
 * 
 */ 
@Component
public class Audiencia {
	public void sentarse() {
		System.out.println("El show esta por comenzar, favor de tomar asiento...");
	}
	
	public void apagarCelulares() {
		System.out.println("Favor de apagar los celulares...");
	}
	public void aplaudir() {
		System.out.println("El show ha terminado. Clap clap clap");
	}
	public void devolucion() {
		System.out.println("El show fue terrible, se devolverán las entradas");
	}
}
