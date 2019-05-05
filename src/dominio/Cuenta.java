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
	 * @author Pablo
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
	 * @author Pablo
	 */
	public void ingresar(double x) throws Exception
	{
		if(x<=0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		m.setConcepto("Ingreso en efectivo");
		m.setImporte(x);
		this.mMovimientos.addElement(m);
	}

	/**
	 * metodo que retira dinero de la cuenta
	 * @author Aketza
	 * @param x cantidad de dinero a retirar
	 * @exception Exception si el saldo es insuficiente o la cantidad introducida negativa
	 * @return void
	 */
	public void retirar(double x) throws Exception{

		if(x<0)
			throw new Exception("No se puede retirar una cantidad negativa");
		if(getSaldo()<x)
			throw new Exception("Saldo insuficiente");

		Movimiento m= new Movimiento();
		m.setConcepto("Retirada en efectivo");
		m.setImporte(-x);
		this.mMovimientos.addElement(m);
	}


	public void ingresar(String concepto,double x) throws Exception{
		if(x>0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		Movimiento m= new Movimiento();
		m.setConcepto("Ingreso en efectivo");
		m.setImporte(x);
		this.mMovimientos.addElement(m);

	}

	/**
	* Metodo para retirar dinero de una cuenta, dando razones de la accion
	* @author Ruben
	* @param concepto razon por la que se retira dinero
	* @param x cantidad de dinero a retirar
	*/
	public void retirar (String concepto, double x) throws Exception{
		if(x<=0)
			throw new Exception("No se puede retirar una cantidad negativa");
		if(getSaldo()<x)
			throw new Exception("Saldo insuficiente");
		Movimiento m=new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(-x);
		this.mMovimientos.addElement(m);
	}

	/**
	* Metodo que devuelve el saldo actual de la Cuenta
	* @author Ruben
	* @return saldo actual de la Cuenta
	*/
	public double getSaldo(){
		double r=0.0;
		for(int i=0;i<this.mMovimientos.size();i++){
			Movimiento m=(Movimiento)mMovimientos.elementAt(i);
			r+=m.getImporte();
		}
		return r;
	}

	/**
	* Metodo para añadir un movimiento a la lista de movimientos
	* @author Ruben
	* @param m movimiento que se desea añadir a la lista
	*/
	public void addMovimiento(Movimiento m)
	{
		mMovimientos.addElement(m);
	}


}
