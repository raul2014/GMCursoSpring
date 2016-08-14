package mx.com.gm.jdbc;

import java.util.List;

/**
 * Esta interfaz nos permitira comunicarnos y realizar operaciones 
 * contra la base de datos. 
 *
 */
public interface PersonaDao {
	public void insertPersona(Persona persona);
	public void updatePersona(Persona persona);
	public void deletePersona(Persona persona);
	public Persona findPersonaById(int idPersona);
	public List<Persona> findAllPersonas();
	public int contadorPersonasPorNombre(Persona persona);
	public int contadorPersonas();
	public Persona getPersonaByEmail(Persona persona);
}
