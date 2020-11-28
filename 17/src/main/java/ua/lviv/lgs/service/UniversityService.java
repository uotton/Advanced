package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.University;

public interface UniversityService {
	University save(University university);

	University findById(Long id);

	University update(University university);

	void deleteById(Long id);

	List<University> getAll();

	List<University> findByName(String name);

	List<University> findByLevel(Integer level);

	List<University> findByAddress(String address);

}
