package com.jp.tcc.entregaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.tcc.entregaservice.dto.request.AtualizarEntregaRequestDTO;
import com.jp.tcc.entregaservice.service.EntregaService;

@RestController
@RequestMapping(path = "/api/entregas")
@SuppressWarnings("rawtypes")
public class EntregaController {

	@Autowired
	private EntregaService service;

	@PutMapping(value = "/{entregaId}")
	public ResponseEntity update(@PathVariable String entregaId, @RequestBody AtualizarEntregaRequestDTO entregaRequest) {
		service.atualizarEntrega(entregaId, entregaRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping(value = "/{entregaId}")
	public ResponseEntity findById(@PathVariable String entregaId) {
		var buscarEntregaResponse = service.buscarEntrega(entregaId);
		return ResponseEntity.ok(buscarEntregaResponse);
	}
	
}
