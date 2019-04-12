package dominio;

public class Credito extends Tarjeta
{
	
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
	
	public double getCreditoDisponible()
	{
		return mCredito-getSaldo();
	}
	
	public void liquidar(int mes, int año)
	{
		Movimiento liq = new Movimiento();
		liq.setConcepto("Liquidación de operaciones de tarj, crédito, " + (mes+1) + " de " + (año+1900));
		double r=0.0;
		for(int=0;i<this.mMovimientos.size();i++)
		{
			Movimiento m= (Movimiento) mMovimientos.elementAt(i);
			if (m.getFecha().getMonth()+1==mes && m.getFecha().getYear()+1900==año)
				r+=m.getImporte();
		}
		liq.setImporte(r);
		if(r!=0)
			mCuentaAsociada.addMovimiento(liq);
	}
}
