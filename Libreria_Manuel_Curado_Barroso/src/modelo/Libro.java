package modelo;

public class Libro {
	
	private String ISBN;
	private String titulo;
	private String autor;
	private String editorial;
	private float precio;
	private int cantidad;
	private String formato;
	private String estado;

	public Libro(String iSBN, String titulo, String autor, String editorial, float precio, int cantidad, String formato,
			String estado) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.precio = precio;
		this.cantidad = cantidad;
		this.formato = formato;
		this.estado = estado;
	}

	public String toString() {
		return "ISBN: " + ISBN + 
				"\nTÍTULO: " + titulo + 
				"\nAUTOR: " + autor + 
				"\nEDITORIAL: " + editorial + 
				"\nPRECIO:  " + precio +
				"\nCANTIDAD:  " + cantidad +
				"\nFORMATO:  " + formato +
				"\nESTADO:  " + estado;
	}

	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
