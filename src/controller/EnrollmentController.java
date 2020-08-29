package controller;

import model.entity.*;
import model.service.CourseService;
import model.service.EnrollmentService;
import model.service.TermCourseService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentController {
    private static EnrollmentController ourInstance = new EnrollmentController();

    public static EnrollmentController getInstance() {
        return ourInstance;
    }

    private EnrollmentController() {
    }

    public List<TermCourseEntity> fillSelectionTable(StudentEntity studentEntity) throws Exception {
        List<TermCourseEntity> studentList = new ArrayList<>();
        List<TermCourseEntity> termList = TermCourseService.getInstance().report();
        for (TermCourseEntity entity:termList)
            if (idChecker(entity.getCourse_id(), studentEntity))
                studentList.add(entity);
        return studentList;
    }
    private boolean idChecker(long id, StudentEntity studentEntity) throws Exception {
        List<CourseEntity> courseEntities = CourseService.getInstance().report();
        for (CourseEntity entity : courseEntities){
            if (id == entity.getCode() && entity.getField().equalsIgnoreCase(studentEntity.getMaajor())){
                return true;
            }
            if (id == entity.getCode() && entity.getField().equalsIgnoreCase("public")){
                return true;
            }
            if (id == entity.getCode() && entity.getField().equalsIgnoreCase("base")){
                return true;
            }
        }
        return false;
    }

    public List<CourseEntity> completeSelectionTable(List<TermCourseEntity> list) throws Exception {
        List<CourseEntity> courseEntities = new ArrayList<>();
        List<CourseEntity> courseEntityList = CourseService.getInstance().report();
        for (TermCourseEntity entity: list){
            for (int i = 0; i < courseEntityList.size(); i++){
                if (entity.getCourse_id() == courseEntityList.get(i).getCode()){
                    courseEntities.add(courseEntityList.get(i));
                }
            }
        }
        return courseEntities;
    }

    public void resultTableChecker(List<EnrollmentAssitanceEntity> list, long stdId) throws InputException {
        if (checkNeed(list))                     throw new InputException("please select the need of the courses too");
        else if (checkPrerequisite(list, stdId)) throw new InputException("prerequisite rule is broken");
        else if (checkNameCount(list))           throw new InputException("can NOT PICK same course twice");
        else if (checkUnitCount(list))           throw new InputException("units out of bounds");
        else if (checkPublicCount(list))         throw new InputException("you can only pick two public course");
        else if (checkRepetitive(list, stdId))   throw new InputException("REPETITIVE course detected");


    }

    private boolean checkNeed(List<EnrollmentAssitanceEntity> list){
        int state = 0;
        for (EnrollmentAssitanceEntity entity : list){
            if (String.valueOf(entity.getNeed()).length() > 2)
                state++;
        }
        for (int i = 0; i < list.size(); i++){
            for (int j = i+1; j < list.size(); j++){
                    if (list.get(i).getNeed() == list.get(j).getId())
                        state -= 2;
            }
        }
        //System.out.println(state);
        if (state == 0) return false;
        return true;
    }
    private boolean checkPrerequisite(List<EnrollmentAssitanceEntity> list, long stdId)  {
        int state = 0;
        List<EnrollmentEntity> enrollmentList = null;
        for (EnrollmentAssitanceEntity entity : list){
            if (String.valueOf(entity.getPrerequisite()).length() > 2) {
                state++;
            }
        }
        //System.out.println("state = " + state);




        try { enrollmentList = EnrollmentService.getInstance().report(); }
        catch (Exception e) { JOptionPane.showMessageDialog(null, e.getMessage()); }
        //System.out.println("enrollment list length : " + enrollmentList.size());



        for (EnrollmentAssitanceEntity assitanceEntity : list){
            for (EnrollmentEntity entity : enrollmentList){
                if (assitanceEntity.getPrerequisite() == Long.valueOf(entity.getId().substring(0, 7)) && entity.getStdId() == stdId)
                    state--;
            }
        }
        //System.out.println("new state = " + state);
        if (state == 0) return false;
        return true;
    }
    private boolean checkUnitCount(List<EnrollmentAssitanceEntity> list){
        int unit = 0;
        for (EnrollmentAssitanceEntity entity : list)
            unit += entity.getUnit();
        if (unit > 20) return true;
        return false;
    }
    private boolean checkNameCount(List<EnrollmentAssitanceEntity> list){
        int i = 0,j = 0;
        for (i = 0; i < list.size(); i++)
            for (j = i+1; j < list.size(); j++) {
                if (list.get(i).getName().equalsIgnoreCase(list.get(j).getName()))
                    return true;
            }
        return false;
    }
    private boolean checkPublicCount(List<EnrollmentAssitanceEntity> list){
        int counter = 0;
        for (EnrollmentAssitanceEntity entity : list) {
            if (entity.getType().equalsIgnoreCase("public")) counter++;
        }
        if (counter > 2) return true;
        else return false;
    }
    private boolean checkRepetitive(List<EnrollmentAssitanceEntity> list, long stdId){
        List<EnrollmentEntity> enrollmentList = null;
        try { enrollmentList = EnrollmentService.getInstance().report(); }
        catch (Exception e) { JOptionPane.showMessageDialog(null, e.getMessage()); }

        for (EnrollmentAssitanceEntity assitanceEntity : list)
            for (EnrollmentEntity entity : enrollmentList){
                if (assitanceEntity.getId() == Long.valueOf(entity.getId().substring(0,7)) && stdId == entity.getStdId())
                    return true;
            }
        return false;
    }
}
