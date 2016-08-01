package concursantes;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
//Con '@Aspect' definimos la clase como aspecto
@Component
@Aspect				
public class Audiencia {
	
	//Definicion del pointcut que se ejecuta cuando se intercepta el 
	//metodo objetivo en este caso el definido con aspectJ (lo 
	//que esta definido en el '@Pointcut').
	//En el pointcut se define el metodo objetivp. Ademas creamos el metodo 'ejecutarShow'
	//que no es mas que una "marca" para poder referirnos al pointcut.
	@Pointcut("execution(* concursantes.Concursante.ejecutar(..))")
	public void ejecutarShow() {}
	
	/**
	 * Este metodo recibe una referencia de la clase que contiene el metodo objetivo
	 * @param joinpoint
	 */
	// En 'around' indicamos el pointcut que se ejecutara cuando
	// interceptamos el metodo objetivo
	@Around("ejecutarShow()")
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
