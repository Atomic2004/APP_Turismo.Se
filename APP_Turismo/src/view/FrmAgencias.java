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
    private JTextField textidagencias;

    public FrmAgencias() {
        setTitle("Gestión de Agencias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel Nombre = new JLabel("Nombre:");
        Nombre.setBounds(107, 11, 63, 24);
        contentPane.add(Nombre);
        textNombre = new JTextField();
        textNombre.setBounds(180, 11, 129, 24);
        contentPane.add(textNombre);

        JLabel Direccion = new JLabel("Dirección:");
        Direccion.setBounds(107, 48, 63, 24);
        contentPane.add(Direccion);
        textDireccion = new JTextField();
        textDireccion.setBounds(179, 46, 129, 24);
        contentPane.add(textDireccion);

        JLabel correo = new JLabel("Correo:");
        correo.setBounds(107, 83, 63, 24);
        contentPane.add(correo);
        textCorreo = new JTextField();
        textCorreo.setBounds(180, 81, 129, 24);
        contentPane.add(textCorreo);

        JLabel telefono = new JLabel("Teléfono:");
        telefono.setBounds(107, 117, 63, 24);
        contentPane.add(telefono);
        textTelefono = new JTextField();
        textTelefono.setBounds(180, 116, 129, 24);
        contentPane.add(textTelefono);

        JLabel web = new JLabel("Web:");
        web.setBounds(107, 152, 63, 24);
        contentPane.add(web);
        textWeb = new JTextField();
        textWeb.setBounds(180, 151, 129, 24);
        contentPane.add(textWeb);

        JLabel idcompañias = new JLabel("ID Compañía:");
        idcompañias.setBounds(37, 187, 86, 24);
        contentPane.add(idcompañias);
        textIdCompania = new JTextField();
        textIdCompania.setBounds(117, 187, 86, 24);
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
        		AgenciasClass cr = new AgenciasClass();
        		cr.delete(Integer.parseInt(textIdCompania.getText()));
        	}
        });
        contentPane.add(btneliminar);
        
        JButton btnupgrate = new JButton("");
        btnupgrate.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		AgenciasClass cr = new AgenciasClass();
        		cr.update(Integer.parseInt(textIdCompania.getText()),textNombre.getText(), textDireccion.getText(), textCorreo.getText(), textTelefono.getText(), textWeb.getText(), Integer.parseInt(textidagencias.getText()));
        	}
        });
        btnupgrate.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-actualizar-en-la-nube-50.png"));
        btnupgrate.setBounds(283, 222, 113, 78);
        contentPane.add(btnupgrate);
        
        JLabel labidAgencias = new JLabel("ID Agencias:");
        labidAgencias.setBounds(213, 186, 86, 24);
        contentPane.add(labidAgencias);
        
        textidagencias = new JTextField();
        textidagencias.setBounds(283, 186, 86, 24);
        contentPane.add(textidagencias);
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