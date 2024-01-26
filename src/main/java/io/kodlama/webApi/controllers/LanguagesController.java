package io.kodlama.webApi.controllers;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.business.abstratcs.LanguageService;
import io.kodlama.business.dto.language.requests.AddLanguageRequest;
import io.kodlama.business.dto.language.requests.UpdateLanguageRequest;
import io.kodlama.business.dto.language.responces.GetAllLanguageResponse;
import io.kodlama.business.dto.language.responces.GetByIdLanguageResponse;

@RestController
@RequestMapping("/api/language")
public class LanguagesController {
	@Autowired
	private LanguageService languageService;
	JSONObject result = new JSONObject();

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GetAllLanguageResponse> getAll() {
		return this.languageService.getAll();
	}

	@GetMapping(path = ("/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public GetByIdLanguageResponse getById(@PathVariable int id) {
		return this.languageService.getById(id);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String add(@RequestBody AddLanguageRequest request) {
		result.put("Message", request.getName() + " language is added");
		languageService.add(request);
		return result.toString();
	}

	@PutMapping(path = ("/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public String update(@PathVariable int id, @RequestBody UpdateLanguageRequest request) {
		result.put("Messsage", "Language is updated: " + id);
		this.languageService.update(id, request);
		return result.toString();
	}

	@DeleteMapping(path = ("/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@PathVariable int id) {
		result.put("Message", "Language is deleted: " + id);
		this.languageService.delete(id);
		return result.toString();
	}

}
