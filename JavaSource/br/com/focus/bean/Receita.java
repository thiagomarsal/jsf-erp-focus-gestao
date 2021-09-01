/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Thiago M. Farias
 * 
 */

/**
 * Declara que é havera uma entidade no BD. para persistencia.
 */
@Entity
public class Receita implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceita;
    @Column(nullable = true, length = 100)
    private String descricao;
    @Column(nullable = true, length = 100)
    private String obs;
    @Column(nullable = true, length = 40)
    private String olho;
    @Column(nullable = true, length = 10)
    private Double diametro;
    @Column(nullable = true)
    private Double espessura;
    @Column(nullable = true)
    private Double curva;
    @Column(nullable = true)
    private Double eixo;
    @Column(nullable = true)
    private Double precoVenda;
    @Column(nullable = true)
    private Double totalServicos;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ServicosSelecionados> servicosSelecionados;
    
    public Receita() {
        super();
    }

	/**
	 * @return the idReceita
	 */
	public Long getIdReceita() {
		return idReceita;
	}

	/**
	 * @param idReceita the idReceita to set
	 */
	public void setIdReceita(Long idReceita) {
		this.idReceita = idReceita;
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

	/**
	 * @return the obs
	 */
	public String getObs() {
		return obs;
	}

	/**
	 * @param obs the obs to set
	 */
	public void setObs(String obs) {
		this.obs = obs;
	}

	/**
	 * @return the olho
	 */
	public String getOlho() {
		return olho;
	}

	/**
	 * @param olho the olho to set
	 */
	public void setOlho(String olho) {
		this.olho = olho;
	}

	/**
	 * @return the diametro
	 */
	public Double getDiametro() {
		return diametro;
	}

	/**
	 * @param diametro the diametro to set
	 */
	public void setDiametro(Double diametro) {
		this.diametro = diametro;
	}

	/**
	 * @return the espessura
	 */
	public Double getEspessura() {
		return espessura;
	}

	/**
	 * @param espessura the espessura to set
	 */
	public void setEspessura(Double espessura) {
		this.espessura = espessura;
	}

	/**
	 * @return the curva
	 */
	public Double getCurva() {
		return curva;
	}

	/**
	 * @param curva the curva to set
	 */
	public void setCurva(Double curva) {
		this.curva = curva;
	}

	/**
	 * @return the eixo
	 */
	public Double getEixo() {
		return eixo;
	}

	/**
	 * @param eixo the eixo to set
	 */
	public void setEixo(Double eixo) {
		this.eixo = eixo;
	}

	/**
	 * @return the servicosSelecionados
	 */
	public List<ServicosSelecionados> getServicosSelecionados() {
		return servicosSelecionados;
	}


	/**
	 * @param servicosSelecionados the servicosSelecionados to set
	 */
	public void setServicosSelecionados(List<ServicosSelecionados> servicosSelecionados) {
		this.servicosSelecionados = servicosSelecionados;
	}

	/**
	 * @return the precoVenda
	 */
	public Double getPrecoVenda() {
		return precoVenda;
	}


	/**
	 * @param precoVenda the precoVenda to set
	 */
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}


	/**
	 * @return the totalServicos
	 */
	public Double getTotalServicos() {
		return totalServicos;
	}


	/**
	 * @param totalServicos the totalServicos to set
	 */
	public void setTotalServicos(Double totalServicos) {
		this.totalServicos = totalServicos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idReceita == null) ? 0 : idReceita.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receita other = (Receita) obj;
		if (idReceita == null) {
			if (other.idReceita != null)
				return false;
		} else if (!idReceita.equals(other.idReceita))
			return false;
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Receita clone() throws CloneNotSupportedException {
		Receita r = new Receita();
		r.setIdReceita(new Long(this.idReceita.longValue()));
		r.setDescricao(this.descricao);
		r.setCurva(this.curva);
		r.setDiametro(this.diametro);
		r.setEixo(this.eixo);
		r.setEspessura(this.espessura);
		r.setOlho(this.olho);
		r.setObs(this.obs);
		r.setPrecoVenda(new Double(this.precoVenda == null ? 0: this.precoVenda.floatValue()));
		r.setServicosSelecionados(this.servicosSelecionados);
		return r;
	}
}
