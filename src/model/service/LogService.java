package model.service;

import model.entity.LogEntity;
import model.repository.LogRepository;
import java.util.List;
/**
 * Created by Nazanin on 1/28/2020.
 */

public class LogService
{
    private static LogService logInstance = new LogService();

    public static LogService getInstance() {
        return logInstance;
    }

    private LogService() {}

    public void add(LogEntity logEntity) throws Exception
    {
        try (LogRepository repository = new LogRepository())
        {
            repository.insert(logEntity);
            repository.commit();
        }
    }

    public void edit(LogEntity logEntity) throws Exception
    {
        try (LogRepository repository = new LogRepository())
        {
            repository.update(logEntity);
            repository.commit();
        }
    }

    public void remove(long id) throws Exception
    {
        try (LogRepository repository = new LogRepository())
        {
            repository.delete(id);
            repository.commit();
        }
    }

    public List<LogEntity> report() throws Exception
    {
        List<LogEntity> list;
        try (LogRepository repository = new LogRepository())
        {
            list = repository.select();
            repository.commit();
        }
        return list;
    }

    public LogEntity reportById(long id) throws Exception
    {
        LogEntity logEntity;
        try (LogRepository repository = new LogRepository())
        {
            logEntity = repository.selectById(id);
        }
        return logEntity;
    }
}
