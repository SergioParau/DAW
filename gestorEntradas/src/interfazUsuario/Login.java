package interfazUsuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import conexionBD.Autenticacion;
import conexionBD.Registro;

public class Login extends JFrame {

	// Atributos de la GUI
	private JTextField campoUsuario;
	private JPasswordField campoPassword;
	private JButton registro, login, forgotPw, sinRegistro;
	private JFrame frame;

	// FUENTES Y BORDER-STYLING
	private Font helveticaN = new Font("Helvetica", Font.PLAIN, 15);
	private Border line = BorderFactory.createEmptyBorder();
	private Border empty = new EmptyBorder(0, 5, 0, 0);
	private CompoundBorder border = new CompoundBorder(line, empty);

	// CONSTRUCTOR
	public Login() {

		super("Ticket Ninja. Entra en tu sesión para empezar a comprar ya!");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(220, 150);
		this.setSize(800, 500);
		this.getContentPane().setBackground(Color.decode("#77DEFF"));

		// ELEMENTOS DEL NOMBRE USUARIO
		JLabel usuarioTag = new JLabel("Nombre de usuario");

		usuarioTag.setBounds(30, 200, 150, 30);
		usuarioTag.setFont(helveticaN);

		getContentPane().add(usuarioTag);

		campoUsuario = new JTextField();

		campoUsuario.setBounds(170, 200, 150, 30);
		campoUsuario.setFont(helveticaN);
		campoUsuario.setBorder(border);
		getContentPane().add(campoUsuario);

		// ELEMENTOS DE LA CONTRASENYA
		JLabel pwTag = new JLabel("Contraseña");

		pwTag.setBounds(30, 250, 150, 30);
		pwTag.setFont(helveticaN);

		getContentPane().add(pwTag);

		campoPassword = new JPasswordField();

		campoPassword.setBounds(170, 250, 150, 30);
		campoPassword.setFont(helveticaN);
		campoPassword.setBorder(border);

		getContentPane().add(campoPassword);

		// BOTONES
		login = new JButton("Log In");
		login.setBounds(30, 300, 290, 35);
		login.setFont(helveticaN);
		login.setBackground(Color.decode("#2E93B2"));
		login.setFocusPainted(false);
		login.setOpaque(true);
		login.setContentAreaFilled(true);
		login.setBorderPainted(false);

		login.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				login.setBackground(Color.decode("#2E93B2"));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				login.setBackground(Color.decode("#195061"));
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				login.setBackground(Color.decode("#195061"));
			}
		});

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				verificacion();

			}
		});
		getContentPane().add(login);

		// CONTRASEÑA OLVIDADA

		forgotPw = new JButton("Has olvidado tu contraseña?");
		forgotPw.setFont(helveticaN);
		forgotPw.setBounds(70, 340, 300, 20);
		forgotPw.setBorderPainted(false);
		forgotPw.setFocusPainted(false);
		forgotPw.setContentAreaFilled(false);
		add(forgotPw);
		forgotPw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField email = new JTextField();
				JPasswordField pw = new JPasswordField();
				Object[] inputs = { "Email:", email, "Contraseña: ", pw, };

				int option = JOptionPane.showConfirmDialog(null, inputs,
						"Cambiar contraseña", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION
						&& !email.getText().equals("")
						&& !pw.getPassword().equals("")) {
					Registro cambiarPw = new Registro();
					if (cambiarPw.comprobarEmail(email.getText())) {
						String getPass = new String(pw.getPassword());
						
						if (cambiarPw.updatePassword(email.getText(), getPass)) {
							JOptionPane.showMessageDialog(null,
									"Contraseña cambiada!");
						} else {
							JOptionPane.showMessageDialog(null,
									"Revisa tu correo! Algo no va bien!");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"No encontramos tu email por ninguna parte!");
					}
				}
			}
		});

		// IMAGEN
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(Login.class
				.getResource("/lib/logoPNGresize.png")));
		imagen.setBounds(270, 0, 265, 140);
		getContentPane().add(imagen);

		// NO ESTAS REGISTRADO?
		JLabel registroTag = new JLabel(
				"No estás registrado? Pulsa aquí para hacerlo.");
		registroTag.setBounds(450, 185, 300, 50);

		registroTag.setFont(helveticaN);

		getContentPane().add(registroTag);

		registro = new JButton("Regístrate!");
		registro.setBounds(500, 230, 170, 40);
		registro.setFont(helveticaN);
		registro.setFocusPainted(false);
		registro.setContentAreaFilled(true);
		registro.setBorderPainted(false);
		registro.setOpaque(true);
		registro.setBackground(Color.decode("#2E93B2"));

		registro.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				registro.setBackground(Color.decode("#2E93B2"));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				registro.setBackground(Color.decode("#195061"));
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				registro.setBackground(Color.decode("#195061"));
			}
		});

		registro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// CAMBIAR A VENTANA REGISTRO
				dispose();
				RegistroUsuario registro = new RegistroUsuario();
				registro.setVisible(true);
			}

		});
		getContentPane().add(registro);

		sinRegistro = new JButton("Continuar sin registro >>>");
		sinRegistro.setBounds(436, 270, 300, 50);
		sinRegistro.setFont(helveticaN);
		sinRegistro.setBorderPainted(false);
		sinRegistro.setFocusPainted(false);
		sinRegistro.setContentAreaFilled(false);
		sinRegistro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// ENTRAR EN MENÚ CLIENTE
				dispose();
				MenuCliente menuC = new MenuCliente();
				Autenticacion.getAuth().setAuthenticated(false);
				menuC.frame.setVisible(true);

			}
		});
		getContentPane().add(sinRegistro);

		this.setVisible(true);

	}

	public void verificacion() {

		// Aquí guardaremos el contenido de las cajas de texto y se las
		// asignaremos a las variables
		String usuario = campoUsuario.getText();
		String password = new String(campoPassword.getPassword());

		// Creamos un objeto del tipo conexión para realizar la validación de
		// los datos intruducidos por el usuario
		Registro log = new Registro();
		boolean conectado = log.login(usuario, password);
		boolean gestor = log.esGestor(usuario);

		if (conectado) {
			if (gestor) {
				this.dispose();
				MenuGestor menuG = new MenuGestor();
				menuG.setVisible(true);
			} else {
				this.dispose();
				MenuCliente menuC = new MenuCliente();
				Autenticacion.getAuth().setAuthenticated(true);
				menuC.frame.setVisible(true);
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Nombre de usuario o Contraseña incorrecto!");
		}
	}

	public static void main(String[] args) {
		Login screen = new Login();
	}
}
