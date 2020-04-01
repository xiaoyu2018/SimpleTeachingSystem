package com;

import java.util.ArrayList;
import java.io.FileWriter;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class TeachingSys 
{
    ArrayList<Student> students = new ArrayList<>();
    String[] temp = new String[8];
    public TeachingSys()
    {
        Path path = Paths.get("D:\\没意思\\111\\666\\data\\student.txt");
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String string : list) {
            temp = string.split(" ");
            students.add(
                    new Student
                    (temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], Integer.parseInt(temp[7]))
            );
        }
    }

    public void add(Scanner scanner)
    {
        System.out.println("please input info in order of \"no IDKey name major class native_place home_add score\"");
        scanner.nextLine();
        while(true)
        {
            temp = scanner.nextLine().split(" ");
            while (true)
            {
                if (temp.length == 8)
                    break;
                System.out.println("please input correctly");
                temp = scanner.nextLine().split(" ");
            }
            if (locateByNo(temp[0])!=null)
            {
                System.out.println("this student has been existed in database...press any key to back");
                scanner.nextLine();
                break;
            }   
            students.add(
                    new Student(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], Integer.parseInt(temp[7])));
            update();
            System.out.println("press 1 to continue adding or press 0 to back to the menu");
            if(Integer.parseInt(scanner.nextLine())==0)
                break;
        }
        
    }

    public void remove(Scanner scanner)
    {
        System.out.println("please input the student's no you want to remove");
        scanner.nextLine();
        while (true) 
        {
            students.remove(getStudent(scanner));
            update();
            System.out.println("press 1 to continue removing or press 0 to back to the menu");
            if (Integer.parseInt(scanner.nextLine()) == 0)
                break;
        }
    }

    public void modify(Scanner scanner)
    {
        System.out.println("please input the student's no you want to modify");
        scanner.nextLine();
        while (true) 
        {
            Student stu = getStudent(scanner);
            System.out.println
            ("please input info in order of \"IDKey name major class native_place home_add score\"");
            temp = scanner.nextLine().split(" ");
            while (true) {
                if (temp.length == 7)
                    break;
                System.out.println("please input correctly");
                temp = scanner.nextLine().split(" ");
            }
            stu.IDKey = temp[0];stu.name = temp[1];stu.major = temp[2];
            stu._class = temp[3];
            stu.native_place = temp[4];
            stu.home_add = temp[5];
            stu.score = Integer.parseInt(temp[6]);

            update();
            System.out.println("press 1 to continue modifying or press 0 to back to the menu");
            if (Integer.parseInt(scanner.nextLine()) == 0)
                break;
        }

    }
    Student locateByNo(String no)
    {
        for (Student student : students) {
            if (student.no.equals(no))
                return student;
        }
        return null;
    }

    Student getStudent(Scanner scanner)
    {
            String no = scanner.nextLine();
            Student student;
            while ((student = locateByNo(no)) == null) 
            {
                System.out.println("input not found,please input again");
                no = scanner.nextLine();
            }
            return student;
    }

    void update()
    {
        try {
            FileWriter fw = new FileWriter("D:\\没意思\\111\\666\\data\\student.txt");
            for (Student s : students) {
                fw.write(s.no + " " + s.IDKey + " " + s.name + " " + s.major+ " " 
            + s._class + " " + s.native_place + " " + s.home_add+ " " + s.score+'\n');
            }
            fw.close();
            System.out.println("update successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showByNo(Scanner scanner)
    {
        scanner.nextLine();
        System.out.println("please input the student's no you want require");
        show(scanner, getStudent(scanner));
    }
    public void show(Scanner scanner,Student s)
    {
        System.out.println("******************************************");
        System.out.println("no: " + s.no);
        System.out.println("major: " + s.major);
        System.out.println("class:" + s._class);
        System.out.println("name: " + s.name);
        System.out.println("score: " + s.score);
        System.out.println("IDKey: " + s.IDKey);
        System.out.println("home_add: " + s.home_add);
        System.out.println("native_place: " + s.native_place);
        System.out.println("******************************************");
        System.out.println("press any key to back to the menu...");
        scanner.nextLine();
    }

    public void showRank(Scanner scanner)
    {
        Collections.sort(students);
        int i=0;
        System.out.println("***********performence rank***********");
        for (Student student : students)
            System.out.println((++i) + " " + student.no + " " 
                    + student.name + " " + student.score);
            
        System.out.println("press any key to back to the menu...");
        scanner.nextLine();
        scanner.nextLine();
    }
    public void showDistibution(Scanner scanner) 
    {
        if(students.size()==0)
            return;
        int s = 0, a = 0, b = 0, c = 0, d = 0;
        float t = 0;
        for (Student student : students) {
            switch (student.score / 10) {
                case 10:
                case 9:
                    s++;
                    break;
                case 8:
                    a++;
                    break;
                case 7:
                    b++;
                    break;
                case 6:
                    c++;
                    break;
                default:
                    d++;
            }
            t++;
        }
        System.out.println("***********performence distribution***********");
        System.out.printf("                 90-100: %.2f%%\n",s/t*100);
        System.out.printf("                 80-89: %.2f%%\n",a/t*100);
        System.out.printf("                 70-79: %.2f%%\n",b/t*100);
        System.out.printf("                 60-69: %.2f%%\n",c/t*100);
        System.out.printf("                 0-59: %.2f%%\n\n",d/t*100);
        System.out.println("press any key to back to the menu...");
        scanner.nextLine();
        scanner.nextLine();
    }
    
    public int menu(Scanner scanner)
    {
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.println("please input your choice");
        System.out.print("\n");
        System.out.print("\n");
        System.out.println("1 add students' info");
        System.out.println("2 remove students' info");
        System.out.println("3 modify students' info");
        System.out.println("4 show students' info");
        System.out.println("5 show performance rank");
        System.out.println("6 show integral performance distibution");
        System.out.println("0 exit");
        int mode= scanner.nextInt();
        while(mode>6||mode<0)
        {
            System.out.println("please input correctly");
            mode = scanner.nextInt();
        }
        return mode;
    }
}