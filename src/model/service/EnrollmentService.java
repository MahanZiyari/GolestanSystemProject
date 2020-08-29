package model.service;

import model.entity.EnrollmentEntity;
import model.repository.EnrollmentRepository;

import java.util.List;

public class EnrollmentService {
    private static EnrollmentService ourInstance = new EnrollmentService();

    public static EnrollmentService getInstance() {
        return ourInstance;
    }

    private EnrollmentService() {
    }

    public void add(EnrollmentEntity entity) throws Exception{
        try (EnrollmentRepository repository = new EnrollmentRepository()){
            repository.insert(entity);
            repository.commit();
        }
    }

    public void edit(EnrollmentEntity entity) throws Exception{
        try (EnrollmentRepository repository = new EnrollmentRepository()){
            repository.update(entity);
            repository.commit();
        }
    }

    public void remove(int index) throws Exception{
        try (EnrollmentRepository repository = new EnrollmentRepository()){
            repository.delete(index);
            repository.commit();
        }
    }

    public List<EnrollmentEntity> report() throws Exception{
        List<EnrollmentEntity> list;
        try (EnrollmentRepository repository = new EnrollmentRepository()){
            list = repository.select();
        }
        return list;
    }
}
