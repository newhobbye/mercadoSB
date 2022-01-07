package br.com.mercado.mercadosb.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String nome;
	@NotBlank
	@Min(0)
	private double precoVarejo;
	@NotBlank
	@Min(0)
	private double precoAtacado;
	@NotBlank
	@Min(0)
	private int qtd;
	@NotBlank
	private String categoria;
	
	public Produto() {
		
	}

	public Produto(String nome, double precoVarejo, double precoAtacado, int qtd, String categoria) {
		this.nome = nome;
		this.precoVarejo = precoVarejo;
		this.precoAtacado = precoAtacado;
		this.qtd = qtd;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoVarejo() {
		return precoVarejo;
	}

	public void setPrecoVarejo(double precoVarejo) {
		this.precoVarejo = precoVarejo;
	}

	public double getPrecoAtacado() {
		return precoAtacado;
	}

	public void setPrecoAtacado(double precoAtacado) {
		this.precoAtacado = precoAtacado;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
