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

import io.kodlama.business.abstratcs.TechnologyService;
import io.kodlama.business.dto.technology.requests.AddTechnologyRequest;
import io.kodlama.business.dto.technology.requests.UpdateTechnologyRequest;
import io.kodlama.business.dto.technology.responces.GetAllTechnologyResponse;
import io.kodlama.business.dto.technology.responces.GetByIdTechnologyResponse;

@RestController
@RequestMapping("/api/technology")
public class TechnologiesController {
	@Autowired
	private TechnologyService technologyService;
	JSONObject result = new JSONObject();

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GetAllTechnologyResponse> getAll() {
		return this.technologyService.getAll();
	}

	@GetMapping(path = ("/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public GetByIdTechnologyResponse getById(@PathVariable int id) {
		return this.technologyService.getById(id);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String add(@RequestBody AddTechnologyRequest request) {
		result.put("Message", request.getName() + " is added to language id: " + request.getLanguageId());
		this.technologyService.add(request);
		return result.toString();
	}

	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String update(int id, UpdateTechnologyRequest request) {
		result.put("Messsage", "Technology is updated: " + id);
		this.technologyService.update(id, request);
		return result.toString();
	}

	@DeleteMapping(path = ("/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@PathVariable int id) {
		result.put("Message", "Technology is deleted: " + id);
		this.technologyService.delete(id);
		return result.toString();
	}
}
