/**
 * 
 */
package br.com.focus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author jose
 *
 */
@Entity
public class ContaReceber implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContaReceber;
	private Date dataVencimento;
	private Date dataQuitacao;
	private Double valor;
	private Double valorRecebido;
	private Double multa;
	private Double juros;
	private Double desconto;
	private String numeroDocumento;
	private String obs;
	@Enumerated(EnumType.STRING)
    private StatusContas statusContas;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFormaPagamento")
	@Fetch(FetchMode.JOIN)
	private FormaPagamento formaPagamento;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente")
	@Fetch(FetchMode.JOIN)
	private Cliente cliente;
	@ManyToOne
	private Venda venda;
	@ManyToOne
	private OrdemServico ordemServico;
	
	
	/**
	 * 
	 */
	public ContaReceber() {
		super();
	}
	/**
	 * @param compra
	 */
	public ContaReceber(Venda venda) {
		super();
		this.venda = venda;
	}
	/**
	 * @param formaPagamento
	 * @param fornecedor
	 */
	public ContaReceber(FormaPagamento formaPagamento, Cliente cliente) {
		super();
		this.formaPagamento = formaPagamento;
		this.cliente = cliente;
	}
	/**
	 * @return the idContaReceber
	 */
	public Long getIdContaReceber() {
		return idContaReceber;
	}
	/**
	 * @param idContaReceber the idContaReceber to set
	 */
	public void setIdContaReceber(Long idContaReceber) {
		this.idContaReceber = idContaReceber;
	}
	/**
	 * @return the dataVencimento
	 */
	public Date getDataVencimento() {
		return dataVencimento;
	}
	/**
	 * @param dataVencimento the dataVencimento to set
	 */
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	/**
	 * @return the dataQuitacao
	 */
	public Date getDataQuitacao() {
		return dataQuitacao;
	}
	/**
	 * @param dataQuitacao the dataQuitacao to set
	 */
	public void setDataQuitacao(Date dataQuitacao) {
		this.dataQuitacao = dataQuitacao;
	}
	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}
	/**
	 * @return the valorRecebido
	 */
	public Double getValorRecebido() {
		return valorRecebido;
	}
	/**
	 * @param valorRecebido the valorRecebido to set
	 */
	public void setValorRecebido(Double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}
	/**
	 * @return the multa
	 */
	public Double getMulta() {
		return multa;
	}
	/**
	 * @param multa the multa to set
	 */
	public void setMulta(Double multa) {
		this.multa = multa;
	}
	/**
	 * @return the juros
	 */
	public Double getJuros() {
		return juros;
	}
	/**
	 * @param juros the juros to set
	 */
	public void setJuros(Double juros) {
		this.juros = juros;
	}
	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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
	 * @return the statusContas
	 */
	public StatusContas getStatusContas() {
		return statusContas;
	}
	/**
	 * @param statusContas the statusContas to set
	 */
	public void setStatusContas(StatusContas statusContas) {
		this.statusContas = statusContas;
	}
	/**
	 * @return the formaPagamento
	 */
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	/**
	 * @param formaPagamento the formaPagamento to set
	 */
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the venda
	 */
	public Venda getVenda() {
		return venda;
	}
	/**
	 * @param venda the venda to set
	 */
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	/**
	 * @return the ordemServico
	 */
	public OrdemServico getOrdemServico() {
		return ordemServico;
	}
	/**
	 * @param ordemServico the ordemServico to set
	 */
	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}
	/**
	 * @return the desconto
	 */
	public Double getDesconto() {
		return desconto;
	}
	/**
	 * @param desconto the desconto to set
	 */
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
}
