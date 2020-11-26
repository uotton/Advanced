package ua.lviv.lgs.dao.implement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ua.lviv.lgs.Student;
import ua.lviv.lgs.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {
	private List<Student> students = new ArrayList<Student>();

	public StudentDaoImpl() {

	}

	@Override
	public Optional<Student> get(long id) {
		return Optional.ofNullable(students.get((int) id));
	}

	@Override
	public List<Student> getAll() {
		return students;
	}

	@Override
	public void save(Student t) {
		students.add(t);
	}

	@Override
	public void update(Student t) {
		students.remove((int) t.getId());
		students.add(t);
	}

	@Override
	public void delete(Student t) {
		students.remove(t);
	}
}
