package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Metodos.Conexion;

import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.*;

public class FrmAdministrador extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;

	public FrmAdministrador() {
		setTitle("Panel Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 180, 850, 270);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnAgencias = new JButton("New button");
		btnAgencias.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblagencias");
			}
		});
		btnAgencias.setBounds(30, 23, 89, 23);
		contentPane.add(btnAgencias);

		JButton btnClientes = new JButton("Clientes");
		btnClientes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblclientes");
			}
		});
		btnClientes.setBounds(164, 23, 89, 23);
		contentPane.add(btnClientes);

		JButton btnCompanias = new JButton("Compañías");
		btnCompanias.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblcompanias");
			}
		});
		btnCompanias.setBounds(296, 23, 89, 23);
		contentPane.add(btnCompanias);

		JButton btnDestinos = new JButton("Destinos");
		btnDestinos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tbldestinos");
			}
		});
		btnDestinos.setBounds(438, 23, 89, 23);
		contentPane.add(btnDestinos);

		JButton btnMedios = new JButton("Medios");
		btnMedios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblmedios");
			}
		});
		btnMedios.setBounds(581, 23, 89, 23);
		contentPane.add(btnMedios);

		JButton btnPaquetes = new JButton("Paquetes");
		btnPaquetes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblpaquetes");
			}
		});
		btnPaquetes.setBounds(734, 23, 89, 23);
		contentPane.add(btnPaquetes);

		JButton btnPromotores = new JButton("Promotores");
		btnPromotores.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblpromotores");
			}
		});
		btnPromotores.setBounds(30, 108, 89, 23);
		contentPane.add(btnPromotores);

		JButton btnTipoDocumento = new JButton("Tipo Documento");
		btnTipoDocumento.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tbltipodocumento");
			}
		});
		btnTipoDocumento.setBounds(164, 108, 89, 23);
		contentPane.add(btnTipoDocumento);

		JButton btnTiposMedios = new JButton("Tipos Medios");
		btnTiposMedios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tbltiposmedios");
			}
		});
		btnTiposMedios.setBounds(296, 108, 89, 23);
		contentPane.add(btnTiposMedios);

		JButton btnTipoTransporte = new JButton("Tipo Transporte");
		btnTipoTransporte.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tbltipotransporte");
			}
		});
		btnTipoTransporte.setBounds(438, 108, 89, 23);
		contentPane.add(btnTipoTransporte);

		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblusuarios");
			}
		});
		btnUsuarios.setBounds(581, 108, 89, 23);
		contentPane.add(btnUsuarios);

		JButton btnVehiculo = new JButton("Vehículos");
		btnVehiculo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblvehiculo");
			}
		});
		btnVehiculo.setBounds(734, 108, 89, 23);
		contentPane.add(btnVehiculo);
	}
	
	private void cargarTabla(String nombreTabla) {
		modelo = new DefaultTableModel();
		table.setModel(modelo);

		try (Connection con = new Conexion().conectarBD();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM " + nombreTabla)) {

			ResultSetMetaData meta = rs.getMetaData();
			int columnas = meta.getColumnCount();

			for (int i = 1; i <= columnas; i++) {
				modelo.addColumn(meta.getColumnName(i));
			}

			while (rs.next()) {
				Object[] fila = new Object[columnas];
				for (int i = 0; i < columnas; i++) {
					fila[i] = rs.getObject(i + 1);
				}
				modelo.addRow(fila);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			FrmAdministrador frame = new FrmAdministrador();
			frame.setVisible(true);
		});
	}
}
