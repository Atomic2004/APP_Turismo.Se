package view;

import javax.swing.*;
import Model.ClientesClass;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmClientes extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textTipoDocumento, textDocumento, textNombres, textApellidos, textEPS, textAlergias,
            textFechaNacimiento, textCorreo, textEstadoCivil, textTelefono, textDireccion, textIdCliente;

    public FrmClientes() {
        setTitle("Gestión de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTipoDocumento = new JLabel("Tipo Documento:");
        lblTipoDocumento.setBounds(30, 20, 120, 24);
        contentPane.add(lblTipoDocumento);
        textTipoDocumento = new JTextField();
        textTipoDocumento.setBounds(142, 20, 150, 24);
        contentPane.add(textTipoDocumento);

        JLabel lblDocumento = new JLabel("Documento:");
        lblDocumento.setBounds(30, 60, 120, 24);
        contentPane.add(lblDocumento);
        textDocumento = new JTextField();
        textDocumento.setBounds(142, 60, 150, 24);
        contentPane.add(textDocumento);

        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(30, 100, 120, 24);
        contentPane.add(lblNombres);
        textNombres = new JTextField();
        textNombres.setBounds(142, 100, 150, 24);
        contentPane.add(textNombres);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(30, 140, 120, 24);
        contentPane.add(lblApellidos);
        textApellidos = new JTextField();
        textApellidos.setBounds(142, 135, 150, 24);
        contentPane.add(textApellidos);

        JLabel lblEPS = new JLabel("EPS:");
        lblEPS.setBounds(30, 180, 120, 24);
        contentPane.add(lblEPS);
        textEPS = new JTextField();
        textEPS.setBounds(142, 180, 150, 24);
        contentPane.add(textEPS);

        JLabel lblAlergias = new JLabel("Alergias:");
        lblAlergias.setBounds(30, 220, 120, 24);
        contentPane.add(lblAlergias);
        textAlergias = new JTextField();
        textAlergias.setBounds(142, 220, 150, 24);
        contentPane.add(textAlergias);

        JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
        lblFechaNacimiento.setBounds(30, 260, 120, 24);
        contentPane.add(lblFechaNacimiento);
        textFechaNacimiento = new JTextField();
        textFechaNacimiento.setBounds(142, 255, 150, 24);
        contentPane.add(textFechaNacimiento);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(321, 20, 120, 24);
        contentPane.add(lblCorreo);
        textCorreo = new JTextField();
        textCorreo.setBounds(399, 20, 150, 24);
        contentPane.add(textCorreo);

        JLabel lblEstadoCivil = new JLabel("Estado Civil:");
        lblEstadoCivil.setBounds(321, 60, 120, 24);
        contentPane.add(lblEstadoCivil);
        textEstadoCivil = new JTextField();
        textEstadoCivil.setBounds(399, 60, 150, 24);
        contentPane.add(textEstadoCivil);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(321, 100, 120, 24);
        contentPane.add(lblTelefono);
        textTelefono = new JTextField();
        textTelefono.setBounds(399, 100, 150, 24);
        contentPane.add(textTelefono);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(321, 140, 120, 24);
        contentPane.add(lblDireccion);
        textDireccion = new JTextField();
        textDireccion.setBounds(399, 140, 150, 24);
        contentPane.add(textDireccion);

        JLabel lblIdCliente = new JLabel("ID Cliente:");
        lblIdCliente.setBounds(321, 220, 80, 24);
        contentPane.add(lblIdCliente);
        textIdCliente = new JTextField();
        textIdCliente.setBounds(399, 220, 120, 24);
        contentPane.add(textIdCliente);

        JButton btnGuardar = new JButton("");
        btnGuardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-documento-67.png"));
        btnGuardar.setBounds(255, 322, 97, 76);
        btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ClientesClass cl = new ClientesClass();
                cl.create(Integer.parseInt(textTipoDocumento.getText()), Integer.parseInt(textDocumento.getText()), textNombres.getText(), textApellidos.getText(), textEPS.getText(), textAlergias.getText(), textFechaNacimiento.getText(), textCorreo.getText(), textEstadoCivil.getText(), textTelefono.getText(), textDireccion.getText()
                );
            }
        });
        contentPane.add(btnGuardar);

        JButton btnEliminar = new JButton("");
        btnEliminar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-full-trash-64.png"));
        btnEliminar.setBounds(384, 322, 97, 76);
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ClientesClass cl = new ClientesClass();
                cl.delete(Integer.parseInt(textIdCliente.getText()));
            }
        });
        contentPane.add(btnEliminar);

        JButton btnActualizar = new JButton("");
        btnActualizar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-actualizar-en-la-nube-50.png"));
        btnActualizar.setBounds(126, 322, 97, 76);
        btnActualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ClientesClass cl = new ClientesClass();
                cl.update(Integer.parseInt(textTipoDocumento.getText()), Integer.parseInt(textDocumento.getText()), Integer.parseInt(textIdCliente.getText()), textApellidos.getText(), textEPS.getText(),
                    textAlergias.getText(), textFechaNacimiento.getText(), textCorreo.getText(), textEstadoCivil.getText(), textTelefono.getText(), textDireccion.getText(), textNombres.getText()
                );
            }
        });
        contentPane.add(btnActualizar);
    }

	public static void setDefaultLookAndFeelDecorated(int disposeOnClose) {
		// TODO Auto-generated method stub
		
	}
}
