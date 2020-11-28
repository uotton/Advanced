package ua.lviv.lgs.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.University;
import ua.lviv.lgs.dao.UniversityRepository;
import ua.lviv.lgs.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityRepository repository;

	@Override
	public University save(University university) {
		return repository.saveAndFlush(university);
	}

	@Override
	public University findById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public University update(University university) {
		return repository.save(university);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<University> getAll() {
		return repository.findAll();
	}

	@Override
	public List<University> findByName(String name) {
		return repository.findByName(name);
	}
	@Override
	public List<University> findByLevel(Integer level){
		return repository.findByLevel(level);
	}

	@Override
	public List<University> findByAddress(String address) {
		return repository.findByAddress(address);
	}

}