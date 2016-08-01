/**
 * Leccion #4: AOP (PROGRAMACION ORIENTADA A ASPECTOS)
 * Titulo: Ejercicio 8 del curso SPRING de GLOBAL MENTORING
 * Version: 6.0
 * Descricpion:
 * 				- Agregar funcionalidad AOP con el uso de 'around advice'
 * 
 * NOTA (01/08/16):      
 *		En la configuracion de Spring se agrego:
 *		'<aop:aspectj-autoproxy proxy-target-class="true"/>'
 *
 *		Para permitir que las clases que no implementan interfaces sean "proxieded".
 *	     Solucion el problema del error:
 *	     'java.lang.ClassCastException: com.sun.proxy.$Proxy19 cannot be cast to concursantes.Malabarista'
 *	     
 *		 que ocurria al ejecutar el metodo junit test 'TestConcursoTalentos'
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
