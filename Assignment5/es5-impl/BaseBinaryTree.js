/**
 * Basic Binary Tree
 * 
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */

/**
 * Construct a basic binary tree
 * @param rootValue root node's value 
 */
function BaseBinaryTree(rootValue) {
    this.root = {
        value: rootValue
    };
}
/**
 * Check if binary tree is empty
 * @returns boolean 
 */
BaseBinaryTree.prototype.isEmpty = function() {
    return !!this.root;
}

/**
 * Make the tree empty
 */
BaseBinaryTree.prototype.makeEmpty = function() {
    this.root = undefined;
}

module.exports = {
    BaseBinaryTree: BaseBinaryTree
};