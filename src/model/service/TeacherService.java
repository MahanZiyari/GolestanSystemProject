package model.service;

import model.entity.TeacherEntity;
import model.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    private static TeacherService ourInstance = new TeacherService();

    public static TeacherService getInstance() {
        return ourInstance;
    }

    private TeacherService() {
    }

    //---------------ADDING------------
    public void add(TeacherEntity teacherEntity) throws Exception{
        try (TeacherRepository repository = new TeacherRepository()) {
            repository.insert(teacherEntity);
            repository.commit();
        }
    }

    //---------------EDIT---------------
    public void remove(TeacherEntity teacherEntity) throws Exception{
        try (TeacherRepository repository = new TeacherRepository()){
            repository.update(teacherEntity);
            repository.commit();
        }
    }

    //--------------REMOVE-------------
    public void remove(long id) throws Exception{
        try (TeacherRepository repository = new TeacherRepository()){
            repository.delete(id);
            repository.commit();
        }
    }


    //------------------REPORT---------------------
    public List<TeacherEntity> report() throws Exception{
        List<TeacherEntity> list = new ArrayList<>();
        try (TeacherRepository repository = new TeacherRepository()){
            list = repository.select();
            repository.commit();
        }
        return list;
    }
}
