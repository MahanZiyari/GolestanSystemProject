package model.service;

import model.entity.CourseEntity;
import model.entity.StudentEntity;
import model.entity.TermCourseEntity;
import model.repository.CourseRepository;
import model.repository.StudentRepository;
import model.repository.TermCourseRepository;

import java.util.List;

public class TermCourseService
{
    private static TermCourseService ourInstance = new TermCourseService();

    public static TermCourseService getInstance() {
        return ourInstance;
    }

    private TermCourseService() {}

    //--------------INSERTION------------------
    public void add(TermCourseEntity termCourseEntity) throws Exception
    {
        try (TermCourseRepository termCourseRepository = new TermCourseRepository()) {
            termCourseRepository.insert(termCourseEntity);
            termCourseRepository.commit();
        }
    }

    //--------------EDIT------------
    public void edit(TermCourseEntity termCourseEntity) throws Exception
    {
        try (TermCourseRepository termCourseRepository = new TermCourseRepository()) {
            termCourseRepository.update(termCourseEntity);
            termCourseRepository.commit();
        }
    }

    //--------------REMOVE-------------
    public void remove(long code) throws Exception
    {
        try (TermCourseRepository termCourseRepository = new TermCourseRepository()) {
            termCourseRepository.delete(code);
            termCourseRepository.commit();
        }
    }
    //-------------Report---------------
    public List<TermCourseEntity> report() throws Exception{
        List<TermCourseEntity> termCourselist;
        try (TermCourseRepository termCourseRepository = new TermCourseRepository()){
            termCourselist = termCourseRepository.select();
            termCourseRepository.commit();
        }

        return termCourselist;
    }
}
