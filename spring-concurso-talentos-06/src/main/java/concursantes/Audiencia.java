package concursantes;

import org.aspectj.lang.ProceedingJoinPoint;
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
	
	/**
	 * Este metodo recibe una referencia de la clase que contiene el metodo objetivo
	 * @param joinpoint
	 */
	public void monitorearShow(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("El show esta por comenzar, favor de tomar asiento...");
			System.out.println("Favor de apagar los celulares...");
			
			//Anotamos la hora de inicio
			long horaInicio = System.currentTimeMillis();
			
			//Se llama al metodo de negocio (metodo objetivo)
			joinpoint.proceed();
			
			// 1 segundo
			// Este delay en milisegundos es opcional y se puede opner en los metodos
			//de negocio para simular la duracion del metodo
			Thread.sleep(1000);
			
			long horaFin = System.currentTimeMillis();
			System.out.println("El show ha terminado. aplausos");
			System.out.println("El show tuvo una duracion: " + (horaFin - horaInicio));
			
		} catch (Throwable t) {
			System.out.println("El show fue terrible, se devolverán las entradas");
		}
	}
	
	
//	public void sentarse() {
//		System.out.println("El show esta por comenzar, favor de tomar asiento...");
//	}
//	
//	public void apagarCelulares() {
//		System.out.println("Favor de apagar los celulares...");
//	}
//	public void aplaudir() {
//		System.out.println("El show ha terminado. aplausos");
//	}
//	public void devolucion() {
//		System.out.println("El show fue terrible, se devolverán las entradas");
//	}
}
