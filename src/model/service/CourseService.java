package model.service;

import model.entity.CourseEntity;
import model.repository.CourseRepository;

import java.util.List;

public class CourseService {
    private static CourseService ourInstance = new CourseService();

    public static CourseService getInstance() {
        return ourInstance;
    }

    private CourseService() {
    }

    public void add(CourseEntity courseEntity) throws Exception{
        try (CourseRepository repository = new CourseRepository()){
            repository.insert(courseEntity);
            repository.commit();
        }
    }

    public void edit(CourseEntity courseEntity) throws Exception{
        try (CourseRepository repository = new CourseRepository()){
            repository.update(courseEntity);
            repository.commit();
        }
    }

    public void remove(long code) throws Exception{
        try (CourseRepository repository = new CourseRepository()){
            repository.delete(code);
            repository.commit();
        }
    }

    public List<CourseEntity> report() throws Exception{
        List<CourseEntity> list;
        try (CourseRepository repository = new CourseRepository()){
            list = repository.select();
            repository.commit();
        }
        return list;
    }

    public CourseEntity reportById(long id) throws Exception{
        CourseEntity courseEntity;
        try (CourseRepository repository = new CourseRepository()){
            courseEntity = repository.selectById(id);
        }
        return courseEntity;
    }
}
