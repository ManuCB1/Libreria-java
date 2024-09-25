package utiles;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class Validaciones {
	
	public static boolean validarISBN(String ISBN) {
		return (ISBN.length()==13 && Pattern.matches("[0-9]*", ISBN)); // El * indica que se repite 0 o más veces.
		//return Pattern.matches("[0-9]{13}", ISBN); Significa lo mismo.
	}
	
	public static boolean validarLetras(String nombre) {
		return Pattern.matches("[a-zA-Z\\s\\p{Punct}]+", nombre);
	}
	
	public static boolean validarCantidad(String nombre) {
		try {
			int numero = Integer.parseInt(nombre);
			if (!nombre.matches("^\\d+$") && numero < 0) {
			return false;
		}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static boolean validarFloat(String nombre) {
			try {
				char charAt = nombre.charAt(nombre.length()-1);
				if (Float.parseFloat(nombre) < 0 || charAt == 'f' || charAt == 'd') {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
		return true;
	}
}
