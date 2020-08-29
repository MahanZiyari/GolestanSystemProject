package model.service;

import model.entity.RecordsEntity;
import model.repository.RecordsRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazanin
 */
public class RecordsService
{
    private static RecordsService ourInstance = new RecordsService();

    public static RecordsService getInstance() {
        return ourInstance;
    }

    private RecordsService() {}

    //--------------INSERTION--------------
    public void add(RecordsEntity recordsEntity) throws Exception{
        try (RecordsRepository repository = new RecordsRepository()){
            repository.insert(recordsEntity);
            repository.commit();
        }
    }
    //--------------EDIT------------------
    public void edit(RecordsEntity recordsEntity) throws Exception{
        try (RecordsRepository repository = new RecordsRepository()){
            repository.update(recordsEntity);
            repository.commit();
        }
    }
    //--------------REMOVE-----------------
    public void remove(long id) throws Exception{
        try (RecordsRepository repository = new RecordsRepository()){
            repository.delete(id);
            repository.commit();
        }
    }
    //-------------REPORT-------------------
    public List<RecordsEntity> report() throws Exception{
        List<RecordsEntity> list = new ArrayList<>();
        try (RecordsRepository repository = new RecordsRepository()){
            list = repository.select();
            repository.commit();
        }
        return list;
    }
}
