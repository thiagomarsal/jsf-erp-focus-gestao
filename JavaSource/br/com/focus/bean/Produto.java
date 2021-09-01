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
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author Thiago M. Farias
 * 
 */

/*
 * Declara que é havera uma entidade no BD. para persistencia.
 */
@Entity
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	@Column(nullable = false, length = 100)
	private String referencia;
	@Column(nullable = false, length = 100)
	private String descricao;
	@Column(nullable = true, length = 100)
	private String obs;
	@Column(nullable = true, length = 10)
	private Integer estoque;
	@Column(nullable = true, length = 10)
	private Double precoCusto;
	@Column(nullable = true, length = 10)
	private Double acrescimo;
	@Column(nullable = true, length = 10)
	private Double precoVenda;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idMarca")
	@Fetch(FetchMode.JOIN)
	private Marca marca;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idLinha")
	@Fetch(FetchMode.JOIN)
	private Linha linha;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUnidade")
	@Fetch(FetchMode.JOIN)
	private Unidade unidade;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idModelo")
	@Fetch(FetchMode.JOIN)
	private Modelo modelo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCor")
	@Fetch(FetchMode.JOIN)
	private Cor cor;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idGrupo")
	@Fetch(FetchMode.JOIN)
	private Grupo grupo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipo")
	@Fetch(FetchMode.JOIN)
	private Tipo tipo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMaterial")
	@Fetch(FetchMode.JOIN)
	private Material material;

	public Produto() {
		super();
	}

	/**
	 * @param marca
	 * @param linha
	 * @param unidade
	 * @param modelo
	 * @param cor
	 * @param grupo
	 * @param tipo
	 * @param material
	 */
	public Produto(Marca marca, Linha linha, Unidade unidade, Modelo modelo,
			Cor cor, Grupo grupo, Tipo tipo, Material material) {
		super();
		this.marca = marca;
		this.linha = linha;
		this.unidade = unidade;
		this.modelo = modelo;
		this.cor = cor;
		this.grupo = grupo;
		this.tipo = tipo;
		this.material = material;
	}

	/**
	 * @return the idProduto
	 */
	public Long getIdProduto() {
		return idProduto;
	}

	/**
	 * @param idProduto
	 *            the idProduto to set
	 */
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
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
	 * @return the obs
	 */
	public String getObs() {
		return obs;
	}

	/**
	 * @param obs
	 *            the obs to set
	 */
	public void setObs(String obs) {
		this.obs = obs;
	}

	/**
	 * @return the estoque
	 */
	public Integer getEstoque() {
		return estoque;
	}

	/**
	 * @param estoque
	 *            the estoque to set
	 */
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	/**
	 * @return the precoCusto
	 */
	public Double getPrecoCusto() {
		return precoCusto;
	}

	/**
	 * @param precoCusto
	 *            the precoCusto to set
	 */
	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}

	/**
	 * @return the acrescimo
	 */
	public Double getAcrescimo() {
		return acrescimo;
	}

	/**
	 * @param acrescimo
	 *            the acrescimo to set
	 */
	public void setAcrescimo(Double acrescimo) {
		this.acrescimo = acrescimo;
	}

	/**
	 * @return the marca
	 */
	public Marca getMarca() {
		return marca;
	}

	/**
	 * @param marca
	 *            the marca to set
	 */
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	/**
	 * @return the linha
	 */
	public Linha getLinha() {
		return linha;
	}

	/**
	 * @param linha
	 *            the linha to set
	 */
	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	/**
	 * @return the unidade
	 */
	public Unidade getUnidade() {
		return unidade;
	}

	/**
	 * @param unidade
	 *            the unidade to set
	 */
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	/**
	 * @return the modelo
	 */
	public Modelo getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 *            the modelo to set
	 */
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the cor
	 */
	public Cor getCor() {
		return cor;
	}

	/**
	 * @param cor
	 *            the cor to set
	 */
	public void setCor(Cor cor) {
		this.cor = cor;
	}

	/**
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo
	 *            the grupo to set
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the tipo
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * @param material
	 *            the material to set
	 */
	public void setMaterial(Material material) {
		this.material = material;
	}

	/**
	 * @return the precoVenda
	 */
	@Transient
	public Double getPrecoVenda() {
		if ((acrescimo != null) && (precoCusto != null)) {
			Double valor = new Double(0);
			valor = precoCusto;
			precoVenda = (valor * acrescimo / 100.0) + valor;
		}
		return precoVenda;
	}

	/**
	 * @param precoVenda
	 *            the precoVenda to set
	 */
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idProduto == null) ? 0 : idProduto.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Produto other = (Produto) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Produto clone() throws CloneNotSupportedException {
		Produto p = new Produto();
		p.setIdProduto(new Long(this.idProduto.longValue()));
		p.setDescricao(this.descricao);
		p.setAcrescimo(new Double(this.acrescimo == null ? 0 : this.acrescimo.floatValue()));
		p.setUnidade(this.unidade);
		p.setCor(this.cor);
		p.setEstoque(new Integer(this.estoque == null ? 0 : this.estoque.intValue()));
		p.setGrupo(this.grupo);
		p.setLinha(this.linha);
		p.setMarca(this.marca);
		p.setTipo(this.tipo);
		p.setMaterial(this.material);
		p.setObs(this.obs);
		p.setModelo(this.modelo);
		p.setPrecoCusto(new Double(this.precoCusto == null ? 0: this.precoCusto.floatValue()));
		p.setPrecoVenda(new Double(this.precoVenda == null ? 0: this.precoVenda.floatValue()));
		return p;
	}

}
