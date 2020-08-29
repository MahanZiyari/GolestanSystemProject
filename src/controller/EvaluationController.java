package controller;

import model.entity.CourseEntity;
import model.entity.EvaluationEntity;
import model.entity.TeacherEntity;
import model.service.CourseService;
import model.service.EvaluationService;

import java.util.ArrayList;
import java.util.List;

public class EvaluationController {

    private static EvaluationController evaluationController = new EvaluationController();

    private  EvaluationController(){}

    public static EvaluationController getInstance(){return evaluationController;}

    public List<EvaluationEntity> progress(TeacherEntity entityTeacher)throws Exception{
        EvaluationEntity entityEvaluation = new EvaluationEntity();
        List<EvaluationEntity> progressList = EvaluationService.getInstance().report(entityTeacher.getId());
         return progressList;
    }

    // ................. find course name .....................
    public String courseNameFinder(long code) throws Exception {

        List<CourseEntity> listCourse = CourseService.getInstance().report();

        for(CourseEntity entity : listCourse)
        {
            if(entity.getCode() == code)
                return entity.getName();
        }
        return null;
    }

    // .................count.....................
    public int Count(TeacherEntity entity) throws Exception {
        int count=0;
        for (EvaluationEntity entityEvaluation : EvaluationController.getInstance().progress(entity))
        {
            count +=1;
        }
        return count;
    }


}
