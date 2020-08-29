package controller;

import model.entity.TeacherEntity;


public class TeacherIncomeController
{
    private static TeacherIncomeController incomeInstance = new TeacherIncomeController();

    public static TeacherIncomeController getInstance() {
        return incomeInstance;
    }

    private TeacherIncomeController() {}

    public long CalculateSalary(TeacherEntity entity) throws Exception
    {

        long variableIncome=500000;
        long totalIncome = variableIncome+entity.getSalary();
        System.out.println("Teacher Salary:"+totalIncome);
        return totalIncome;
    }

}
