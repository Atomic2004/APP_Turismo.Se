package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Metodos.Conexion;

import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.*;

public class FrmUsuario extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel modelo;

    public FrmUsuario() {
        setTitle("Panel Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnVehiculos = new JButton("");
        btnVehiculos.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-vehicles-64.png"));
        btnVehiculos.setBounds(293, 23, 110, 73);
        contentPane.add(btnVehiculos);

        JButton btnDestinos = new JButton("");
        btnDestinos.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-travel-itinerary-64.png"));
        btnDestinos.setBounds(166, 23, 110, 73);
        contentPane.add(btnDestinos);

        JButton btnPaquetes = new JButton("");
        btnPaquetes.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-trave-diary-48.png"));
        btnPaquetes.setBounds(30, 23, 110, 73);
        contentPane.add(btnPaquetes);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 128, 620, 192);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        btnVehiculos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarTabla("tblvehiculo");
            }
        });

        btnDestinos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarTabla("tbldestinos");
            }
        });

        btnPaquetes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarTabla("tblpaquetes");
            }
        });
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
            FrmUsuario frame = new FrmUsuario();
            frame.setVisible(true);
        });
    }
}
