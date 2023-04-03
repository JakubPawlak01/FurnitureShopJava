public class run {
    Printer printer;
    FileManager fileManager;

    public run(){
        printer = new Printer();
        fileManager = new FileManager();
    }

    User createUser(int userNr) {
        if (userNr == 1) {
            printer.printCreateAdmin();
            User user = new Admin(printer, fileManager);
            return user;
        } else {
            printer.printCreateClient();
            User user = new Client(printer, fileManager);
            return user;
        }
    }

    User login() {
        printer.printHelloLogin();
        return createUser(printer.printSelectUser());
    }

    int showMainMenu(User user) {
        return user.showMainMenu();
    }

    boolean selectMenu(User user, int menuNr) {
        switch (menuNr) {
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
        User user = main.login();
        boolean exit = false;
        while (!exit) {
            exit = main.selectMenu(user, main.showMainMenu(user));
        }
    }
}
