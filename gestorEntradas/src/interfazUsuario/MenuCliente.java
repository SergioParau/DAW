package interfazUsuario;

//import TableModel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.JComboBox;

import com.toedter.calendar.JCalendar;

import conexionBD.ConexionesCliente;

import javax.swing.JRadioButton;

import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

public class MenuCliente extends JFrame {

	// FUENTES Y BORDER-STYLING
	Font helveticaN = new Font("Helvetica", Font.PLAIN, 15);
	Font helveticaM = new Font("Helvetica", Font.PLAIN, 20);
	Font helveticaXS = new Font("Helvetica", Font.PLAIN, 12);
	Border line = BorderFactory.createEmptyBorder();
	Border empty = new EmptyBorder(0, 5, 0, 0);
	Border textArea = new EmptyBorder(5, 5, 0, 0);
	CompoundBorder border = new CompoundBorder(line, empty);
	CompoundBorder borderArea = new CompoundBorder(line, textArea);

	public JFrame frame;
	private JTextField textFieldNombre;
	private JRadioButton radioButtonnombre;
	private JRadioButton radioButtonfecha;
	private JComboBox comboBox;
	private JCalendar fechaIni, fechaFin;
	private JTable table;
	private ResultSet rs;
	private JButton botonBuscar, botonNext, logOut;

	ConexionesCliente conexion = new ConexionesCliente();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MenuCliente window = new MenuCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(0, 0, 936, 669);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.decode("#77DEFF"));
		frame.getContentPane().setLayout(null);

		// IMAGEN
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(Login.class
				.getResource("/lib/logoPNGresize.png")));
		imagen.setBounds(350, 0, 265, 140);
		frame.getContentPane().add(imagen);

		// Escribir nombre de evento
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(40, 190, 250, 30);
		frame.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.setFont(helveticaN);
		textFieldNombre.setBorder(border);
		textFieldNombre.setEnabled(false);

		// ComboBox Tipo de evento
		comboBox = new JComboBox();
		comboBox.setBounds(770, 360, 130, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Conciertos");
		comboBox.addItem("Deportes");
		comboBox.addItem("Teatro");
		comboBox.addItem("Cine");
		comboBox.addItem("Ópera");
		comboBox.addItem("Circo");
		comboBox.setFont(helveticaN);
		comboBox.setOpaque(true);
		comboBox.setBackground(Color.decode("#2E93B2"));
		comboBox.setEnabled(false);

		// JCalendar
		fechaIni = new JCalendar();
		fechaIni.setBounds(400, 200, 250, 153);
		fechaIni.setBackground(Color.decode("#2E93B2"));
		frame.getContentPane().add(fechaIni);
		fechaIni.setEnabled(false);

		fechaFin = new JCalendar();
		fechaFin.setBounds(660, 200, 250, 153);
		fechaFin.setBackground(Color.decode("#2E93B2"));
		frame.getContentPane().add(fechaFin);
		fechaFin.setEnabled(false);

		// radioButton NOMBRE
		radioButtonnombre = new JRadioButton("Buscar por nombre");
		radioButtonnombre.setBounds(34, 160, 184, 23);
		radioButtonnombre.setFont(helveticaN);
		frame.getContentPane().add(radioButtonnombre);
		radioButtonnombre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (radioButtonnombre.isSelected()) {
					textFieldNombre.setEnabled(true);
					fechaIni.setEnabled(false);
					fechaFin.setEnabled(false);
					comboBox.setEnabled(false);
				}

			}
		});

		// radiobutton FECHA y TIPO
		radioButtonfecha = new JRadioButton("Buscar por fecha y tipo");
		radioButtonfecha.setBounds(730, 160, 184, 23);
		radioButtonfecha.setFont(helveticaN);
		frame.getContentPane().add(radioButtonfecha);
		radioButtonfecha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (radioButtonfecha.isSelected()) {
					fechaIni.setEnabled(true);
					fechaFin.setEnabled(true);
					comboBox.setEnabled(true);
					textFieldNombre.setEnabled(false);
				}
			}
		});

		ButtonGroup group = new ButtonGroup();
		group.add(radioButtonnombre);
		group.add(radioButtonfecha);

		JLabel lblSeleccione = new JLabel("Eventos existentes entre:");
		lblSeleccione.setBounds(400, 160, 184, 14);
		lblSeleccione.setFont(helveticaN);
		frame.getContentPane().add(lblSeleccione);

		Label label_1 = new Label("Inicio");
		label_1.setBounds(400, 180, 184, 22);
		label_1.setFont(helveticaN);
		frame.getContentPane().add(label_1);

		Label label_2 = new Label("Fin");
		label_2.setBounds(660, 180, 184, 22);
		label_2.setFont(helveticaN);
		frame.getContentPane().add(label_2);

		Label label = new Label("Tipo de evento:");
		label.setBounds(660, 360, 100, 22);
		label.setFont(helveticaN);
		label.setBackground(null);
		frame.getContentPane().add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 456, 870, 160);
		frame.getContentPane().add(scrollPane);

		// tabla de eventos
		table = new JTable();
		table.setBounds(45, 200, 700, 60);
		scrollPane.setViewportView(table);

		// BOTON LOG OUT
		logOut = new JButton("Log Out");
		logOut.setBounds(815, 11, 89, 23);
		logOut.setFocusPainted(false);
		logOut.setFont(helveticaXS);
		logOut.setFocusPainted(false);
		logOut.setContentAreaFilled(true);
		logOut.setBorderPainted(false);
		logOut.setOpaque(true);
		logOut.setBackground(Color.decode("#2E93B2"));
		frame.getContentPane().add(logOut);
		logOut.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				logOut.setBackground(Color.decode("#2E93B2"));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				logOut.setBackground(Color.decode("#195061"));
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				logOut.setBackground(Color.decode("#195061"));
			}
		});
		logOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				Login atrasLogin = new Login();
				atrasLogin.setVisible(true);

			}
		});

		// BOTON SIGUIENTE
		botonNext = new JButton("Siguiente");
		botonNext.setBounds(773, 422, 130, 30);
		botonNext.setFocusPainted(false);
		botonNext.setFont(helveticaN);
		botonNext.setFocusPainted(false);
		botonNext.setContentAreaFilled(true);
		botonNext.setBorderPainted(false);
		botonNext.setOpaque(true);
		botonNext.setBackground(Color.decode("#2E93B2"));
		frame.getContentPane().add(botonNext);
		botonNext.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				botonNext.setBackground(Color.decode("#2E93B2"));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				botonNext.setBackground(Color.decode("#195061"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonNext.setBackground(Color.decode("#2E93B2"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				botonNext.setBackground(Color.decode("#195061"));
			}
		});

		botonNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (!textFieldNombre.getText().equals("")
						|| comboBox.isEnabled()
						|| textFieldNombre.isEnabled()) {
					String nom = (String) table.getValueAt(
							table.getSelectedRow(), 0);
					if (conexion.entradasVenta(nom)) {
						frame.setVisible(false);
						MenuClienteCompra compra = new MenuClienteCompra(nom);
						compra.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,
								"Las entradas de este evento "
										+ "todavía no están a la venta!");
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"Por favor, selecciona primero un evento");
				}
			}

		});// FIN ACTIONLISTENER

		// BOTON BUSCAR
		botonBuscar = new JButton("Buscar");
		botonBuscar.setBounds(290, 400, 350, 50);
		botonBuscar.setFocusPainted(false);
		botonBuscar.setFont(helveticaM);
		botonBuscar.setFocusPainted(false);
		botonBuscar.setContentAreaFilled(true);
		botonBuscar.setBorderPainted(false);
		botonBuscar.setOpaque(true);
		botonBuscar.setBackground(Color.decode("#2E93B2"));
		frame.getContentPane().add(botonBuscar);
		botonBuscar.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				botonBuscar.setBackground(Color.decode("#2E93B2"));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				botonBuscar.setBackground(Color.decode("#195061"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonBuscar.setBackground(Color.decode("#2E93B2"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				botonBuscar.setBackground(Color.decode("#195061"));
			}
		});

		botonBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (radioButtonnombre.isSelected()) {
					if (textFieldNombre.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Introduce el nombre de algún evento");
					} else {
						TableModel tm = conexion.buscarEvento(textFieldNombre
								.getText());
						// muestra en la tabla los resultados

						table.setModel(tm);
					}
				} else if (radioButtonfecha.isSelected()) {

					// pasar el item seleccionado de combobox a string
					String tipoEvento = (String) comboBox.getSelectedItem();

					// pasar fecha de inicio y fin del jcalendar a java.util y
					// luego a java.sql
					java.util.Date inicio_util = fechaIni.getDate();
					java.sql.Date inicio_sql = new java.sql.Date(inicio_util
							.getTime());

					java.util.Date fin_util = fechaFin.getDate();
					java.sql.Date fin_sql = new java.sql.Date(fin_util
							.getTime());

					// se conecta a la bd y busca por fechas y tipo
					TableModel tm = conexion.busquedaEventoFechas(tipoEvento,
							inicio_sql, fin_sql);

					// muestra en la tabla los resultados
					table.setModel(tm);

				} else {
					JOptionPane.showMessageDialog(null,
							"Por favor, selecciona un tipo de búsqueda.");
				}
			}
		});
	}
	// ====================FIN BUSCAR===========================
}
