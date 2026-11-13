package banco;
import javax.swing.*;
import java.awt.*;
public class MenuPrincipal extends JFrame {
    private final CuentaBancaria cuenta;
    public MenuPrincipal(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
        initComponents();
    }
    private void initComponents() {
        setTitle("Banco Mexicano - Menú principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 330);
        setLocationRelativeTo(null);
        setResizable(false);
        JLabel titulo = new JLabel("BANCO MEXICANO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        JButton deposito = new JButton("1. Depósito");
        JButton retiro = new JButton("2. Retiro");
        JButton saldo = new JButton("3. Saldo");
        JButton salir = new JButton("4. Salir");
        deposito.addActionListener(e -> new Deposito(this, cuenta).setVisible(true));
        retiro.addActionListener(e -> new Retiro(this, cuenta).setVisible(true));
        saldo.addActionListener(e -> JOptionPane.showMessageDialog(this,
            "La opción Saldo se programará en la siguiente actividad."));
        salir.addActionListener(e -> JOptionPane.showMessageDialog(this,
            "La opción Salir se programará en la siguiente actividad."));
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 40, 25, 40));
        panel.add(titulo); panel.add(deposito); panel.add(retiro); panel.add(saldo); panel.add(salir);
        add(panel);
    }
}
