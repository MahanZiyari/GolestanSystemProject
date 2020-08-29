package model.entity;
/**
 * Created by Nazanin on 1/28/2020.
 */
public class LogEntity
{
    private long id;
    private String dateAndTime , subject , text;

    public long getId() { return id; }

    public LogEntity setId(long id)
    {
        this.id = id;
        return this;
    }

    public String getDateAndTime() { return dateAndTime; }

    public LogEntity setDateAndTime(String dateAndTime)
    {
        this.dateAndTime = dateAndTime;
        return this;
    }

    public String getSubject() { return subject; }

    public LogEntity setSubject(String subject)
    {
        this.subject = subject;
        return this;
    }

    public String getText() { return text; }

    public LogEntity setText(String text)
    {
        this.text = text;
        return this;
    }
}
