import java.util.*;
import java.io.*;

class Main {
    static File file;
    static FileWriter writer;

    public static void main(String args[]) {

        try {
            file = new File("Accounts.txt");
            file.createNewFile();
        } catch (Exception a) {

        }


        LinkedList<account> main = new LinkedList<account>();
        Scanner scan = new Scanner(System.in);
        String name = "name";
        String password;
        String in;
        boolean r = true;
        boolean all = true;

        main.add(new account("adsdsdsd", "asdsddd"));


        while (all == true) {
            System.out.println("Would you like to (create account) or (login)?");
            in = test(scan);
            // login
            if (in.equals("login")) {
                System.out.println("Enter Username:");
                name = test(scan);
                System.out.println("Enter Password:");
                password = test(scan);
                boolean ah = true;
                for (int i = 0; i < main.size(); i++) {
                    if (main.get(i).login(name, password)) {
                        System.out.println("welcome, " + main.get(i).name);
                        all = false;
                        ah = false;
                        break;

                    }
                }
                if (ah == true) {
                    System.out.println("sorry account does not match records");
                }
            }
            if (in.equals("create account")) {
                //add adccount


                boolean f = true;
                while (f) {
                    f = false;
                    System.out.println("Enter Username:");
                    name = test(scan);
                    for (int i = 0; i < main.size(); i++) {
                        if (main.get(i).ex(name)) {
                            f = true;
                            break;

                        }
                    }

                }


                System.out.println("Enter Password:");
                password = test(scan);


                main.add(new account(name, password));
                addAccount(name,password);

            }
        }
  
  
  /*
  login
Bob
Ross
create account
Bob
Ross
create account
JamesBond
GoldenGun
create account
JamesBond2
GoldenGun
create account
JamesBond2
john
GoldenGun
login
Bob
GoldenGun
login
JamesBond
GoldenGun
*/


    }
///////////////////////////////////new stuff
    public static void addAccount(String name, String pass) {
        try {
            writer = new FileWriter("Accounts.txt", true);
            writer.write(name + " " + pass + "\n");
            writer.close();
        } catch (Exception a) {

        }
    }




//////////////////////////////////////////////////////////////////////////////////////
    public static String test(Scanner scan) {

        String x;
        while (true) {
            try {
                x = scan.nextLine();
                break;
            } catch (InputMismatchException aa) {

            }

        }
        return x;
    }
}


class account {
    account(String x, String y) {
        this.name = x;
        this.account = y;
    }


    String name;
    String account;

    boolean login(String name, String account) {
        boolean x = false;
        if (this.name.equals(name) && this.account.equals(account)) {

            x = true;
        }

        return x;
    }

    boolean ex(String name) {
        boolean x = false;
        if (this.name.equals(name)) {
            x = true;

        }
        return x;
    }
}

    
    
