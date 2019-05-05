package dominio.test;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import dominio.Tarjeta;

/**
 * Clase test de tarjeta
 * Esta clase no deberia existir, esta porque lo pone en las hojas
 * ya que todos sus metodos son abstractos, seria mejor probar en la debito y credito
 * directamente
 * @author Pablo
 *
 */
public abstract class TarjetaTester1 extends TestCase
{
    public TarjetaTester1(String sTestName)
    {
      super(sTestName);
    }
   

    public abstract Tarjeta getTarjetaObtenida();
    public abstract Tarjeta prepararTarjetaEsperada();

    /**
	* Prueba de retirar una cantidad de 1000 de una tarjeta
	* @author Ruben
	*/
    public void testRetirar1000(){
    }
  }
