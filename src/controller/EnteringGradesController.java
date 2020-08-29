package controller;

import model.entity.CourseEntity;
import model.entity.EnrollmentEntity;
import model.entity.StudentEntity;
import model.service.CourseService;
import model.service.EnrollmentService;
import model.service.StudentService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EnteringGradesController {
    private static EnteringGradesController ourInstance = new EnteringGradesController();

    public static EnteringGradesController getInstance() {
        return ourInstance;
    }

    private EnteringGradesController() {
    }

    public String nameFinder(long id){
        List<CourseEntity> courseist = new ArrayList<>();
        try {
            courseist = CourseService.getInstance().report();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "WARNING", 0);
        }
        for (CourseEntity entity : courseist){
            if (id == entity.getCode())
                return entity.getName();
        }
        return null;
    }

    public int absenceChecker(long stdId, String course){
        List<EnrollmentEntity> list = new ArrayList<>();
        try {
            list = EnrollmentService.getInstance().report();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        for (EnrollmentEntity enrollmentEntity : list){
            if (stdId == enrollmentEntity.getStdId() && enrollmentEntity.getId().equalsIgnoreCase(course))
                return enrollmentEntity.getAbsence();
        }
        return -1;
    }

    public List<EnrollmentEntity> studentSelector(String id, int term) throws Exception {
        List<EnrollmentEntity> enrollmentList = EnrollmentService.getInstance().report();
        List<EnrollmentEntity> students = new ArrayList<>();
        for (int i = 0; i < enrollmentList.size(); i++){
            if (id.equalsIgnoreCase(enrollmentList.get(i).getId()) && term == enrollmentList.get(i).getTerm()){
                students.add(enrollmentList.get(i));
            }
        }
        return students;
    }

    public StudentEntity studentFinder(long stdId) throws Exception {
        List<StudentEntity> list = StudentService.getInstance().report();
        for (StudentEntity entity : list){
            if (stdId == entity.getId()){
                return entity;
            }
        }
        return null;
    }
}
