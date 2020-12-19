package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {
    private HashMap<String, String> dictionaryMap;
    private String file;

    public SaveableDictionary() {
        dictionaryMap = new HashMap<>();
    }

    public void add(String words, String translation) {
        dictionaryMap.putIfAbsent(words, translation);
        dictionaryMap.putIfAbsent(translation, words);
    }

    public String translate(String word) {
        return dictionaryMap.getOrDefault(word, null);
    }

    public void delete(String word) {
        // requres word to be present
        dictionaryMap.remove(dictionaryMap.get(word));
        dictionaryMap.remove(word);
    }

    public SaveableDictionary(String file) {
        dictionaryMap = new HashMap<>();
        this.file = file;
    }

    public boolean load() {
        try (Scanner fileReader = new Scanner(Paths.get(file))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
                this.add(parts[1], parts[0]);
            }
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }

    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(file);
            while (!dictionaryMap.isEmpty()) {
                for (String word : dictionaryMap.keySet()) {
                    writer.println(word + ":" + dictionaryMap.get(word));
                    dictionaryMap.remove(dictionaryMap.get(word));
                    dictionaryMap.remove(word);
                    break;
                }
            }
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}