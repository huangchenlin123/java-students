package com.athuang.studentmanager;

import java.util.Scanner;

public class StudentView {
    Scanner sc = new Scanner(System.in);
    Student[] students = new Student[50];
    int count = 0;
    Student[] newStudents = new Student[students.length-1];

    public void start(){
        while(true){
            System.out.println("----------------学生管理系统--------------");
            System.out.println("1  添加学生");
            System.out.println("2  修改学生");
            System.out.println("3  删除学生");
            System.out.println("4  查看学生");
            System.out.println("5  退出系统");
            System.out.println("请选择(1-5):");


            int num = sc.nextInt();
            System.out.println("-----------------------------------------");
switch (num){
    case 1:
        addStudent();
        break;
    case 2:
        updateStudent();
        break;
    case 3:
        deleteStudent();
        break;
    case 4:
        findAllStudent();
        break;
    case 5:
        System.out.println("是否退出?按0确认,按9取消");
        int key = sc.nextInt();
        if(key==0){
            System.out.println("baibai");
            return;

        }else if(key==9){
            break;
        }
        break;
}
        }

    }

    private void findAllStudent() {
        System.out.println("学号"+"\t"+"姓名"+"\t"+"年龄"+"\t"+"性别");

        for (int j = 0; j < count; j++) {
            for (int i = 0; i < count-1-j; i++) {
                if (students[i].getId().compareTo(students[i+1].getId())>0){
                    Student temp =students[i];
                    students[i] = students[i+1];
                    students[i+1] = temp;

                }

            }

        }
        if (count==0){
            System.out.println("无学生");

        }else{
            for (int i = 0; i < count; i++) {
                System.out.println(students[i].getId()+"\t"+students[i].getName()+"\t"+students[i].getAge()+"\t"+students[i].getSex());
            }

        }
    }

    private void deleteStudent() {
        System.out.println("请输入要删除的学号");
        int id = sc.nextInt();
        int removeIndex = ArrayUtils.findIndexById(students, id, count);
        System.arraycopy(students,0,newStudents,0,removeIndex);
        System.arraycopy(students,removeIndex+1,newStudents,removeIndex,students.length-removeIndex-1);
        students = newStudents;
        count--;
        System.out.println("删除成功");

    }

    private void updateStudent() {
        System.out.println("请您输入要修改的学号");
        int id = sc.nextInt();
        int updateIndex = ArrayUtils.findIndexById(students,id,count);
        System.out.println("请您输入学生姓名");
        String name = sc.next();
        System.out.println("请您输入学生年龄");
        int age = sc.nextInt();
        System.out.println("请您输入学生性别");
        String sex = sc.next();
        Student student = new Student(id, name,age, sex);
        students[updateIndex] = student;
        System.out.println("修改成功");


    }

    private void addStudent() {
        System.out.println("请输入学号");
        int id = sc.nextInt();
        System.out.println("请输入学生姓名");
        String name = sc.next();
        System.out.println("请输入学生年龄");
        int age = sc.nextInt();
        System.out.println("请您输入学生性别");
        String sex = sc.next();
        Student student =new Student(id, name, age, sex);
        students[count] = student;
        count++;
        System.out.println("添加成功");
    }
}
