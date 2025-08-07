package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;

public class distribuidorXiaomi extends JFrame {

	private JPanel contentPane;
	private JTextField txtPrecio;
	private JTextField txtPantalla;
	private JTextField txtRam;
	private JTextField txtRom;
	private JTextField txtCarga;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtPrecioVentas;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					distribuidorXiaomi frame = new distribuidorXiaomi();
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
	public distribuidorXiaomi() {
		setTitle("TIENDA DISTRIBUIDORA XIAOMI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(36, 33, 437, 301);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Archivo", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(151, 117, 89, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Mantenimiento", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 11, 412, 249);
		panel_1.add(tabbedPane_1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Consultar", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(22, 22, 65, 14);
		panel_5.add(lblModelo);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(138, 19, 127, 22);
		panel_5.add(comboBox);
		
		JLabel lblPrecio = new JLabel("Precio (S/):");
		lblPrecio.setBounds(22, 50, 103, 14);
		panel_5.add(lblPrecio);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(138, 48, 127, 20);
		panel_5.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblPantalla = new JLabel("Pantalla:");
		lblPantalla.setBounds(22, 80, 65, 14);
		panel_5.add(lblPantalla);
		lblPantalla.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtPantalla = new JTextField();
		txtPantalla.setBounds(138, 78, 127, 20);
		panel_5.add(txtPantalla);
		txtPantalla.setColumns(10);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(294, 19, 89, 23);
		panel_5.add(btnCerrar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(294, 47, 89, 23);
		panel_5.add(btnGuardar);
		
		JLabel lblRam = new JLabel("RAM:");
		lblRam.setBounds(22, 111, 101, 14);
		panel_5.add(lblRam);
		lblRam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtRam = new JTextField();
		txtRam.setBounds(138, 109, 127, 20);
		panel_5.add(txtRam);
		txtRam.setColumns(10);
		
		JLabel lblRom = new JLabel("ROM:");
		lblRom.setBounds(22, 144, 101, 14);
		panel_5.add(lblRom);
		lblRom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtRom = new JTextField();
		txtRom.setBounds(138, 142, 127, 20);
		panel_5.add(txtRom);
		txtRom.setColumns(10);
		
		JLabel lblCargaRpida = new JLabel("Carga r\u00E1pida:");
		lblCargaRpida.setBounds(22, 181, 101, 14);
		panel_5.add(lblCargaRpida);
		lblCargaRpida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtCarga = new JTextField();
		txtCarga.setBounds(138, 179, 127, 20);
		panel_5.add(txtCarga);
		txtCarga.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Modificar", null, panel_6, null);
		panel_6.setLayout(null);
		
		JButton btnGuardar_1 = new JButton("Guardar");
		btnGuardar_1.setBounds(296, 39, 89, 23);
		panel_6.add(btnGuardar_1);
		
		JButton btnCerrar_1 = new JButton("Cerrar");
		btnCerrar_1.setBounds(296, 11, 89, 23);
		panel_6.add(btnCerrar_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(140, 11, 127, 22);
		panel_6.add(comboBox_1);
		
		JLabel lblModelo_1 = new JLabel("Modelo:");
		lblModelo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModelo_1.setBounds(24, 14, 65, 14);
		panel_6.add(lblModelo_1);
		
		JLabel lblPrecio_1 = new JLabel("Precio (S/):");
		lblPrecio_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio_1.setBounds(24, 42, 103, 14);
		panel_6.add(lblPrecio_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(140, 40, 127, 20);
		panel_6.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 70, 127, 20);
		panel_6.add(textField_1);
		
		JLabel lblPantalla_1 = new JLabel("Pantalla:");
		lblPantalla_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPantalla_1.setBounds(24, 72, 65, 14);
		panel_6.add(lblPantalla_1);
		
		JLabel lblRam_1 = new JLabel("RAM:");
		lblRam_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRam_1.setBounds(24, 103, 101, 14);
		panel_6.add(lblRam_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(140, 101, 127, 20);
		panel_6.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(140, 134, 127, 20);
		panel_6.add(textField_3);
		
		JLabel lblRom_1 = new JLabel("ROM:");
		lblRom_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRom_1.setBounds(24, 136, 101, 14);
		panel_6.add(lblRom_1);
		
		JLabel lblCargaRpida_1 = new JLabel("Carga r\u00E1pida:");
		lblCargaRpida_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCargaRpida_1.setBounds(24, 173, 101, 14);
		panel_6.add(lblCargaRpida_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(140, 171, 127, 20);
		panel_6.add(textField_4);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("Listar", null, panel_7, null);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 387, 158);
		panel_7.add(scrollPane);
		
		JTextArea txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		JButton btnCerrarListar = new JButton("Cerrar");
		btnCerrarListar.setBounds(91, 180, 89, 23);
		panel_7.add(btnCerrarListar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(227, 180, 89, 23);
		panel_7.add(btnListar);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Ventas", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblModelo_2 = new JLabel("Modelo:");
		lblModelo_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModelo_2.setBounds(32, 25, 65, 14);
		panel_2.add(lblModelo_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(148, 22, 127, 22);
		panel_2.add(comboBox_2);
		
		JLabel lblPrecio_2 = new JLabel("Precio (S/):");
		lblPrecio_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio_2.setBounds(32, 53, 103, 14);
		panel_2.add(lblPrecio_2);
		
		txtPrecioVentas = new JTextField();
		txtPrecioVentas.setColumns(10);
		txtPrecioVentas.setBounds(148, 51, 127, 20);
		panel_2.add(txtPrecioVentas);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(304, 22, 89, 23);
		panel_2.add(btnVender);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidad.setBounds(32, 86, 103, 14);
		panel_2.add(lblCantidad);
		
		JButton btnCerrar_2_1 = new JButton("Cerrar");
		btnCerrar_2_1.setBounds(304, 50, 89, 23);
		panel_2.add(btnCerrar_2_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(148, 84, 127, 20);
		panel_2.add(spinner);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 116, 412, 146);
		panel_2.add(scrollPane_1);
		
		JTextArea txtSVentas = new JTextArea();
		scrollPane_1.setViewportView(txtSVentas);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Configuraci\u00F3n", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(10, 11, 412, 251);
		panel_3.add(tabbedPane_2);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_2.addTab("Descuentos", null, panel_8, null);
		panel_8.setLayout(null);
		
		JLabel lbl1a5u = new JLabel("1 a 5 unidades");
		lbl1a5u.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl1a5u.setBounds(10, 33, 113, 14);
		panel_8.add(lbl1a5u);
		
		JLabel lbl6a10u = new JLabel("6 a 10 unidades");
		lbl6a10u.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl6a10u.setBounds(10, 73, 113, 14);
		panel_8.add(lbl6a10u);
		
		JLabel lbl11a15u = new JLabel("11 a 15 unidades");
		lbl11a15u.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl11a15u.setBounds(10, 111, 113, 14);
		panel_8.add(lbl11a15u);
		
		JLabel lbl15aMas = new JLabel("M\u00E1s de 15 unidades");
		lbl15aMas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl15aMas.setBounds(10, 153, 140, 14);
		panel_8.add(lbl15aMas);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(133, 151, 115, 20);
		panel_8.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(133, 109, 115, 20);
		panel_8.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(133, 71, 115, 20);
		panel_8.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(133, 31, 115, 20);
		panel_8.add(textField_8);
		
		JLabel lblModelo_2_1_1 = new JLabel("%");
		lblModelo_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModelo_2_1_1.setBounds(258, 34, 29, 14);
		panel_8.add(lblModelo_2_1_1);
		
		JLabel lblModelo_2_1_1_1 = new JLabel("%");
		lblModelo_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModelo_2_1_1_1.setBounds(258, 74, 29, 14);
		panel_8.add(lblModelo_2_1_1_1);
		
		JLabel lblModelo_2_1_1_1_1 = new JLabel("%");
		lblModelo_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModelo_2_1_1_1_1.setBounds(258, 112, 29, 14);
		panel_8.add(lblModelo_2_1_1_1_1);
		
		JLabel lblModelo_2_1_1_1_1_1 = new JLabel("%");
		lblModelo_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModelo_2_1_1_1_1_1.setBounds(258, 154, 29, 14);
		panel_8.add(lblModelo_2_1_1_1_1_1);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(308, 30, 89, 23);
		panel_8.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(308, 70, 89, 23);
		panel_8.add(btnCancelar);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_2.addTab("Obsequios", null, panel_9, null);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1 unidad");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(22, 33, 103, 14);
		panel_9.add(lblNewLabel);
		
		JLabel lblA = new JLabel("2 a 5 unidades");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblA.setBounds(22, 74, 103, 14);
		panel_9.add(lblA);
		
		JLabel lblNewLabel_1_1 = new JLabel("6 a m\u00E1s unidades");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(22, 118, 121, 14);
		panel_9.add(lblNewLabel_1_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(153, 27, 96, 20);
		panel_9.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(153, 68, 96, 20);
		panel_9.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(153, 112, 96, 20);
		panel_9.add(textField_11);
		
		JButton btnAceptarConfiguracion = new JButton("Aceptar");
		btnAceptarConfiguracion.setBounds(295, 30, 89, 23);
		panel_9.add(btnAceptarConfiguracion);
		
		JButton btnCancelarConfiguracion_1 = new JButton("Cancelar");
		btnCancelarConfiguracion_1.setBounds(295, 65, 89, 23);
		panel_9.add(btnCancelarConfiguracion_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Ayuda", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tienda distribuidora");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(90, 11, 234, 31);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("XIOMI");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1_2.setBounds(90, 42, 234, 31);
		panel_4.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Autores");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(164, 94, 89, 14);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Alfredo Condori");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel_2_1.setBounds(135, 119, 146, 14);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Ever Garc\u00EDa");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel_2_1_1.setBounds(135, 141, 146, 14);
		panel_4.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Fiorela Quispe");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel_2_1_1_1.setBounds(135, 162, 146, 14);
		panel_4.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Jorge Bastidas");
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel_2_1_1_1_1.setBounds(135, 183, 146, 14);
		panel_4.add(lblNewLabel_2_1_1_1_1);
		
		JButton btnCerrarAyuda = new JButton("Cerrar");
		btnCerrarAyuda.setBounds(164, 225, 89, 23);
		panel_4.add(btnCerrarAyuda);
	}
}
