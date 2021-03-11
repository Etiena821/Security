package com.squd6.security.services;

import com.squd6.security.models.Student;
import com.squd6.security.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class StudentService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return studentRepository.findStudentByEmail(s).get();
    }
}
