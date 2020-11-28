package ua.lviv.lgs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ua.lviv.lgs.University;

public interface UniversityRepository extends JpaRepository<University, Long>, CrudRepository<University, Long> {
	List<University> findByName(String name);

	List<University> findByLevel(Integer level);

	List<University> findByAddress(String address);
}

