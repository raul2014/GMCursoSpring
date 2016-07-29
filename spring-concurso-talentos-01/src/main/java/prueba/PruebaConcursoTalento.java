/**
 * Leccion #3: INYECCION DE DEPENDENCIAS
 * Titulo: Ejercicio 3 del curso SPRING de GLOBAL MENTORING
 * Version: 2.0
 * Descricpion: 
 * 				- Programa que utiliza Spring.
 *				- Aqui las dependencias son inyectadas con spring
 *				- Se utiliza interfaces.  				
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
