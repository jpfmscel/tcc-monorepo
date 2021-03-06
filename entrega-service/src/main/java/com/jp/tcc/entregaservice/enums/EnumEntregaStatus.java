package com.jp.tcc.entregaservice.enums;

import lombok.Getter;

@Getter
public enum EnumEntregaStatus {

	EM_TRANSITO(1, "Em Trânsito"), ENTREGUE(2, "Entregue"), FALHA_ENTREGA(3, "Falha Entrega"),
	EM_PREPARO(0, "Em Preparo");

	private int codigo;
	private String descricao;

	EnumEntregaStatus(int codigo, String descricao) {
		this.descricao = descricao;
		this.codigo = codigo;
	}
}
