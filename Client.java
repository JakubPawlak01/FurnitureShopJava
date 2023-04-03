public class Client implements User{
private Printer printer;
private FileManager fileManager;

public Client(Printer printer, FileManager fileManager) {
    this.printer = printer;
    this.fileManager = fileManager;
}

public int showMainMenu() {
    return printer.printMenuClient();
}

public void callMenu1() {
    String type = printer.getTypeFromUser();
    String model = printer.getModelFromUser();
    String color = printer.getColorFromUser();
    Furniture furniture = new Furniture(type, model, color);
    int id = fileManager.getIdFromFile(furniture);
    if (id == -1) {
        printer.printFurnitureNotFound();
        return;
    }
    int price = fileManager.getPriceFromFile(id);
    furniture.setPrice(price);
    furniture.setId(id);
    if (printer.printFurniturePrice(furniture)) {
        printer.printFurnitureId(furniture);
        fileManager.deleteFurniture(id);
    }
}

public void callMenu2() {
    String type = printer.getTypeFromUser();
    String model = printer.getModelFromUser();
    String color = printer.getColorFromUser();
    int price = printer.getPriceFromUser();
    int id = printer.getIdFromUser();
    Furniture furniture = new Furniture(id, price, type, model, color);
    printer.printFurniture(furniture);
    fileManager.addFurniture(furniture);
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
