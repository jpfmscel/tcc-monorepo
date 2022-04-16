package com.jp.tcc.entregaservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/entregas")
public class EntregaController {

//	@Autowired
//	private EntregaService service;

	@GetMapping(value = "/{entregaId}")
	public ResponseEntity findById(@PathVariable String entregaId) {
		return ResponseEntity.ok(null);
	}

}
