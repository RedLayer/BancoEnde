package dominio.test;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import dominio.Tarjeta;

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
