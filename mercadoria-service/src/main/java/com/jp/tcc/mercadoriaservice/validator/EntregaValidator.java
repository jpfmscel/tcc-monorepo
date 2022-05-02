package com.jp.tcc.mercadoriaservice.validator;

import java.util.ArrayList;
import java.util.List;

import com.jp.tcc.mercadoriaservice.dto.request.AtualizarEntregaRequestDTO;

public class EntregaValidator {

	
	public static List<String> validate(AtualizarEntregaRequestDTO requestDTO){
		
		var validationErrors = new ArrayList<String>();
		
		if(requestDTO.getGeolocation() == null || requestDTO.getGeolocation().getLatitude() == null || requestDTO.getGeolocation().getLatitude() < -90.0f ||  requestDTO.getGeolocation().getLatitude() > 90.0f || 
				requestDTO.getGeolocation().getLongitude() == null || requestDTO.getGeolocation().getLongitude() < -180.0f ||requestDTO.getGeolocation().getLongitude() > 180.0f) {
			validationErrors.add("Geolocation incorreta : " + requestDTO.getGeolocation());
		}
		
		if(requestDTO.getStatus() == null) {
			validationErrors.add("Status da entrega incorreto : " + requestDTO.getGeolocation());
		}
		
		return validationErrors;
	}
}
