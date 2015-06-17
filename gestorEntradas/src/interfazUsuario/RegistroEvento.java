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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import conexionBD.ConexionesGestor;
import usuarios.Evento;

public class RegistroEvento extends JFrame {

	// ATRIBUTOS
	private JTextField nombre, local, ciudad, fecha,entradasGen,entradasVip,precioGen,precioVip;

	private String[] descEvento = { "Conciertos", "Cine", "Teatro", "Deporte","Ópera","Circo" };
	private static final String NO_SELECCIONABLE = "- Tipo de Evento -";
	private JComboBox eventoTipo = new JComboBox();
	private JTextArea info;
	private boolean seleccionable = true;

	private JCheckBox setEntradas;
	
	private JButton registrarEvento,atrasMenu;

	//FUENTES Y BORDER-STYLING
	Font helveticaN = new Font("Helvetica", Font.PLAIN, 15);
	Font helveticaM = new Font("Helvetica", Font.PLAIN, 20);
	Font helveticaXS = new Font("Helvetica", Font.PLAIN, 12);
	Border line = BorderFactory.createEmptyBorder();
	Border empty = new EmptyBorder(0, 5, 0, 0);
	Border textArea = new EmptyBorder(5,5,0,0);
	CompoundBorder border = new CompoundBorder(line, empty);
	CompoundBorder borderArea = new CompoundBorder(line, textArea);
	
	// CONSTRUCTOR

	@SuppressWarnings("unchecked")
	public RegistroEvento() {

		super("Creación de un evento");
		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(150, 0);
		this.setSize(1000, 650);
		this.getContentPane().setBackground(Color.decode("#77DEFF"));
		

		
		// IMAGEN
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(Login.class.getResource("/lib/logoPNGresize.png")));
		imagen.setBounds(380, 10, 285, 160);
		getContentPane().add(imagen);
		
		/*// HEADING
		JLabel heading = new JLabel("Crear nuevo evento");
		heading.setBounds(350, 20, 400, 50);
		Font helvetica = new Font("Helvetica", Font.BOLD, 30);
		heading.setFont(helvetica);
		add(heading);*/

		//BOTON ATRAS
		
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
				MenuGestor atras = new MenuGestor();
				atras.setVisible(true);
				
			}
		});
		
		
		/*
		 * CAMPOS DE INSERTADO DE DATOS PARA EL REGISTRO DE EVENTOS. LOS FOCUS
		 * LISTENER SIRVEN PARA DETECTAR SI EL PUNTERO ESTÃ� SOBRE UN CAMPO
		 * DETERMINADO O NO.
		 */

		// CAMPO NOMBRE
		nombre = new JTextField("Nombre");
		nombre.setBounds(200, 180, 250, 40);
		nombre.setFont(helveticaN);
		nombre.setBorder(border);
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
		add(nombre);
		
		//INFORMACION EVENTO
		
		info = new JTextArea("+ info:");
		info.setBounds(460, 230, 350, 140);
		info.setFont(helveticaN);
		info.setBorder(borderArea);
		info.setLineWrap(true);
		info.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (info.getText().trim().equals("+ info:")) {
					info.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (info.getText().trim().equals("")) {
					info.setText("+ info:");
				}
			}
		});
		add(info);
		
		entradasGen = new JTextField("Entradas Generales");
		entradasGen.setBounds(200, 230, 150, 40);
		entradasGen.setFont(helveticaN);
		entradasGen.setBorder(border);
		entradasGen.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (entradasGen.getText().trim().equals("Entradas Generales")) {
					entradasGen.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (entradasGen.getText().trim().equals("")) {
					entradasGen.setText("Entradas Generales");
				}
			}
		});
		add(entradasGen);

		
		entradasVip = new JTextField("Tickets VIP");
		entradasVip.setBounds(200, 280, 150, 40);
		entradasVip.setFont(helveticaN);
		entradasVip.setBorder(border);
		entradasVip.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (entradasVip.getText().trim().equals("Tickets VIP")) {
					entradasVip.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (entradasVip.getText().trim().equals("")) {
					entradasVip.setText("Tickets VIP");
				}
			}
		});
		add(entradasVip);
		
		
		//PRECIO ENTRADAS
		
		precioGen = new JTextField("€");
		precioGen.setBounds(360, 230, 90, 40);
		precioGen.setFont(helveticaN);
		precioGen.setBorder(border);
		precioGen.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (precioGen.getText().trim().equals("€")) {
					precioGen.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (precioGen.getText().trim().equals("")) {
					precioGen.setText("€");
				}
			}
		});
		add(precioGen);
		
		
		precioVip = new JTextField("€");
		precioVip.setBounds(360, 280, 90, 40);
		precioVip.setFont(helveticaN);
		precioVip.setBorder(border);
		precioVip.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (precioVip.getText().trim().equals("€")) {
					precioVip.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (precioVip.getText().trim().equals("")) {
					precioVip.setText("€");
				}
			}
		});
		add(precioVip);


		// CAMPO tipoEvento
		eventoTipo.addItem(NO_SELECCIONABLE);
		for (int i = 0; i < descEvento.length; i++) {
			eventoTipo.addItem(descEvento[i]);

		}

		eventoTipo.setBounds(460, 180, 350, 40);
		eventoTipo.setFont(helveticaN);
		eventoTipo.setOpaque(true);
		eventoTipo.setBackground(Color.decode("#2E93B2"));
		add(eventoTipo);

		// CAMPO local
		local = new JTextField("Localización");
		local.setFont(helveticaN);
		local.setBorder(border);
		local.setBounds(200, 380, 200, 40);
		local.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (local.getText().trim().equals("Localización")) {
					local.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (local.getText().trim().equals("")) {
					local.setText("Localización");
				}
			}
		});
		add(local);

		// CAMPO ciudad
		ciudad = new JTextField("Ciudad");
		ciudad.setFont(helveticaN);
		ciudad.setBorder(border);
		ciudad.setBounds(200, 330, 250, 40);
		ciudad.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (ciudad.getText().trim().equals("Ciudad")) {
					ciudad.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (ciudad.getText().trim().equals("")) {
					ciudad.setText("Ciudad");
				}
			}
		});
		add(ciudad);

		// CAMPO tipoEntrada
		fecha = new JTextField("Fecha y hora (YYYY/MM/DD HH:mm:ss)");
		fecha.setFont(helveticaN);
		fecha.setBorder(border);
		fecha.setBounds(410, 380, 400, 40);
		fecha.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (fecha.getText().trim().equals("Fecha y hora (YYYY/MM/DD HH:mm:ss)")) {
					fecha.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (fecha.getText().trim().equals("")) {
					fecha.setText("Fecha y hora (YYYY/MM/DD HH:mm:ss)");
				}
			}
		});
		add(fecha);
		
		//CHECKBOX HABILITAR ENTRADAS
		setEntradas = new JCheckBox("Habilitar venta de entradas");
		setEntradas.setBounds(363, 470, 250,20);
		setEntradas.setFont(helveticaN);
		add(setEntradas);
		

		// BOTON REGISTRO
		registrarEvento = new JButton("Completar registro");
		registrarEvento.setBounds(370, 490, 250, 50);
		registrarEvento.setFont(helveticaN);
		registrarEvento.setFocusPainted(false);
		registrarEvento.setContentAreaFilled(true);
		registrarEvento.setBorderPainted(false);
		registrarEvento.setOpaque(true);
		registrarEvento.setBackground(Color.decode("#2E93B2"));
		registrarEvento.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				registrarEvento.setBackground(Color.decode("#2E93B2"));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				registrarEvento.setBackground(Color.decode("#195061"));
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				registrarEvento.setBackground(Color.decode("#195061"));
			}
		});
		registrarEvento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Pattern dateReg = Pattern.compile("(\\d{4})/(\\d{2})/(\\d{2}) (\\d{2}):(\\d{2}):(\\d{2})");
				Matcher mat = dateReg.matcher(fecha.getText());
				
				//
				
				if (nombre.getText().equals("Nombre")
						|| eventoTipo.getSelectedItem().equals(
								"- Tipo de Evento -")
						|| local.getText().equals("Localización")
						|| ciudad.getText().equals("Ciudad")
						|| fecha.getText().equals("Fecha y hora (YYYY/MM/DD HH:mm:ss)")
						|| !mat.matches()
						|| entradasGen.getText().equals("Tickets")) {
					JOptionPane.showMessageDialog(null,
							"Revisa los datos! Algún campo no es correcto!");
				} else {
					registrarEvento();
					JOptionPane.showMessageDialog(null,
							"El Evento ha sido registrado correctamente");

				}
			}
		});

		add(registrarEvento);

		this.setVisible(true);
	}

	public void registrarEvento() {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		
		try {
		Date fechaEvento=formato.parse(fecha.getText());
		System.out.println(fechaEvento);
		
		Evento evento = new Evento(nombre.getText(),eventoTipo.getSelectedItem().toString(),local.getText(),ciudad.getText(),fechaEvento,setEntradas.isSelected(),
				Integer.parseInt(entradasGen.getText()),Integer.parseInt(precioGen.getText()),Integer.parseInt(entradasVip.getText()),
				Integer.parseInt(precioVip.getText()),info.getText());

		ConexionesGestor regEvento = new ConexionesGestor();
		regEvento.altaEvento(evento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.dispose();
		MenuGestor registroComp = new MenuGestor();
		registroComp.setVisible(true);

	}

	public static void main(String[] args) {
		RegistroEvento registroE = new RegistroEvento();
	}

}
