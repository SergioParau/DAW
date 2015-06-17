package interfazUsuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import usuarios.Evento;
import conexionBD.ConexionesGestor;

public class MenuGestor extends JFrame {

	// ATRIBUTOS ALTA EVENTO
	JLabel altaEventoL = new JLabel("Crear Evento");
	JButton altaEvento = new JButton("Go!");

	// ATRIBUTOS BAJA EVENTO
	JLabel bajaEventoL = new JLabel("Eliminar evento");
	JTextField campoBajaEvento = new JTextField("Nombre del evento");
	JButton bajaEvento = new JButton("Eliminar");

	// ATRIBUTOS COMPROBAR EVENTO
	JLabel comprobarEventoL = new JLabel("¿Quedan entradas?");
	JTextField campoComprobarEvento = new JTextField("Nombre del evento");
	JButton comprobarEvento = new JButton("Check!");

	// ATRIBUTOS CONEXIONES
	ConexionesGestor conGestor = new ConexionesGestor();

	//ATRAS
	
	JButton logOut;
	
	// FUENTES Y BORDER-STYLING
	Font helveticaN = new Font("Helvetica", Font.PLAIN, 15);
	Font helveticaXS = new Font("Helvetica", Font.PLAIN, 12);
	Border line = BorderFactory.createEmptyBorder();
	Border empty = new EmptyBorder(0, 5, 0, 0);
	CompoundBorder border = new CompoundBorder(line, empty);

	public MenuGestor() {
		super("Menu de gestión de entradas");
		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(400, 50);
		this.setSize(400, 700);
		this.getContentPane().setBackground(Color.decode("#77DEFF"));
		Font helveticaN = new Font("Helvetica", Font.PLAIN, 20);

		// IMAGEN
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(Login.class
				.getResource("/lib/logoPNGresize.png")));
		imagen.setBounds(80, -20, 285, 160);
		getContentPane().add(imagen);

		
		//BOTON LOGOUT
		
		logOut = new JButton("LOG OUT");
		logOut.setBounds(145, 630, 100, 25);
		logOut.setFocusPainted(false);
		logOut.setFont(helveticaXS);
		logOut.setFocusPainted(false);
		logOut.setContentAreaFilled(true);
		logOut.setBorderPainted(false);
		logOut.setOpaque(true);
		logOut.setBackground(Color.decode("#2E93B2"));
		add(logOut);
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
				
				dispose();
				Login atrasLogin = new Login();
				atrasLogin.setVisible(true);
				
			}
		});

		// ALTA EVENTO
		altaEventoL.setBounds(135, 125, 300, 60);
		altaEventoL.setFont(helveticaN);
		add(altaEventoL);
		altaEvento.setBounds(45, 175, 300, 60);
		altaEvento.setFont(helveticaN);
		altaEvento.setFocusPainted(false);
		altaEvento.setContentAreaFilled(true);
		altaEvento.setBorderPainted(false);
		altaEvento.setOpaque(true);
		altaEvento.setBackground(Color.decode("#2E93B2"));
		add(altaEvento);

		altaEvento.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				altaEvento.setBackground(Color.decode("#2E93B2"));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				altaEvento.setBackground(Color.decode("#195061"));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				altaEvento.setBackground(Color.decode("#195061"));
			}
		});
		
		
		altaEvento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RegistroEvento regEvento = new RegistroEvento();
				regEvento.setVisible(true);

			}
		});

		// BAJA EVENTO
		bajaEventoL.setBounds(130, 250, 300, 60);
		bajaEventoL.setFont(helveticaN);
		add(bajaEventoL);

		campoBajaEvento.setBorder(null);
		campoBajaEvento.setFont(helveticaN);
		campoBajaEvento.setHorizontalAlignment(SwingConstants.CENTER);
		;
		campoBajaEvento.setBounds(45, 300, 300, 45);
		campoBajaEvento.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (campoBajaEvento.getText().trim().equals("")) {
					campoBajaEvento.setText("Nombre del evento");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (campoBajaEvento.getText().trim()
						.equals("Nombre del evento")) {
					campoBajaEvento.setText("");
				}
			}
		});
		add(campoBajaEvento);
		bajaEvento.setBounds(45, 350, 300, 60);
		bajaEvento.setFont(helveticaN);
		bajaEvento.setFocusPainted(false);
		bajaEvento.setContentAreaFilled(true);
		bajaEvento.setBorderPainted(false);
		bajaEvento.setOpaque(true);
		bajaEvento.setBackground(Color.decode("#2E93B2"));
		add(bajaEvento);

		bajaEvento.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				bajaEvento.setBackground(Color.decode("#2E93B2"));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				bajaEvento.setBackground(Color.decode("#195061"));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				bajaEvento.setBackground(Color.decode("#195061"));
			}
		});
		
		bajaEvento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (campoBajaEvento.getText().equals("Nombre del evento")) {
					JOptionPane.showMessageDialog(null,
							"No has introducido ningún evento!");
				} else {
					int respuesta = JOptionPane.showConfirmDialog(null,
							"Seguro que deseas borrar el evento seleccionado?");

					if (respuesta == JOptionPane.YES_OPTION) {
						boolean borrar = conGestor.bajaEvento(campoBajaEvento.getText());
						
						if(borrar){
							JOptionPane.showMessageDialog(null, "El evento "+campoBajaEvento.getText()+" ha sido borrado con éxito!");
							campoBajaEvento.setText("Nombre del evento");
						}else{
							JOptionPane.showMessageDialog(null, "El evento "+campoBajaEvento.getText()+" no existe!");
						}
					} else if (respuesta == JOptionPane.NO_OPTION) {

					}
				}
			}
		});

		// COMPROBAR EVENTO
		comprobarEventoL.setBounds(108, 430, 300, 60);
		comprobarEventoL.setFont(helveticaN);
		add(comprobarEventoL);

		campoComprobarEvento.setBounds(45, 480, 300, 45);
		campoComprobarEvento.setBorder(null);
		campoComprobarEvento
				.setHorizontalAlignment(SwingConstants.CENTER);
		;
		campoComprobarEvento.setFont(helveticaN);
		campoComprobarEvento.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (campoComprobarEvento.getText().trim().equals("")) {
					campoComprobarEvento.setText("Nombre del evento");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (campoComprobarEvento.getText().trim()
						.equals("Nombre del evento")) {
					campoComprobarEvento.setText("");
				}
			}
		});
		add(campoComprobarEvento);
		comprobarEvento.setBounds(45, 530, 300, 60);
		comprobarEvento.setFont(helveticaN);
		comprobarEvento.setFocusPainted(false);
		comprobarEvento.setContentAreaFilled(true);
		comprobarEvento.setBorderPainted(false);
		comprobarEvento.setOpaque(true);
		comprobarEvento.setBackground(Color.decode("#2E93B2"));
		add(comprobarEvento);

		comprobarEvento.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				comprobarEvento.setBackground(Color.decode("#2E93B2"));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				comprobarEvento.setBackground(Color.decode("#195061"));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

				comprobarEvento.setBackground(Color.decode("#195061"));
			}
		});
		
		
		comprobarEvento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (campoComprobarEvento.getText().equals("Nombre del evento")) {
					JOptionPane.showMessageDialog(null,
							"No has introducido ningún evento!");
				} else {
					
					Evento ev = conGestor.estadoEvento(campoComprobarEvento.getText());
					
					if (ev.isQuedanEntradas()) {
						JOptionPane.showMessageDialog(null,
								"Yipi Ka Yei! Quedan "+ev.getNumEntradas()+" entradas!"
										+ ev.getNumGen()+" entradas generales y "+ev.getNumVip()+" entradas VIP");
					} else {
						JOptionPane.showMessageDialog(null,
								"Cáspitas, este evento está agotado!");
					}
				}
			}
		});

		this.setVisible(true);
	}

	public static void main(String[] args) {
		MenuGestor panel = new MenuGestor();

	}

}
