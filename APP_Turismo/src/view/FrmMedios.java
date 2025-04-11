package view;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.AgenciasClass;
import Model.MediosClass;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMedios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textidmedios;
	private JTextField textnombre;
	private JTextField textobservacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMedios frame = new FrmMedios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMedios() {
		setTitle("Medios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblidmedios = new JLabel("ID Medios:");
		lblidmedios.setBounds(109, 31, 83, 14);
		contentPane.add(lblidmedios);

		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setBounds(109, 56, 83, 14);
		contentPane.add(lblnombre);

		JLabel lblobservacion = new JLabel("Observacion:");
		lblobservacion.setBounds(109, 81, 83, 14);
		contentPane.add(lblobservacion);

		textidmedios = new JTextField();
		textidmedios.setBounds(202, 28, 86, 20);
		contentPane.add(textidmedios);
		textidmedios.setColumns(10);

		textnombre = new JTextField();
		textnombre.setColumns(10);
		textnombre.setBounds(202, 53, 86, 20);
		contentPane.add(textnombre);

		textobservacion = new JTextField();
		textobservacion.setColumns(10);
		textobservacion.setBounds(202, 78, 86, 20);
		contentPane.add(textobservacion);

		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-documento-67.png"));
		btnGuardar.setBounds(52, 161, 83, 78);
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MediosClass cr = new MediosClass();
				cr.create(textnombre.getText(), textobservacion.getText(), Integer.parseInt(textidmedios.getText()));
			}
		});
		contentPane.add(btnGuardar);

		JButton btneliminar = new JButton("");
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MediosClass cr = new MediosClass();
				cr.delete(Integer.parseInt(textidmedios.getText()));

			}
		});
		btneliminar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-full-trash-64.png"));
		btneliminar.setBounds(156, 161, 83, 78);
		contentPane.add(btneliminar);
		
		JButton btnupdate = new JButton("");
		btnupdate.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-actualizar-en-la-nube-50.png"));
		btnupdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MediosClass cr = new MediosClass();
				cr.update(Integer.parseInt(textidmedios.getText()), textnombre.getText(), textobservacion.getText());
				
			}
		});
		btnupdate.setBounds(262, 161, 83, 78);
		contentPane.add(btnupdate);
	}
}
