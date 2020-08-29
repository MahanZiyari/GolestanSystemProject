package controller;

import model.entity.EmployeeEntity;
import model.repository.EmployeeRepository;
import model.service.EmployeeService;

import java.util.List;

public class Edit_Information_Employee {

    private static  Edit_Information_Employee edit_information_employee = new Edit_Information_Employee();

    private  Edit_Information_Employee(){}

    public static Edit_Information_Employee  getInstance(){return edit_information_employee;}

    //.................... Edit Information .........................
    public void edit(EmployeeEntity entity) //just pass and name;
    {
        try {
            List<EmployeeEntity> employeeEntityList = EmployeeService.getInstance().report();
            for (EmployeeEntity employee : employeeEntityList) {
                if (employee.getId() == entity.getId())
                {
                    EmployeeService.getInstance().edit(entity);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //............ show information ................
    public EmployeeEntity show(EmployeeEntity entity) {
        try {
            List<EmployeeEntity> employeeEntityList = EmployeeService.getInstance().report();
            for (EmployeeEntity employee : employeeEntityList) {
                if(employee.getId() == entity.getId())
                    return employee;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
