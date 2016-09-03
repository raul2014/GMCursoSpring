package mx.com.gm.jdbc;

import java.util.List;

/**
 * Esta interface que nos permite simular la capa de servicio que nos permitira comununicarnos
 * con la capa de datos.
 * Se provee una lista de servicios para poder comunicarse con la capa de datos.
 * 
 * @author Dell rjc
 *
 */
public interface PersonaService {
	public List<Persona> listarPersonas();
	public Persona recuperarPersona(Persona persona);
	public void agregarPersona(Persona persona);
	public void modificarPersona(Persona persona);
	public void eliminarPersona(Persona persona);
}
