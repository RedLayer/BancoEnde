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
	 *constructor del Credito
	 *@author Aketza
	 *@param numero
	 *@param titular titular del credito
	 *@param fechaCaducidad fecha de caducidad del credito a conceder
	 *@param credito cantidad a conceder
	 */
	public Credito(String numero,String titular,Date fechaCaducidad,double credito) {
		super(numero,titular,fechaCaducidad);
		mCredito=credito;
		mMovimientos=new Vector();
	}


	/**
	 * metodo para retirar el dinero del credito
	 * @author Aketza
	 * @param x cantidad a retirar
	 * @exception Excepcion si tu saldo es insuficiente
	 * @return void
	 */
	public void retirar(double x) throws Exception{
		Movimiento m= new Movimiento();
		m.setConcepto("Retirada en cajero automatico");
		x=(x*0.05<3.0? 3 : x*0.05);
		m.setImporte(x);
		mMovimientos.addElement(m);

		if (x>getCreditoDisponible())
			throw new Exception("Credito insuficiente");

	}

	/**
	* Metodo que sirve para ingresar dinero a la cuenta de credito asociada
	* @author Ruben
	* @param x cantidad a ingresar
	*/
	public void ingresar (double x) throws Exception{
		Movimiento m = new Movimiento();
		m.setConcepto("Ingreso en cuenta asociada(cajero automatico)");
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
	public void pagoEnEstablecimiento(String datos, double x) throws Exception{
		Movimiento m=new Movimiento();
		m.setConcepto("Compra a credito en " + datos);
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
	 * clasificando el año y el mes para la misma
	 * @param mes mes de la liquidacion
	 * @param anio año de la liquidacion
	 * @author Pablo
	 */
	public void liquidar(int mes, int anio)
	{
		Movimiento liq = new Movimiento();
		liq.setConcepto("Liquidaciï¿½n de operaciones de tarj, crï¿½dito, " + (mes+1) + " de " + (anio+1900));
		double r=0.0;
		for(int i=0;i<this.mMovimientos.size();i++)
		{
			Movimiento m= (Movimiento) mMovimientos.elementAt(i);
			if (m.getFecha().getMonth()+1==mes && m.getFecha().getYear()+1900==anio)
				r+=m.getImporte();
		}
		liq.setImporte(r);
		if(r!=0)
			mCuentaAsociada.addMovimiento(liq);
	}
}
