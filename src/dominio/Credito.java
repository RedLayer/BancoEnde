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
	 * m�todo constructor de Cr�ditos
	 * @param numero numero de transferencia 
	 * @param titular titular de la cuenta
	 * @param fechaCaducidad fecha en la que expira
	 * @param credito importe
	 * @author Aketza
	 */
	public Credito (String numero,String titular,Date fechaCaducidad,double credito) {
		super(numero,titular,fechaCaducidad);
		mCredito=credito;
		mMovimientos= new Vector();
		
	}
	/**
	 * metodo que retira dinero de un cajero
	 * @param x precio
	 * @return void
	 * @throws Exception excepci�n lanzada si el saldo es menos al cobro;
	 *@author Aketza 
	 */
	public void retirar (double x) throws Exception{
		Movimiento m= new Movimiento();
		m.setConcepto("Retirada en cajero autom�tico");
		x=(x*0.05<3.0?3:x*0.05); //a�adimos una comisi�n de un 5% m�nimo 3 euros
		m.setImporte(x);
		mMovimientos.addElement(m);
		if(x>getCreditoDisponible()) 
			throw new Exception("Credito insuficiente");
	}
	
	
	
	/**
	 * Metodo que devuelve el saldo total
	 * @return devuelve un numero con el saldo total
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
