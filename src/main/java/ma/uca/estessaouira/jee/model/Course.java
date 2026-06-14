package ma.uca.estessaouira.jee.model;

public class Course {
    private int id;
    private String title;
    private String teacher;
    private int duration;

    public Course() {}

    public Course(int id, String title, String teacher, int duration) {
        this.id = id;
        this.title = title;
        this.teacher = teacher;
        this.duration = duration;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
}
