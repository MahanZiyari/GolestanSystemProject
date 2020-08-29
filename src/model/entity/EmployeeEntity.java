package model.entity;

public class EmployeeEntity implements User {
    private long id, salary;
    private String name, pass, post;

    public long getId() {
        return id;
    }

    public EmployeeEntity setId(long id) {
        this.id = id;
        return this;
    }

    public long getSalary() {
        return salary;
    }

    public EmployeeEntity setSalary(long salary) {
        this.salary = salary;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public EmployeeEntity setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public String getPost() {
        return post;
    }

    public EmployeeEntity setPost(String post) {
        this.post = post;
        return this;
    }
}
