package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class UI extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final int paginaInicio = 0;
	protected static final int paginaEstanteria = 1;
	

	protected JPanel contentPane;
	protected JLabel lblISBN;
	protected JLabel lblTITULO;
	protected JLabel lblAUTOR;
	protected JLabel lblEDITORIAL;
	protected JLabel lblPRECIO;
	protected JLabel lblCantidad;
	
	protected JTextField textISBN;
	protected JTextField textTITULO;
	protected JTextField textAUTOR;
	protected JTextField textEDITORIAL;
	protected JTextField textPRECIO;
	protected JTextField textCantidad;
	
	protected JTabbedPane tabbedPane;
	protected JScrollPane scrollPane;
	protected JTable tablaLibros;
	
//	Botones
	protected JButton btnGuardar;
	protected JButton btnSalir;
	protected JButton btnBorrar;
	protected JButton btnConsultar;
	protected JButton btnModificar;
	protected JButton btnComprar;
	protected JButton btnVender;
	protected JButton btnLimpiarCampos;
	
	protected JLabel lblImagen;
	
//	Formatos
	protected JPanel panelFormato;
	protected JLabel lblFormato;
	protected ButtonGroup grupoFormato;
	protected JRadioButton rdbtnCartone;
	protected JRadioButton rdbtnEspiral;
	protected JRadioButton rdbtnGrapada;
	protected JRadioButton rdbtnRustica;
	
	
//	Estados
	protected JLabel lblEstado;
	protected JPanel panelEstado;
	protected ButtonGroup grupoEstado;
	protected JRadioButton rdbtnReedicion;
	protected JRadioButton rdbtnNovedad;

	
	

	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
	public UI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 543);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(0, 172, 172));
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("LIBRERIA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		GroupLayout gl_panelSuperior = new GroupLayout(panelSuperior);
		gl_panelSuperior.setHorizontalGroup(
			gl_panelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSuperior.createSequentialGroup()
					.addContainerGap(341, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(345))
		);
		gl_panelSuperior.setVerticalGroup(
			gl_panelSuperior.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelSuperior.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelSuperior.setLayout(gl_panelSuperior);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Libro = new JPanel();
		Libro.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("LIBRO", null, Libro, null);
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));

		
		lblISBN = new JLabel("ISBN:");
		lblISBN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textISBN = new JTextField();
		textISBN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textISBN.setColumns(10);
		
		lblTITULO = new JLabel("TITULO:");
		lblTITULO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textTITULO = new JTextField();
		textTITULO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textTITULO.setColumns(10);
		
		lblAUTOR = new JLabel("AUTOR:");
		lblAUTOR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textAUTOR = new JTextField();
		textAUTOR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textAUTOR.setColumns(10);
		
		textEDITORIAL = new JTextField();
		textEDITORIAL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textEDITORIAL.setColumns(10);
		
		lblPRECIO = new JLabel("PRECIO:");
		lblPRECIO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textPRECIO = new JTextField();
		textPRECIO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPRECIO.setColumns(10);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(UI.class.getResource("/imagen/libro.png")));
		
		lblFormato = new JLabel("FORMATO");
		lblFormato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		panelFormato = new JPanel();
		panelFormato.setBackground(new Color(255, 222, 173));
		panelFormato.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		panelEstado = new JPanel();
		panelEstado.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelEstado.setBackground(new Color(255, 222, 173));
		
		lblEDITORIAL = new JLabel("EDITORIAL:");
		lblEDITORIAL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblCantidad = new JLabel("CANTIDAD:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textCantidad = new JTextField();
		textCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textCantidad.setColumns(10);
		
		btnLimpiarCampos = new JButton("Limpiar Campos");
		btnLimpiarCampos.setFocusPainted(false);
		btnLimpiarCampos.setBackground(new Color(255, 255, 255));

		btnLimpiarCampos.setIcon(new ImageIcon(UI.class.getResource("/imagen/borrador.png")));
		GroupLayout gl_Libro = new GroupLayout(Libro);
		gl_Libro.setHorizontalGroup(
			gl_Libro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Libro.createSequentialGroup()
					.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_Libro.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING)
									.addComponent(lblISBN)
									.addComponent(lblTITULO, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPRECIO)
									.addComponent(lblEDITORIAL, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblFormato, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblAUTOR, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
								.addGap(16)
								.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_Libro.createSequentialGroup()
										.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING)
											.addComponent(textTITULO, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
											.addComponent(textISBN, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
											.addComponent(textAUTOR, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
											.addComponent(textEDITORIAL, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
											.addComponent(textPRECIO, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
										.addComponent(lblImagen, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
										.addGap(109))
									.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_Libro.createSequentialGroup()
										.addGap(408)
										.addComponent(btnLimpiarCampos, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_Libro.createSequentialGroup()
								.addGap(117)
								.addComponent(panelFormato, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_Libro.createSequentialGroup()
							.addGap(117)
							.addComponent(panelEstado, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_Libro.setVerticalGroup(
			gl_Libro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Libro.createSequentialGroup()
					.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Libro.createSequentialGroup()
							.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Libro.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING)
										.addComponent(lblISBN)
										.addComponent(textISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textTITULO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_Libro.createParallelGroup(Alignment.BASELINE)
										.addComponent(textAUTOR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAUTOR, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_Libro.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_Libro.createSequentialGroup()
											.addComponent(lblEDITORIAL)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblPRECIO, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_Libro.createSequentialGroup()
											.addComponent(textEDITORIAL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textPRECIO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_Libro.createSequentialGroup()
									.addGap(46)
									.addComponent(lblTITULO, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_Libro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFormato, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelFormato, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_Libro.createSequentialGroup()
							.addGap(22)
							.addComponent(lblImagen, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Libro.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelEstado, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_Libro.createSequentialGroup()
							.addGap(4)
							.addComponent(btnLimpiarCampos, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_Libro.linkSize(SwingConstants.VERTICAL, new Component[] {lblPRECIO, lblFormato});
		
		rdbtnReedicion = new JRadioButton("Reedicion");
		rdbtnReedicion.setBackground(new Color(255, 222, 173));
		
		rdbtnNovedad = new JRadioButton("Novedad");
		rdbtnNovedad.setBackground(new Color(255, 222, 173));
		GroupLayout gl_panelEstado = new GroupLayout(panelEstado);
		gl_panelEstado.setHorizontalGroup(
			gl_panelEstado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEstado.createSequentialGroup()
					.addGap(51)
					.addComponent(rdbtnReedicion)
					.addGap(46)
					.addComponent(rdbtnNovedad)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_panelEstado.setVerticalGroup(
			gl_panelEstado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEstado.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelEstado.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnReedicion)
						.addComponent(rdbtnNovedad))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		panelEstado.setLayout(gl_panelEstado);
		
		

		
		
		rdbtnCartone = new JRadioButton("Cartoné");
		rdbtnCartone.setBackground(new Color(255, 222, 173));
		
		rdbtnRustica = new JRadioButton("Rústica");
		rdbtnRustica.setBackground(new Color(255, 222, 173));
		
		rdbtnGrapada = new JRadioButton("Grapada");
		rdbtnGrapada.setBackground(new Color(255, 222, 173));
		
		rdbtnEspiral = new JRadioButton("Espiral");
		rdbtnEspiral.setBackground(new Color(255, 222, 173));
		panelFormato.setLayout(new MigLayout("", "[61px][59px][63px][59px]", "[21px]"));
		panelFormato.add(rdbtnCartone, "cell 0 0,alignx left,aligny top");
		panelFormato.add(rdbtnRustica, "cell 1 0,alignx left,aligny top");
		panelFormato.add(rdbtnGrapada, "cell 2 0,alignx left,aligny top");
		panelFormato.add(rdbtnEspiral, "cell 3 0,alignx left,aligny top");
		Libro.setLayout(gl_Libro);
		
		
 
        
		grupoFormato = new ButtonGroup();
		Component[] BotonesFormato = panelFormato.getComponents();

		for (Component botonesFormato : BotonesFormato) {
		    if (botonesFormato instanceof JRadioButton) {
		        grupoFormato.add((JRadioButton) botonesFormato);
		    }
		}
		
		
		grupoEstado = new ButtonGroup();
		Component[] BotonesEstado = panelEstado.getComponents();
		
		for (Component botonesEstado : BotonesEstado) {
		    if (botonesEstado instanceof JRadioButton) {
		    	grupoEstado.add((JRadioButton) botonesEstado);
		    }
		}
		
		
		JPanel Estanteria = new JPanel();
		Estanteria.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("ESTANTERIA", null, Estanteria, null);
		Estanteria.setLayout(new GridLayout(1, 0, 0, 0));
		
		scrollPane = new JScrollPane();
		Estanteria.add(scrollPane);
		
		tablaLibros = new JTable();
		tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(tablaLibros);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelInferior.setBackground(new Color(255, 255, 255));
		contentPane.add(panelInferior, BorderLayout.SOUTH);
					
					btnGuardar = new JButton("GUARDAR");
					btnGuardar.setFocusPainted(false);
					btnGuardar.setBorderPainted(false);
					btnGuardar.setIcon(new ImageIcon(UI.class.getResource("/imagen/guardar.png")));
					btnGuardar.setBackground(new Color(255, 255, 255));
						
						btnConsultar = new JButton("Consultar");
						btnConsultar.setFocusPainted(false);
						btnConsultar.setBorderPainted(false);
						btnConsultar.setBackground(new Color(255, 255, 255));
						btnConsultar.setIcon(new ImageIcon(UI.class.getResource("/imagen/consulta.png")));
						
						btnBorrar = new JButton("Borrar");
						btnBorrar.setFocusPainted(false);
						btnBorrar.setBorderPainted(false);
						btnBorrar.setIcon(new ImageIcon(UI.class.getResource("/imagen/borrar.png")));
						btnBorrar.setBackground(new Color(255, 255, 255));
					
						btnSalir = new JButton("SALIR");
						btnSalir.setFocusPainted(false);
						btnSalir.setBackground(new Color(255, 255, 255));
						btnSalir.setBorderPainted(false);
						btnSalir.setIcon(new ImageIcon(UI.class.getResource("/imagen/salida.png")));

						panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
						panelInferior.add(btnGuardar);
						panelInferior.add(btnConsultar);
						
						btnModificar = new JButton("Modificar");
						btnModificar.setFocusPainted(false);
						btnModificar.setBorderPainted(false);
						btnModificar.setBorder(UIManager.getBorder("Button.border"));
						btnModificar.setBackground(new Color(255, 255, 255));
						btnModificar.setIcon(new ImageIcon(UI.class.getResource("/imagen/modificar.png")));
						panelInferior.add(btnModificar);
						
						btnComprar = new JButton("Comprar");
						btnComprar.setFocusPainted(false);
						btnComprar.setBackground(new Color(255, 255, 255));
						btnComprar.setBorderPainted(false);
						btnComprar.setIcon(new ImageIcon(UI.class.getResource("/imagen/comprar.png")));
						panelInferior.add(btnComprar);
						
						btnVender = new JButton("Vender");
						btnVender.setFocusPainted(false);
						btnVender.setBackground(new Color(255, 255, 255));
						btnVender.setBorderPainted(false);
						btnVender.setIcon(new ImageIcon(UI.class.getResource("/imagen/vender.png")));
						panelInferior.add(btnVender);
	
						panelInferior.add(btnBorrar);
						panelInferior.add(btnSalir);
	}
}
