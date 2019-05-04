package dominio.test;


import java.util.Date;

import dominio.Credito;
import dominio.Cuenta;
import dominio.Debito;
import junit.framework.TestCase;

/**
 * Pruebas para la clase debito
 * @author Pablo
 *
 */
class DebitoTester1 extends TestCase{
	Debito debito;
	Cuenta cuenta;
	
	/**
	 * Creacion del constructor de la clase
	 * @param sTestName Nombre del test para la clase TestCase
	 * @author Pablo
	 */
	public DebitoTester1(String sTestName)
	{
		super(sTestName);
	}
	
	/**
	 * prueba de set para la clase de debito
	 * @author Pablo
	 */
	public void setUp() throws Exception
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
