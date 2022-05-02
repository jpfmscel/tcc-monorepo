package com.jp.tcc.mercadoriaservice.repository;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("entrega-service")
public interface EntregaClient {

	@GetMapping("/api/entregas/{id}")
    ResponseEntity<HashMap> getEntregaById(@PathVariable("id") String id);
}
