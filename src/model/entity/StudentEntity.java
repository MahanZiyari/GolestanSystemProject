package model.entity;

public class StudentEntity implements User{
    private String name, pass, maajor, grade;
    private long id, entry;

    public String getName() {
        return name;
    }

    public StudentEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public StudentEntity setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public String getMaajor() {
        return maajor;
    }

    public StudentEntity setMaajor(String maajor) {
        this.maajor = maajor;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public StudentEntity setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public long getId() {
        return id;
    }

    public StudentEntity setId(long id) {
        this.id = id;
        return this;
    }

    public long getEntry() {
        return entry;
    }
    public StudentEntity setEntry(long entry) {
        this.entry = entry;
        return this;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", maajor='" + maajor + '\'' +
                ", grade='" + grade + '\'' +
                ", id=" + id +
                ", entry=" + entry +
                '}';
    }
}
