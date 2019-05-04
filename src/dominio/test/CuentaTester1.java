package dominio.test;

import org.junit.runner.JUnitCore;

import dominio.Cuenta;
import junit.framework.TestCase;

/**
 * Pruebas para la clase Cuenta
 * @author pablo
 *
 */
class CuentaTester1 extends TestCase{


	Cuenta cuenta;

	/**
	 * constructor de la caja de pruebas
	 * @author Aketza
	 * @param sTestName nombre del test
	 */
	public CuentaTester1(String sTestName) {
		super(sTestName);
	}

	/**
	 * configura una cuenta
	 * @author Aketza
	 * @see junit.framework.TestCase#setUp()
	 */
	public void setUp() throws Exception{
		cuenta=new Cuenta("0001.0002.12.1234567890", "Fulano de Tal");
	}


	/**
	 * @author Aketza
	 * @exception Exception
	 * @see junit.framework.TestCase#tearDown()
	 */
	public void tearDown() throws Exception {

	}


	/**
	 * Prueba para ingresar 1000 en la cuenta
	 * @author Pablo
	 */
	public void testIngresar1000()
	{

	}

	/**
	 * Prueba para retirar 1000 de la cuenta
	 * @author Pablo
	 */
	public void testRetirar1000()
	{

	}

	/**
		* Prueba de ingresar, y despues retirar dinero en una cuenta
		* @author Ruben
		*/
	public void testIngresoYRetirada(){

	}


	public static void main(String[] args) {
		Junit.swingui.TestRunner.run(CuentaTester1.class);
	}

}
