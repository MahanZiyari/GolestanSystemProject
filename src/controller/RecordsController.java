package controller;

import model.entity.EmployeeEntity;
import model.entity.RecordsEntity;
import model.service.RecordsService;

/**
 * Created by Nazanin
 */
public class RecordsController
{


    private static RecordsController ourInstance = new RecordsController();

    public static RecordsController getInstance() {
        return ourInstance;
    }

    private RecordsController() {}

    public void blanksChecker(String text,String subject) throws BlankException
    {
        if(text==null||text.trim().isEmpty()  ||
                subject==null||subject.trim().isEmpty()  )
        {
            throw new BlankException();
        }
    }

    public void save (long id,String subject,String text) throws Exception
    {
        RecordsEntity recordsEntity=new RecordsEntity();
        recordsEntity.setId(id);
        recordsEntity.setSubject(subject);
        recordsEntity.setText(text);
        RecordsService.getInstance().add(recordsEntity);
    }

}
