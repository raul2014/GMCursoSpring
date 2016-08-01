package concursantes;

import org.springframework.stereotype.Component;

@Component
public class Voluntario implements Pensador {
	private String pensamientos;
	
	@Override
	public void pensarEnAlgo(String pensamientos) {
		System.out.println("Voluntario pensando en algo...");
		this.pensamientos = pensamientos;
	}
	
	public String getPensamientos() {
		return pensamientos;
	}
}
