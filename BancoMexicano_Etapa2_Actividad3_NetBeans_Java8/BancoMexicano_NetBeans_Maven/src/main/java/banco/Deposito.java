package banco;
import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;
public class Deposito extends JFrame {
    private final CuentaBancaria cuenta;
    private JTextField txtCantidad;
    public Deposito(JFrame menu, CuentaBancaria cuenta) {
        this.cuenta = cuenta;
        initComponents();
        setLocationRelativeTo(menu);
    }
    private void initComponents() {
        setTitle("Banco Mexicano - Depósito");
        setSize(380, 210); setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel titulo = new JLabel("REALIZAR DEPÓSITO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        txtCantidad = new JTextField();
        JButton btnDepositar = new JButton("Depositar");
        JButton btnCancelar = new JButton("Cancelar");
        btnDepositar.addActionListener(e -> realizarDeposito());
        btnCancelar.addActionListener(e -> dispose());
        JPanel campos = new JPanel(new GridLayout(2, 1, 5, 5));
        campos.add(new JLabel("Cantidad a depositar:")); campos.add(txtCantidad);
        JPanel botones = new JPanel(new FlowLayout());
        botones.add(btnDepositar); botones.add(btnCancelar);
        setLayout(new BorderLayout(10, 10));
        add(titulo, BorderLayout.NORTH); add(campos, BorderLayout.CENTER); add(botones, BorderLayout.SOUTH);
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
    }
    private void realizarDeposito() {
        double cantidad;
        try { cantidad = Double.parseDouble(txtCantidad.getText().trim().replace(",", ".")); }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresa una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!cuenta.depositar(cantidad)) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Depósito realizado: " +
            NumberFormat.getCurrencyInstance(new Locale("es", "MX")).format(cantidad));
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas realizar otro depósito?",
            "Nuevo depósito", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) { txtCantidad.setText(""); txtCantidad.requestFocus(); }
        else dispose();
    }
}
