/**
 * Leccion #6: SPRING JDBC
 * Titulo: Ejercicio 13 del curso SPRING de GLOBAL MENTORING
 * Version: 2.3
 * Descripcion:
 * 				- Se realiza el ABM utilizando el la v 1.0.
 * 				  En esta version se realiza la implementacion 
 * 				  de los servicios:
 * 				  				'findAllPersonas', contadorPersonas()
 * 
 * 				- Se agrego el test 'testContarPersonasPorNombre'
 * 
 * 			    - Se agrego la implementacion de 'findPersonaById'. 
 * 				- Uso de RowMapper con Spring JDBC
 * 				- Se recupero objetos resultado de query que reciben parametros.
 *				
 *				- Inserción con Spring JDBC - ejercicio
 *
 *				- Se agrego la implementacion de 'getPersonaByEmail' y 'insertPersona'
 * 
 * NOTA (05/08/2016):      
 *		- I don't use 'jdbcTemplate.queryForObject(query)' because is deprecated
 *		  since version 3.2.2. (correct me if mistake). 
 *		  To fix it, replace the code with queryForObject(String, Class).
 *
 *		  Source: http://www.mkyong.com/spring/jdbctemplate-queryforint-is-deprecated/
 *
 *		(09/08/2016):
 *		- La clase 'ParameterizedBeanPropertyRowMapper' esta deprecada' en spring 4.3 
 *        entonces uso 'BeanPropertyRowMapper' asi:
 *		          RowMapper<Persona> personaRowMapper = ParameterizedBeanPropertyRowMapper.newInstance(Persona.class);
 *		 			
 */
package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import mx.com.gm.jdbc.Persona;
import mx.com.gm.jdbc.PersonaDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:datasource-test.xml",
								   "classpath:applicationContext.xml"})
public class TestPersonasDaoImpl {
	
	private static Log logger = LogFactory.getLog("TestPersonasDaoImpl");
	@Autowired
	PersonaDao personaDao;
	
	@Test
	public void deberiaMostrarPersonas() {
		try {
			System.out.println();
			logger.info("Inicio de test 'deberiaMostrarPersonas'");
			List<Persona> personas = personaDao.findAllPersonas();
			int contPersonas = 0;
			for (Persona persona : personas) {
				logger.info("Persona: " + persona);
				contPersonas++;
			}
			// Segun el numero de personas recuperadas, deberia ser 
			// el mismo de la tabla
			assertEquals(contPersonas, personaDao.contadorPersonas());
			logger.info("Fin del test 'deberiaMostrarPersonas'");
		} catch (Exception e) {
			logger.error("Error JDBC", e);
		}
	}
	
	@Test
	public void testContarPersonasPorNombre() {
		try {
			System.out.println();
			logger.info("Inicio del test de ContarPersonasPorNombre");
			String nombre = "Nancy";
			Persona personaEjemplo = new Persona();
			personaEjemplo.setNombre(nombre);
			int nroPersonasEncontradas = personaDao.contadorPersonasPorNombre(personaEjemplo);
			logger.info("Numero de personas encontradas por nombre '" + nombre + "': " + nroPersonasEncontradas);
			assertEquals(2, nroPersonasEncontradas);
			logger.info("Fin del test ContarPersonasPorNombre");
		} catch (Exception e) {
			logger.error("Error JDBC", e);
		}
	}
	
	@Test
	public void testFindPersonaById() {
		try {
			System.out.println();
			logger.info("Inicio del test de testFindPersonaById");
		    int idPersona = 1;
		    Persona persona = personaDao.findPersonaById(idPersona);
		    // Segun la persona recuperadad, deberia ser la misma que el 
		    // registro 1
		    assertEquals("Admin", persona.getNombre());
		    logger.info("Persona recuperada (id=" + idPersona + "): " + persona);
			logger.info("Fin del test de testFindPersonaById");
		} catch (Exception e) {
			logger.error("Error JDBC", e);
		}
	}
	
	@Test
	public void deberiaInsertarPersona() {
		try {
			System.out.println();
			logger.info("Inicio del test 'deberiaInsertarPersona'");
			
			// El script de datos tiene 3 registros
			assertEquals(3, personaDao.contadorPersonas());
			
			Persona persona = new Persona();
			persona.setNombre("Carlos");
			persona.setApePaterno("Romero");
			persona.setApeMaterno("Esparza");
			persona.setEmail("carlos.romero@gmail.com");
			
			personaDao.insertPersona(persona);
			
			// Recuperamos a la persona recien insertada por su email
			persona = personaDao.getPersonaByEmail(persona);
			
			logger.info("Persona insertada: " + persona);
			
			// Deberia haber ya cuatro personas
			assertEquals(4, personaDao.contadorPersonas());
			
			logger.info("Fin del test 'deberiaInsertarPersona'");
		} catch (Exception e) {
			logger.error("Error JDBC", e);
		}
	}
}
