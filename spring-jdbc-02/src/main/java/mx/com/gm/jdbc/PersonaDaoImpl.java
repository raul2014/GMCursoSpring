package mx.com.gm.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

// Con '@Repository' indicamos que es una clase de la CAPA DE DATOS
// Si no sabriamos en que capa usamos '@Component'
@Repository
public class PersonaDaoImpl implements PersonaDao {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	//Query con parametros por nombre
	//Omitimos la PK ya que es autoincremental
	private static final String SQL_INSERT_PERSONA = "insert into persona(nombre, ape_paterno,ape_materno,email) "
												   + "values(:nombre, :apePaterno, :apeMaterno, :email)";
	/**
	 * Query con PARAMETROS POR INDICE
	 * Omitimos private  static String SQL_INSERT_PERSONA =
	 * "insert into persona(username, password, fullname, email, update_by_email) values (?, ?, ?, ?, ?)";
	 */
	// PARAMETROS POR NOMBRE
	private static String SQL_UPDATE_PERSONA = "update persona set nombre = :nombre, ape_paterno = apePaterno, ape_materno = apeMaterno, email = :email " 
											 + "where id_persona = :idPersona";
	private static String SQL_DELETE_PERSONA = "delete from persona where id_persona = :idPersona";
	private static String SQL_SELECT_PERSONA = "select id_persona, nombre, ape_paterno, ape_materno, email from persona";
	
	//PARAMETROS POR INDICE
	private static final String  SQL_SELECT_PERSONA_BY_ID = SQL_SELECT_PERSONA + "  where id_persona = ?"; 
	
	// Por medio de '@Autowired' inyectamos el 'dataSource' 
	@Autowired
	public void setDataSource(DataSource dataSource) {
		// No es comun que se utiliceb las dos plantillas, sin embargo 
		// si es posible.
		// La diferencia es el manejo de par�metros por indice o nombre
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void insertPersona(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	public void updatePersona(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	public void deletePersona(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	public Persona findPersonaById(int idPersona) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Persona> findAllPersonas() {
		/**
		 * Esta consulta es quivalente a
		 * 
		 * String sql = "select * from persona";
		 */
		/**
		 * La clase 'ParameterizedBeanPropertyRowMapper' esta deprecada' en spring 4.3 entonces uso 'BeanPropertyRowMapper'
		 * 
		 * RowMapper<Persona> personaRowMapper = ParameterizedBeanPropertyRowMapper.newInstance(Persona.class);
		 */
		
		// Utilizamos 'BeanPropertyRowMapper' para crear un objeto 'PersonaRowMapper' en donde recuperaremos cada objeto resultante de query
		RowMapper<Persona> personaRowMapper = BeanPropertyRowMapper.newInstance(Persona.class);
			
		return this.jdbcTemplate.query(SQL_SELECT_PERSONA, personaRowMapper);
	}

	public int contadorPersonasPorNombre(Persona persona) {
		return 0;
	}

	public int contadorPersonas() {
		//I don't use 'jdbcTemplate.queryForInt(query)' because is deprecated
		//since version 3.2.2. (correct me if mistake). 
		//To fix it, replace the code with queryForObject(String, Class).
		
		String sql = "select count(*) from persona";
		// Esta es otra opcion si no tuvieramos jdbcTemplate
		// return this.namedParameterJdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);  

		return this.jdbcTemplate.queryForObject(sql, Integer.class);   		
	}

	public Persona getPersonaByEmail(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
