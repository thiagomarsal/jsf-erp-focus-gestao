package br.com.focus.bean;



public enum StatusContas {
	
	ABERTO("Aberto"),
	QUITADO("Quitado"),
	CANCELADO("Cancelado"),
	NOPRAZO("No Prazo"),
	ATRASADO("Atrasado");
	
	private StatusContas(String descricao){
		this.descricao = descricao;
	}
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
