package com.jp.tcc.mercadoriaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.tcc.mercadoriaservice.dto.request.AtualizarEntregaRequestDTO;
import com.jp.tcc.mercadoriaservice.repository.EntregaClient;
import com.jp.tcc.mercadoriaservice.service.EntregaService;

@RestController
@RequestMapping(path = "/api/mercadorias")
@SuppressWarnings("rawtypes")
public class MercadoriaController {

	@Autowired
	private EntregaClient entregaClient;

	@GetMapping(value = "/{entregaId}")
	public ResponseEntity findById(@PathVariable String entregaId) {
		var buscarEntregaResponse = entregaClient.getEntregaById(entregaId);
		return ResponseEntity.ok(buscarEntregaResponse.getBody());
	}
	
}
