/**
 * Leccion #3: INYECCION DE DEPENDENCIAS
 * Titulo: Ejercicio 4 del curso SPRING de GLOBAL MENTORING
 * Version: 2.0
 * Descricpion: - Se agrega nueva concursante con diferente habilidad (MalabaristaRecitador) 
 * 				- Programa que utiliza Spring.
 *				- Aqui las dependencias son inyectadas con spring
 *				- Se utiliza interfaces.
 *				- Se enseña a inyectar beans atraves de CONSTRUCTORES con parametros.
 *				- Configuracion beans para pasar agumentos ya sea a través del pasaje de argumentos 
 *				  de tipos primitivos (int, long) o referencias de objetos.  				
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
