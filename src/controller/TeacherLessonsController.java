package controller;

import model.entity.CourseEntity;
import model.entity.TeacherEntity;
import model.entity.TermCourseEntity;
import model.service.CourseService;
import model.service.TermCourseService;

import java.util.ArrayList;
import java.util.List;

public class TeacherLessonsController {
    private static  TeacherLessonsController  teacherLessons = new TeacherLessonsController();

    public static TeacherLessonsController getInstance(){ return teacherLessons;}

    private TeacherLessonsController(){}


    //................. teacher lessons .................
    public String[][] teacherLessons(TeacherEntity entity) throws Exception {

        int rowsCount = lessonsCount(entity.getId());

        int columnsCount = 4;  //5:course-id, course-name, day, time
        int i = 0;
        String[][] str = new String[rowsCount][columnsCount];
            List<TermCourseEntity> termCourseList = TermCourseService.getInstance().report();
            for (TermCourseEntity termCourseEntity : termCourseList)
            {
                if (termCourseEntity.getTeacher_id() == entity.getId()  && i < rowsCount)
                {

                    str[i][0] = String.valueOf(termCourseEntity.getCourse_id());
                    str[i][1] = courseNameFinder(termCourseEntity.getCourse_id());
                    str[i][2] = termCourseEntity.getDay();
                    str[i][3] =termCourseEntity.getTime();
                    i += 1;
                }

            }
            return str;

    }


    //............... lessons count ..................
    public int lessonsCount(long id) throws Exception {
        int lessonsCount = 0;

            List<TermCourseEntity> termCourseList = TermCourseService.getInstance().report();
            for (TermCourseEntity termCourseEntity : termCourseList) {
                if (termCourseEntity.getTeacher_id() == id) {
                    lessonsCount += 1;
                }
            }
        return lessonsCount;
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
}

