package dominio;

import java.util.Date;

/**
 * Clase con los movimientos de una cuenta
 * @author Pablo
 *
 */
public class Movimiento {

	protected String mConcepto;
	protected Date mFecha;
	protected double mImporte;

	/**
	* Constructor de la clase Movimiento
	* @author Ruben
	*/
	public Movimiento(){
		mFecha=new Date();
	}

	/**
	* Metodo que devuelve el valor del Importe
	* @author Ruben
	* @return importe del movimiento
	*/
	public double getImporte(){
		return mImporte;
	}
	
	/**
	 * m�todo que devuelve el concepto de un movimiento
	 * @author Aketza
	 * @return String
	 */
	public String getConcepto() {
		return mConcepto;

	}

	/**
	 * m�todo que sobreescribe el concepto de un movimiento con el que le pasan
	 * @author Aketza
	 * @param newMConcepto el nuevo concepto a escribir
	 * @return void
	 */
	public void setConcepto(String newMConcepto) {
		newMConcepto= newMConcepto;
	}

	/**
	 * metodo que devuelve la fecha del movimiento
	 * @return Devuelve la fecha en formato fecha
	 * @author Pablo
	 */
	public Date getFecha()
	{
		return mFecha;
	}

	/**
	 * Metodo que pone la fecha como la fecha pasada como parametro
	 * @param newMFecha Nueva fecha para el movimiento
	 * @author Pablo
	 */
	public void setFecha(Date newMFecha)
	{
		mFecha = newMFecha;
	}

	/**
	 * Metodo que pone el importe como el importe pasado como parametro
	 * @param newMImporte nuevo importe para el movimiento
	 * @author Pablo
	 */
	public void setImporte(double newMImporte)
	{
		mImporte = newMImporte;
	}
}
