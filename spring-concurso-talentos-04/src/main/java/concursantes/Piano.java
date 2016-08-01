package concursantes;

import org.springframework.stereotype.Component;

//Con '@Componet' haace que esta clase se detectada por Spring para ser agregada
//como un bean llamado 'piano'
@Component
public class Piano implements Instrumento {

	@Override
	public void tocar() {
		System.out.println("Clin clin clin clin...");

	}

}
