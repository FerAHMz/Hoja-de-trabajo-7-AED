package uvg.edu.gt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DictionaryBinaryTree<String, String> dictionary = new DictionaryBinaryTree<>();

        // Define las rutas absolutas a los archivos
        String diccionarioPath = "ht7\\diccionario.txt";
        String textoPath = "ht7\\texto.txt";

        // Cargar el diccionario desde el archivo
        loadDictionaryFromFile(dictionary, diccionarioPath);

        // Mostrar el diccionario ordenado (in-order traversal)
        System.out.println("Diccionario Inglés-Español:");
        dictionary.inOrder();

        // Traducir el texto desde el archivo
        String translatedText = translateTextFromFile(dictionary, textoPath);
        
        // Mostrar el texto traducido
        System.out.println("\nTexto traducido:");
        System.out.println(translatedText);
    }

    private static void loadDictionaryFromFile(DictionaryBinaryTree<String, String> dictionary, String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    dictionary.insert(new Association<>(parts[0].trim(), parts[1].trim()));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + fileName);
        }
    }

    private static String translateTextFromFile(DictionaryBinaryTree<String, String> dictionary, String fileName) {
        StringBuilder translatedText = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^a-zA-Z ]", "").toLowerCase(); // Elimina puntuación y convierte a minúsculas
                String translatedWord = dictionary.searchByKey(word);
                if (translatedWord != null) {
                    translatedText.append(translatedWord).append(" ");
                } else {
                    translatedText.append("*").append(word).append("* ").append(" ");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + fileName);
            return "";
        }
        return translatedText.toString().trim();
    }
}
