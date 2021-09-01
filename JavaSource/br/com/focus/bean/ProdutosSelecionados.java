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
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * @author Thiago M. Farias
 * 
 */

/**
 * Declara que é havera uma entidade no BD. para persistencia.
 */
@Entity
public class ProdutosSelecionados implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProdutosSelecionados;
	@Column( length = 100)
	private String descricao;
	@Column(length = 10)
	private String classificacaoFiscal;
	@Column(length = 10)
	private String situacaoTributaria;
	@Column(length = 10)
	private Double precoUnitario;
	@Column(length = 10)
	private Integer quantidade;
	@Column(length = 10)
	private Double precoTotal;
	@Column(length = 10)
	private String unidade;
	@Column(length = 10)
	private Double aliquotaIcms;
	@Column(length = 10)
	private Double aliquotaIpi;
	@Column(length = 1)
	private String identificador;
	@ManyToOne
	private Produto produto;
	@ManyToOne
	private Receita receita;

	public ProdutosSelecionados() {
		super();
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
	 * @return the precoUnitario
	 */
	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	/**
	 * @param precoUnitario the precoUnitario to set
	 */
	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the precoTotal
	 */
	@Transient
	public Double getPrecoTotal() {
		if(getPrecoUnitario()!=null && getQuantidade()!= null)
			return getPrecoUnitario().doubleValue()*getQuantidade();
		return precoTotal;
	}

	/**
	 * @param precoTotal the precoTotal to set
	 */
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}

	/**
	 * @return the unidade
	 */
	public String getUnidade() {
		return unidade;
	}

	/**
	 * @param unidade the unidade to set
	 */
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	/**
	 * @return the aliquotaIcms
	 */
	public Double getAliquotaIcms() {
		return aliquotaIcms;
	}

	/**
	 * @param aliquotaIcms the aliquotaIcms to set
	 */
	public void setAliquotaIcms(Double aliquotaIcms) {
		this.aliquotaIcms = aliquotaIcms;
	}

	/**
	 * @return the aliquotaIpi
	 */
	public Double getAliquotaIpi() {
		return aliquotaIpi;
	}

	/**
	 * @param aliquotaIpi the aliquotaIpi to set
	 */
	public void setAliquotaIpi(Double aliquotaIpi) {
		this.aliquotaIpi = aliquotaIpi;
	}

	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * @return the idProdutosSelecionados
	 */
	public Long getIdProdutosSelecionados() {
		return idProdutosSelecionados;
	}

	/**
	 * @param idProdutosSelecionados the idProdutosSelecionados to set
	 */
	public void setIdProdutosSelecionados(Long idProdutosSelecionados) {
		this.idProdutosSelecionados = idProdutosSelecionados;
	}

	/**
	 * @return the classificacaoFiscal
	 */
	public String getClassificacaoFiscal() {
		return classificacaoFiscal;
	}

	/**
	 * @param classificacaoFiscal the classificacaoFiscal to set
	 */
	public void setClassificacaoFiscal(String classificacaoFiscal) {
		this.classificacaoFiscal = classificacaoFiscal;
	}

	/**
	 * @return the situacaoTributaria
	 */
	public String getSituacaoTributaria() {
		return situacaoTributaria;
	}

	/**
	 * @param situacaoTributaria the situacaoTributaria to set
	 */
	public void setSituacaoTributaria(String situacaoTributaria) {
		this.situacaoTributaria = situacaoTributaria;
	}

	/**
	 * @return the receita
	 */
	public Receita getReceita() {
		return receita;
	}

	/**
	 * @param receita the receita to set
	 */
	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

}
