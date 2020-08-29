package controller;

import model.entity.CreditCardEntity;
import model.service.CreditCardService;

import javax.swing.*;
import java.util.List;

public class PaymentController
{
    private static PaymentController paymentInstance = new PaymentController();

    public static PaymentController getInstance() {
        return paymentInstance;
    }

    private PaymentController() {}

    public void fieldsChecker(String cardNumber,String secondPass,
                              String cvv2,String expireYear,
                              String expireMonth,String captcha) throws BlankException
    {
        if(cardNumber==null||cardNumber.trim().isEmpty()  ||
               secondPass==null||secondPass.trim().isEmpty()  ||
                cvv2==null||cvv2.trim().isEmpty()  ||
                expireYear==null||expireYear.trim().isEmpty()  ||
                expireMonth==null||expireMonth.trim().isEmpty()  ||
                captcha==null || captcha.trim().isEmpty())
        {
            throw new BlankException();
        }
    }
    public void checkCaptchaCode(String captcha, String input) throws CaptchaException
    {
        if (!captcha.equalsIgnoreCase(input))
            throw new CaptchaException("Wrong Captcha Code");
    }

    public void payment(String cardNumber,String secondPass)throws Exception
    {
        CreditCardEntity entity = null;
        List<CreditCardEntity> creditCardList = CreditCardService.getInstance().report();
        int i, state = 0;
        for(i=0;i<creditCardList.size();i++)
        {
            if (creditCardList.get(i).getCardNumber().equalsIgnoreCase(cardNumber) && creditCardList.get(i).getSecondPass().equalsIgnoreCase(secondPass)){
                        entity = new CreditCardEntity().setCardNumber(cardNumber)
                        .setCvv2(creditCardList.get(i).getCvv2())
                        .setExpireMonth(creditCardList.get(i).getExpireMonth())
                        .setExpireYear(creditCardList.get(i).getExpireYear())
                        .setFund(creditCardList.get(i).getFund())
                        .setName(creditCardList.get(i).getName())
                        .setSecondPass(secondPass);
                state++;
            }

        }
        if (state == 1){
            if (entity.getFund() <= 800000)
                throw new InsufficientMoneyException();
            else {
                entity.setFund(entity.getFund() - 800000);
                CreditCardService.getInstance().edit(entity);
                JOptionPane.showMessageDialog(null, "Payment Operation successfully DONE!");
            }
        }
        if (state == 0)
            throw new CardNotFoundException();

    }
}
/*CreditCardEntity creditCard=creditCardList.get(i);
            if(creditCard.getCardNumber()!=null&& creditCard.getCardNumber().equalsIgnoreCase(cardNumber)
                    && creditCard.getSecondPass()!=null &&
                    creditCard.getSecondPass().equalsIgnoreCase(secondPass))
            {
              System.out.println("found user");
              long fund=creditCard.getFund();

              if(fund<=800000)
              {
                  throw new InsufficientMoneyException();
              }
              else
              {
                fund = fund-800000;
                creditCard.setFund(fund);
                CreditCardService.getInstance().edit(creditCard);
                JOptionPane.showMessageDialog(null,
                        "Payment was successfully done !",
                        "Payment Result",JOptionPane.OK_OPTION);
              }
            }
            else
            {
                throw new CardNotFoundException();
            }*/


