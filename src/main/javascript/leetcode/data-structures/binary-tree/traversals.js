/**
 * Binary Tree Preorder Traversal https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
const preorderTraversal = root =>
    root ? [root.val, ...preorderTraversal(root.left), ...preorderTraversal(root.right)] : [];

module.exports = { preorderTraversal };
