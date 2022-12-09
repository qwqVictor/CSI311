var BaseBinaryTree = require("./BaseBinaryTree").BaseBinaryTree;

/**
 * Construct a binary search tree
 */
function BinarySearchTree() {
    BaseBinaryTree.call(this, undefined);
}

/* make inheritance */
BinarySearchTree.prototype = Object.create(BaseBinaryTree);

/**
 * Insert a value into BST
 * @param value the value to be inserted
 */
BinarySearchTree.prototype.insert = function (value) {
    var insertRecursively = (function (value, node) {
        if (!node || !node.value) {
            node = {
                value: value,
                left: undefined,
                right: undefined
            };
        }
        if (value == node.value)
            node.value = value;
        else if (value < node.value)
            node.left = insertRecursively(value, node.left);
        else node.right = insertRecursively(value, node.right);
        return node;
    }).bind(this);

    this.root = insertRecursively(value, this.root);
}

/**
 * Find a value in BST and get it
 * @param value The value to find
 * @returns the value to be found
 */
BinarySearchTree.prototype.get = function (value) {
    var getRecursively = (function (value, node) {
        if (!node)
            return null;
        if (value == node.value)
            return node.value;
        else if (value < node.value)
            return getRecursively(value, node.left);
        else return getRecursively(value, node.right);
    }).bind(this);

    return getRecursively(value, this.root);
}

/**
 * Remove a value in BST
 * @param value The value to be removed 
 * @returns the value removed
 */
BinarySearchTree.prototype.remove = function(value) {
    var removeRecursively = (function (value, node) {
        if (!node)
            return null;
        if (value == node.value) {
            if (!node.left)
                return node.right;
            else if (!node.right)
                return node.left;
            else {
                var rightNodeInLeftTree = node.left;
                while (rightNodeInLeftTree && rightNodeInLeftTree.right)
                    rightNodeInLeftTree = rightNodeInLeftTree.right;
                node.value = rightNodeInLeftTree.value;
                node.left = removeRecursively(value, node.left);
            }
        }
        else if (value < node.value)
            node.left = removeRecursively(value, node.left);
        else node.right = removeRecursively(value, node.right);
        return node
    }).bind(this);

    return removeRecursively(value, this.root);
}

/**
 * Iterate the BST
 * @param callback callback function
 */
BinarySearchTree.prototype.forEach = function (callback) {
    var stack = [], traversalNode = this.root;
    while (traversalNode || stack.length > 0) {
        while (traversalNode) {
            stack.push(traversalNode);
            traversalNode = traversalNode.left;
        }
        var node = stack.pop();
        traversalNode = node.right;
        callback(node.value);
    }
}

module.exports = {
    BinarySearchTree: BinarySearchTree
};