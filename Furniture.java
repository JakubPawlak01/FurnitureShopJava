public class Furniture {
    public int id;
    public int price;
    public String model;
    public String color;
    public String type;
    public Furniture(int id, int price, String type, String model, String color) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.model = model;
        this.color = color;
    }
    
    public Furniture(String type, String model, String color) {
        this.type = type;
        this.model = model;
        this.color = color;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setId(int id) {
        this.id = id;
    }
};    