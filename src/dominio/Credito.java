package dominio;

import java.util.Date;
import java.util.Vector;

/**
 * Clase para hacer todo tipo de movimientos
 * relacionados con el credito de la tarjeta
 * @author Pablo
 *
 */
public class Credito extends Tarjeta
{
	protected double mCredito;
	protected Vector mMovimientos;


	/**
	 *constructor del Cr�dito
	 *@author Aketza
	 *@param numero
	 *@param titular titular del cr�dito
	 *@param fechaCaducidad fecha de caducidad del cr�dito a conceder
	 *@param credito cantidad a conceder
	 */
	public Credito(String numero,String titular,Date fechaCaducidad,double credito) {
		super(numero,titular,fechaCaducidad);
		mCredito=credito;
		mMovimientos=new Vector();
	}


	/**
	 * m�todo para retirar el dinero del cr�dito
	 * @author Aketza
	 * @param x cantidad a retirar
	 * @exception Excepci�n si tu saldo es insuficiente
	 * @return void
	 */
	public void retirar(double x) {
		Movimiento m= new Movimiento();
		m.setConcepto("Retirada en cajero autom�tico");
		x=(x*0.05<3.0? 3 : x*0.05);
		m.setImporte(x);
		mMovimientos.addElement(m);

		if (x>getCreditoDisponible())
			throw new Exception("Cr�dito insuficiente");

	}

	/**
	* Metodo que sirve para ingresar dinero a la cuenta de credito asociada
	* @author Ruben
	* @param x cantidad a ingresar
	*/
	public void ingresar (double x) throws exception{
		Movimiento m = new Movimiento();
		m.setConcepto("Ingreso en cuenta asociada(cajero automático)");
		m.setImporte(x);
		mMovimientos.addElement(m);
		mCuentaAsociada.ingresar(x);
	}

	/**
	* Metodo que guarda los datos de un pago
	* @author Ruben
	* @param datos datos del establecimiento en el que se ha realizado el pago
	* @param x cantidad ingresada
	*/
	public void pagoEnEstablecimiento(String datos, double x) throws exception{
		Movimiento m=new Movimiento();
		m.setConcepto("Compra a crédito en " + datos);
		m.setImporte(x);
		mMovimientos.addElement(m);
	}


	/**
	 * Metodo que devuelve el saldo total
	 * @return devuelve un numero con el saldo total
	 * @author Pablo
	 */
	public double getSaldo()
	{
		double r=0.0;
		for(int i=0;i<this.mMovimientos.size();i++)
		{
			Movimiento m =(Movimiento) mMovimientos.elementAt(i);
			r+=m.getImporte();
		}
		return r;
	}

	/**
	 * Metodo que devuelve el credito disponible
	 * restandole el saldo al credito total
	 * @return devuelve en un numero el credito disponible
	 * @author Pablo
	 */
	public double getCreditoDisponible()
	{
		return mCredito-getSaldo();
	}

	/**
	 * Liquida todas las movimientos de la tarjeta de credito
	 * clasificando el a�o y el mes para la misma
	 * @param mes mes de la liquidacion
	 * @param a�o a�o de la liquidacion
	 * @author Pablo
	 */
	public void liquidar(int mes, int a�o)
	{
		Movimiento liq = new Movimiento();
		liq.setConcepto("Liquidaci�n de operaciones de tarj, cr�dito, " + (mes+1) + " de " + (a�o+1900));
		double r=0.0;
		for(int=0;i<this.mMovimientos.size();i++)
		{
			Movimiento m= (Movimiento) mMovimientos.elementAt(i);
			if (m.getFecha().getMonth()+1==mes && m.getFecha().getYear()+1900==a�o)
				r+=m.getImporte();
		}
		liq.setImporte(r);
		if(r!=0)
			mCuentaAsociada.addMovimiento(liq);
	}
}
