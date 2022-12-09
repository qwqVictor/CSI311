import { BaseBinaryTree } from "./BaseBinaryTree";
export class BinarySearchTree extends BaseBinaryTree {
    insert(value: any): void
    get(): any
    remove(value: any): any
    forEach(callback: (value: any) => void): void
}