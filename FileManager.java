import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileManager {
    public void addFurniture(Furniture furniture) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("database.csv", true));
            writer.write(furniture.id + ";" +
                    furniture.type + ";" +
                    furniture.model + ";" +
                    furniture.color + ";" +
                    furniture.price + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> split(String data) {
        return Arrays.stream(data.split(";"))
                .collect(Collectors.toList());
    }

    public String join(List<String> data) {
        return String.join(";", data);
    }

    public List<String> csv_read(String filePath) {
        List<String> vectorOfLines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                vectorOfLines.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vectorOfLines;
    }

    public boolean findId(int id, List<String> stringFromFile) {
        int idFromString = Integer.parseInt(stringFromFile.get(0));
        return idFromString == id;
    }

    public void deleteFurniture(int id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("database.csv"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("database2.csv", true));
            String line = reader.readLine();
            while (line != null) {
                if (findId(id, this.split(line))) {
                    line = reader.readLine();
                    continue;
                } else {
                    writer.write(line + "\n");
                }
                line = reader.readLine();
            }
            reader.close();
            writer.close();
            File database = new File("database.csv");
            database.delete();
            File database2 = new File("database2.csv");
            database2.renameTo(database);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getIdFromFile(Furniture furniture) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("database.csv"));
            String line = reader.readLine();
            while (line != null) {
                List<String> vector = this.split(line);
                if (vector.get(1).equals(furniture.type) && vector.get(2).equals(furniture.model) && vector.get(3).equals(furniture.color)) {
                    int id = Integer.parseInt(vector.get(0));
                    reader.close();
                    return id;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int getPriceFromFile(int id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("database.csv"));
            String line = reader.readLine();
            while (line != null) {
                List<String> vector = this.split(line);
                if (this.findId(id, vector)) {
                    int price = Integer.parseInt(vector.get(4));
                    reader.close();
                    return price;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void getFurniture(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("database.csv"));
            String line = reader.readLine();
            while (line != null) {
                List<String> vector = this.split(line);
                System.out.println("Rodzaj: " + vector.get(1));
                System.out.println("Model: " + vector.get(2));
                System.out.println("Kolor: " + vector.get(3));
                System.out.println("Cena: " + vector.get(4));
                System.out.println();
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
