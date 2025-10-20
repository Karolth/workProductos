package com.productoswork.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //Anotaciones JPA
@Table(name = "usuarios")
public class Usuario {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idUsuario;
	    private String documento; // cédula o número de identificación
	    private String password;
	    
		public Usuario() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Integer getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(Integer idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getDocumento() {
			return documento;
		}

		public void setDocumento(String documento) {
			this.documento = documento;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Usuario(Integer idUsuario, String documento, String password) {
			super();
			this.idUsuario = idUsuario;
			this.documento = documento;
			this.password = password;
		}

		@Override
		public String toString() {
			return "Usuario [idUsuario=" + idUsuario + ", documento=" + documento + ", password=" + password + "]";
		}
	    
	    
}
