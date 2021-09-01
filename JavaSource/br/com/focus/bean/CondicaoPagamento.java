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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Thiago M. Farias
 * 
 */

/*
 * Declara que é havera uma entidade no BD. para persistencia.
 */
@Entity
public class CondicaoPagamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCondicaoPagamento;
	@Column(nullable = false, length = 40)
	private String descricao;
	private Integer parcelas;
	

	/**
	 * 
	 */
	public CondicaoPagamento() {
		super();
	}

	/**
	 * @param formaPagamento
	 */
	public CondicaoPagamento(FormaPagamento formaPagamento) {
		super();
	}

	/**
	 * @return the idCondicaoPagamento
	 */
	public Long getIdCondicaoPagamento() {
		return idCondicaoPagamento;
	}

	/**
	 * @param idCondicaoPagamento
	 *            the idCondicaoPagamento to set
	 */
	public void setIdCondicaoPagamento(Long idCondicaoPagamento) {
		this.idCondicaoPagamento = idCondicaoPagamento;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the parcelas
	 */
	public Integer getParcelas() {
		return parcelas;
	}

	/**
	 * @param parcelas
	 *            the parcelas to set
	 */
	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

}
