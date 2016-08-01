package concursantes;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Mago implements Adivinador {
	private String pensamientos;
	
	// Interceptamos el metodo 'pensar' y recupera el parametro 'pensamientos' de un 
	// tipo 'Pensador' es decir lo que piensa el voluntario que piensa. 
	// Aqui el metodo 'pensar' tiene un parametro.
	// Cuando el pensador piense en algo dicho pensamiento sera interceptado por el Mago que lo tratara
	// con el metodo 'interceptarPensamientos'
	@Pointcut("execution(* concursantes.Pensador.pensarEnAlgo(String)) && args(pensamientos)")
	public void pensar(String pensamientos){}
	
	
	//Se intercepta el metodo antes de que se ejecute el metodo 'pensarEnAlgo' de un tipo 'Pensador'.
	//Se logra usando '@Before'
	@Before("pensar(pensamientos)")
	@Override
	public void interceptarPensamientos(String pensamientos) {
		System.out.println("Magia...");
		System.out.println("Estos son los pensamientos del voluntario: " + pensamientos);
		this.pensamientos = pensamientos;
	}
	
	public String getPensamientos() {
		return pensamientos;
	};
}
