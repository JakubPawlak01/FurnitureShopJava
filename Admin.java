public class Admin implements User{
private Printer printer;
private FileManager fileManager;

public Admin(Printer printer, FileManager fileManager) {
    this.printer = printer;
    this.fileManager = fileManager;
}

public int showMainMenu() {
    return printer.printMenuAdmin();
}

public void callMenu1() {
    String type = printer.getTypeFromUser();
    int id = printer.getIdFromUser();
    int price = printer.getPriceFromUser();
    String model = printer.getModelFromUser();
    String color = printer.getColorFromUser();
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
