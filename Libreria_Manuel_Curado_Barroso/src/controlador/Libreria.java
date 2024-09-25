package controlador;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Libro;

public class Libreria {
	private ArrayList<Libro> arrayLibro = new ArrayList<Libro>();
	
	public void anadirLibros(Libro libro) {
		arrayLibro.add(libro);
	}

	public void borrarLibros(int indice) {
		arrayLibro.remove(indice);
	}
	
	public void modificarLibros(String isbn, Libro modificacion) {
		for (int i = 0; i < this.arrayLibro.size(); i++) {
			if  (this.arrayLibro.get(i).getISBN().equals(isbn)) {
				arrayLibro.set(i, modificacion);
			}
		}

	}

	public ArrayList<Libro> getLibreria() {
		return arrayLibro;
	}
	
	public void rellenarTabla (JTable tablaLibros) {
		String nombresColumnas[] = {"ISBN", "TITULO", "EDITORIAL", "AUTOR", "PRECIO", "CANTIDAD", "FORMATO", "ESTADO"};
        String[][] filasTabla = new String [this.arrayLibro.size()][8];
        for (int i = 0; i < this.arrayLibro.size(); i++) {
            filasTabla[i][0] = this.arrayLibro.get(i).getISBN();
            filasTabla[i][1] = this.arrayLibro.get(i).getTitulo();
            filasTabla[i][2] = this.arrayLibro.get(i).getEditorial();
            filasTabla[i][3] = this.arrayLibro.get(i).getAutor();
            filasTabla[i][4] = String.valueOf(this.arrayLibro.get(i).getPrecio());
            filasTabla[i][5] = String.valueOf(this.arrayLibro.get(i).getCantidad());
            filasTabla[i][6] = this.arrayLibro.get(i).getFormato();
            filasTabla[i][7] = this.arrayLibro.get(i).getEstado();
            }
    
        DefaultTableModel tablaCompleta = new DefaultTableModel (filasTabla, nombresColumnas);
        tablaLibros.setModel(tablaCompleta);
	    
    }
	
	public int obtenerIdSeleccionado(JTable tablaLibros, String ISBN) {

		    for (int fila = 0; fila < tablaLibros.getRowCount(); fila++) {
		        for (int columna = 0; columna < tablaLibros.getColumnCount(); columna++) {
		            String valorCelda = tablaLibros.getValueAt(fila, columna).toString();
		            if (valorCelda.equals(ISBN)) {
		                return fila;
		            }
		        }
		    }
		return -1;
	}
	
	
	public Libro obtenerLibroDos(String ISBN) {
		for (int i = 0; i < this.arrayLibro.size(); i++) {
			if  (this.arrayLibro.get(i).getISBN().equals(ISBN)) {
				return arrayLibro.get(i);
			}
		}
		return null;
	}
	
	
	public Libro obtenerLibroSeleccionado(JTable tablaLibros) {
		for (int i = 0; i < arrayLibro.size(); i++) {
			if (tablaLibros.getSelectedRow() == i) {
				return arrayLibro.get(i);
			}
		}
		return null;
	}
	
	public boolean comprobarISBNExistente(String ISBN) {
		boolean resultado = false;
		for (int i = 0; i < arrayLibro.size(); i++) {			
			if (arrayLibro.get(i).getISBN().equals(ISBN)) {
				resultado = true;
			}
		}
		return resultado;
		
		
	}
	
	public void iniciarLibreria() {
        this.anadirLibros(new Libro("9780141036144", "1984", "George Orwell", "Penguin Books", 10.99f, 10, "Cartoné", "Novedad"));
        this.anadirLibros(new Libro("9780061120084", "To Kill a Mockingbird", "Harper Lee", "Harper Perennial Modern Classics", 12.99f, 10, "Cartoné", "Novedad"));
        this.anadirLibros(new Libro("9780062315007", "The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", 11.49f, 10, "Cartoné", "Novedad"));
        this.anadirLibros(new Libro("9780544003415", "The Hobbit", "J.R.R. Tolkien", "Houghton Mifflin Harcourt", 14.99f, 10, "Cartoné", "Novedad"));
        this.anadirLibros(new Libro("9780060850524", "The Great Gatsby", "F. Scott Fitzgerald", "Scribner", 9.99f, 10, "Cartoné", "Novedad"));
        this.anadirLibros(new Libro("9780743273565", "The Da Vinci Code", "Dan Brown", "Pocket Books", 13.95f, 10, "Cartoné", "Novedad"));
        this.anadirLibros(new Libro("9780061122415", "The Hunger Games", "Suzanne Collins", "Scholastic Press", 8.99f, 10, "Cartoné", "Novedad"));
        this.anadirLibros(new Libro("9780143134772", "Becoming", "Michelle Obama", "Penguin Books", 18.99f, 10, "Cartoné", "Novedad"));
        this.anadirLibros(new Libro("9780739326222", "The Road", "Cormac McCarthy", "Vintage", 10.95f, 10, "Cartoné", "Novedad"));
        this.anadirLibros(new Libro("9780062662851", "Educated", "Tara Westover", "Random House", 16.99f, 10, "Cartoné", "Novedad"));
    }
	  
	
	
}
