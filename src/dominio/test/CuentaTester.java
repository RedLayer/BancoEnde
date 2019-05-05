package dominio.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dominio.Credito;
import dominio.Cuenta;



/**
* Pruebas de la clase credito
* Pasadas las clases de tester a JUnit 5
*
* @author Pablo
*
*/
class CuentaTester {
	static Cuenta cuenta;
	
	/**
	 * prueba para ver si funcionan los constructores de tarjeta y cuenta
	 * @author Aketza
	 * @exception Exception que lanzan los m�todos de ambas clases si algo va mal
	 * 	 * @see junit.framework.TestCase#setUp()
	 * @return void
	 */
	@BeforeAll
	public static void setUp() throws Exception
	{
		cuenta=new Cuenta("0001.0002.12.1234567890", "Fulano de Tal");
		cuenta.ingresar(1500);

	}
	/**
	 * @author Aketza
	 * @exception Exception
	 * @see junit.framework.TestCase#tearDown()
	 */
	@AfterAll
	@Test
	@DisplayName("Prueba para eliminar una cuenta")
	public static void tearDown() throws Exception {
		cuenta=null;
		assertNull(cuenta);
	}


	/**
	 * Prueba para ingresar 1000 en la cuenta
	 * @author Pablo
	 * @throws Exception 
	 */
	@Test
	@DisplayName("Cuenta para ingresar dinero y que no de fallo")
	public void testIngresar1000() throws Exception
	{
		cuenta.ingresar(1000.0);
		assertEquals(2500.0,cuenta.getSaldo());
		cuenta.retirar(1000.0);
	}

	/**
	 * Prueba para retirar 1000 de la cuenta
	 * @author Pablo
	 * @throws Exception 
	 */
	@Test
	@DisplayName("Prueba para retirar dinero y que no de fallo")
	public void testRetirar1000() throws Exception
	{
		cuenta.retirar(1000.0);
		assertEquals(500.0,cuenta.getSaldo());
		cuenta.ingresar(1000.0);
	}

	/**
	* Prueba de ingresar, y despues retirar dinero en una cuenta
	* @author Ruben
	 * @throws Exception 
	*/
	@Test
	@DisplayName("Prueba conjunta de retirada e ingreso de dinero")
	public void testIngresoYRetirada() throws Exception{
		assertAll("Ingreso de 1000",
	            () -> {
	            	cuenta.ingresar(1000.0);
	            	assertEquals(2500.0,cuenta.getSaldo());

	                // Executed only if the previous assertion is valid.
	                assertAll("Retirada de 1000",
	                    () -> {
	                    	cuenta.retirar(1000.0);
	                		assertEquals(1500.0,cuenta.getSaldo());
	                    }
	                );
	            });
		cuenta.ingresar(1000.0);
	}

}
