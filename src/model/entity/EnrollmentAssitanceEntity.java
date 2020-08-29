package model.entity;

public class EnrollmentAssitanceEntity {
    private String code, name, type;
    private int unit;
    private long id, prerequisite, need;

    public long getId() {
        return id;
    }

    public EnrollmentAssitanceEntity setId(long id) {
        this.id = id;
        return this;
    }

    public long getPrerequisite() {
        return prerequisite;
    }

    public EnrollmentAssitanceEntity setPrerequisite(long prerequisite) {
        this.prerequisite = prerequisite;
        return this;
    }

    public long getNeed() {
        return need;
    }

    public EnrollmentAssitanceEntity setNeed(long need) {
        this.need = need;
        return this;
    }

    public String getCode() {
        return code;
    }

    public EnrollmentAssitanceEntity setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public EnrollmentAssitanceEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public EnrollmentAssitanceEntity setType(String type) {
        this.type = type;
        return this;
    }

    public int getUnit() {
        return unit;
    }

    public EnrollmentAssitanceEntity setUnit(int unit) {
        this.unit = unit;
        return this;
    }

    @Override
    public String toString() {
        return "EnrollmentAssitanceEntity{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", unit=" + unit +
                ", id=" + id +
                ", prerequisite=" + prerequisite +
                ", need=" + need +
                '}';
    }
}
