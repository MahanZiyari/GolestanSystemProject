package model.entity;

import java.util.ArrayList;
import java.util.List;

public class TermSummaryEntity {
    private int termNumber;
    private List<EnrollmentEntity> termCourses = new ArrayList<>();
    private float average;
    private long stdId;

    public long getStdId() {
        return stdId;
    }

    public TermSummaryEntity setStdId(long stdId) {
        this.stdId = stdId;
        return this;
    }

    public int getTermNumber() {
        return termNumber;
    }

    public TermSummaryEntity setTermNumber(int termNumber) {
        this.termNumber = termNumber;
        return this;
    }

    public List<EnrollmentEntity> getTermCourses() {
        return termCourses;
    }

    public TermSummaryEntity setTermCourses(List<EnrollmentEntity> termCourses) {
        this.termCourses = termCourses;
        return this;
    }

    public float getAverage() {
        return average;
    }

    public TermSummaryEntity setAverage(float average) {
        this.average = average;
        return this;
    }

}
