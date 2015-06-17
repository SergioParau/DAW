package interfazUsuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import conexionBD.Autenticacion;
import conexionBD.ConexionesCliente;

@SuppressWarnings("serial")
public class MenuClienteCompra extends JFrame {

	// ATRIBUTOS//

	private JTextField titular, cvv;

	private JComboBox numEntradas, dia, mes, anyo, formaPago, tipoTarjeta,
			tipoEntrada;

	private static final String NO_SELECCIONABLE_TICKETS = "0";
	private static final String NO_SELECCIONABLE_DIA = "Dia";
	private static final String NO_SELECCIONABLE_MES = "Mes";
	private static final String NO_SELECCIONABLE_ANYO = "Año";
	private static final String NO_SELECCIONABLE_PAGO = "Pago";
	private static final String NO_SELECCIONABLE_TIPO = "Tarjeta";
	private static final String NO_SELECCIONABLE_ENTRADA = "Entrada";

	private int[] tickets = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	private int[] diaC = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
			16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
	private String[] mesC = { "Enero", "Febrero", "Marzo", "Abril", "Mayo",
			"Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
			"Diciembre" };
	private int[] anyoC = { 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022,
			2023, 2024, 2025 };
	private String[] formaPagoT = { "Tarjeta de débito", "Tarjeta de crédito",
			"PayPal" };
	private String[] tipoTarjetaT = { "Visa", "Mastercard" };

	private String[] tipoEntradaC = { "General", "VIP" };

	private JButton comprar, atrasMenu, logOut;

	private static String nombreEvento;

	// FUENTES Y BORDER-STYLING
	Font helveticaN = new Font("Helvetica", Font.PLAIN, 15);
	Font helveticaM = new Font("Helvetica", Font.PLAIN, 20);
	Font helveticaXS = new Font("Helvetica", Font.PLAIN, 12);
	Border line = BorderFactory.createEmptyBorder();
	Border empty = new EmptyBorder(0, 5, 0, 0);
	Border textArea = new EmptyBorder(5, 5, 0, 0);
	CompoundBorder border = new CompoundBorder(line, empty);
	CompoundBorder borderArea = new CompoundBorder(line, textArea);

	@SuppressWarnings({ "unchecked" })
	public MenuClienteCompra(String nombreEvento) {

		super("Compra de entradas en TicketNinja");

		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(150, 0);
		this.setSize(1000, 650);
		this.getContentPane().setBackground(Color.decode("#77DEFF"));
		MenuClienteCompra.nombreEvento = nombreEvento;

		// IMAGEN
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(Login.class
				.getResource("/lib/logoPNGresize.png")));
		imagen.setBounds(380, 10, 285, 160);
		getContentPane().add(imagen);

		// BOTON ATRAS

		atrasMenu = new JButton("<< Atrás");
		atrasMenu.setBounds(30, 50, 90, 35);
		atrasMenu.setFocusPainted(false);
		atrasMenu.setFont(helveticaXS);
		atrasMenu.setFocusPainted(false);
		atrasMenu.setContentAreaFilled(true);
		atrasMenu.setBorderPainted(false);
		atrasMenu.setOpaque(true);
		atrasMenu.setBackground(Color.decode("#2E93B2"));
		add(atrasMenu);
		atrasMenu.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				atrasMenu.setBackground(Color.decode("#2E93B2"));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				atrasMenu.setBackground(Color.decode("#195061"));
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				atrasMenu.setBackground(Color.decode("#195061"));
			}
		});
		atrasMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuCliente atras = new MenuCliente();
				atras.frame.setVisible(true);

			}
		});

		JLabel datosTarjeta = new JLabel("Introduce los datos de tu tarjeta");
		datosTarjeta.setBounds(350, 200, 250, 20);
		datosTarjeta.setFont(helveticaN);
		add(datosTarjeta);

		// CAMPO TITULAR
		titular = new JTextField("Titular");
		titular.setBounds(350, 225, 250, 40);
		titular.setFont(helveticaN);
		titular.setBorder(border);
		titular.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (titular.getText().trim().equals("Titular")) {
					titular.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (titular.getText().trim().equals("")) {
					titular.setText("Titular");
				}
			}
		});
		add(titular);

		cvv = new JTextField("CVV");
		cvv.setBounds(610, 225, 50, 40);
		cvv.setFont(helveticaN);
		cvv.setBorder(border);
		cvv.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (cvv.getText().trim().equals("CVV")) {
					cvv.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (cvv.getText().trim().equals("")) {
					cvv.setText("CVV");
				}
			}
		});
		add(cvv);

		// CAMPO TIPOTARJETA
		tipoTarjeta = new JComboBox();
		tipoTarjeta.addItem(NO_SELECCIONABLE_TIPO);
		for (int i = 0; i < tipoTarjetaT.length; i++) {
			tipoTarjeta.addItem(tipoTarjetaT[i]);

		}

		tipoTarjeta.setBounds(350, 275, 130, 40);
		tipoTarjeta.setFont(helveticaN);
		tipoTarjeta.setOpaque(true);
		tipoTarjeta.setBackground(Color.decode("#2E93B2"));
		add(tipoTarjeta);

		// CAMPO TIPOTARJETA
		formaPago = new JComboBox();
		formaPago.addItem(NO_SELECCIONABLE_PAGO);
		for (int i = 0; i < formaPagoT.length; i++) {
			formaPago.addItem(formaPagoT[i]);

		}

		formaPago.setBounds(490, 275, 170, 40);
		formaPago.setFont(helveticaN);
		formaPago.setOpaque(true);
		formaPago.setBackground(Color.decode("#2E93B2"));
		add(formaPago);

		// FECHA DE CADUCIDAD

		JLabel fechaCad = new JLabel("Fecha de caducidad");
		fechaCad.setBounds(350, 330, 250, 20);
		fechaCad.setFont(helveticaN);
		add(fechaCad);

		// COMBOS DIA-MES-AÑO

		dia = new JComboBox();
		dia.addItem(NO_SELECCIONABLE_DIA);
		for (int i = 0; i < diaC.length; i++) {
			dia.addItem(diaC[i]);

		}

		dia.setBounds(350, 355, 75, 40);
		dia.setFont(helveticaN);
		dia.setOpaque(true);
		dia.setBackground(Color.decode("#2E93B2"));
		add(dia);

		mes = new JComboBox();
		mes.addItem(NO_SELECCIONABLE_MES);
		for (int i = 0; i < mesC.length; i++) {
			mes.addItem(mesC[i]);

		}

		mes.setBounds(435, 355, 125, 40);
		mes.setFont(helveticaN);
		mes.setOpaque(true);
		mes.setBackground(Color.decode("#2E93B2"));
		add(mes);

		anyo = new JComboBox();
		anyo.addItem(NO_SELECCIONABLE_ANYO);
		for (int i = 0; i < anyoC.length; i++) {
			anyo.addItem(anyoC[i]);

		}

		anyo.setBounds(570, 355, 90, 40);
		anyo.setFont(helveticaN);
		anyo.setOpaque(true);
		anyo.setBackground(Color.decode("#2E93B2"));
		add(anyo);

		// NUMERO ENTRADAS

		JLabel numTickets = new JLabel("Número de entradas");
		numTickets.setBounds(350, 410, 250, 20);
		numTickets.setFont(helveticaN);
		add(numTickets);

		numEntradas = new JComboBox();
		numEntradas.addItem(NO_SELECCIONABLE_TICKETS);
		for (int i = 0; i < tickets.length; i++) {
			numEntradas.addItem(tickets[i]);

		}

		numEntradas.setBounds(350, 430, 75, 40);
		numEntradas.setFont(helveticaN);
		numEntradas.setOpaque(true);
		numEntradas.setBackground(Color.decode("#2E93B2"));
		add(numEntradas);

		JLabel tipoEntradas = new JLabel("Tipo de entrada");
		tipoEntradas.setBounds(510, 410, 250, 20);
		tipoEntradas.setFont(helveticaN);
		add(tipoEntradas);

		tipoEntrada = new JComboBox();
		tipoEntrada.addItem(NO_SELECCIONABLE_ENTRADA);
		for (int i = 0; i < tipoEntradaC.length; i++) {
			tipoEntrada.addItem(tipoEntradaC[i]);
		}
		tipoEntrada.setBounds(510, 430, 150, 40);
		tipoEntrada.setFont(helveticaN);
		tipoEntrada.setOpaque(true);
		tipoEntrada.setBackground(Color.decode("#2E93B2"));
		add(tipoEntrada);

		// BOTON COMPRA
		comprar = new JButton("COMPRAR");
		comprar.setBounds(350, 490, 310, 50);
		comprar.setFont(helveticaN);
		comprar.setFocusPainted(false);
		comprar.setContentAreaFilled(true);
		comprar.setBorderPainted(false);
		comprar.setOpaque(true);
		comprar.setBackground(Color.decode("#2E93B2"));
		comprar.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				comprar.setBackground(Color.decode("#2E93B2"));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				comprar.setBackground(Color.decode("#195061"));
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				comprar.setBackground(Color.decode("#195061"));
			}
		});
		comprar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (titular.getText().equals("Titular")
						|| cvv.getText().equals("CVV")
						|| formaPago.getSelectedItem().equals("Pago")
						|| tipoTarjeta.getSelectedItem().equals("Tarjeta")
						|| dia.getSelectedItem().equals("Dia")
						|| mes.getSelectedItem().equals("Mes")
						|| anyo.getSelectedItem().equals("Año")
						|| numEntradas.getSelectedItem().equals(0)
						|| tipoEntrada.getSelectedItem().equals("Entrada")) {
					JOptionPane.showMessageDialog(null,
							"Revisa los datos! Algún campo no es correcto!");
				} else {

					try {
						comprarEntrada();
					} catch (ParseException e1) {
						
						e1.printStackTrace();
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		add(comprar);

		this.setVisible(true);
	}

	public void comprarEntrada() throws ParseException, NumberFormatException, IOException {

		/*
		 * CONVERSION FECHA JAVA-SQL
		 */
		
		
		SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MMMM-dd");
		String fechaString = anyo.getSelectedItem() + "-" + mes.getSelectedItem() + "-"
				+ dia.getSelectedItem();
		Date fecha = formatFecha.parse(fechaString);
		java.sql.Date caducidadSQL = new java.sql.Date(fecha.getTime());

		/*
		 * EN ESTE BLOQUE, EL SISTEMA PIDE AL USUARIO QUE INTRODUZCA SU
		 * CONTRASEÑA PARA PROCEDER A LA COMPRA.
		 */

		ConexionesCliente compra = new ConexionesCliente();
		JPasswordField pw = new JPasswordField();

		if (Autenticacion.getAuth().isAuthenticated()) {

			int result = JOptionPane.showConfirmDialog(null, pw,
					"Introduce tu contraseña de usuario",
					JOptionPane.OK_CANCEL_OPTION);

			String passSuplied = new String(pw.getPassword());

			if (result == JOptionPane.OK_OPTION) {
				if (compra.checkPassword(passSuplied)) {
					if (tipoEntrada.getSelectedItem().equals("General")) {
						if (compra.quedanEntradasGen(nombreEvento, Integer
								.parseInt(numEntradas.getSelectedItem()
										.toString()))) {
							compra.comprarEntrada(passSuplied, nombreEvento,
									(String) formaPago.getSelectedItem(),
									caducidadSQL, Integer.parseInt(cvv
											.getText()), (String) tipoTarjeta
											.getSelectedItem(),
									(String) tipoEntrada.getSelectedItem(),
									Integer.parseInt(numEntradas
											.getSelectedItem().toString()));
							JOptionPane
									.showMessageDialog(
											null,
											"La compra ha sido realizada! "
													+ "Imprime tu entrada para acceder al establecimiento");
							dispose();
							MenuCliente logOut = new MenuCliente();
							logOut.frame.setVisible(true);
						} else {
							JOptionPane
									.showMessageDialog(
											null,
											"No quedan entradas Generales!"
													+ "Por favor, selecciona otro tipo de entrada.");
						}
					} else if (tipoEntrada.getSelectedItem().equals("VIP")) {
						if (compra.quedanEntradasVip(nombreEvento, Integer
								.parseInt(numEntradas.getSelectedItem()
										.toString()))) {
							compra.comprarEntrada(passSuplied, nombreEvento,
									formaPago.getSelectedItem().toString(),
									caducidadSQL, Integer.parseInt(cvv
											.getText()), tipoTarjeta
											.getSelectedItem().toString(),
									tipoEntrada.getSelectedItem().toString(),
									Integer.parseInt(numEntradas
											.getSelectedItem().toString()));
							JOptionPane
									.showMessageDialog(
											null,
											"La compra ha sido realizada! "
													+ "Imprime tu entrada para acceder al establecimiento");
							dispose();
							MenuCliente logOut = new MenuCliente();
							logOut.frame.setVisible(true);
						} else {
							JOptionPane
									.showMessageDialog(
											null,
											"No quedan entradas VIP!"
													+ "Por favor, selecciona otro tipo de entrada.");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Lo siento. Contraseña incorrecta");
				}
			} else {

			}
		} else {

			if (tipoEntrada.getSelectedItem().equals("General")) {
				if (compra.quedanEntradasGen(nombreEvento, Integer
						.parseInt(numEntradas.getSelectedItem().toString()))) {
					compra.comprarEntradaNoReg(titular.getText(), nombreEvento,
							(String) formaPago.getSelectedItem(), caducidadSQL,
							Integer.parseInt(cvv.getText()),
							(String) tipoTarjeta.getSelectedItem(),
							(String) tipoEntrada.getSelectedItem(), Integer
									.parseInt(numEntradas.getSelectedItem()
											.toString()));
					JOptionPane
							.showMessageDialog(
									null,
									"La compra ha sido realizada! "
											+ "Imprime tu entrada para acceder al establecimiento");
					dispose();
					MenuCliente logOut = new MenuCliente();
					logOut.frame.setVisible(true);
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"No quedan entradas Generales!"
											+ "Por favor, selecciona otro tipo de entrada.");
				}
			} else if (tipoEntrada.getSelectedItem().equals("VIP")) {
				if (compra.quedanEntradasVip(nombreEvento, Integer
						.parseInt(numEntradas.getSelectedItem().toString()))) {
					compra.comprarEntradaNoReg(titular.getText(), nombreEvento,
							(String) formaPago.getSelectedItem(), caducidadSQL,
							Integer.parseInt(cvv.getText()),
							(String) tipoTarjeta.getSelectedItem(),
							(String) tipoEntrada.getSelectedItem(), Integer
									.parseInt(numEntradas.getSelectedItem()
											.toString()));
					JOptionPane
							.showMessageDialog(
									null,
									"La compra ha sido realizada! "
											+ "Imprime tu entrada para acceder al establecimiento");
					dispose();
					MenuCliente logOut = new MenuCliente();
					logOut.frame.setVisible(true);
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"No quedan entradas VIP!"
											+ "Por favor, selecciona otro tipo de entrada.");
				}
			}

		}
	}
	public static void main(String [] args){
		MenuClienteCompra test = new MenuClienteCompra(nombreEvento);
	}

}
