package controller;

import model.entity.EmployeeEntity;
import model.entity.LogEntity;
import model.service.EmployeeService;
import model.service.LogService;

import java.time.LocalDateTime;

/**
 * Created by Nazanin
 */
public class LoanController
{
    private EmployeeEntity employeeEntity;

    private static LoanController loanInstance = new LoanController();

    public static LoanController getInstance() {
        return loanInstance;
    }

    private LoanController() {}

    public void request(long id,String text,String subject) throws Exception
    {
        LogEntity logEntity=new LogEntity();
        String dateTime = String.valueOf(LocalDateTime.now());
        logEntity.setId(id);
        logEntity.setDateAndTime(dateTime);
        logEntity.setSubject(subject);
        logEntity.setText(text);
        LogService.getInstance().add(logEntity);
    }

    public void blanksChecker(String text,String subject) throws BlankException {
        if(text==null||text.trim().isEmpty()  ||
                subject==null||subject.trim().isEmpty()  )
        {
            throw new BlankException();
        }
    }

}
