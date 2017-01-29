package com.example.basel.login_1;

/**
 * Created by Basel on 1/13/2017.
 */

public class ClassObject {
    String name;
    int code;
    String university;
    int students;

    public ClassObject() {
        name = "";
        code = 0;
        university = "";
        students = 0;
    }

    public ClassObject(String name, int code, String university, int students) {
        this.name = name;
        this.code = code;
        this.university = university;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public String getUniversity() {
        return university;
    }

    public int getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setStudents(int students) {
        this.students = students;
    }
}
