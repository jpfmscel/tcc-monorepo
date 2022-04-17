package com.jp.tcc.entregaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.tcc.entregaservice.dto.request.AtualizarEntregaRequestDTO;
import com.jp.tcc.entregaservice.service.EntregaService;

@RestController
@RequestMapping(path = "/api/entregas")
public class EntregaController {

	@Autowired
	private EntregaService service;

	@PutMapping(value = "/{entregaId}")
	public ResponseEntity findById(@PathVariable String entregaId, @RequestBody AtualizarEntregaRequestDTO entregaRequest) {
		
		service.atualizarEntrega(entregaId, entregaRequest);
		
		return ResponseEntity.ok(null);
	}

}
