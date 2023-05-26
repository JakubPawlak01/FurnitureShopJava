public class Admin implements User{
private Printer printer;
private FileManager fileManager;
private String username;
private String password;

public Admin(Printer printer, FileManager fileManager,String username, String password) {
    this.printer = printer;
    this.fileManager = fileManager;
    this.username = username;
    this.password = password;
}

public String getUsername() {
    return username;
}

public int showMainMenu() {
    return printer.printMenuAdmin();
}

public void callMenu1() {
    printer.printChooseFurniture();

    String type = printer.getTypeFromUser();

    if(type.equals("Stół")) {
        printer.printChooseTable();
    }
    else if(type.equals("Krzesło")) {
        printer.printChooseChair();
    }
    else if(type.equals("Łóżko")) {
        printer.printChooseBed();
    }
    else if(type.equals("Szafa")) {
        printer.printChooseWardobe();
    }
    else if(type.equals("Komoda")) {
        printer.printChooseDresser();
    }
    else {
        printer.printBadChoice();
    }

    String model = printer.getModelFromUser();

    printer.printChooseColor();
    String color = printer.getColorFromUser();
    int id = printer.getIdFromUser();
    int price = printer.getPriceFromUser();
    Furniture furniture = new Furniture(id, price, type, model, color);
    printer.printFurniture(furniture);
    fileManager.addFurniture(furniture);
}

public void callMenu2() {
    int id = printer.getIdFromUser();
    fileManager.deleteFurniture(id);
}

public void callMenu3() {
    printer.printCallMenu3();
}

public void callMenu4() {
    printer.printCallMenu4();
}

public void callMenu5() {
    printer.printCallMenu5();
}

public void callWrong() {
    printer.printCallWrong();
}

}
