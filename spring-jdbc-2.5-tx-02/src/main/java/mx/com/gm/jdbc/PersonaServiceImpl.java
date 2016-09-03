package mx.com.gm.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/* Con el el anotacion '@Service' configuramos esta clase como de servicio
 *
 * Con @Transactional configuramos la transaccion.
 * Propagation.SUPPORTS: Indicamos que soportan una transaccion si ya existe alguna.
 * readOnly=true : Indica que los metodos de la clase son solo lectura
 */
@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDao personaDao;
	
	@Override
	public List<Persona> listarPersonas() {			// Nombre de servcio representa mas el negocio
		return personaDao.findAllPersonas();		// Aqui se usan nombres que se asemejan a nombres de capa de datos
	}

	@Override
	public Persona recuperarPersona(Persona persona) {
		return personaDao.findPersonaById(persona.getIdPersona());
	}
	
	// Propagation.REQUIRED: Indica que los metodos requieren una transaccion porque modifican la info de la bd
	// readOnly=false : Indica que el metodo escribe en la bd por lo cual no es de solo lectura.
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public void agregarPersona(Persona persona) {
		personaDao.insertPersona(persona);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public void modificarPersona(Persona persona) {
		personaDao.updatePersona(persona);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);
	}

}
