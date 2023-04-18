public class RedBlackTree<T extends Comparable<T>> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        T value;
        Node left, right;
        boolean color;

        Node(T value, boolean color) {
            this.value = value;
            this.color = color;
        }
    }

    private Node root;

    public void insert(T value) {
        root = insert(root, value);
        root.color = BLACK;
    }

    private Node insert(Node node, T value) {
        if (node == null) {
            return new Node(value, RED);
        }

        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = insert(node.left, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, value);
        } else {
            
            return node;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    public void delete(T value) {
        if (!contains(value)) {
            return;
        }

        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = delete(root, value);
        if (root != null) {
            root.color = BLACK;
        }
    }

    private Node delete(Node node, T value) {
        if (value.compareTo(node.value) < 0) {
            if (!isRed(node.left) && !isRed(node.left.left)) {
                node = moveRedLeft(node);
            }
            node.left = delete(node.left, value);
        } else {
            if (isRed(node.left)) {
                node = rotateRight(node);
            }
            if (value.compareTo(node.value) == 0 && node.right == null) {
                return null;
            }
            if (!isRed(node.right) && !isRed(node.right.left)) {
                node = moveRedRight(node);
            }
            if (value.compareTo(node.value) == 0) {
                Node min = findMin(node.right);
                node.value = min.value;
                node.right = deleteMin(node.right);
            } else {
                node.right = delete(node.right, value);
            }
        }
        return balance(node);
    }

    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private void flipColors(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    private Node moveRedLeft(Node node) {
        flipColors(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
            flipColors(node);
        }
        return node;
    }

    private Node moveRedRight(Node node) {
        flipColors(node);
        if (!isRed(node.left) && !isRed(node.left.left)) {
            node = rotateRight(node);
            flipColors(node);
        }
        return node;
    }
    
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    private Node deleteMin(Node node) {
        if (node.left == null) {
            return null;
        }
    
        if (!isRed(node.left) && !isRed(node.left.left)) {
            node = moveRedLeft(node);
        }
    
        node.left = deleteMin(node.left);
        return balance(node);
    }
    
    private Node balance(Node node) {
        if (isRed(node.right)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }
    
    public boolean contains(T value) {
        return contains(root, value);
    }
    
    private boolean contains(Node node, T value) {
        if (node == null) {
            return false;
        }
    
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            return contains(node.left, value);
        } else if (cmp > 0) {
            return contains(node.right, value);
        } else {
            return true;
        }
    }
}
