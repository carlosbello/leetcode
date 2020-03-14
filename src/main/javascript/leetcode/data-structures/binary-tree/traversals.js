/**
 * Binary Tree Preorder Traversal https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
const preorderTraversal = root =>
    root ? [root.val, ...preorderTraversal(root.left), ...preorderTraversal(root.right)] : [];

/**
 * Binary Tree Inorder Traversal https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
const inorderTraversal = root =>
    root ? [...inorderTraversal(root.left), root.val, ...inorderTraversal(root.right)] : [];

module.exports = { preorderTraversal, inorderTraversal };
