package uvg.edu.gt;

public class Main {
    public static void main(String[] args) {
        // Crear el diccionario como un árbol binario de búsqueda
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>();

        // Insertar algunas asociaciones de palabras inglés-español
        dictionary.insert(new Association<>("house", "casa"));
        dictionary.insert(new Association<>("dog", "perro"));
        dictionary.insert(new Association<>("homework", "tarea"));
        dictionary.insert(new Association<>("woman", "mujer"));
        dictionary.insert(new Association<>("town", "pueblo"));
        dictionary.insert(new Association<>("yes", "si"));

        // Mostrar el diccionario ordenado (in-order traversal)
        System.out.println("Diccionario Inglés-Español:");
        dictionary.inOrder();

        // Texto a traducir
        String text = "The woman asked me to do my homework about my town.";

        // Traducir el texto
        String translatedText = translateText(dictionary, text);

        // Mostrar el texto traducido
        System.out.println("\nTexto traducido:");
        System.out.println(translatedText);
    }

    private static String translateText(BinaryTree<Association<String, String>> dictionary, String text) {
        StringBuilder translatedText = new StringBuilder();
        String[] words = text.split(" ");
    
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            // Asume que tienes un método adecuado para buscar por clave.
            String translatedWord = dictionary.searchByKey(lowerCaseWord); // Usando el nuevo método
    
            if (translatedWord != null) {
                translatedText.append(translatedWord).append(" ");
            } else {
                translatedText.append("*").append(word).append("* ").append(" ");
            }
        }
    
        return translatedText.toString().trim();
    }
    
}

