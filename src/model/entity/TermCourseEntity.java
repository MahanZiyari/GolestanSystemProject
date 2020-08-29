package model.entity;

public class TermCourseEntity {
    private long group, course_id, teacher_id;
    private String day, time;

    public long getgruop() {
        return group;
    }

    public TermCourseEntity setgroup(long group) {
        this.group = group;
        return this;
    }

    public long getCourse_id() {
        return course_id;
    }

    public TermCourseEntity setCourse_id(long course_id) {
        this.course_id = course_id;
        return this;
    }

    public long getTeacher_id() {
        return teacher_id;
    }

    public TermCourseEntity setTeacher_id(long teacher_id) {
        this.teacher_id = teacher_id;
        return this;
    }

    public String getDay() {
        return day;
    }

    public TermCourseEntity setDay(String day) {
        this.day = day;
        return this;
    }

    public String getTime() {
        return time;
    }

    public TermCourseEntity setTime(String time) {
        this.time = time;
        return this;
    }
}
