package uvg.edu.gt;

public class DictionaryBinaryTree<K extends Comparable<K>, V> extends BinaryTree<Association<K, V>> {

    public V searchByKey(K key) {
        Node<Association<K, V>> current = getRoot();
        while (current != null) {
            int comparison = key.compareTo(current.value.getKey());
            if (comparison == 0) {
                return current.value.getValue();
            } else if (comparison < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }
}
