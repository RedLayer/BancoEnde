package dominio;

public class Cuenta {
	protected String mNumero;
	protected String mTitular;
	protected Vector mMovimientos;
	
	public Cuenta(String numero, String titular)
	{
		mNumero=numero;
		mTitular=titular;
		mMovimientos=new Vector();
	}
	
	public void ingresar(double x) throws Exception
	{
		if(x<=0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		m.setconcepto("Ingreso en efectivo");
		m.setImporte(x);
		this.mMovimientos.addElement(m);
	}
}
