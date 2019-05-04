package dominio.test;

import java.util.Date;

import dominio.Credito;
import dominio.Cuenta;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import dominio.Cuenta;

/**
 * Pruebas de la clase credito
 *
 * @author Pablo
 *
 */
class CreditoTester1 extends TestCase{
	Cuenta cuenta;
	Credito tarjeta;

	/**
	 * Constructor de la clase pruebas de credito
	 * con titulo pasado a la clase TestCase
	 * @param sTestName Titulo de la clase pruebas
	 * @author Pablo
	 */
	public CreditoTester1(String sTestName)
	{
		super(sTestName);
	}




	/**
	 * prueba para ver si funcionan los constructores de tarjeta y cuenta
	 * @author Aketza
	 * @exception Exception que lanzan los m�todos de ambas clases si algo va mal
	 * @return void
	 */
	public void setUp() throws Exception
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
	public void tearDown() throws Exception{

	}

	/**
		* Prueba de ingresar una cantidad de 500 a una tarjeta de credito
		* @author Ruben
		*/
	public void testIngresar500(){

	}

	/**
		* Prueba de retirar una cantidad de 300 a una tarjeta de credito
		* @author Ruben
		*/
	public void testRetirar300(){

	}

	/**
		* Prueba de liquidar una tarjeta de credito
		* @author Ruben
		*/
	public void testLiquidar(){

	}

	public static void main (String args[]){
		//junit.swingui.TestRunner.run(CreditoTester1.class);
	}


}
