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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.focus.bean.superClasses.Entidade;

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
public class Fornecedor extends Entidade implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFornecedor;
    @Column(nullable = true, length = 20)
    private String contato;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCidade")
    @Fetch(FetchMode.JOIN)
    private Cidade cidade;

    public Fornecedor() {
        super();
    }

    public Fornecedor(Cidade cidade) {
        this.cidade = cidade;
    }

	/**
	 * @return the idFornecedor
	 */
	public Long getIdFornecedor() {
		return idFornecedor;
	}

	/**
	 * @param idFornecedor the idFornecedor to set
	 */
	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	/**
	 * @return the contato
	 */
	public String getContato() {
		return contato;
	}

	/**
	 * @param contato the contato to set
	 */
	public void setContato(String contato) {
		this.contato = contato;
	}

	/**
	 * @return the cidade
	 */
	public Cidade getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
    
}
