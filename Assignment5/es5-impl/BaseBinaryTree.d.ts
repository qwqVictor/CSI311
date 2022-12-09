/**
 * Type definitions of Base Binary Tree
 * 
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
type TreeNode = {
    value: any
    left?: TreeNode
    right?: TreeNode
}

export class BaseBinaryTree {
    protected root: TreeNode
    isEmpty(): boolean
    makeEmpty(): void
}