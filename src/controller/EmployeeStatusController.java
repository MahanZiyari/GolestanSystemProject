package controller;

import model.entity.LogEntity;
import model.service.LogService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazanin
 */
public class EmployeeStatusController {
    private static EmployeeStatusController ourInstance = new EmployeeStatusController();

    public static EmployeeStatusController getInstance() {
        return ourInstance;
    }

    private EmployeeStatusController() {
    }

    public List<LogEntity> display(long id) {
        List<LogEntity> logList = null;
        List<LogEntity> list=new ArrayList<>();
        try {
            logList = LogService.getInstance().report();
        } catch (Exception e) {
            e.printStackTrace();
        }
       for (int i=0;i<logList.size();i++)
       {
           LogEntity logEntity=logList.get(i);
           if (logEntity.getId()==id)
           {
               list.add(logEntity);
           }
       }
        return list;
    }
}
