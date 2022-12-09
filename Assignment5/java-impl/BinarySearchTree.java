import java.util.Iterator;

/**
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<T>> extends BaseBinaryTree<T> implements Iterable<T> {
    /**
     * Initialize the tree
     */
    public BinarySearchTree() {
        super();
    }

    /**
     * Insert a new value
     * 
     * @param value the value to be inserted
     */
    public void insert(T value) {
        this.root = insert(value, this.root);
    }

    private TreeNode<T> insert(T value, TreeNode<T> node) {
        if (node == null || node.value == null) {
            node = new TreeNode<T>(value);
            return node;
        }
        int compareToResult = value.compareTo(node.value);
        if (compareToResult == 0) {
            node.value = value;
        } else if (compareToResult < 0) {
            node.left = insert(value, node.left);
        } else {
            node.right = insert(value, node.right);
        }
        return node;
    }

    /**
     * Search the value
     * 
     * @param key the key to find the value
     * @return the wanted value
     */
    public T get(T key) {
        return get(key, this.root);
    }

    private T get(T key, TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        int compareToResult = key.compareTo(node.value);
        if (compareToResult == 0) {
            return node.value;
        } else if (compareToResult < 0) {
            return get(key, node.left);
        } else {
            return get(key, node.right);
        }
    }

    /**
     * Remove a value from the tree
     * 
     * @param value the value to be removed
     */
    public void remove(T value) {
        root = remove(value, this.root);
    }

    private TreeNode<T> remove(T key, TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        int compareToResult = key.compareTo(node.value);
        if (compareToResult == 0) {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                TreeNode<T> rightNodeInLeftTree = node.left;
                while (rightNodeInLeftTree != null && rightNodeInLeftTree.right != null)
                    rightNodeInLeftTree = rightNodeInLeftTree.right;
                node.value = rightNodeInLeftTree.value;
                node.left = remove(key, node.left);
            }
        } else if (compareToResult < 0) {
            node.left = remove(key, node.left);
        } else {
            node.right = remove(key, node.right);
        }
        return node;
    }

    /**
     * Construct an iterator of this tree
     * 
     * @return an iterator to in-order traverse this tree
     */
    public Iterator<T> iterator() {
        return new TreeIterator<T>(this);
    }

    /**
     * Return string representation of this tree
     * 
     * @return a string that represent this tree
     */
    public String toString() {
        return "root: \n" + this.root.toString();
    }
}
