package dominio;
/**
 * Clase para hacer todo tipo de movimientos 
 * relacionados con el credito de la tarjeta
 * @author Pablo
 *
 */
public class Credito extends Tarjeta
{
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
