/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.bean.superClasses;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * @author Thiago M. Farias
 * 
 */
@MappedSuperclass
public class GenericIdDesc implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descricao;
    private String status;
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
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
