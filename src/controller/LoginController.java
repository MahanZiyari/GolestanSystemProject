package controller;

import model.entity.EmployeeEntity;
import model.entity.StudentEntity;
import model.entity.TeacherEntity;
import model.entity.User;
import model.service.EmployeeService;
import model.service.StudentService;
import model.service.TeacherService;
import view.EmployeePanel;
import view.EnteringGrades;
import view.StudentPanel;
import view.TeacherPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LoginController {
    private static LoginController ourInstance = new LoginController();

    public static LoginController getInstance() {
        return ourInstance;
    }

    private LoginController() {
    }

    public void navigator(String id, String pass) throws Exception {
        int state = 0;
        List<StudentEntity> studentEntities;
        List<TeacherEntity> teacherEntities;
        List<EmployeeEntity> employeeEntities;

        if (id.startsWith("9")){
            studentEntities = StudentService.getInstance().report();
            for (int i = 0; i < studentEntities.size(); i++){
                if (Long.parseLong(id) == studentEntities.get(i).getId() && pass.equalsIgnoreCase(studentEntities.get(i).getPass())){
                    state++;
                    StudentPanel panel = new StudentPanel(studentEntities.get(i));
                    break;
                }
            }
        }else if (id.startsWith("5")){
            teacherEntities = TeacherService.getInstance().report();
            for (int i = 0; i < teacherEntities.size(); i++){
                if (Long.parseLong(id) == teacherEntities.get(i).getId() && pass.equalsIgnoreCase(teacherEntities.get(i).getPass())){
                    TeacherPanel panel = new TeacherPanel(teacherEntities.get(i));
                    state++;
                    break;
                }
            }
        }else if (id.startsWith("3")){
            employeeEntities = EmployeeService.getInstance().report();
            for (int i = 0; i < employeeEntities.size(); i++){
                if (Long.parseLong(id) == employeeEntities.get(i).getId() && pass.equalsIgnoreCase(employeeEntities.get(i).getPass())){
                    EmployeePanel panel = new EmployeePanel(employeeEntities.get(i));
                    state++;
                    break;
                }
            }
        }
        else {
            throw new LoginEception("INVALID ID");
        }
    }
}
