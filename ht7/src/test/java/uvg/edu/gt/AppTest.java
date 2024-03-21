package uvg.edu.gt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void insertAndSearchTest() {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();
        Association<String, String> association = new Association<>("dog", "perro");
        
        tree.insert(association);
        Association<String, String> result = tree.search(association);
        
        assertNotNull(result);
        assertEquals("perro", result.getValue());
    }
}

