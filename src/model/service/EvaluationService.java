package model.service;
import model.entity.EvaluationEntity;
import model.repository.EvaluationRepository;

import java.util.ArrayList;
import java.util.List;

public class EvaluationService {
    private static EvaluationService ourInstance = new EvaluationService();

    public static EvaluationService getInstance() {
        return ourInstance;
    }

    private  EvaluationService(){}

    //------------------REPORT---------------------
    public List<EvaluationEntity> report(long id) throws Exception{
        List<EvaluationEntity>  list = new ArrayList<>();
        try (EvaluationRepository repository = new EvaluationRepository()){
            list = repository.select(id);
            repository.commit();
        }
        return list;
    }
}
