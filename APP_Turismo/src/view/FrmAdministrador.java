package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Metodos.Conexion;

import java.awt.EventQueue;
import java.awt.event.*;
import java.nio.channels.Selector;
import java.sql.*;

public class FrmAdministrador extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	public int selector; 

	public FrmAdministrador() {
		setTitle("Panel Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 180, 850, 253);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnAgencias = new JButton("");
		btnAgencias.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-proteger-48.png"));
		btnAgencias.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblagencias");
				selector = 1;
			}
		});
		btnAgencias.setBounds(30, 11, 89, 57);
		contentPane.add(btnAgencias);

		JButton btnClientes = new JButton("");
		btnClientes.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-clientes-50.png"));
		btnClientes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblclientes");
				selector = 2;
			}
		});
		btnClientes.setBounds(146, 11, 89, 57);
		contentPane.add(btnClientes);

		JButton btnCompanias = new JButton("");
		btnCompanias.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-latam-airlines-48.png"));
		btnCompanias.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblcompanias");
				selector = 3;
			}
		});
		btnCompanias.setBounds(273, 11, 89, 57);
		contentPane.add(btnCompanias);

		JButton btnDestinos = new JButton("");
		btnDestinos.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-travel-itinerary-64.png"));
		btnDestinos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tbldestinos");
				selector = 4;
			}
		});
		btnDestinos.setBounds(394, 11, 89, 57);
		contentPane.add(btnDestinos);

		JButton btnMedios = new JButton("");
		btnMedios.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-medios-de-comunicación-48.png"));
		btnMedios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblmedios");
				selector = 5;
			}
		});
		btnMedios.setBounds(515, 11, 89, 57);
		contentPane.add(btnMedios);

		JButton btnPaquetes = new JButton("");
		btnPaquetes.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-trave-diary-48.png"));
		btnPaquetes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblpaquetes");
				selector = 6;
			}
		});
		btnPaquetes.setBounds(635, 11, 89, 57);
		contentPane.add(btnPaquetes);

		JButton btnPromotores = new JButton("");
		btnPromotores.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-promoter-65.png"));
		btnPromotores.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblpromotores");
				selector = 7;
			}
		});
		btnPromotores.setBounds(30, 79, 89, 74);
		contentPane.add(btnPromotores);

		JButton btnTipoDocumento = new JButton("");
		btnTipoDocumento.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-product-documents-64.png"));
		btnTipoDocumento.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tbltipodocumento");
				selector = 8;
			}
		});
		btnTipoDocumento.setBounds(146, 79, 89, 74);
		contentPane.add(btnTipoDocumento);

		JButton btnTiposMedios = new JButton("");
		btnTiposMedios.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-mosaico-50.png"));
		btnTiposMedios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tbltiposmedios");
				selector = 9;
			}
		});
		btnTiposMedios.setBounds(273, 79, 89, 74);
		contentPane.add(btnTiposMedios);

		JButton btnTipoTransporte = new JButton("");
		btnTipoTransporte.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-vehicles-64.png"));
		btnTipoTransporte.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tbltipotransporte");
				selector = 10;
			}
		});
		btnTipoTransporte.setBounds(394, 79, 89, 74);
		contentPane.add(btnTipoTransporte);

		JButton btnUsuarios = new JButton("");
		btnUsuarios.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-usuarios-50.png"));
		btnUsuarios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblusuarios");
				selector = 11;
			}
		});
		btnUsuarios.setBounds(515, 79, 89, 74);
		contentPane.add(btnUsuarios);

		JButton btnVehiculo = new JButton("");
		btnVehiculo.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-híbrido-50.png"));
		btnVehiculo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarTabla("tblvehiculo");
				selector = 12;
			}
		});
		btnVehiculo.setBounds(635, 79, 89, 74);
		contentPane.add(btnVehiculo);
		
		JButton btneditar = new JButton("");
		btneditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmAgencias frmAgencias = new FrmAgencias();
				FrmClientes frmClientes = new FrmClientes();
				FrmCompanias frmCompanias = new FrmCompanias();
				FrmDestinos frmDestinos = new FrmDestinos();
				FrmLogin frmLogin = new FrmLogin();
				FrmMedios frmMedios = new FrmMedios();
				FrmPanel frmPanel = new FrmPanel();
				FrmPaquetes frmPaquetes = new FrmPaquetes();
				FrmPromotores frmPromotores = new FrmPromotores();
				FrmTipoDocumento frmTipoDocumento = new FrmTipoDocumento();
				FrmTiposMedios frmTiposMedios = new FrmTiposMedios();
				FrmTipoTransporte frmTipoTransporte = new FrmTipoTransporte();
				FrmUsuario frmUsuario = new FrmUsuario();
				FrmVehiculo frmVehiculo = new FrmVehiculo();
				
				if(selector != 0) {
				switch (selector) {
					case 1 -> {
						FrmAgencias.setDefaultLookAndFeelDecorated(JFrame.DISPOSE_ON_CLOSE);
						FrmAgencias frmAgencias2 = new FrmAgencias();
						frmAgencias2.setVisible(true);
					}
					case 2 -> {
						FrmClientes.setDefaultLookAndFeelDecorated(JFrame.DISPOSE_ON_CLOSE);
						FrmClientes frmClientes2 = new FrmClientes();
						frmClientes2.setVisible(true);
					}
					case 3 -> {
						FrmCompanias.setDefaultLookAndFeelDecorated(JFrame.DISPOSE_ON_CLOSE);
						FrmClientes frmCompanias2 = new FrmClientes();
						frmCompanias2.setVisible(true);	
					}
					case 4 -> {
						frmDestinos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						FrmDestinos frmDestinos2 = new FrmDestinos();
						frmDestinos2.setVisible(true);
					}
					case 5 -> {
						frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						FrmLogin frmLogin2 = new FrmLogin();
						frmLogin2.setVisible(true);
					}
					case 6 -> {
						frmMedios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						FrmMedios frmMedios2 = new FrmMedios();
						frmMedios2.setVisible(true);
					}
					case 7 -> {
						frmPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						FrmPanel frmPanel2 = new FrmPanel();
						frmPanel2.setVisible(true);
					}
					case 8 -> {
						frmPaquetes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						FrmPaquetes frmPaquetes2 = new FrmPaquetes();
						frmPaquetes2.setVisible(true);
					}
					case 9 -> {
						frmPromotores.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						FrmPromotores frmPromotores2 = new FrmPromotores();
						frmPromotores2.setVisible(true);
					}
					case 10 -> {
						frmTipoDocumento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						FrmTipoDocumento frmTipoDocumento2 = new FrmTipoDocumento();
						frmTipoDocumento2.setVisible(true);
					}
					case 11 -> {
						frmTiposMedios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						FrmTiposMedios frmTiposMedios2 = new FrmTiposMedios();
						frmTiposMedios2.setVisible(true);
					}
					case 12 -> {
						frmTipoTransporte.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						FrmTipoTransporte frmTipoTransporte2 = new FrmTipoTransporte();
						frmTipoTransporte2.setVisible(true);
					}
					case 13 -> {
						frmUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						FrmUsuario frmUsuario2 = new FrmUsuario();
						frmUsuario2.setVisible(true);
					}
					case 14 -> {
						frmVehiculo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						FrmVehiculo frmVehiculo2 = new FrmVehiculo();
						frmVehiculo2.setVisible(true);
					}
					default -> {
						JOptionPane.showMessageDialog(null, "Opción no válida.");
					}
					}
				}
			}
		});
		btneditar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-editor-50.png"));
		btneditar.setBounds(788, 39, 70, 57);
		contentPane.add(btneditar);
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
