package test;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import concursantes.Concursante;
import concursantes.Malabarista;
import concursantes.Musico;

// Con anotaciones indicamos que vamos a ejecutar pruebas en spring con junit
//Ademas indicamos la ubicacion del archivo de configuracion de Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestConcursoTalentos {
	/* Reemplazado con el uso de anotaciones de Spring
	private BeanFactory factory;
	*/
	
	private static Log logger = LogFactory.getLog("TestConcursoTalentos");
	@Autowired
	@Qualifier("solei")
	private Concursante malabarista1;
	@Autowired
	@Qualifier("soleiRecitador")
	private Concursante malabarista2;
	@Autowired
	@Qualifier("jasonPiano")
	private Concursante musico1;
	@Autowired
	@Qualifier("jasonSaxofon")
	private Concursante musico2;
	
	@Before
	public void before() {
		/* Reemplazado con el uso de anotaciones de Spring
		  
		factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		malabarista1 = (Concursante)factory.getBean("solei");
		malabarista2 = (Concursante)factory.getBean("soleiRecitador");
		musico1 = (Musico)factory.getBean("jasonPiano");
		musico2 = (Musico)factory.getBean("jasonSaxofon");
		*/
	}

	@Test
	public void testMalabarista() {
		logger.info("Inicio de ejecutar Malabarista");
		int nroPelotas = 10;
		malabarista1.ejecutar();
		//assertEquals(nroPelotas, ((Malabarista)malabarista1).getPelotas());
		assertEquals(nroPelotas, ((Malabarista)malabarista1).getPelotas());
		logger.info("Fin de Ejecutar Malabarista");
		
		logger.info("Inicio de ejecutar MalabaristaRecitador");
		nroPelotas = 15;
		malabarista2.ejecutar();
		assertEquals(nroPelotas, ((Malabarista)malabarista2).getPelotas());
		logger.info("Fin de Ejecutar MalabaristaRecitador");

		logger.info("Inicio de ejecutar musico Pianista");
		String cancion = "Noche de paz";
		musico1.ejecutar();
		assertEquals(cancion, ((Musico)musico1).getCancion());
		logger.info("fin de ejecutar musico Pianista");
		
		logger.info("Inicio de ejecutar musico saxofonista");
		cancion = "Equinox";
		musico2.ejecutar();
		assertEquals(cancion, ((Musico)musico2).getCancion());
		logger.info("fin de ejecutar musico saxofonista");
	}

}
