/**
 * Leccion #2: FILOSOFÍA DE SPRING FRAMEWORK
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

import beans.Traductor;

public class PruebaInterprete {
	
	private static BeanFactory factory;

	public static void main(String[] args) {
		
		factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Traductor traductorEsp = (Traductor)factory.getBean("traductorEspanol");
		traductorEsp.hablar();
		System.out.println();
		Traductor traductorIngl = (Traductor)factory.getBean("traductorIngles");
		traductorIngl.hablar();
		
	}

}
