package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Boton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Informacion extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Informacion dialog = new Informacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Informacion() {
		
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBackground(new Color(208, 121, 3));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			Boton cancelButton = new Boton("Cerrar", 340, 250);
			cancelButton.setFocusable(false);
			cancelButton.setFocusTraversalKeysEnabled(false);
			cancelButton.setFocusPainted(false);
			cancelButton.setBounds(327, 250, 102, 39);
			cancelButton.setBackground(new Color(196, 114, 3));
			cancelButton.setFont(new Font("Sitka Small", Font.BOLD, 15));
			//cancelButton.setBounds(197, 179, 65, 23);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		
		JLabel lbl1 = new JLabel("Programa para la vizualizaci\u00F3n ");
		lbl1.setBounds(17, 11, 423, 32);
		lbl1.setFont(new Font("Sitka Small", Font.BOLD, 25));
		contentPanel.add(lbl1);
		
		JLabel lbl2 = new JLabel("y an\u00E1lisis de m\u00E9todos de ");
		lbl2.setBounds(89, 43, 267, 26);
		lbl2.setFont(new Font("Sitka Small", Font.BOLD, 20));
		contentPanel.add(lbl2);
		
		JLabel lbl3 = new JLabel("Ordenamiento y B\u00FAsqueda");
		lbl3.setBounds(46, 67, 351, 32);
		lbl3.setFont(new Font("Sitka Small", Font.BOLD, 25));
		contentPanel.add(lbl3);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblAutor.setBounds(46, 123, 46, 20);
		contentPanel.add(lblAutor);
		
		JLabel lblNombre = new JLabel("Diego Herrera De la Calle");
		lblNombre.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNombre.setBounds(150, 123, 206, 20);
		contentPanel.add(lblNombre);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNivel.setBounds(46, 148, 42, 20);
		contentPanel.add(lblNivel);
		
		JLabel lblNivelAutor = new JLabel("Quinto Ingenier\u00EDa en Computaci\u00F3n");
		lblNivelAutor.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNivelAutor.setBounds(150, 148, 277, 20);
		contentPanel.add(lblNivelAutor);
		
		JLabel lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblAsignatura.setBounds(46, 173, 87, 20);
		contentPanel.add(lblAsignatura);
		
		JLabel lblNewLabel_5 = new JLabel("Dise\u00F1o y An\u00E1lisis de Algoritmos");
		lblNewLabel_5.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNewLabel_5.setBounds(150, 173, 257, 20);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblProfesor.setBounds(46, 201, 70, 20);
		contentPanel.add(lblProfesor);
		
		JLabel lblNewLabel_7 = new JLabel("Dr. Eric R. Jeltsch Figueroa");
		lblNewLabel_7.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNewLabel_7.setBounds(150, 201, 225, 20);
		contentPanel.add(lblNewLabel_7);
	}

}
