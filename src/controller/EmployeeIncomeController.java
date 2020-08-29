package controller;

import model.entity.EmployeeEntity;
import model.entity.TeacherEntity;

public class EmployeeIncomeController
{
    private static EmployeeIncomeController incomeInstance = new EmployeeIncomeController();

    public static EmployeeIncomeController getInstance() {
        return incomeInstance;
    }

    private EmployeeIncomeController() {}

    public long CalculateSalary(EmployeeEntity entity) throws Exception
    {
        long totalIncome = entity.getSalary();
        System.out.println("Employee Salary:"+totalIncome);
        return totalIncome;
    }
}
