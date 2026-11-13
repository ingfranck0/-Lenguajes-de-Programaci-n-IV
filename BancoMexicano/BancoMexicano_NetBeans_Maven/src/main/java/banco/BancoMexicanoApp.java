package banco;
import javax.swing.SwingUtilities;
public class BancoMexicanoApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CuentaBancaria cuenta = new CuentaBancaria();
            new MenuPrincipal(cuenta).setVisible(true);
        });
    }
}
