package dominio;

/**
 * La tarjeta con sus respectivos campos 
 * incluyendo objetos de otras clases
 * Al ser una clase abstracta todos sus hijos tendran que 
 * implementar las clases abstractas
 * @author Pablo
 *
 */
public abstract class Tarjeta {

	/**
	 * Metodo abstracto sobre el pago en establecimiento
	 * @param datos datos del establecimiento
	 * @param x dinero a pagar al establecimiento
	 * @throws Exception excepcion si el numero es negativo
	 * @author Pablo
	 */
	public abstract void pagoEnEstablecimiento(String datos, double x) throws Exception;
	
	/**
	 *Método abstracto sobre la retirada de saldo
	 *@author Aketza
	 *@param x dinero a retirar
	 *@return void
	 */
	public abstract void retirar(double x);
	
	/**
	 *Método abstracto sobre el ingreso de dinero
	 *@author Aketza
	 *@param x dinero a ingresar
	 *@return void
	 */
	public abstract void ingresar(double x);
	
	
	/**
	 * Metodo abstracto para recoger el saldo
	 * @return devuelve un numero con el saldo
	 * @Author Pablo
	 */ 
	public abstract double getSaldo();
}
