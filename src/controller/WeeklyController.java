package controller;

import model.entity.CourseEntity;
import model.entity.EnrollmentEntity;
import model.entity.TeacherEntity;
import model.entity.TermCourseEntity;
import model.service.CourseService;
import model.service.EnrollmentService;
import model.service.TeacherService;
import model.service.TermCourseService;

import java.util.ArrayList;
import java.util.List;

public class WeeklyController {
    private static WeeklyController ourInstance = new WeeklyController();

    public static WeeklyController getInstance() {
        return ourInstance;
    }

    private WeeklyController() {
    }

    public List<EnrollmentEntity> selector(long stdId, int term) throws Exception {
        List<EnrollmentEntity> entities = EnrollmentService.getInstance().report();
        List<EnrollmentEntity> studentList = new ArrayList<>();
        for (EnrollmentEntity entity : entities){
            if (entity.getStdId() == stdId && entity.getTerm() == term)
                studentList.add(entity);
        }
        return studentList;
    }

    public String nameFinder(EnrollmentEntity entity) throws Exception {
        List<CourseEntity> courseEntities = CourseService.getInstance().report();
        for (CourseEntity courseEntity : courseEntities){
            if (entity.getId().substring(0, 7).equalsIgnoreCase(String.valueOf(courseEntity.getCode())))
                return courseEntity.getName();
        }
        return null;
    }

    public String TeacherFinder(EnrollmentEntity enrollmentEntity) throws Exception {
        List<TermCourseEntity> termCourseEntities = TermCourseService.getInstance().report();
        for (TermCourseEntity entity : termCourseEntities){
            if (Long.valueOf(enrollmentEntity.getId().substring(0,7)) == entity.getCourse_id()){
                return searchTeacher(entity.getTeacher_id());
            }
        }
        return null;
    }

    private String searchTeacher(long id){
        List<TeacherEntity> list = null;
        try {
            list = TeacherService.getInstance().report();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (TeacherEntity entity : list){
            if (id == entity.getId())
                return entity.getName();
        }
        return null;
    }
}
