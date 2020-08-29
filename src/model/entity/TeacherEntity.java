package model.entity;

public class TeacherEntity implements User {
    private String name, pass, experties;
    private long salary, id;

    public String getName() {
        return name;
    }

    public TeacherEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public TeacherEntity setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public String getExperties() {
        return experties;
    }

    public TeacherEntity setExperties(String experties) {
        this.experties = experties;
        return this;
    }

    public long getSalary() {
        return salary;
    }

    public TeacherEntity setSalary(long salary) {
        this.salary = salary;
        return this;
    }

    public long getId() {
        return id;
    }

    public TeacherEntity setId(long id) {
        this.id = id;
        return this;
    }
}
