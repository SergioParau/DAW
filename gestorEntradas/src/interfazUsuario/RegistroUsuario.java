package interfazUsuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import conexionBD.Registro;
import usuarios.Usuario;

public class RegistroUsuario extends JFrame {

	// ATRIBUTOS
	JTextField nombre, apellidos, direccion, poblacion, provincia,
			codigoPostal, pais, tlf, email, nombreUsuario, dni;

	JPasswordField password;

	JCheckBox esGestor;

	JButton registrar, atrasMenu;

	private static final int MAX_INTENTOS = 3;

	// FUENTES Y BORDER-STYLING
	Font helveticaN = new Font("Helvetica", Font.PLAIN, 20);
	Font helveticaXS = new Font("Helvetica", Font.PLAIN, 15);
	Border line = BorderFactory.createEmptyBorder();
	Border empty = new EmptyBorder(0, 5, 0, 0);
	CompoundBorder border = new CompoundBorder(line, empty);

	// CONSTRUCTOR
	public RegistroUsuario() {

		super("Registro de nuevo usuario");
		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(150, 0);
		this.setSize(1280, 720);
		this.getContentPane().setBackground(Color.decode("#77DEFF"));

		// IMAGEN
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(Login.class
				.getResource("/lib/logoPNGresize.png")));
		imagen.setBounds(510, -30, 285, 160);
		getContentPane().add(imagen);

		// BOTON ATRAS

		atrasMenu = new JButton("<< Atrás");
		atrasMenu.setBounds(10, 10, 110, 30);
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
				setVisible(false);
				Login atrasLogin = new Login();
				atrasLogin.setVisible(true);

			}
		});

		/*
		 * CAMPOS DE INSERTADO DE DATOS PARA EL REGISTRO DE USUARIOS. LOS FOCUS
		 * LISTENER SIRVEN PARA DETECTAR SI EL PUNTERO ESTÃ� SOBRE UN CAMPO
		 * DETERMINADO O NO.
		 * 
		 * LOS DOCUMENT LISTENER SON PARA DETECTAR SI CADA CAMPO ES VÃ�LIDO PARA
		 * EL REGISTRO
		 */

		// CAMPO NOMBRE
		nombre = new JTextField("Nombre");
		nombre.setBounds(150, 140, 400, 40);
		nombre.setFont(helveticaN);
		nombre.setBorder(border);
		/*
		 * nombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		 * nombre.setMargin(new Insets(0, 5, 0, 0));
		 */
		nombre.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (nombre.getText().trim().equals("Nombre")) {
					nombre.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (nombre.getText().trim().equals("")) {
					nombre.setText("Nombre");
				}
			}
		});

		nombre.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				if (!nombre.getText().isEmpty()
						&& !nombre.getText().equals("Nombre")) {
					nombre.setBackground(Color.decode("#4EFF8F"));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				if (nombre.getText().isEmpty()) {
					nombre.setBackground(Color.white);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});

		add(nombre);

		// CAMPO APELLIDOS
		apellidos = new JTextField("Apellidos");
		apellidos.setBounds(700, 140, 400, 40);
		apellidos.setFont(helveticaN);
		apellidos.setBorder(border);
		apellidos.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (apellidos.getText().trim().equals("Apellidos")) {
					apellidos.setText("");

				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (apellidos.getText().trim().equals("")) {
					apellidos.setText("Apellidos");

				}
			}
		});

		apellidos.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				if (!apellidos.getText().isEmpty()
						&& !apellidos.getText().equals("Apellidos")) {
					apellidos.setBackground(Color.decode("#4EFF8F"));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				if (apellidos.getText().isEmpty()) {
					apellidos.setBackground(Color.white);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});

		add(apellidos);

		// CAMPO DIRECCION
		direccion = new JTextField("Dirección");
		direccion.setBounds(150, 220, 400, 40);
		direccion.setFont(helveticaN);
		direccion.setBorder(border);
		direccion.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (direccion.getText().trim().equals("Dirección")) {
					direccion.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (direccion.getText().trim().equals("")) {
					direccion.setText("Dirección");
				}
			}
		});

		direccion.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				if (!direccion.getText().isEmpty()
						&& !direccion.getText().equals("Dirección")) {
					direccion.setBackground(Color.decode("#4EFF8F"));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				if (direccion.getText().isEmpty()) {
					direccion.setBackground(Color.white);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});

		add(direccion);

		// CAMPO POBLACION
		poblacion = new JTextField("Población");
		poblacion.setBounds(150, 300, 400, 40);
		poblacion.setFont(helveticaN);
		poblacion.setBorder(border);
		poblacion.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (poblacion.getText().trim().equals("Población")) {
					poblacion.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (poblacion.getText().trim().equals("")) {
					poblacion.setText("Población");
				}
			}
		});

		poblacion.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				if (!poblacion.getText().isEmpty()
						&& !poblacion.getText().equals("Población")) {
					poblacion.setBackground(Color.decode("#4EFF8F"));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				if (poblacion.getText().isEmpty()) {
					poblacion.setBackground(Color.white);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});

		add(poblacion);

		// CAMPO PROVINCIA
		provincia = new JTextField("Provincia");
		provincia.setBounds(700, 300, 400, 40);
		provincia.setFont(helveticaN);
		provincia.setBorder(border);
		provincia.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (provincia.getText().trim().equals("Provincia")) {
					provincia.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (provincia.getText().trim().equals("")) {
					provincia.setText("Provincia");
				}
			}
		});

		provincia.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				if (!provincia.getText().isEmpty()
						&& !provincia.getText().equals("Provincia")) {
					provincia.setBackground(Color.decode("#4EFF8F"));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				if (provincia.getText().isEmpty()) {
					provincia.setBackground(Color.white);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});

		add(provincia);

		// CAMPO CODIGO POSTAL
		codigoPostal = new JTextField("Código Postal");
		codigoPostal.setBounds(150, 380, 400, 40);
		codigoPostal.setFont(helveticaN);
		codigoPostal.setBorder(border);
		codigoPostal.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (codigoPostal.getText().trim().equals("Código Postal")) {
					codigoPostal.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (codigoPostal.getText().trim().equals("")) {
					codigoPostal.setText("Código Postal");
				}
			}
		});

		codigoPostal.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				if (codigoPostal.getDocument().getLength() == 5) {
					codigoPostal.setBackground(Color.decode("#4EFF8F"));
				}

				if (codigoPostal.getText().isEmpty()
						|| codigoPostal.getText().equals("Código Postal")) {
					codigoPostal.setBackground(Color.white);
				}

				if (codigoPostal.getDocument().getLength() > 5
						&& !codigoPostal.getText().equals("Código Postal")) {
					codigoPostal.setBackground(Color.decode("#FF534E"));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				if (codigoPostal.getDocument().getLength() < 5) {
					codigoPostal.setBackground(Color.decode("#FF534E"));
				}

				if (codigoPostal.getDocument().getLength() == 5) {
					codigoPostal.setBackground(Color.decode("#4EFF8F"));
				}

				if (codigoPostal.getText().isEmpty()
						|| codigoPostal.getText().equals("Código Postal")) {
					codigoPostal.setBackground(Color.white);
				}

			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});

		add(codigoPostal);

		/*
		 * CAMPOS DE LA SEGUNDA COLUMNA
		 */

		// CAMPO PAIS
		pais = new JTextField("País");
		pais.setBounds(700, 380, 400, 40);
		pais.setFont(helveticaN);
		pais.setBorder(border);
		pais.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (pais.getText().trim().equals("País")) {
					pais.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (pais.getText().trim().equals("")) {
					pais.setText("País");
				}
			}
		});

		pais.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				if (!pais.getText().isEmpty() && !pais.getText().equals("País")) {
					pais.setBackground(Color.decode("#4EFF8F"));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				if (pais.getText().isEmpty()) {
					pais.setBackground(Color.white);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});

		add(pais);

		// CAMPO TELEFONO
		tlf = new JTextField("Teléfono");
		tlf.setBounds(700, 220, 400, 40);
		tlf.setFont(helveticaN);
		tlf.setBorder(border);
		tlf.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (tlf.getText().trim().equals("Teléfono")) {
					tlf.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (tlf.getText().trim().equals("")) {
					tlf.setText("Teléfono");
				}
			}
		});

		tlf.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				if (!tlf.getText().isEmpty()
						&& !tlf.getText().equals("Teléfono")) {
					tlf.setBackground(Color.decode("#4EFF8F"));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				if (tlf.getText().isEmpty()) {
					tlf.setBackground(Color.white);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});

		add(tlf);

		// CAMPO DNI
		dni = new JTextField("DNI o NIF");
		dni.setBounds(150, 460, 400, 40);
		dni.setFont(helveticaN);
		dni.setBorder(border);
		dni.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (dni.getText().trim().equals("DNI o NIF")) {
					dni.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (dni.getText().trim().equals("")) {
					dni.setText("DNI o NIF");
				}
			}
		});

		dni.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				Pattern dniReg = Pattern.compile("(\\d{8})([-]?)([A-Za-z]{1})");
				Matcher mat = dniReg.matcher(dni.getText());

				if (mat.matches()) {
					dni.setBackground(Color.decode("#4EFF8F"));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				Pattern dniReg = Pattern.compile("(\\d{8})([-]?)([A-Za-z]{1})");
				Matcher mat = dniReg.matcher(dni.getText());

				if (!mat.matches() && !dni.getText().isEmpty()) {
					dni.setBackground(Color.decode("#FF534E"));
				}

				if (dni.getText().isEmpty()
						|| dni.getText().equals("DNI o NIF")) {
					dni.setBackground(Color.white);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

				if (dni.getText().isEmpty()
						|| dni.getDocument().equals("DNI o NIF")) {
					dni.setBackground(Color.white);
				}
			}

		});

		add(dni);

		// CAMPO EMAIL
		email = new JTextField("E-mail");
		email.setBounds(700, 460, 400, 40);
		email.setFont(helveticaN);
		email.setBorder(border);
		email.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (email.getText().trim().equals("E-mail")) {
					email.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (email.getText().trim().equals("")) {
					email.setText("E-mail");
				}
			}
		});

		email.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				Pattern dniReg = Pattern
						.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
				Matcher mat = dniReg.matcher(email.getText());

				if (mat.matches()) {
					email.setBackground(Color.decode("#4EFF8F"));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				Pattern dniReg = Pattern.compile("(\\d{8})([-]?)([A-Za-z]{1})");
				Matcher mat = dniReg.matcher(email.getText());

				if (!mat.matches() && !email.getText().isEmpty()) {
					email.setBackground(Color.decode("#FF534E"));
				}

				if (email.getText().isEmpty()
						|| email.getText().equals("E-mail")) {
					email.setBackground(Color.white);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

				if (email.getText().isEmpty()
						|| email.getDocument().equals("E-mail")) {
					email.setBackground(Color.white);
				}
			}

		});

		add(email);

		// CAMPO NOMBRE DE USUARIO
		nombreUsuario = new JTextField("Nombre de Usuario");
		nombreUsuario.setBounds(150, 540, 400, 40);
		nombreUsuario.setFont(helveticaN);
		nombreUsuario.setBorder(border);
		nombreUsuario.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (nombreUsuario.getText().trim().equals("Nombre de Usuario")) {
					nombreUsuario.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (nombreUsuario.getText().trim().equals("")) {
					nombreUsuario.setText("Nombre de Usuario");
				}
			}
		});

		nombreUsuario.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				if (!nombreUsuario.getText().isEmpty()
						&& !nombreUsuario.getText().equals("Nombre de Usuario")) {
					nombreUsuario.setBackground(Color.decode("#4EFF8F"));
				}

				if (nombreUsuario.getText().equals("Nombre de Usuario")) {
					nombreUsuario.setBackground(Color.decode("#FFA874"));
				}

			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				if (nombreUsuario.getText().isEmpty()) {
					nombreUsuario.setBackground(Color.white);
				}

			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});

		nombreUsuario.setBackground(Color.decode("#FFA874"));
		add(nombreUsuario);

		// CAMPO CONTRASEÃ‘A
		JLabel passwordL = new JLabel("Contraseña: (Entre 5 y 20 caracteres)");
		passwordL.setBounds(700, 505, 400, 40);
		password = new JPasswordField();
		password.setBounds(700, 540, 400, 40);
		password.setBorder(border);
		password.setEchoChar('ㅅ');
		password.setFont(helveticaN);
		password.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				if (password.getPassword().length > 5
						&& password.getPassword().length < 20) {
					password.setBackground(Color.decode("#4EFF8F"));
				}

				if (password.getPassword().length > 20) {
					password.setBackground(Color.decode("#FF534E"));
				}

			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				if (password.getPassword().length > 5
						&& password.getPassword().length < 20) {
					password.setBackground(Color.decode("#4EFF8F"));
				}

				if (password.getPassword().length == 0) {
					password.setBackground(Color.decode("#FFA874"));
				}

				if (password.getPassword().length < 5
						&& password.getPassword().length != 0) {
					password.setBackground(Color.decode("#FF534E"));

				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});

		password.setBackground(Color.decode("#FFA874"));
		add(passwordL);
		add(password);

		// CHECKBOX GESTOR

		final String gestorPass = "ninja";
		esGestor = new JCheckBox("Soy Gestor, amo y señor de los ninjas.");
		esGestor.setBounds(815, 580, 300, 30);
		esGestor.setFont(helveticaXS);
		add(esGestor);
		esGestor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPasswordField ninjaPass = new JPasswordField();

				if (esGestor.isSelected()) {
					for (int i = 1; i <= MAX_INTENTOS; i++) {
						int result = JOptionPane.showConfirmDialog(null,
								ninjaPass, "Introduce Contraseña",
								JOptionPane.OK_CANCEL_OPTION);

						String passSuplied = new String(ninjaPass.getPassword());

						if (result == JOptionPane.OK_OPTION) {
							if (passSuplied.equals(gestorPass)) {
								esGestor.setSelected(true);
								break;
							} else {
								if(i<MAX_INTENTOS){
								esGestor.setSelected(false);
								ninjaPass.setText("");;
								}else if(i == MAX_INTENTOS){
									dispose();
									Login exit = new Login();
									exit.setVisible(true);
								}
							}
						} else {
							esGestor.setSelected(false);
						}
					}
				}
			}
		});

		// BOTON REGISTRO
		registrar = new JButton("Completar registro");
		registrar.setFont(helveticaN);
		registrar.setBounds(380, 620, 500, 50);
		registrar.setFocusPainted(false);
		registrar.setContentAreaFilled(true);
		registrar.setBorderPainted(false);
		registrar.setOpaque(true);
		registrar.setBackground(Color.decode("#2E93B2"));

		registrar.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				registrar.setBackground(Color.decode("#2E93B2"));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				registrar.setBackground(Color.decode("#195061"));
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				registrar.setBackground(Color.decode("#195061"));
			}
		});

		registrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Pattern dniReg = Pattern.compile("(\\d{8})([-]?)([A-Za-z]{1})");
				Matcher mat = dniReg.matcher(dni.getText());

				if (nombre.getDocument().equals("Nombre")
						|| apellidos.getDocument().equals("Apellidos")
						|| direccion.getDocument().equals("Dirección")
						|| poblacion.getDocument().equals("Población")
						|| provincia.getDocument().equals("Provincia")
						|| codigoPostal.getDocument().equals("Código Postal")
						|| pais.getDocument().equals("País")
						|| tlf.getDocument().equals("Teléfono")
						|| email.getDocument().equals("E-mail")
						|| nombreUsuario.getDocument().equals(
								"Nombre de Usuario") || !mat.matches()
						|| password.getPassword().length < 5) {
					JOptionPane.showMessageDialog(null,
							"Revisa los datos! Algún campo no es correcto!");
				} else {

					registrarUsuario();

				}

			}
		});

		add(registrar);

		this.setVisible(true);
	}

	public void registrarUsuario() {

		Registro reg = new Registro();
		String correo = email.getText();
		String strPassword = new String(password.getPassword());
		String telf = tlf.getText().replace(" ", "").toString();
		String codPostal = codigoPostal.getText().toString();
		boolean encontrado = reg.comprobarEmail(correo);

		if (encontrado) {
			JOptionPane.showMessageDialog(null,
					"Ya existe una cuenta con este correo electrónico.");
		} else {

			Usuario usuario = new Usuario(nombre.getText(),
					apellidos.getText(), direccion.getText(),
					poblacion.getText(), provincia.getText(),
					Integer.parseInt(codPostal), pais.getText(), telf,
					email.getText(), nombreUsuario.getText(), strPassword,
					dni.getText(), esGestor.isSelected());

			reg.regUsuario(usuario);
			JOptionPane.showMessageDialog(null,
					"Enhorabuena! Registro completado!");
			this.dispose();
			Login registroComp = new Login();
			registroComp.setVisible(true);
		}
	}

	

}
