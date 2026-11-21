package banco;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

/** Ventana que consulta y muestra el saldo actual de la cuenta. */
public class Saldo extends JFrame {
    private final CuentaBancaria cuenta;

    public Saldo(JFrame menu, CuentaBancaria cuenta) {
        this.cuenta = cuenta;
        initComponents();
        setLocationRelativeTo(menu);
    }

    private void initComponents() {
        setTitle("Banco Mexicano - Saldo");
        setSize(380, 230);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titulo = new JLabel("SALDO DE LA CUENTA", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel etiquetaMonto = new JLabel("Monto:");
        JTextField txtMonto = new JTextField(
                NumberFormat.getCurrencyInstance(new Locale("es", "MX")).format(cuenta.getSaldo()));
        txtMonto.setEditable(false);
        txtMonto.setBackground(new Color(230, 230, 230));
        txtMonto.setFont(new Font("Arial", Font.BOLD, 16));

        JButton continuar = new JButton("Continuar");
        continuar.addActionListener(e -> dispose());

        JPanel centro = new JPanel(new GridLayout(2, 1, 8, 8));
        centro.add(etiquetaMonto);
        centro.add(txtMonto);

        JPanel inferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        inferior.add(continuar);

        setLayout(new BorderLayout(12, 12));
        add(titulo, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        add(inferior, BorderLayout.SOUTH);
        ((JPanel) getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(18, 20, 18, 20));
    }
}
