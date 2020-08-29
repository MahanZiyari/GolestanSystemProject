package model.entity;

/**
 * Created by Nazanin
 */
public class RecordsEntity
{
    private long id;
    private String subject,text;

    public long getId() { return id; }

    public RecordsEntity setId(long id)
    {
        this.id = id;
        return this;
    }

    public String getSubject() { return subject; }

    public RecordsEntity setSubject(String subject)
    {
        this.subject = subject;
        return this;
    }

    public String getText() { return text; }

    public RecordsEntity setText(String text)
    {
        this.text = text;
        return this;
    }
}
