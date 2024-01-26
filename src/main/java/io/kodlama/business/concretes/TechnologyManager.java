package io.kodlama.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.business.abstratcs.TechnologyService;
import io.kodlama.business.dto.technology.requests.AddTechnologyRequest;
import io.kodlama.business.dto.technology.requests.UpdateTechnologyRequest;
import io.kodlama.business.dto.technology.responces.GetAllTechnologyResponse;
import io.kodlama.business.dto.technology.responces.GetByIdTechnologyResponse;
import io.kodlama.core.utilities.mapper.ModelMapperService;
import io.kodlama.dataAccess.abstracts.TechnologyDao;
import io.kodlama.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	@Autowired
	private TechnologyDao technologyDao;

	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = technologyDao.findAll();
		List<GetAllTechnologyResponse> technologyResponse = technologies.stream().map(
				technology -> this.modelMapperService.forResponse().map(technology, GetAllTechnologyResponse.class))
				.toList();
		return technologyResponse;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) {
		Technology technology = technologyDao.findById(id).orElseThrow();
		GetByIdTechnologyResponse technologyResponse = this.modelMapperService.forResponse().map(technology,
				GetByIdTechnologyResponse.class);
		return technologyResponse;
	}

	@Override
	public void add(AddTechnologyRequest request) {
		Technology technology = this.modelMapperService.forRequest().map(request, Technology.class);
		this.technologyDao.save(technology);

	}

	@Override
	public void update(int id, UpdateTechnologyRequest request) {
		Technology technology = technologyDao.findById(id).orElseThrow();
		this.modelMapperService.forRequest().map(request, technology);
		this.technologyDao.save(technology);

	}

	@Override
	public void delete(int id) {
		Technology technology = technologyDao.findById(id).orElseThrow();
		this.technologyDao.delete(technology);

	}

}
