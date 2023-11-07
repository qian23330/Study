package com.itheima.frame;

import com.itheima.bean.Appointment;
import com.itheima.bean.Department;
import com.itheima.bean.Doctor;
import com.itheima.bean.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class HospitalManager {
    // 1、系统需要存储全部科室信息
    private ArrayList<Department> allDepartments = new ArrayList<>();

    // 2、系统需要记录全部的预约详情
    private ArrayList<Appointment> appointments = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("====欢迎进入仁爱医院信息管理系统====");
            System.out.println("1、科室管理-添加科室");
            System.out.println("2、科室管理-删除科室");
            System.out.println("3、科室管理-修改科室");
            System.out.println("4、医生管理-录入医生");
            System.out.println("5、医生管理-医生坐诊设置(可设置当天和未来6天的坐诊情况)");
            System.out.println("6、医生管理-展示全部医生的坐诊详情（当前和未来6天的坐诊详情）");
            System.out.println("7、医生管理-挂号预约");
            System.out.println("8、搜索某个医生当前和未来6天内的病人预约详情（展示每天预约病人的具体信息）");
            System.out.println("请输入操作命令：");
            Scanner sc = new Scanner(System.in);
            switch (sc.next()) {
                case "1":
                    addDepartment();
                    break;
                case "4":
                    addDoctor();
                    break;
                case "5":
                    setDoctorJob(); // 难点
                    break;
                case "6":
                    showAllDoctorInfos(); // 难点
                    break;
                default:
                    System.out.println("当前命令输入有误，请重新输入！");
            }
        }
    }

    private void showAllDoctorInfos() {
        System.out.println("全部医生的坐诊详情如下===");
        for (int i = 0; i < allDepartments.size(); i++) {
            Department department = allDepartments.get(i);
            System.out.println((i + 1) + ", " + department.getName());
            System.out.println("---------------------------------------------------------------------");
            ArrayList<Doctor> doctors = department.getDoctors();
            for (int j = 0; j < doctors.size(); j++) {
                Doctor doctor = doctors.get(j);
                System.out.println(doctor.getName() + "医生的坐班信息如下");
                ArrayList<Schedule> schedules = doctor.getSchedules();
                updateSchedules(schedules); // 更新一下时间
                for (int k = 0; k < schedules.size(); k++) {
                    Schedule schedule = schedules.get(k);
                    System.out.println(schedule.getToday());
                    if(!schedule.isUpdate()) {
                        System.out.println("未排班\t\t\t");
                        continue;
                    }

                    if(schedule.isMorning()){
                        System.out.println("上午 " + schedule.getMstart() + " - " + schedule.getMend()
                          + " 总数/已预约 " +schedule.getmTotalNumber() + "/" + schedule.getmAppointNumbe());
                    }else {
                        System.out.println("上午 休息");
                    }

                    if(schedule.isAfternoon()){
                        System.out.println("下午 " + schedule.getAstart() + "-" + schedule.getAend()
                                + " 总数/已预约 " + schedule.getaTotalNumber() + "/" + schedule.getaAppointNumber());
                    }else {
                        System.out.println("下午 休息");
                    }
                }
            }
        }
    }

    private void setDoctorJob() {
        System.out.println("========设置医生的坐诊时间========");
        Department departMent = getDepartmentByUser();

        // 选择医生
        ArrayList<Doctor> doctors = departMent.getDoctors();
        if(doctors.size() == 0) {
            System.out.println("当前科室下无医生~");
            return;
        }

        while (true) {
            System.out.println("当前科室下的医生如下：");
            for (int i = 0; i < doctors.size(); i++) {
                Doctor doctor = doctors.get(i);
                System.out.println((i + 1) + "," + doctor.getName());
            }
            System.out.println("请输入");
            // 2、接收命令
            int command = sc.nextInt();
            if (command < 1 || command > allDepartments.size()) {
                System.out.println("选择有误，请重新确认~");
                continue;
            }

            Doctor doctor = doctors.get(command - 1);
            // 3、为这个医生设置坐诊情况。
            ArrayList<Schedule> schedules = doctor.getSchedules();
            // 更新未来七天的时间
            updateSchedules(schedules);

            // 4、修改坐诊信息.依次展示这个医生的坐诊详情
            for (int i = 0; i < schedules.size(); i++) {


                Schedule schedule = schedules.get(i);
                updateDoctorSchedule(schedule);
            }
            break;
        }
    }


    private void updateDoctorSchedule(Schedule schedule) {
        LocalDate today = schedule.getToday();
        System.out.println(today + "的安排如下：");
        if(!schedule.isUpdate()) {
            System.out.println("未排班\t\t\t");
        }else {
            System.out.print("\t上午\t");
            if(schedule.isMorning()){
                System.out.print("坐诊 时间为：" + schedule.getMstart() + "-"
                        + schedule.getMend() + "总数/预约数：" + schedule.getmTotalNumber() + "/" + schedule.getmAppointNumbe());
            }else {
                System.out.print("休息");
            }
            System.out.println();
            System.out.print("\t下午\t");
            if(schedule.isAfternoon()){
                System.out.print("坐诊 时间为：" + schedule.getAstart() + "-"
                        + schedule.getAend() + "总数/预约数：" + schedule.getaTotalNumber() + "/" + schedule.getaAppointNumber());
            }else {
                System.out.println("休息");
            }
        }
        System.out.println("是否修改？y/n");
        String rs = sc.next();
        if("y".equals(rs)) {
            schedule.setUpdate(true); // 表示开始了排班了
            System.out.println("上午是否上班？y/n");
            String rs2 = sc.next();
            if("y".equals(rs2)){
                schedule.setMorning(true);
                System.out.println("上班的开始时间和结束时间是：");
                String start = sc.next();
                String end = sc.next();
                System.out.println("可预约人数是：");
                int number = sc.nextInt();
                schedule.setMstart(LocalTime.parse(start));
                schedule.setMend(LocalTime.parse(end));
                schedule.setmTotalNumber(number);
            }else {
                schedule.setMorning(false);
            }

            System.out.println("下午是否上班？y/n");
            String rs3 = sc.next();
            if("y".equals(rs3)){
                schedule.setAfternoon(true);
                System.out.println("上班的开始时间和结束时间是：");
                String start = sc.next();
                String end = sc.next();
                System.out.println("可预约人数是：");
                int number = sc.nextInt();
                schedule.setAstart(LocalTime.parse(start));
                schedule.setAend(LocalTime.parse(end));
                schedule.setaTotalNumber(number);
            }else {
                schedule.setAfternoon(false);
            }
        }
    }

    /**
     * 更新成当前到未来6天的时间
     * @param schedules
     */
    private void updateSchedules(ArrayList<Schedule> schedules) {
        if(schedules.size() == 0) {
            for (int i = 0; i <= 6; i++) {
                Schedule schedule = new Schedule();
                LocalDate now = LocalDate.now();
                schedule.setToday(now.plusDays(i));
                schedules.add(schedule);
            }
            return;
        }

        // 去除过期的时间
        for (int i = 0; i < schedules.size(); i++) {
            Schedule schedule = schedules.get(i);
            LocalDate now = LocalDate.now();
            LocalDate current = schedule.getToday();
            if(current.equals(now)){
                break;
            }
            if(current.isBefore(now)){
                schedules.remove(schedule);
                i--;
            }
        }

        // 补全当前和未来6天的时间 【s1, s2, s3,】
        LocalDate last = schedules.get(schedules.size() - 1).getToday();
        int size = schedules.size();
        for (int i = 0; i < 7 - size; i++) {
            Schedule schedule = new Schedule();
            schedule.setToday(last.plusDays(i + 1));
            schedules.add(schedule);
        }
    }

    /**
     * 选择科室
     * @return
     */
    private Department getDepartmentByUser(){
        if(allDepartments.size() == 0){
            return null;
        }

        while (true) {
            // 1、先选择科室.
            System.out.println("请选择科室：");
            for (int i = 0; i < allDepartments.size(); i++) {
                Department department = allDepartments.get(i);
                System.out.println((i + 1) + "," + department.getName());
            }
            System.out.println("请输入");
            // 2、接收命令
            int command = sc.nextInt();
            if (command < 1 || command > allDepartments.size()) {
                System.out.println("选择有误，请重新确认~");
                continue;
            }
            // 得到科室
            Department department = allDepartments.get(command - 1);
            return department;
        }
    }

    private void addDoctor() {
        System.out.println("========录入医生========");
        while (true) {
            // 1、先选择科室.
            Department department = getDepartmentByUser();
            if(department == null){
                System.out.println("当前无任何科室~");
                return;
            }
            Doctor doctor = new Doctor();
            doctor.setDepartmentName(department.getName());

            // 录入医生的id
            doctor.setDoctorId(UUID.randomUUID().toString());

            System.out.println("请输入医生的姓名：");
            String name = sc.next();
            doctor.setName(name);

            System.out.println("请输入医生的性别：");
            String sex = sc.next();
            doctor.setGender(sex);

            System.out.println("请输入医生的年龄：");
            int age = sc.nextInt();
            doctor.setAge(age);

            System.out.println("请输入医生的特长：");
            String specialty = sc.next();
            doctor.setSpecialty(specialty);

            System.out.println("请输入医生的入职日期（格式：yyyy-MM-dd）：");
            String joinDateString = sc.next();
            LocalDate joinDate = LocalDate.parse(joinDateString);
            doctor.setJoinDate(joinDate);

            department.getDoctors().add(doctor);
            System.out.println("录入医生到该科室成功！");
            break;
        }
    }

    private void addDepartment() {
        System.out.println("========添加科室========");
        OUT:
        while (true) {
            System.out.println("请您输入科室名称：");
            String name = sc.next();
            // 判断名称是否存在
            for (int i = 0; i < allDepartments.size(); i++) {
                Department department = allDepartments.get(i);
                System.out.println("名称存在，请重新输入！");
                if(department.getName().equals(name)) continue OUT;
            }

            Department department = new Department();
            department.setName(name);
            allDepartments.add(department);
            System.out.println("添加科室成功！");
            break;
        }
    }
}
