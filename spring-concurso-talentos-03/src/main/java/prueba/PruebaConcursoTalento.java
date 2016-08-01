/**
 * Leccion #3: INYECCION DE DEPENDENCIAS
 * Titulo: Ejercicio 5 del curso SPRING de GLOBAL MENTORING
 * Version: 3.0
 * Descricpion: - Se agrega nueva concursante con diferente habilidad (Musico) 
 * 				- Programa que utiliza Spring.
 *				- Aqui las dependencias son inyectadas con spring
 *				- Se utiliza interfaces.
 *				- Se enseña a inyectar beans atraves de SETTERS.				
 */
package prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import concursantes.Concursante;

public class PruebaConcursoTalento {

	private static BeanFactory factory;
	
	public static void main(String[] args) {
		factory = new ClassPathXmlApplicationContext("applicationContext.xml");

		Concursante concursante1 = (Concursante)factory.getBean("solei");
		concursante1.ejecutar();
	}

}
