package com.itheima.bean;

import java.time.LocalDate;
import java.util.ArrayList;

/*
1、科室管理：新增科室，删除科室（如果有医生在，则不能删除该科室），修改科室。
2、医生管理：录入医生信息，以及科室信息。修改医生信息（主要是修改个人信息和科室）
3、坐诊信息设置：可以设置医生当天和未来6天的坐诊情况，包括上午和下午的坐诊时间段和可预约数量，系统将自动保存到该医生的坐诊信息列表中。
4、全部信息展示：按照科室，展示每个医生七天的坐诊情况，需要按照科室归类展示
5、预约功能：用户可以选择要预约的科室，医生、日期和时间段，并输入患者的个人信息，系统将自动判断该时间段是否还有预约名额，并保存预约信息。
6. 搜索功能：用户可以输入搜索日期和时间段，系统将自动搜索未来七天内在该时间段坐诊的医生信息，并按照科室分类展示。
7、可以查询某个医生未来七天，病人对它的预约情况。
*/
public class Doctor {
    private String doctorId; // 编号
    private String name;
    private String departmentName;
    private String gender;
    private int age;
    private String specialty; // 主治方向
    private LocalDate joinDate; // 入职时间
    private ArrayList<Schedule> schedules = new ArrayList<>();

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }
}
