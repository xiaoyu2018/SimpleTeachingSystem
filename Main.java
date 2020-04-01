import com.*;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();
        TeachingSys ts = new TeachingSys();
        while(true)
        {
            int answer = welcome();
            if (answer == 2)
            {
                if(!userManager.createNewAccount(scanner))
                    continue;
            }
            else if(answer==1)
                userManager.check(scanner);
            else
                return;
            while(true)
            {
                int mode =ts.menu(scanner);
                switch(mode)
                {
                    case 0:
                        System.exit(0);
                    case 1:
                        ts.add(scanner);
                        break;
                    case 2:
                        ts.remove(scanner);
                        break;
                    case 3:
                        ts.modify(scanner);
                        break;
                    case 4:
                        ts.showByNo(scanner);
                        break;
                    case 5:
                        ts.showRank(scanner);
                        break;    
                    case 6:
                        ts.showDistibution(scanner);
                        break;
                }
            }
        }
    }
    
    static int welcome() {
        System.out.print('\n');
        System.out.print('\n');
        System.out.print('\n');
        System.out.println("############# This is a TEACHING MANAGEMENT SYSTEM #############");
        System.out.println("                ____          ____   ____                  ____");
        System.out.println(" \\    /\\    /  |      |      /      /    \\    /\\    /\\    |");
        System.out.println("  \\  /  \\  /   |————  |      |      |    |   /  \\  /  \\   |————");
        System.out.println("   \\/    \\/    |____  |____  \\____  \\____/  /    \\/    \\  |____");
        System.out.print('\n');
        System.out.print('\n');
        System.out.print('\n');
        System.out.println("    SIGN ON or just CREATE A NEW ACCOUNT before you use it");
        System.out.println("                         __ __ __ __ __");
        System.out.println("                        |              | ");
        System.out.println("                        |   0、exit    |");
        System.out.println("                        |              |");
        System.out.println("                        |  1、sign on  |");
        System.out.println("                        |              | ");
        System.out.println("                        |  2、sign in  | ");
        System.out.println("                        |__ __ __ __ __|");
        System.out.println("                       inpute your choice");
        int answer = Integer.parseInt(new Scanner(System.in).nextLine());
        while (answer != 0 && answer != 1 && answer != 2) {
            System.out.println("you should input 0||1||2 to continue");
            answer = new Scanner(System.in).nextInt();
        }
        return answer;
    }
}