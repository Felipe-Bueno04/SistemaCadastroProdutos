package br.org.unisenaipr.comercial.fabricante.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_FABRICANTE")
@SequenceGenerator(name = "SEQ_FABRICANTE", sequenceName = "S_FABRICANTE", allocationSize = 1)
public class Fabricante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FABRICANTE")
	@Column(name = "fabricante_id", nullable = false)
	private Long id;
	
	@Column(name = "fabricante_nomefantasia", nullable = false, length = 200)
	private String nomeFantasia;
	
	@Column(name = "fabricante_razaosocial", nullable = false, length = 200)
	private String razaoSocial;
	
	@Column(name = "fabricante_cnpj", nullable = false, length = 15, unique = true)
	private String cnpj;
	
	@Column(name = "fabricante_endereco", nullable = false, length = 150)
	private String endereco;
	
	@Column(name = "fabricante_telefone", nullable = false, length = 25)
	private String telefone;
	
	@Column(name = "fabricante_email", nullable = false, length = 150)
	private String email;
	
	@Column(name = "fabricante_vendedor", nullable = false, length = 150)
	private String vendedor;

	
	public Fabricante() {
		super();
	}


	public Fabricante(Long id, String nomeFantasia, String razaoSocial, String cnpj, String endereco, String telefone,
			String email, String vendedor) {
		super();
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.vendedor = vendedor;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getVendedor() {
		return vendedor;
	}


	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}	
}
