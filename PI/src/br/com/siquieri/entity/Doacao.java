/*
Andrew Siquieri - RA: 20872955 
Hadil Karim - RA: 20745273
Guilherme Lins - RA: 20699690
José Netto - RA: 20163147
Selma Masuzawa - RA: 20680327
*/
package br.com.siquieri.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//POJO do Doacao
@Entity
@Table(name="doacao")
public class Doacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int doacaoid;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="RG")
	private String rg;
	
	@Column(name="CPF_CNPJ")
	private String cpf;
	
	@Column(name="ENDERECO")
	private String endereco;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="QUANTIA")
	private double quantia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDUSUARIO")
	private Usuario usuario;

	public int getDoacaoid() {
		return doacaoid;
	}

	public void setDoacaoid(int doacaoid) {
		this.doacaoid = doacaoid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getQuantia() {
		return quantia;
	}

	public void setQuantia(double quantia) {
		this.quantia = quantia;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
