/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author Thiago M. Farias
 * 
 */

@Entity
public class Cidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long idCidade;
	@Column(length = 3)
	private String ddd;
	@Column(nullable = false, length = 30)
	private String nome;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEstado")
	@Fetch(FetchMode.JOIN)
	private Estado estado;
	
	/**
	 * 
	 */
	public Cidade() {
		super();
	}
	
	/**
	 * @param estado
	 */
	public Cidade(Estado estado) {
		super();
		this.estado = estado;
	}

	/**
	 * @return the idCidade
	 */
	public Long getIdCidade() {
		return idCidade;
	}
	/**
	 * @param idCidade the idCidade to set
	 */
	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}
	/**
	 * @return the ddd
	 */
	public String getDdd() {
		return ddd;
	}
	/**
	 * @param ddd the ddd to set
	 */
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
