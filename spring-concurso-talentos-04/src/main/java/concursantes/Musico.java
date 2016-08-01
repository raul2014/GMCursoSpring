package concursantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("jasonPiano")
public class Musico implements Concursante {
	
	//Inyeccion de valor primitivo (podemos eliminar el metodo set)
	@Value("Noche de paz")
	private String cancion;
	
	//Inyeccion automatica por propiedad (podemos eliminar el metodo set)
	//Autowiring lo que se hace es buscar en la fabrica de Spring un objeto llamado 'piano' 
	//y lo inyecta en el atributo 'instrumento'
	//Con 'Qualifier' indico el bean que se desea buscar 
	@Autowired 
	@Qualifier("piano")
	private Instrumento instrumento;
	
	public Musico() {
	}
	
	@Override
	public void ejecutar() throws EjecucionException {
		System.out.println("Tocando " + cancion + ": ");
		instrumento.tocar();
	}

	public String getCancion() {
		return cancion;
	}

	public void setCancion(String cancion) {
		this.cancion = cancion;
	}

	public Instrumento getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
}
