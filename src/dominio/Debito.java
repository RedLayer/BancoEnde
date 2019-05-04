package dominio;

import java.util.Date;

public class Debito extends Tarjeta
{

	/**
	 *constructor de las tarjetas de debito
	 *@author Aketza
	 *@param numero numero de tarjeta
	 *@param titular titular de la tarjeta
	 *@param fechaCaducidad fecha de caducidad de la tarjeta
	 */
	public Debito(String numero,String titular,Date fechaCaducidad) {
		super(numero,titular,fechaCaducidad);
	}

	/**
	* Metodo para retirar dinero de la cuenta de Debito
	* @author Ruben
	* @param x cantidad a retirar
	*/
	public void retirar(double x) throws Exception{
		this.mCuentaAsociada.retirar("Retirada en cajero automático",x);
	}

	/**
	* Metodo para ingresar dinero a la cuenta de Debito
	* @author Ruben
	* @param x cantidad a ingresar
	*/
	public void ingresar(double x) throws Exception{
		this.mCuentaAsociada.ingresar("Ingreso en cajero automático",x);
	}


	/**
	 * Metodo que realiza un pago en un establecimiento
	 * retirando el dinero de la cuenta asociada
	 * @param datos datos del sitio de compra
	 * @param x dinero a retirar de la cuenta
	 * @throws Exception Excepcion que lanza si el dinero no es suficiente
	 * @author Pablo
	 */
	public void pagoEnEstablecimiento(String datos, double x) throws Exception
	{
		this.mCuentaAsociada.retirar("Compra en: " + datos,x);
	}

	/**
	 * Metodo que devuelve el saldo
	 * disponible en la cuenta asociada
	 * @return Devuelve un numero con el saldo disponible
	 * @author Pablo
	 */
	public double getSaldo()
	{
		return mCuentaAsociada.getSaldo();
	}
}
