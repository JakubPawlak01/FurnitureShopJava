import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Printer {
    private final Scanner scanner;

    public Printer() {
        scanner = new Scanner(System.in);
    }

    private void printList(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    public void printHelloLogin(){
        System.out.println("Etap logowania");
    }

    public int printSelectUser(){
        System.out.println("Wybór użytkownika: ");
        System.out.println("Admin - 1");
        System.out.println("User - 2");
        int user = scanner.nextInt();
        return user;
    }

    public void printCreateAdmin(){
        System.out.println("Zalogowano jako administrator");
    }

    public void printCreateClient(){
        System.out.println("Zalogowano jako użytkowik");
    }
    
    public int printMenuAdmin() {
        List<String> adminMenu = Arrays.asList("Utworz mebel", "Usun mebel", "3", "4", "Wyjscie");
        printList(adminMenu);
        System.out.println();
        int menuNr = scanner.nextInt();
        return menuNr;
    }
        
    public int printMenuClient() {
        List<String> clientMenu = Arrays.asList("Kup mebel", "Zwroc mebel", "3", "4", "Wyjscie");
        printList(clientMenu);
        System.out.println();
        int menuNr = scanner.nextInt();
        return menuNr;
    }

    public void printCallMenu1(){
        System.out.println("Witaj w menu 1");
    }
    public void printCallMenu2(){
        System.out.println("Witaj w menu2");
    }
    public void printCallMenu3(){
        System.out.println("Witaj w menu3");
    }
    public void printCallMenu4(){
        System.out.println("Witaj w menu4");
    }
    public void printCallMenu5(){
        System.out.println("Zapraszamy ponownie!");
    }
    public void printCallWrong(){
        System.out.println("Witaj w callWrong");
    }

    public void printAdminConstructor(){
        System.out.println("Witaj w AdminConstructor");
    }
    public void printClientConstructor(){
        System.out.println("Witaj w ClientConstructor");
    }

    public String getTypeFromUser() {
        System.out.println("Podaj rodzaj mebla");
        String type = scanner.next();
        return type;
    }

    public int getIdFromUser() {
        System.out.println("Podaj id");
        int id = scanner.nextInt();
        return id;
    }
    
    public int getPriceFromUser() {
        System.out.println("Podaj cene");
        int price = scanner.nextInt();
        return price;
    }
    
    public String getColorFromUser() {
        System.out.println("Podaj kolor");
        String color = scanner.next();
        return color;
    }
    
    public String getModelFromUser() {
        System.out.println("Podaj model");
        String model = scanner.next();
        return model;
    }
    
    public void printFurniture(Furniture furniture) {
        System.out.println("Twoj mebel to: \n");
        System.out.println("Rodzaj: " + furniture.type);
        System.out.println("Model: " + furniture.model);
        System.out.println("Kolor: " + furniture.color);
        System.out.println("Cena: " + furniture.price);
        System.out.println("ID: " + furniture.id + "\n");
    }
    
    public boolean printFurniturePrice(Furniture furniture) {
        System.out.println("Cena twojego mebla to: " + furniture.price);
        System.out.println("Wpisz tak jesli chcesz kupic mebel");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();
        return input.equals("tak");
    }
    
    public void printFurnitureId(Furniture furniture) {
        System.out.println("Dziekujemy za zakup!\n");
        System.out.println("ID mebla potrzebne do zwrotu to: " + furniture.id + "\n");
    }

    public void printFurnitureNotFound(){
        System.out.println("Nie znaleziono mebla");
    }

}
