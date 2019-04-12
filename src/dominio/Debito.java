package dominio;

public class Debito extends Tarjeta
{
	/**
	 * Metodo que realiza un pago en un establecimiento
	 * retirando el dinero de la cuenta asociada
	 * @param datos datos del sitio de compra
	 * @param x dinero a retirar de la cuenta
	 * @throws Exception Excepcion que lanza si el dinero no es suficiente
	 */
	public void pagoEnEstablecimiento(String datos, double x) throws Exception
	{
		this.mCuentaAsociada.retirar("Compra en: " + datos,x);
	}
	
	/**
	 * Metodo que devuelve el saldo
	 * disponible en la cuenta asociada
	 * @return Devuelve un numero con el saldo disponible
	 */
	public double getSaldo() 
	{
		return mCuentaAsociada.getSaldo();
	}
}
