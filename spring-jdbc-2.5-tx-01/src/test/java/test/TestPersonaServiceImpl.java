package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import mx.com.gm.jdbc.Persona;
import mx.com.gm.jdbc.PersonaDao;
import mx.com.gm.jdbc.PersonaService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:datasource-test.xml", 
							       "classpath:applicationContext.xml"})
public class TestPersonaServiceImpl {
	private static Log logger = LogFactory.getLog("TestPersonaServiceImpl");
	
	// Dependencia inyectada para probar la CAPA DE SERVICIO
	@Autowired
	private PersonaService personaService;
	
	// Dependencia inyectada para probar la CAPA DE DATOS
	@Autowired
	private PersonaDao personaDao;
	
	/*
	 * @Transactional : En las pruebas pruebas unitarias se utiliza para indicar que se haga rollback 
	 * de los cambios realizados en la bd.
	 *
	 */
	@Test
	@Transactional
	public void deberiaMostrarPersonas() {
		try {
			System.out.println();
			logger.info("Inicio del test 'deberiaMostrarPersonas'");
			int contadorPersonas = this.deplegarPersonas();
			
			//Segun el numero de personas recuperadas
			//deberia ser el mismo de la tabla
			assertEquals(contadorPersonas, personaDao.contadorPersonas());
			logger.info("Fin del test 'deberiaMostrarPersonas'");
			System.out.println();
		} catch (Exception e) {
			logger.error("Error Servicio", e);
		}
	}

	private int deplegarPersonas() {
		List<Persona> personas = personaService.listarPersonas();
		int contadorPersonas = 0;
		for (Persona persona : personas) {
			logger.info("Persona: " + persona);
			contadorPersonas++;
		}
		return contadorPersonas;
	}

}
