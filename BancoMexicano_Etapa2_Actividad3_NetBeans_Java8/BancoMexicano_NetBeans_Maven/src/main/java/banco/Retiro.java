package banco;
import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;
public class Retiro extends JFrame {
    private final CuentaBancaria cuenta;
    private JTextField txtCantidad;
    public Retiro(JFrame menu, CuentaBancaria cuenta) {
        this.cuenta = cuenta;
        initComponents();
        setLocationRelativeTo(menu);
    }
    private void initComponents() {
        setTitle("Banco Mexicano - Retiro");
        setSize(380, 210); setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel titulo = new JLabel("REALIZAR RETIRO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        txtCantidad = new JTextField();
        JButton btnRetirar = new JButton("Retirar");
        JButton btnCancelar = new JButton("Cancelar");
        btnRetirar.addActionListener(e -> realizarRetiro());
        btnCancelar.addActionListener(e -> dispose());
        JPanel campos = new JPanel(new GridLayout(2, 1, 5, 5));
        campos.add(new JLabel("Cantidad a retirar:")); campos.add(txtCantidad);
        JPanel botones = new JPanel(new FlowLayout());
        botones.add(btnRetirar); botones.add(btnCancelar);
        setLayout(new BorderLayout(10, 10));
        add(titulo, BorderLayout.NORTH); add(campos, BorderLayout.CENTER); add(botones, BorderLayout.SOUTH);
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
    }
    private void realizarRetiro() {
        double cantidad;
        try { cantidad = Double.parseDouble(txtCantidad.getText().trim().replace(",", ".")); }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresa una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!cuenta.retirar(cantidad)) {
            JOptionPane.showMessageDialog(this, "No se puede realizar el retiro. Verifica que tengas saldo suficiente.",
                "Retiro no realizado", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Retiro realizado: " +
            NumberFormat.getCurrencyInstance(new Locale("es", "MX")).format(cantidad));
        dispose();
    }
}
