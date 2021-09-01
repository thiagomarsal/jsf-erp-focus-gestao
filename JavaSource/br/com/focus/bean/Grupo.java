/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.com.focus.bean.superClasses.GenericIdDesc;

/**
 * @author Thiago M. Farias
 * 
 */

/**
 * Declara que é uma SubClasse.
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
/**
 * Declara que é havera uma entidade no BD. para persistencia.
 */
@Entity
public class Grupo extends GenericIdDesc implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupo;
	
	
	/**
	 * 
	 */
	public Grupo() {
		super();
	}
	/**
	 * @return the idGrupo
	 */
	public Long getIdGrupo() {
		return idGrupo;
	}
	/**
	 * @param idGrupo the idGrupo to set
	 */
	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}
}
