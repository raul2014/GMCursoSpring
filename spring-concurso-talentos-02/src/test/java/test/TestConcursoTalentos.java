package test;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import concursantes.Concursante;
import concursantes.Malabarista;


public class TestConcursoTalentos {
	private BeanFactory factory;
	private static Log logger = LogFactory.getLog("TestConcursoTalentos");
	private Concursante malabarista1;
	private Concursante malabarista2;
	
	@Before
	public void before() {
		factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		malabarista1 = (Concursante)factory.getBean("solei");
		malabarista2 = (Concursante)factory.getBean("soleiRecitador");
	}

	@Test
	public void testMalabarista() {
		logger.info("Inicio de ejecutar Malabarista");
		int nroPelotas = 10;
		malabarista1.ejecutar();
		assertEquals(nroPelotas, ((Malabarista)malabarista1).getPelotas());
		logger.info("Fin de Ejecutar Malabarista");
		
		logger.info("Inicio de ejecutar MalabaristaRecitador");
		nroPelotas = 15;
		malabarista2.ejecutar();
		assertEquals(nroPelotas, ((Malabarista)malabarista2).getPelotas());
		logger.info("Fin de Ejecutar MalabaristaRecitador");

	}

}
