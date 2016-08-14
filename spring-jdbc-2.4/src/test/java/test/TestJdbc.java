/**
 * Leccion #5: SPRING JDBC
 * Titulo: Ejercicio 12 del curso SPRING de GLOBAL MENTORING
 * Version: 1.0
 * Descripcion:
 * 				- Se realiza una conexion a una base de datos embebida usando el jar H2. 
 * 				  H2 permite simular una base de datos que esta en memoria.
 * 				  Posteriormente se realiza una consulta en dicha base.
 * 
 * NOTA (05/08/2016):      
 *		- I don't use 'jdbcTemplate.queryForObject(query)' because is deprecated
 *		  since version 3.2.2. (correct me if mistake). 
 *		  To fix it, replace the code with queryForObject(String, Class).
 *
 *		  Source: http://www.mkyong.com/spring/jdbctemplate-queryforint-is-deprecated/	 			
 */

package test;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:datasource-test.xml"})
public class TestJdbc {
	
	private static Log logger = LogFactory.getLog("TestJdbc");
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void testJdbc() {
		logger.info("Inicio del test Jdbc");
		
		//I don't use 'jdbcTemplate.queryForInt(query)' because is deprecated
		//since version 3.2.2. (correct me if mistake). 
		//To fix it, replace the code with queryForObject(String, Class).
		String query = "select count(*) from persona";
		int nroPersonas = jdbcTemplate.queryForObject(query, Integer.class);
		assertEquals(3, nroPersonas);
		logger.info("Fin del test Jdbc");
	}

}
