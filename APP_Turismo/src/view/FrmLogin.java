package view;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import Metodos.Conexion;

public class FrmLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	Conexion conector = new Conexion();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(120, 70, 70, 14);
		contentPane.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(200, 67, 120, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setBounds(120, 100, 80, 14);
		contentPane.add(lblContraseña);

		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(200, 97, 120, 20);
		contentPane.add(txtContraseña);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(160, 160, 110, 30);
		contentPane.add(btnIngresar);

		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String usuario = txtUsuario.getText();
				String contraseña = new String(txtContraseña.getPassword());

				try {
					Connection conn = conector.conectarBD();
					String query = "SELECT rol FROM tblusuarios WHERE nombre = ? AND contraseña = ?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, usuario);
					pst.setString(2, contraseña);

					ResultSet rs = pst.executeQuery();

					if (rs.next()) {
						String rol = rs.getString("rol");

						if (rol.equalsIgnoreCase("Administrador")) {
							JOptionPane.showMessageDialog(null, "Bienvenido Administrador");
							new FrmAdministrador().setVisible(true);
							dispose();
						} else if (rol.equalsIgnoreCase("Usuario")) {
							JOptionPane.showMessageDialog(null, "Bienvenido Usuario");
							new FrmUsuario().setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Rol no reconocido");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
					}

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
					ex.printStackTrace();
				}
			}
		});
	}
}
