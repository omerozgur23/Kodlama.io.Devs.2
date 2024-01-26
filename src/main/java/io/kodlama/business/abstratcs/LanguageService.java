package io.kodlama.business.abstratcs;

import java.util.List;

import io.kodlama.business.dto.language.requests.AddLanguageRequest;
import io.kodlama.business.dto.language.requests.UpdateLanguageRequest;
import io.kodlama.business.dto.language.responces.GetAllLanguageResponse;
import io.kodlama.business.dto.language.responces.GetByIdLanguageResponse;

public interface LanguageService {
	List<GetAllLanguageResponse> getAll();

	GetByIdLanguageResponse getById(int id);

	void add(AddLanguageRequest request);

	void update(int id, UpdateLanguageRequest request);

	void delete(int id);

}
