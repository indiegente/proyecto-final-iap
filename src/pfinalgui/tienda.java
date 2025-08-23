package pfinalgui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class tienda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tienda frame = new tienda();
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
	public tienda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setBounds(0, 0, 113, 27);
		contentPane.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(29, 98, 99, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Archivo");
		mnNewMenu_1.setBounds(10, 38, 173, 20);
		contentPane.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salir");
		mnNewMenu_1.add(mntmNewMenuItem);
	}
}
