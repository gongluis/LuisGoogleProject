package com.luis.luisgoogleproject.kotlin.jetpack;

public class PersonForReflect {
    private String name;
    private String age;
    private String grade;

    public PersonForReflect(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
//方法私有 无法修改 姓名，使用发射技术修改姓名
    private void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
