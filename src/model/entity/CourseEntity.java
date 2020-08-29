package model.entity;

public class CourseEntity {
    private long code, prerequisite, need;
    private String name, field;
    private int unit;

    public long getCode() {
        return code;
    }

    public CourseEntity setCode(long code) {
        this.code = code;
        return this;
    }

    public long getPrerequisite() {
        return prerequisite;
    }

    public CourseEntity setPrerequisite(long prerequisite) {
        this.prerequisite = prerequisite;
        return this;
    }

    public long getNeed() {
        return need;
    }

    public CourseEntity setNeed(long need) {
        this.need = need;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getField() {
        return field;
    }

    public CourseEntity setField(String field) {
        this.field = field;
        return this;
    }

    public int getUnit() {
        return unit;
    }

    public CourseEntity setUnit(int unit) {
        this.unit = unit;
        return this;
    }
}
