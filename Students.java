package ru.sapteh;

public class Students {
    public static final String TABLE_NAME = "students";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String FIRSTNAME_COLUMN = "firstname";
    public static final String LASTNAME_COLUMN = "lastname";
    public static final String PROFESSION_COLUMN = "profession";
    public static final String COURSE_COLUMN = "course";

    private int id;
    private String name;
    private String firstname;
    private String lastname;
    private String profession;
    private String course;

    public Students (int id, String name, String firstname, String lastname, String profession, String course) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profession = profession;
        this.course = course;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setName (String name) {
        this.name = name;
    }
    public String getName () {
        return name;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public String getProfession() {
        return profession;
    }
    public void setCourse() {
        this.course = course;
    }
    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %s, %s", getId(),getName(),getFirstname(),getLastname(),getProfession(),getCourse());
    }
}
