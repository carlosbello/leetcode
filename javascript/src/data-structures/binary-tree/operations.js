// eslint-disable-next-line no-unused-vars
const TreeNode = require('./tree-node');

/**
 * 700. Search in a Binary Search Tree https://leetcode.com/problems/search-in-a-binary-search-tree/
 * @param {TreeNode} root
 * @param {*} val
 * @returns {TreeNode}
 */
const searchBST = (root, val) => {
    if (!root || val === root.val) {
        return root;
    }
    return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
};

module.exports = { searchBST };
