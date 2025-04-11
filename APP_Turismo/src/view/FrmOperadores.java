package view;

import javax.swing.*;
import Model.OperadoresClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmOperadores extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textNombre, textDireccion, textCorreo, textTelefono, textLicencia, textIdOperador;

    public FrmOperadores() {
        setTitle("Gestión de Operadores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(107, 11, 63, 24);
        contentPane.add(lblNombre);
        textNombre = new JTextField();
        textNombre.setBounds(180, 11, 129, 24);
        contentPane.add(textNombre);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(107, 48, 63, 24);
        contentPane.add(lblDireccion);
        textDireccion = new JTextField();
        textDireccion.setBounds(179, 46, 129, 24);
        contentPane.add(textDireccion);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(107, 83, 63, 24);
        contentPane.add(lblCorreo);
        textCorreo = new JTextField();
        textCorreo.setBounds(180, 81, 129, 24);
        contentPane.add(textCorreo);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(107, 117, 63, 24);
        contentPane.add(lblTelefono);
        textTelefono = new JTextField();
        textTelefono.setBounds(180, 116, 129, 24);
        contentPane.add(textTelefono);

        JLabel lblLicencia = new JLabel("Licencia:");
        lblLicencia.setBounds(107, 152, 63, 24);
        contentPane.add(lblLicencia);
        textLicencia = new JTextField();
        textLicencia.setBounds(180, 151, 129, 24);
        contentPane.add(textLicencia);

        JLabel lblIdOperador = new JLabel("ID Operador:");
        lblIdOperador.setBounds(107, 187, 86, 24);
        contentPane.add(lblIdOperador);
        textIdOperador = new JTextField();
        textIdOperador.setBounds(180, 186, 86, 24);
        contentPane.add(textIdOperador);

        JButton btnGuardar = new JButton("");
        btnGuardar.setBounds(37, 222, 113, 78);
        btnGuardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-documento-67.png"));
        btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OperadoresClass operador = new OperadoresClass();
                operador.create(textNombre.getText(), textDireccion.getText(), textCorreo.getText(), textTelefono.getText(), textLicencia.getText());
            }
        });
        contentPane.add(btnGuardar);

        JButton btnEliminar = new JButton("");
        btnEliminar.setBounds(160, 222, 113, 78);
        btnEliminar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-full-trash-64.png"));
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OperadoresClass operador = new OperadoresClass();
                operador.delete(Integer.parseInt(textIdOperador.getText()));
            }
        });
        contentPane.add(btnEliminar);

        JButton btnActualizar = new JButton("");
        btnActualizar.setBounds(283, 222, 113, 78);
        btnActualizar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-actualizar-en-la-nube-50.png"));
        btnActualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OperadoresClass operador = new OperadoresClass();
                operador.update(Integer.parseInt(textIdOperador.getText()), textNombre.getText(), textDireccion.getText(), textCorreo.getText(), textTelefono.getText(), textLicencia.getText());
            }
        });
        contentPane.add(btnActualizar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FrmOperadores frame = new FrmOperadores();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
