package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Locale;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField txtLU;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtMail;
	private JTextField txtGithub;
	private JLabel lblFoto;
	private JLabel lblHora;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 274));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 0, 430, 211);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Informacion del alumno", null, tabInformation, "Muestra la informacion declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setBounds(10, 21, 45, 14);
		tabInformation.add(lblLU);
		
		
		txtLU = new JTextField();
		txtLU.setBounds(87, 18, 328, 20);
		tabInformation.add(txtLU);
		txtLU.setColumns(10);
		txtLU.setText(String.valueOf(studentData.getId()));
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(87, 49, 328, 20);
		tabInformation.add(txtApellido);
		txtApellido.setText(studentData.getLastName());
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(87, 77, 328, 20);
		tabInformation.add(txtNombre);
		txtNombre.setText(studentData.getFirstName());
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(87, 108, 328, 20);
		tabInformation.add(txtMail);
		txtMail.setText(studentData.getMail());
		
		txtGithub = new JTextField();
		txtGithub.setColumns(10);
		txtGithub.setBounds(87, 141, 328, 20);
		tabInformation.add(txtGithub);
		txtGithub.setText(studentData.getGithubURL());
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 53, 45, 14);
		tabInformation.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 80, 45, 14);
		tabInformation.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(10, 111, 45, 14);
		tabInformation.add(lblEmail);
		
		JLabel lblGithubUrl = new JLabel("Github URL");
		lblGithubUrl.setBounds(10, 144, 67, 14);
		tabInformation.add(lblGithubUrl);
		contentPane.add(tabbedPane);
		
		
		lblFoto = new JLabel("New label");
		ImageIcon icon=new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
		Image scaleImage =icon.getImage().getScaledInstance(154,181 , Image.SCALE_DEFAULT);
		icon=new ImageIcon(scaleImage);
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setIcon(icon);
		lblFoto.setBounds(446, 27, 150, 180);
		contentPane.add(lblFoto);
		
		
		lblHora = new JLabel("hora");
		lblHora.setBounds(14, 215, 388, 14);
		contentPane.add(lblHora);
		DateTimeFormatter FormatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter FormatoHoras = DateTimeFormatter.ofPattern("HH:mm:ss");
		lblHora.setText("Esta ventana fue generada el "+FormatoFecha.format(LocalDateTime.now())+" a las: "+FormatoHoras.format(LocalDateTime.now()));
		
	}
}
