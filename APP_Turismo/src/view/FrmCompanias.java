package view;

import javax.swing.*;
import Model.CompaniasClass;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmCompanias extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textRazonSocial, textDireccion, textCorreo, textTelefono, textFechacreacion, textWeb, textIdCompania;

    public FrmCompanias() {
        setTitle("Gestión de Compañías");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblRazonSocial = new JLabel("Razón Social:");
        lblRazonSocial.setBounds(26, 11, 86, 24);
        contentPane.add(lblRazonSocial);
        textRazonSocial = new JTextField();
        textRazonSocial.setBounds(122, 11, 129, 24);
        contentPane.add(textRazonSocial);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(26, 46, 63, 24);
        contentPane.add(lblDireccion);
        textDireccion = new JTextField();
        textDireccion.setBounds(122, 46, 129, 24);
        contentPane.add(textDireccion);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(26, 81, 63, 24);
        contentPane.add(lblCorreo);
        textCorreo = new JTextField();
        textCorreo.setBounds(122, 81, 129, 24);
        contentPane.add(textCorreo);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(26, 116, 63, 24);
        contentPane.add(lblTelefono);
        textTelefono = new JTextField();
        textTelefono.setBounds(122, 116, 129, 24);
        contentPane.add(textTelefono);

        JLabel lblFechacreacion = new JLabel("Fecha Creación:");
        lblFechacreacion.setBounds(26, 151, 100, 24);
        contentPane.add(lblFechacreacion);
        textFechacreacion = new JTextField();
        textFechacreacion.setBounds(122, 151, 129, 24);
        contentPane.add(textFechacreacion);

        JLabel lblWeb = new JLabel("Web:");
        lblWeb.setBounds(26, 186, 63, 24);
        contentPane.add(lblWeb);
        textWeb = new JTextField();
        textWeb.setBounds(122, 186, 129, 24);
        contentPane.add(textWeb);

        JLabel lblIdCompania = new JLabel("ID Compañía:");
        lblIdCompania.setBounds(269, 126, 79, 24);
        contentPane.add(lblIdCompania);
        textIdCompania = new JTextField();
        textIdCompania.setBounds(338, 126, 86, 24);
        contentPane.add(textIdCompania);

        JButton btnGuardar = new JButton("");
        btnGuardar.setBounds(36, 221, 113, 78);
        btnGuardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-documento-67.png"));
        btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CompaniasClass cr = new CompaniasClass();
                cr.create(textRazonSocial.getText(), textDireccion.getText(), textCorreo.getText(), 
                          textTelefono.getText(), textFechacreacion.getText(), textWeb.getText());
            }
        });
        contentPane.add(btnGuardar);

        JButton btnEliminar = new JButton("");
        btnEliminar.setBounds(159, 221, 113, 78);
        btnEliminar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-full-trash-64.png"));
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CompaniasClass cr = new CompaniasClass();
                cr.delete(Integer.parseInt(textIdCompania.getText()));
            }
        });
        contentPane.add(btnEliminar);

        JButton btnActualizar = new JButton("");
        btnActualizar.setBounds(282, 221, 113, 78);
        btnActualizar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-actualizar-en-la-nube-50.png"));
        btnActualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CompaniasClass cr = new CompaniasClass();
                cr.update(Integer.parseInt(textIdCompania.getText()), textRazonSocial.getText(), 
                          textDireccion.getText(), textCorreo.getText(), textTelefono.getText(), 
                          textFechacreacion.getText(), textWeb.getText());
            }
        });
        contentPane.add(btnActualizar);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmCompanias frame = new FrmCompanias();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

	public static void setDefaultLookAndFeelDecorated(int disposeOnClose) {
		// TODO Auto-generated method stub
		
	}
}
