package com.jp.tcc.entregaservice.cqrs.comando;

public interface IComando<S extends IComandoRequest> {

	void execute(S request);

}
