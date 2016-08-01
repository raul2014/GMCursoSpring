package concursantes;

public class MalabaristaRecitador extends Malabarista {
	private Poema poema;
	
	public MalabaristaRecitador(Poema poema) {
		super();
		this.poema = poema;
	}

	public MalabaristaRecitador(int pelotas, Poema poema) {
		super(pelotas);
		this.poema = poema;
	}

	public Poema getPoema() {
		return poema;
	}

	public void setPoema(Poema poema) {
		this.poema = poema;
	}
	
	@Override
	public void ejecutar() throws EjecucionException {
		super.ejecutar();
		System.out.println("Mientras recita...");
		poema.recitar();
		System.out.println("Termina recitaci�n...");
	}
}
