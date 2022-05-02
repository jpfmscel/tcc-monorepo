package com.jp.tcc.entregaservice.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class GeoLocation {
	
	@NonNull
	Float latitude;
	
	@NonNull
	Float longitude;
	
	public boolean isValid() {
		return Math.abs(this.getLatitude()) <= 90 && Math.abs(this.getLongitude()) <= 180;  
	}
}
