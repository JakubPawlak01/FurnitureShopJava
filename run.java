import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class run {
    Printer printer;
    FileManager fileManager;
    Scanner scanner;
    private List<User> loggedInUsers;

    public run(){
        printer = new Printer();
        fileManager = new FileManager();
        scanner = new Scanner(System.in);
        loggedInUsers = new ArrayList<>();
    }

    User createUser(int userNr,String username, String password) {
        if (userNr == 1) {
            printer.printCreateAdmin();
            User user = new Admin(printer, fileManager, username, password);
            printer.printHelloAdmin((Admin)user);
            return user;
        } else {
            printer.printCreateClient();
            User user = new Client(printer, fileManager, username);
            printer.printHelloClient((Client) user);
            return user;
        }
    }

    User login() {
        printer.printHelloLogin();
        int userNr = printer.printSelectUser();

        if (userNr == 1) {
            printer.printLogin();
            String login = scanner.nextLine();
            printer.printPassword();
            String password = scanner.nextLine();

            if (fileManager.validateAdmin(login, password)) {
                return createUser(userNr,login, password);
            } else {
                printer.printInvalidLogin();
                return null;
            }
        } 
        else {
            printer.printLogin();
            String username = scanner.nextLine();
            User existingUser = findLoggedInUser(username);

            if (existingUser != null) {
                printer.userAlreadyLogged( (Client) existingUser);
                return existingUser;
            }
        
            User user = createUser(userNr, username, null);
            if (user != null) {
                loggedInUsers.add(user);
                return user;
            } else {
                return null;
            }
    }
}

    private User findLoggedInUser(String username) {
        for (User user : loggedInUsers) {
            if (user instanceof Client && ((Client) user).getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean logout(User user) {
        loggedInUsers.remove(user);
        printer.printLogout();
        return true;
    }

    int showMainMenu(User user) {
        return user.showMainMenu();
    }

    boolean selectMenu(User user, int menuNr) {
        switch (menuNr) {
            case 0:
                logout(user);
                return true;
            case 1:
                user.callMenu1();
                return false;
            case 2:
                user.callMenu2();
                return false;
            case 3:
                user.callMenu3();
                return false;
            case 4:
                user.callMenu4();
                return false;
            case 5:
                user.callMenu5();
                return true;
            default:
                user.callWrong();
                return true;
        }
    }

    public static void main(String[] args) {
        run main = new run();
        boolean exit = false;
        User user = main.login();
        while (!exit) {
            if (user != null) {
                main.loggedInUsers.add(user);
                int menuNr = main.showMainMenu(user);
                if(menuNr == 0) {
                    user = main.login();
                }
                exit = main.selectMenu(user, menuNr);
                if (exit) {
                    if(!(menuNr == 5)){
                        exit = false;
                    }
                }
            }
        }
    }
}