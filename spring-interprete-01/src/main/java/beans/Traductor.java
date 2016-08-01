package beans;

public class Traductor {
	private InterpreteEspanol interprete;
	public InterpreteEspanol getInterprete() {
		return interprete;
	}

	public void setInterprete(InterpreteEspanol interprete) {
		this.interprete = interprete;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String nombre;
	
	public void hablar() {
		this.interprete.saludar();
		System.out.println(nombre);
		this.interprete.despedirse();
	}
}
