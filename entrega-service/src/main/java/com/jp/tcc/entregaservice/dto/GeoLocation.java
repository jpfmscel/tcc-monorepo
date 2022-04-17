package com.jp.tcc.entregaservice.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GeoLocation {
	Float latitude;
	Float longitude;
}
