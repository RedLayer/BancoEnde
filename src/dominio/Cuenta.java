package dominio;

import java.util.Vector;

/**
 * Una clase el la que se crea una cuenta bancaria
 * Aqui se almacena los datos basicos de una cuenta y sus movimientos
 * @author Pablo
 *
 */
public class Cuenta {
	protected String mNumero;
	protected String mTitular;
	protected Vector mMovimientos;
	
	/**
	 * Constructor de la clase Cuenta en
	 * el que se pide el numero y el titular
	 * @param numero numero de la cuenta
	 * @param titular titular de la cuenta
	 */
	public Cuenta(String numero, String titular)
	{
		mNumero=numero;
		mTitular=titular;
		mMovimientos=new Vector();
	}
	
	
	
	
	/**
	 * Metodo para ingresar dinero en la cuenta
	 * se utiliza el parametro para añadir el movimiento efectuado en la cuenta	
	 * @param x el dinero que se añade al movimiento de la cuenta
	 * @throws Exception Excepcion lanzada si el parametro es negativo
	 */
	public void ingresar(double x) throws Exception
	{
		if(x<=0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		m.setconcepto("Ingreso en efectivo");
		m.setImporte(x);
		this.mMovimientos.addElement(m);
	}
	
	/**
	 * metodo para retirar una determinada cantidad de dinero del banco
	 * @param x cantidad de dinero a retirar
	 * @throws Exception
	 */
	public void retirar(double x) throws Exception{
		if(x<=0)
			throw new Exception("No se puede retirar una cantidad negativa");
		if(getSaldo()<x)
			throw new Exception("saldo insuficiente");
		
		Movimiento m= new Movimiento();
		m.setConcepto("retirada en efectivo");
		m.setImporte(-x);
		this.mMovimientos.addElement(m);
	}
	
	/**
	 * 
	 * @param concepto
	 * @param x
	 * @author Aketza
	 */
	public void ingresar(String concepto, double x) {
		
		
	}
	
}
