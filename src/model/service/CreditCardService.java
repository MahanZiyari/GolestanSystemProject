package model.service;

import model.entity.CreditCardEntity;
import model.repository.CreditCardRepository;

import java.util.List;

public class CreditCardService
{
    private static CreditCardService ourInstance = new CreditCardService();

    public static CreditCardService getInstance() {
        return ourInstance;
    }

    private CreditCardService() {}

    //--------------INSERTION------------------
    public void add(CreditCardEntity creditCardEntity) throws Exception
    {
        try (CreditCardRepository creditCardRepository =
                     new CreditCardRepository())
        {
            creditCardRepository.insert(creditCardEntity);
            creditCardRepository.commit();
        }
    }
    //--------------EDIT------------
    public void edit(CreditCardEntity creditCardEntity) throws Exception
    {
        try (CreditCardRepository creditCardRepository =
                     new CreditCardRepository())
        {
            creditCardRepository.update(creditCardEntity);
            creditCardRepository.commit();
        }
    }
    //--------------REMOVE-------------
    public void remove(String cardNumber) throws Exception
    {
        try (CreditCardRepository creditCardRepository =
                     new CreditCardRepository())
        {
            creditCardRepository.delete(cardNumber);
            creditCardRepository.commit();
        }
    }
    //-------------Report---------------
    public List<CreditCardEntity> report() throws Exception
    {
        List<CreditCardEntity> creditCardEntityList;
        try (CreditCardRepository creditCardRepository =
                     new CreditCardRepository())
        {
            creditCardEntityList = creditCardRepository.select();
            creditCardRepository.commit();
        }
        for (CreditCardEntity entity : creditCardEntityList)
            System.out.println(entity.toString());
        return creditCardEntityList;
    }
}
