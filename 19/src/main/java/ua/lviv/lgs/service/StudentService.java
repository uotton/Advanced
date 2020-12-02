package ua.lviv.lgs.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javassist.NotFoundException;
import ua.lviv.lgs.domain.Student;
import ua.lviv.lgs.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Student storeStudent(String firstName, String lastName, Integer age, MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Student student = null;
		if (!fileName.contains("..")) {
			student = new Student(firstName, lastName, age, fileName, file.getContentType(), file.getBytes());
		}
		return studentRepository.save(student);

	}

	public Student getStudent(String studentId) throws NotFoundException {
		return studentRepository.findById(studentId)
				.orElseThrow(() -> new NotFoundException("Student not found with Id =" + studentId));
	}
}