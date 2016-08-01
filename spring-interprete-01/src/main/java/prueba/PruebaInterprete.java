/**
 * Leccion #2: FILOSOF�A DE SPRING FRAMEWORK
 * Titulo: Ejercicio 3 del curso SPRING de GLOBAL MENTORING
 * Version: 1.0
 * Descricpion: 
 * 				- Programa sin utilizacion de Spring.
 *				- Aqui las dependencias son inyectadas manualmente.
 *				- No se utiliza interfaces.  				
 */
package prueba;

import beans.InterpreteEspanol;
import beans.Traductor;

public class PruebaInterprete {

	public static void main(String[] args) {
		Traductor traductor = new Traductor();
		InterpreteEspanol interprete = new InterpreteEspanol();
		
		//El interprete se inyecta manualmente
		//Y solamente puede recibir un interprete en Espa�ol
		//No un interprete en Ingles u otros idiomas
		
		traductor.setInterprete(interprete);
		traductor.setNombre("Maria Nancy");
		traductor.hablar();

	}

}
