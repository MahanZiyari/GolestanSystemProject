package model.entity;

public class EnrollmentEntity {
    private String id, state;
    private long stdId;
    private int absence;
    private float mark;
    private int term;
    private int index;


    public int getIndex() {
        return index;
    }

    public EnrollmentEntity setIndex(int index) {
        this.index = index;
        return this;
    }

    public String getId() {
        return id;
    }

    public EnrollmentEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getState() {
        return state;
    }

    public EnrollmentEntity setState(String state) {
        this.state = state;
        return this;
    }

    public long getStdId() {
        return stdId;
    }

    public EnrollmentEntity setStdId(long stdId) {
        this.stdId = stdId;
        return this;
    }

    public int getAbsence() {
        return absence;
    }

    public EnrollmentEntity setAbsence(int absence) {
        this.absence = absence;
        return this;
    }

    public float getMark() {
        return mark;
    }

    public EnrollmentEntity setMark(float mark) {
        this.mark = mark;
        return this;
    }

    public int getTerm() {
        return term;
    }

    public EnrollmentEntity setTerm(int term) {
        this.term = term;
        return this;
    }
}
