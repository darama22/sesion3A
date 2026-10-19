package sesion3A;

import java.util.List;

public class Cuenta {
	String mNumero;
	String nTitular;
	Double saldo;
	List <Movimiento> mMovimientos;
	
	public Cuenta(String numero, String titular, double saldoInicial) {
        this.mNumero = numero;
        this.nTitular = titular;
        this.saldo = saldoInicial;
        this.mMovimientos = new List<>();
    }

    public double getSaldo() { return saldo; }
    public String getNumero() { return mNumero; }
    public String getTitular() { return nTitular; }
    public List<Movimiento> getMovimientos() { return mMovimientos; }
	
	
	
	
	public void ingresar(double x) {
        saldo += x;
        mMovimientos.add(new Movimiento(x, Movimiento.Signo.H, "Ingreso"));
    }
	
	public void retirar(double x) {
        if (saldo - x < -500) {
            System.out.println("Fondos insuficientes (saldo " + saldo + "€) en la cuenta "
                    + mNumero + " para el reintegro de " + x + "€");
            return;   // no se hace el reintegro ni se registra movimiento
        }
        saldo -= x;
        mMovimientos.add(new Movimiento(x, Movimiento.Signo.D, "Reintegro"));
    }
	
	
	
}
