/**
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public abstract class BaseBinaryTree<T> {
	protected TreeNode<T> root;

	/**
	 * Construct an empty binary tree.
	 */
	public BaseBinaryTree() {
		this(null);
	}

	/**
	 * Construct a tree with root.
	 * 
	 * @param rootValue the value of root
	 */
	public BaseBinaryTree(T rootValue) {
		this.root = new TreeNode<T>(rootValue, null, null);
	}

	/**
	 * Returns true if the tree is empty, vice versa.
	 * 
	 * @return true if the tree is empty
	 */
	public boolean isEmpty() {
		return this.root == null;
	}

	/**
	 * Clear the tree
	 */
	public void makeEmpty() {
		this.root = null;
	}

	/**
	 * Get the root value
	 * 
	 * @return the value of root
	 * @throws TreeException thrown if the tree is empty
	 */
	public T getRoot() throws TreeException {
		if (this.root == null) {
			throw new TreeException("Empty tree");
		} else {
			return this.root.value;
		}
	}
}
