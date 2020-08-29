package model.entity;

public class CreditCardEntity
{
    private String cardNumber,name,secondPass;
    private int cvv2,expireYear,expireMonth;
    private long fund;

    public long getFund() { return fund; }

    @Override
    public String toString() {
        return "CreditCardEntity{" +
                "cardNumber='" + cardNumber + '\'' +
                ", name='" + name + '\'' +
                ", secondPass='" + secondPass + '\'' +
                ", cvv2=" + cvv2 +
                ", expireYear=" + expireYear +
                ", expireMonth=" + expireMonth +
                ", fund=" + fund +
                '}';
    }

    public CreditCardEntity setFund(long fund)
    {
        this.fund = fund;
        return this;
    }

    public String getCardNumber() { return cardNumber; }

    public CreditCardEntity setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getName() { return name; }

    public CreditCardEntity setName(String name)
    {
        this.name = name;
        return this;
    }

    public String getSecondPass() { return secondPass; }

    public CreditCardEntity setSecondPass(String secondPass)
    {
        this.secondPass = secondPass;
        return this;
    }
    public int getCvv2() { return cvv2; }

    public CreditCardEntity setCvv2(int cvv2)
    {
        this.cvv2 = cvv2;
        return this;
    }

    public int getExpireYear() { return expireYear; }

    public CreditCardEntity setExpireYear(int expireYear)
    {
        this.expireYear = expireYear;
        return this;
    }

    public int getExpireMonth() { return expireMonth; }

    public CreditCardEntity setExpireMonth(int expireMonth)
    {
        this.expireMonth = expireMonth;
        return this;
    }
}
