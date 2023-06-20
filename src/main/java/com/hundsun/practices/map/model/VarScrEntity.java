package com.hundsun.practices.map.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VarScrEntity {
	private String connectDpInterCode;
	private String dpInterCode;
}
