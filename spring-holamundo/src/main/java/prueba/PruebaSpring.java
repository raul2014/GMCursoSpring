package prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.BeanSpring;

public class PruebaSpring {
	private static ApplicationContext context;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanFactory factory = context;
		BeanSpring miBean = (BeanSpring)factory.getBean("miBean");
		System.out.println("Mensaje: "  + miBean.getMensaje());
	}

}
