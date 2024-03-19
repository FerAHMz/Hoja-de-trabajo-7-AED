package uvg.edu.gt;

public class Node {
    E value;
    Node<E> left;
    Node<E> right;

    public Node(E value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
