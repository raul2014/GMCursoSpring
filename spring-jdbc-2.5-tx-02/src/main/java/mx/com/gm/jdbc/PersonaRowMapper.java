package mx.com.gm.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Esta clase permite agregar codigo callback. Por cada registro en nuestro resulset
 * se crea un objeto Rowmapper que a su vez crea un objeto tipo Persona.
 * 
 */
public class PersonaRowMapper implements RowMapper<Persona> {

	/**
	 * M�todo que es llamado por la plantilla de Spring.
	 * Este es un callback 
	 */
	public Persona mapRow(ResultSet rs, int rowNum1) throws SQLException {
		/**
		 * Creacion del objeto persona por cada registro encontrado
		 * en el resultset resultado de ejecutar un query
		 */
		Persona persona = new Persona();
		persona.setIdPersona(rs.getLong("id_persona"));
		persona.setNombre(rs.getString("nombre"));
		persona.setApePaterno(rs.getString("ape_paterno"));
		persona.setApeMaterno(rs.getString("ape_materno"));
		persona.setEmail(rs.getString("email"));
		
		return persona;
	}
}
