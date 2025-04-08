package view;

import javax.swing.*;

import Model.AgenciasClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmAgencias extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textNombre, textDireccion, textCorreo, textTelefono, textWeb, textIdCompania;

    public FrmAgencias() {
        setTitle("Gestión de Agencias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("Nombre:");
        label.setBounds(107, 11, 63, 24);
        contentPane.add(label);
        textNombre = new JTextField();
        textNombre.setBounds(180, 11, 129, 24);
        contentPane.add(textNombre);

        JLabel label_1 = new JLabel("Dirección:");
        label_1.setBounds(107, 48, 63, 24);
        contentPane.add(label_1);
        textDireccion = new JTextField();
        textDireccion.setBounds(179, 46, 129, 24);
        contentPane.add(textDireccion);

        JLabel label_2 = new JLabel("Correo:");
        label_2.setBounds(107, 83, 63, 24);
        contentPane.add(label_2);
        textCorreo = new JTextField();
        textCorreo.setBounds(180, 81, 129, 24);
        contentPane.add(textCorreo);

        JLabel label_3 = new JLabel("Teléfono:");
        label_3.setBounds(107, 117, 63, 24);
        contentPane.add(label_3);
        textTelefono = new JTextField();
        textTelefono.setBounds(180, 116, 129, 24);
        contentPane.add(textTelefono);

        JLabel label_4 = new JLabel("Web:");
        label_4.setBounds(107, 152, 63, 24);
        contentPane.add(label_4);
        textWeb = new JTextField();
        textWeb.setBounds(180, 151, 129, 24);
        contentPane.add(textWeb);

        JLabel label_5 = new JLabel("ID Compañía:");
        label_5.setBounds(107, 187, 86, 24);
        contentPane.add(label_5);
        textIdCompania = new JTextField();
        textIdCompania.setBounds(180, 186, 129, 24);
        contentPane.add(textIdCompania);

        JButton btnGuardar = new JButton("");
        btnGuardar.setBounds(37, 222, 113, 78);
        btnGuardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-documento-67.png"));
        btnGuardar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		AgenciasClass cr = new AgenciasClass();
				cr.create(textNombre.getText(), textDireccion.getText(), textCorreo.getText(), textTelefono.getText(), textWeb.getText(),Integer.parseInt(textIdCompania.getText()));
			}
		});
        contentPane.add(btnGuardar);
        
        JButton btneliminar = new JButton("");
        btneliminar.setBounds(160, 222, 113, 78);
        btneliminar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-full-trash-64.png"));
        btneliminar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		
        		
        	}
        });
        contentPane.add(btneliminar);
        
        JButton btnupgrate = new JButton("");
        btnupgrate.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	}
        });
        btnupgrate.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-actualizar-en-la-nube-50.png"));
        btnupgrate.setBounds(283, 222, 113, 78);
        contentPane.add(btnupgrate);
    }

    private void guardarAgencia() {
        String nombre = textNombre.getText();
        String direccion = textDireccion.getText();
        String correo = textCorreo.getText();
        String telefono = textTelefono.getText();
        String web = textWeb.getText();
        int idCompania = Integer.parseInt(textIdCompania.getText());

        AgenciasClass cr = new AgenciasClass();
        cr.create(nombre, direccion, correo, telefono, web, idCompania);
    }
}