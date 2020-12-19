package dictionary;

public class Main {
    public static void main(String[] args) {
        // You can test your dictionary here
        SaveableDictionary s = new SaveableDictionary("test-671874.txt");
        s.add("tietokone", "computer");
        s.save();
    }
}
