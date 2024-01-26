package io.kodlama.business.dto.technology.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTechnologyRequest {
	private String name;
	@NotNull
	private int languageId;

}
