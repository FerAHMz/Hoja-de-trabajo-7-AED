package uvg.edu.gt;

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    protected Node<E> getRoot() {
        return root;
    }

    protected void setRoot(Node<E> root) {
        this.root = root;
    }

    protected static class Node<E> {
        E value;
        Node<E> left;
        Node<E> right;

        public Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree(){
        root = null;
    }   

    public void insert(E value){
        root = insertRec(root, value);
    }

    private Node<E> insertRec(Node<E> root, E value){
        if(root == null){
            root = new Node<E>(value);
            return root;
        }
        if(value.compareTo(root.value) < 0){
            root.left = insertRec(root.left, value);
        }else if(value.compareTo(root.value) > 0){
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public void inOrder(){
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<E> root){
        if(root != null){
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }

    public E search(E value){
        return searchRec(root, value);
    }

    private E searchRec(Node<E> root, E value){
        if (root == null || root.value.equals(value)){
            return root != null ? root.value : null;
        }
        if(value.compareTo(root.value) < 0){
            return searchRec(root.left, value);
        } else {
            return searchRec(root.right, value);
        }
    }
}
