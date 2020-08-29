package model.service;

import model.entity.StudentEntity;
import model.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static StudentService ourInstance = new StudentService();

    public static StudentService getInstance() {
        return ourInstance;
    }

    private StudentService() {
    }

    //--------------INSERTION------------------
    public void add(StudentEntity studentEntity) throws Exception{
        try (StudentRepository repository = new StudentRepository()) {
            repository.insert(studentEntity);
            repository.commit();
        }
    }

    //--------------EDIT------------
    public void edit(StudentEntity studentEntity) throws Exception{
        try (StudentRepository repository = new StudentRepository()) {
            repository.update(studentEntity);
            repository.commit();
        }
    }

    //--------------REMOVE-------------
    public void remmove(long id) throws Exception{
        try (StudentRepository repository = new StudentRepository()) {
            repository.delete(id);
            repository.commit();
        }
    }

    //----------------REPORT------------
    public List<StudentEntity> report() throws Exception{
        List<StudentEntity> list;
        try (StudentRepository repository = new StudentRepository()){
            list = repository.select();
        }
        return list;
    }
}
