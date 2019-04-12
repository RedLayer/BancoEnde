package dominio.test;

import java.util.Date;

import dominio.Credito;
import dominio.Cuenta;
import junit.framework.TestCase;

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
	 */
	public CreditoTester1(String sTestName)
	{
		super(sTestName);
	}
	

}
