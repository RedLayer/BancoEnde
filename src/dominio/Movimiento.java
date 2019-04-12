package dominio;

import java.util.Date;

/**
 * Clase con los movimientos de una cuenta
 * @author Pablo
 *
 */
public class Movimiento {
	
	/**
	 * metodo que devuelve la fecha del movimiento
	 * @return Devuelve la fecha en formato fecha
	 */
	public Date getFecha()
	{
		return mFecha;
	}
	
	/**
	 * Metodo que pone la fecha como la fecha pasada como parametro
	 * @param newMFecha Nueva fecha para el movimiento
	 */
	public void setFecha(Date newMFecha)
	{
		mFecha = newMFecha;
	}
	
	/**
	 * Metodo que pone el importe como el importe pasado como parametro
	 * @param newMImporte nuevo importe para el movimiento
	 */
	public void setImporte(double newMImporte)
	{
		mImporte = newMImporte
	}
}
