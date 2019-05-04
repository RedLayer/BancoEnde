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

	protected String mNumero, mTitular;
	protected Date mFechaDeCaducidad;
	/**
	* Atributo que guarda la referencia a la cuenta bancaria asociada a la Tarjeta
	*/
	protected Cuenta mCuentaAsociada;

	/**
	* Constructor de la clase Tarjeta
	* @author Ruben
	* @param numero numero identificativo de la Tarjeta
	* @param titular nombre del titular de la Tarjeta
	* @param fechaCaducidad fecha en la que la tarjeta dejará de ser válida
	*/
	public Tarjeta(String numero, String titular, Date fechaCaducidad){
		mNumero=numero;
		mTitular=titular;
		mFechaDeCaducidad=fechaCaducidad;
	}

	/**
	* Metodo que asocia una cuenta bancaria a una Tarjeta
	* @author Ruben
	* @param c cuenta bancaria que se asociará a la Tarjeta
	*/
	public void setCuenta(Cuenta c){
		mCuentaAsociada=c;
	}

	/**
	 * Metodo abstracto sobre el pago en establecimiento
	 * @param datos datos del establecimiento
	 * @param x dinero a pagar al establecimiento
	 * @throws Exception excepcion si el numero es negativo
	 * @author Pablo
	 */
	public abstract void pagoEnEstablecimiento(String datos, double x) throws Exception;

	/**
	 *M�todo abstracto sobre la retirada de saldo
	 *@author Aketza
	 *@param x dinero a retirar
	 *@return void
	 */
	public abstract void retirar(double x);

	/**
	 *M�todo abstracto sobre el ingreso de dinero
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
