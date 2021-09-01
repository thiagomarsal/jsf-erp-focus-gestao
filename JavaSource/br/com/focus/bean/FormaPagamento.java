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
public class FormaPagamento implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormaPagamento;
    @Column(nullable = false, length = 40)
    private String descricao;
    
    
	/**
	 * 
	 */
	public FormaPagamento() {
		super();
	}
	/**
	 * @return the idFormaPagamento
	 */
	public Long getIdFormaPagamento() {
		return idFormaPagamento;
	}
	/**
	 * @param idFormaPagamento the idFormaPagamento to set
	 */
	public void setIdFormaPagamento(Long idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
