package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import modelo.Libro;
import utiles.Validaciones;
import vista.UI;


public class ParaUI extends UI{
	Libreria libreria = new Libreria();
	Libro libro;
	
	public ParaUI() {
		libreria.iniciarLibreria();
		libreria.rellenarTabla(tablaLibros);
		
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(libreria.comprobarISBNExistente(textISBN.getText())) {
					JOptionPane.showMessageDialog(rootPane, "ISBN Existente\n\n"
				+ libreria.obtenerLibroDos(textISBN.getText()), "LIBRERIA", JOptionPane.INFORMATION_MESSAGE);
					
				}
				else if (validacionesOk()){
					
					libro = new Libro(textISBN.getText(), textTITULO.getText(), 
							textAUTOR.getText(), 
							textEDITORIAL.getText(), 
							Float.parseFloat(textPRECIO.getText()), 
							Integer.valueOf(textCantidad.getText()),
							getRadioSeleccion(grupoFormato), 
							getRadioSeleccion(grupoEstado));
					
					libreria.anadirLibros(libro);
					JOptionPane.showMessageDialog(rootPane, "Libro Guardado\n\n"
					+ libreria.obtenerLibroDos(textISBN.getText()), "LIBRERIA", JOptionPane.INFORMATION_MESSAGE);
					
					libreria.rellenarTabla(tablaLibros);
					vaciarCampos();
				}
				
				else {
					JOptionPane.showMessageDialog(rootPane, "CAMPOS ERRÓNEOS", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
			}	
		});
		
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(libreria.comprobarISBNExistente(textISBN.getText())) {
						tabbedPane.setSelectedIndex(paginaInicio);
						int borrarOK = JOptionPane.showConfirmDialog(rootPane, "¿QUIERES BORRAR EL LIBRO?", getTitle(), 0, 1);
						if (borrarOK == 0) {
							int indice = libreria.obtenerIdSeleccionado(tablaLibros, textISBN.getText());
							libreria.rellenarTabla(tablaLibros);
							libreria.borrarLibros(indice);
							libreria.rellenarTabla(tablaLibros);
							JOptionPane.showMessageDialog(rootPane, "LIBRO BORRADO", "ATENCION", JOptionPane.CANCEL_OPTION);
							vaciarCampos();

					}
				}
			}
		});
		
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ISBNsel = JOptionPane.showInputDialog(rootPane, "Introduce ISBN", "BUSCAR LIBRO", JOptionPane.INFORMATION_MESSAGE);
				if (libreria.comprobarISBNExistente(ISBNsel) == true) {
					tabbedPane.setSelectedIndex(paginaInicio);
					mostrarCampos(libreria.obtenerLibroDos(ISBNsel));
				}
				else if(ISBNsel == null) {
//					Cuando le das al botón de CANCELAR o CERRAR PESTAÑA
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "ISBN ERRÓNEO", "RESULTADO DE BÚSQUEDA", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validacionesOk()) {
					if(libreria.comprobarISBNExistente(textISBN.getText())) {
						if (JOptionPane.showConfirmDialog(rootPane, "¿QUIERES MODIFICAR EL LIBRO?", "", 0, 1) == 0) {
							Libro modificacion= new Libro(textISBN.getText(), textTITULO.getText(), 
									textAUTOR.getText(), 
									textEDITORIAL.getText(), 
									Float.parseFloat(textPRECIO.getText()), 
									Integer.valueOf(textCantidad.getText()),
									getRadioSeleccion(grupoFormato), 
									getRadioSeleccion(grupoEstado));
							
							libreria.modificarLibros(textISBN.getText(), modificacion);
							libreria.rellenarTabla(tablaLibros);
							JOptionPane.showMessageDialog(rootPane, "LIBRO MODIFICADO\n\n"
							+ libreria.obtenerLibroDos(textISBN.getText()), "MODIFICAR", JOptionPane.INFORMATION_MESSAGE);
							vaciarCampos();
						}
					}
					else {
						JOptionPane.showMessageDialog(rootPane, "ISBN NO ENCONTRADO", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "CAMPOS ERRÓNEOS", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(libreria.comprobarISBNExistente(textISBN.getText())) {
					String cantidadComprar = JOptionPane.showInputDialog(rootPane, "INGRESE CANTIDAD A COMPRAR", "COMPRAR", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane jPaneComprar = null;
					
					if(Validaciones.validarCantidad(cantidadComprar)){
						if (jPaneComprar.showConfirmDialog(rootPane, "¿QUIERES COMPRAR?", "", 0, 1) == 0) {
							
							Libro comprar = libreria.obtenerLibroDos(textISBN.getText());
							comprar.setCantidad(comprar.getCantidad() + Integer.parseInt(cantidadComprar));
							libreria.modificarLibros(textISBN.getText(), comprar);
							libreria.rellenarTabla(tablaLibros);
							vaciarCampos();
						}
					}
					else if(Validaciones.validarCantidad(cantidadComprar) == false && cantidadComprar != null) {
						JOptionPane.showMessageDialog(rootPane, "CAMPO ERRÓNEO", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(libreria.comprobarISBNExistente(textISBN.getText())) {
					String cantidadVender = JOptionPane.showInputDialog(rootPane, "INGRESE CANTIDAD A VENDER", "COMPRAR", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane jPaneVender = null;

					if(Validaciones.validarCantidad(cantidadVender)) {
						Libro vender = libreria.obtenerLibroDos(textISBN.getText());
						int resultado = vender.getCantidad() - Integer.parseInt(cantidadVender);
						if (jPaneVender.showConfirmDialog(rootPane, "¿QUIERES VENDER?", "", 0, 1) == 0) {
							if (resultado >= 0){
								vender.setCantidad(resultado);
								libreria.modificarLibros(textISBN.getText(), vender);
								libreria.rellenarTabla(tablaLibros);
								vaciarCampos();
							}
							else {
								JOptionPane.showMessageDialog(rootPane, "NO SE PUEDEN VENDER TANTOS LIBROS", "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					else if(Validaciones.validarCantidad(cantidadVender) == false && cantidadVender != null) {
						JOptionPane.showMessageDialog(rootPane, "CAMPO ERRÓNEO", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		
		
		
		tablaLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tablaLibros.setDefaultEditor(Object.class, null);
				if(e.getClickCount()==2) {
					tabbedPane.setSelectedIndex(paginaInicio);
					mostrarCampos(libreria.obtenerLibroSeleccionado(tablaLibros));
				}
				
			}
		});
	}
	
	public String getRadioSeleccion(ButtonGroup grupo) {
	    Enumeration<AbstractButton> buttons = grupo.getElements();
	    while (buttons.hasMoreElements()) {
	        JRadioButton button = (JRadioButton) buttons.nextElement();
	        if (button.isSelected()) {
	            return button.getText();
	        }
	    }
	    return null;
	}
	
    public void setRadioButton(JPanel panel, String seleccionLibro) {
	    Component[] Botones = panel.getComponents();
		for (Component radioButton : Botones ) {
            if (((AbstractButton) radioButton).getText().equals(seleccionLibro)) {
                ((AbstractButton) radioButton).setSelected(true);
                break;
            }
        }
    }
	

	
	private void mostrarCampos(Libro libro){
	textISBN.setText(libro.getISBN());
	textPRECIO.setText(String.valueOf(libro.getPrecio()));
	textTITULO.setText(libro.getTitulo());
	textEDITORIAL.setText(libro.getEditorial());
	textAUTOR.setText(libro.getAutor());
	textCantidad.setText(String.valueOf(libro.getCantidad()));
	setRadioButton(panelFormato, libro.getFormato());
	setRadioButton(panelEstado, libro.getEstado());
	}
	
	private void vaciarCampos() {
		textISBN.setText("");
		textPRECIO.setText("");
		textTITULO.setText("");
		textAUTOR.setText("");
		textEDITORIAL.setText("");
		textCantidad.setText("");
		grupoFormato.clearSelection();
		grupoEstado.clearSelection();
		
	}
	
	public boolean validacionesOk() {
		 if (Validaciones.validarISBN(textISBN.getText())
			&& Validaciones.validarLetras(textAUTOR.getText())
			&& Validaciones.validarFloat(textPRECIO.getText())
			&& Validaciones.validarLetras(textEDITORIAL.getText())
			&& !textTITULO.getText().isEmpty()			
			&& Validaciones.validarCantidad(textCantidad.getText())
			&& grupoFormato.getSelection() != null
			&& grupoEstado.getSelection() != null	
			){
			 return true;
		 }
		 return false;
	}
	
	
}
