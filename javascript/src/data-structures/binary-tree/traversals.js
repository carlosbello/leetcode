/**
 * 144. Binary Tree Preorder Traversal [medium] https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
const preorderTraversal = root =>
    root ? [root.val, ...preorderTraversal(root.left), ...preorderTraversal(root.right)] : [];

/**
 * 94. Binary Tree Inorder Traversal [medium] https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
const inorderTraversal = root =>
    root ? [...inorderTraversal(root.left), root.val, ...inorderTraversal(root.right)] : [];

module.exports = { preorderTraversal, inorderTraversal };
