package datos;

public class Contacto {
	private int idContacto;
	private String direccion;
	private String telefono;
	private String email;
	private Cliente cliente;

	public Contacto() {
		super();
	}

	public Contacto(String direccion, String telefono, String email, Cliente cliente) {
		super();
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.cliente = cliente;
	}

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nContacto \nDireccion: " + direccion + "\n Telefono:" + telefono + "\n Email: " + email;
	}

}
