package dominio.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dominio.Credito;
import dominio.Cuenta;
import dominio.Debito;
import junit.framework.TestCase;



/**
* Pruebas de la clase credito
* Pasada la clase de tester a JUnit 5
*
* @author Pablo
*
*/
class DebitoTester {
	static Debito debito;
	static Cuenta cuenta;
	
	
	/**
	 * Set para la clase de debito creando una tarjeta de debito
	 * @author Pablo
	 */
	@BeforeAll
	public static void setUp() throws Exception
	{
		cuenta= new Cuenta("0001.0002.12.1234567890","Fulano de tal");
		cuenta.ingresar(1000.0);
		Date hoy = new Date();
		long tiempo = Long.parseLong("12096000000");
		Date fecha = new Date(hoy.getTime()+tiempo);
		debito =new Debito("1234567890123456","Fulano de Tal",fecha);
		debito.setCuenta(cuenta);

	}
}
