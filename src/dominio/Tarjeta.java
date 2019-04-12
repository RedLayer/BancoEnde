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
	 */
	public abstract void pagoEnEstablecimiento(String datos, double x) throws Exception;
	/**
	 * Metodo abstracto para recoger el saldo
	 * @return devuelve un numero con el saldo
	 */ 
	public abstract double getSaldo();
}
