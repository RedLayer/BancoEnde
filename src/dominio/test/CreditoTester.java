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



/**
* Pruebas de la clase credito
* Pasada la clase de tester a JUnit 5
*
* @author Pablo
*
*/
class CreditoTester {
	static Cuenta cuenta;
	static Credito tarjeta;
	
	/**
	 * prueba para ver si funcionan los constructores de tarjeta y cuenta
	 * @author Aketza
	 * @exception Exception que lanzan los m�todos de ambas clases si algo va mal
	 * @return void
	 */
	@BeforeAll
	public static void setUp() throws Exception
	{
		cuenta=new Cuenta("0001.0002.12.1234567890", "Fulano de Tal");
		cuenta.ingresar(1000.0);
		Date hoy=new Date();
		long tiempo=Long.parseLong("12096000000");
		Date fecha= new Date(hoy.getTime()+tiempo);
		tarjeta=new Credito("1234567890123456", "Fulano de Tal", fecha , 1000.0);
		tarjeta.setCuenta(cuenta);

	}

	/**
	* Prueba de eliminar una tarjeta de credito
	* @author Ruben
	*/
	@Test
	public void tearDown() throws Exception{

	}

	/**
	* Pruebas de ingresar una cantidad de dinero a una tarjeta de credito
	* @author Ruben
	 * @throws Exception 
	*/
	@Test
	@DisplayName("Test para ingresar 500 en una cuenta")
	public void testIngresar500() throws Exception{
	}
	
	@Test
	@DisplayName("Test para ingresar 500 en una cuenta desde un establecimiento y da error")
	public void testIngresar500_2() throws Exception{
	}

	/**
	* Pruebas de retirar una cantidad de dinero a una tarjeta de credito
	* @author Ruben
	 * @throws Exception 
	*/
	@Test
	@DisplayName("Test para retirar 300 de una cuenta")
	public void testRetirar300() throws Exception{
	}

	/**
	* Prueba de liquidar una tarjeta de credito
	* @author Ruben
	*/
	@Test
	public void testLiquidar(){

	}

}
