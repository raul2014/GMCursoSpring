package concursantes;

import org.springframework.stereotype.Component;

//Con '@Componet' haace que esta clase se detectada por Spring para ser agregada
//como un bean llamado 'saxofon'
@Component
public class Saxofon implements Instrumento {

	@Override
	public void tocar() {
		System.out.println("Tuu tuu tuu tuu...");
	}

}
