package model.service;

import model.entity.EmployeeEntity;
import model.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private static EmployeeService ourInstance = new EmployeeService();

    public static EmployeeService getInstance() {
        return ourInstance;
    }

    private EmployeeService() {
    }
    //--------------INSERTION--------------
    public void add(EmployeeEntity employeeEntity) throws Exception{
        try (EmployeeRepository repository = new EmployeeRepository()){
            repository.insert(employeeEntity);
            repository.commit();
        }
    }
    //--------------EDIT------------------
    public void edit(EmployeeEntity employeeEntity) throws Exception{
        try (EmployeeRepository repository = new EmployeeRepository()){
            repository.update(employeeEntity);
            repository.commit();
        }
    }
    //--------------REMOVE-----------------
    public void remove(long id) throws Exception{
        try (EmployeeRepository repository = new EmployeeRepository()){
            repository.delete(id);
            repository.commit();
        }
    }
    //-------------REPORT-------------------
    public List<EmployeeEntity> report() throws Exception{
        List<EmployeeEntity> list = new ArrayList<>();
        try (EmployeeRepository repository = new EmployeeRepository()){
            list = repository.select();
            repository.commit();
        }
        return list;
    }
}
