/*
Andrew Siquieri - RA: 20872955 
Hadil Karim - RA: 20745273
Guilherme Lins - RA: 20699690
José Netto - RA: 20163147
Selma Masuzawa - RA: 20680327
*/
package br.com.siquieri.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//POJO do Venda
@Entity
@Table(name="venda")
public class Venda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int vendaid;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDUSUARIO")
	private Usuario usuario;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="vendas")
	private Set<Produto> produtos = new LinkedHashSet<>();

	public int getVendaid() {
		return vendaid;
	}

	public void setVendaid(int vendaid) {
		this.vendaid = vendaid;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(LinkedHashSet<Produto> produtos) {
        this.produtos = produtos;
    }

}
