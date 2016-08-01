/**
 * Leccion #3: INYECCION DE DEPENDENCIAS
 * Titulo: Ejercicio 7 del curso SPRING de GLOBAL MENTORING
 * Version: 4.0
 * Descricpion:
 * 				- Programa que utiliza Spring.
 *				- Aqui las dependencias son inyectadas con spring
 *				- Se utiliza interfaces.
 *				- Se configura Spring utilizando ANOTATIONS (anotaciones)
 *				
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
