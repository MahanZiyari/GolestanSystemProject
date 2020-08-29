package controller;

import model.entity.CourseEntity;
import model.entity.EnrollmentEntity;
import model.entity.TermSummaryEntity;
import model.service.CourseService;
import model.service.EnrollmentService;

import java.util.ArrayList;
import java.util.List;

public class StudentInformationController {
    private static StudentInformationController ourInstance = new StudentInformationController();

    public static StudentInformationController getInstance() {
        return ourInstance;
    }

    private StudentInformationController() {
    }

    public List<TermSummaryEntity> lister(long stdId, List<TermSummaryEntity> termSummaryEntities) throws Exception {
        List<EnrollmentEntity> entityList = EnrollmentService.getInstance().report();
        System.out.println("entity list size = " + entityList.size());
        int i = 0;
        for (i = 0; i+1 < entityList.size(); i++){
            if (entityList.get(i).getTerm() != entityList.get(i+1).getTerm()){
                termSummaryEntities.add(new TermSummaryEntity().setTermNumber(entityList.get(i).getTerm())
                        .setStdId(stdId));
                //System.out.println(entityList.get(i).getTerm());
            }
        }
        termSummaryEntities.add(new TermSummaryEntity().setTermNumber(entityList.get(i).getTerm()).setStdId(stdId));
        for (TermSummaryEntity entity: termSummaryEntities) {
            //System.out.println("term = " + entity.getTermNumber() + "  student = " + entity.getStdId());
            courseSelector(entity,entityList);
            entity.setAverage(averageCalculator(entity.getTermCourses()));
        }
        return termSummaryEntities;
    }

    private void courseSelector(TermSummaryEntity summaryEntity, List<EnrollmentEntity> enrollmentList){
        for (EnrollmentEntity entity : enrollmentList){
            if (summaryEntity.getStdId() == entity.getStdId() && summaryEntity.getTermNumber() == entity.getTerm()){
                summaryEntity.getTermCourses().add(entity);
            }
        }
    }

    public float averageCalculator(List<EnrollmentEntity> list){
        float sum = 0;
        int units = 0;
        for (EnrollmentEntity entity : list){
            sum = sum  + (entity.getMark() * giveUnit(entity.getId()));
            units += giveUnit(entity.getId());
        }
        return sum/units;
    }

    public int giveUnit(String code){
        long id = Long.parseLong(code.substring(0,7));
        List<CourseEntity> list = null;
        try {
           list = CourseService.getInstance().report();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (CourseEntity entity : list){
            if (entity.getCode() == id)
                return entity.getUnit();
        }
        return 0;
    }

    public int unitCounter(List<EnrollmentEntity> list){
        int units = 0;
        List<CourseEntity> courseEntities = null;
        try {
            courseEntities = CourseService.getInstance().report();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (EnrollmentEntity entity : list){
            units = units + giveUnit(entity.getId());
        }
        return units;
    }

    public CourseEntity courseFinder(String code){
        long id = Long.parseLong(code.substring(0,7));
        List<CourseEntity> courseEntities = null;
        try {
            courseEntities = CourseService.getInstance().report();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (CourseEntity entity : courseEntities){
            if (entity.getCode() == id)
                return entity;
        }
        return null;
    }
}
