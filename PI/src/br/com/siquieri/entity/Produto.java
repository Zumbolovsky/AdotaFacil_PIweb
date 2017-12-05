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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//POJO do Produto
@Entity
@Table(name="produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int produtoid;
	
        @Column(name="NOME")
	private String nome;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="PRECO")
	private double preco;
	
	@Column(name="QUANTIDADE")
	private int quantidade;
	
	@Lob
	@Column(name="IMAGEM")
	private byte[] imagem;
	
	@ManyToMany(cascade=CascadeType.ALL)
        @JoinTable(
                name="venda_produto",
                joinColumns={@JoinColumn(name="IDPRODUTO")},
                inverseJoinColumns={@JoinColumn(name="IDVENDA")}
        )
	private Set<Venda> vendas = new LinkedHashSet<>();

	public int getProdutoid() {
		return produtoid;
	}

	public void setProdutoid(int produtoid) {
		this.produtoid = produtoid;
	}

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
   
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Set<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(LinkedHashSet<Venda> vendas) {
		this.vendas = vendas;
	}

}
