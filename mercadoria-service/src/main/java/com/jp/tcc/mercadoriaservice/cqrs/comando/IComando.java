package com.jp.tcc.mercadoriaservice.cqrs.comando;

public interface IComando<S extends IComandoRequest> {

	void execute(S request);

}
