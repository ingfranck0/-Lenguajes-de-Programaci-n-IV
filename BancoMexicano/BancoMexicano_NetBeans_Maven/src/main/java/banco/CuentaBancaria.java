package banco;
public class CuentaBancaria {
    private double saldo = 0.0;
    public double getSaldo() { return saldo; }
    public boolean depositar(double cantidad) {
        if (cantidad <= 0) return false;
        saldo += cantidad;
        return true;
    }
    public boolean retirar(double cantidad) {
        if (cantidad <= 0 || cantidad > saldo) return false;
        saldo -= cantidad;
        return true;
    }
}
