package model.entity;

public class EvaluationEntity {
    private long teacher_id , course_id;
    private double score;

//............................. getter...................................

    public long getTeacher_id() {
        return teacher_id;
    }

    public long getCourse_id() {
        return course_id;
    }

    public double getScore() {
        return score;
    }

//................................... setter ...............................

    public EvaluationEntity setTeacher_id(long teacher_id) {
        this.teacher_id = teacher_id;
        return this;
    }

    public EvaluationEntity setCourse_id(long course_id) {
        this.course_id = course_id;
        return this;
    }

    public EvaluationEntity setScore(double score) {
        this.score = score;
        return this;
    }
}
