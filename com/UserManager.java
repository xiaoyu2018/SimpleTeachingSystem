package com;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.FileWriter;
import java.nio.file.*;

public class UserManager 
{
    private User currente_user;
    private Map<String, String> users = new HashMap<>();
    

    public UserManager()
    {
        currente_user = new User();
        Path path = Paths.get("D:\\没意思\\111\\666\\data\\user.txt");
        List<String> list = new ArrayList<>();
        try{
        list = Files.readAllLines(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String string : list) {
            users.put(string.split(" ")[0], string.split(" ")[1]);
        }
    }

    public void check(Scanner scanner)
    {
        for(int i=3;i>0;i--)
        {
            System.out.println("please input your name");
            currente_user.setName(scanner.nextLine());
            System.out.println("please input your password");
            currente_user.setPWD(scanner.nextLine());
            if (!users.containsKey(currente_user.getName())
                    || !users.get(currente_user.getName()).equals(currente_user.getPassword())) 
            {
                System.out.println("username no exists or password error,please input again");
                if(i!=0)
                System.out.println("you can try "+(i-1)+" more times");
                continue;
            }
            System.out.println(currente_user.getName()+" has been logged in");
            return;
        }
        System.out.println("maximum number of attempts,system exit");
        System.exit(0);
    }

    public boolean createNewAccount(Scanner scanner) {
        String name, password;
        System.out.println("please set your username of which the size is no more than 8 words");
        while (true) {
            if ((name = scanner.nextLine()).length() > 8 || name.length() == 0) {
                System.out.println("please set your name correctly");
                continue;
            }
            if (users.containsKey(name)) 
            {
                System.out.println("the name you inputed has been occupied");
                continue;
            }
            currente_user.setName(name);
            break;
        }
        System.out.println("please set your password,and its length should <10 and >6");
        while(true)
        {
            if ((password = scanner.nextLine()).length() <= 10 && password.length() >= 6) {
                currente_user.setPWD(password);
                break;
            } else
                System.out.println("please set your password correctly");
        }
        try
        {
            FileWriter fw = new FileWriter("D:\\没意思\\111\\666\\data\\user.txt",true);
            fw.write(currente_user.getName() + " " + currente_user.getPassword()+ '\n');
            fw.close();
            System.out.println("created successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("log in with the current user ? (y/n)");
        String ch;
        while(!(ch=scanner.nextLine()).equals("y")&&!ch.equals("n"))
        {
            System.out.println("please input y or n");
        }
        if (ch.equals("y"))
        {
            System.out.println(currente_user.getName() + " has been logged in");
            return true;
        }
            
        return false;
    }
    
}