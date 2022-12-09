import java.util.Iterator;
import java.util.Stack;

/**
 * Iterator class for tree
 * 
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class TreeIterator<T> implements Iterator<T> {
    Stack<TreeNode<T>> stack;
    TreeNode<T> traversalNode;

    public TreeIterator(BaseBinaryTree<T> tree) {
        this.stack = new Stack<TreeNode<T>>();
        if (tree != null) {
            this.traversalNode = tree.root;
        }
    }

    @Override
    public boolean hasNext() {
        return this.traversalNode != null || !stack.isEmpty();
    }

    @Override
    public T next() {
        if (this.hasNext()) {
            while (this.traversalNode != null) {
                stack.push(this.traversalNode);
                this.traversalNode = this.traversalNode.left;
            }
            TreeNode<T> node = stack.pop();
            this.traversalNode = node.right;
            return node.value;
        }
        return null;
    }

}
