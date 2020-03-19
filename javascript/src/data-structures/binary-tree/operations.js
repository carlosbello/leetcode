// eslint-disable-next-line no-unused-vars
const TreeNode = require('./tree-node');
const { inorderTraversal } = require('./traversals');

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

/**
 * 653. Two Sum IV - Input is a BST https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * @param {TreeNode} root
 * @param {Number} k
 * @returns {Boolean}
 */
const findTwoSumIVInBST = (root, k) => {
    const values = inorderTraversal(root);
    let i = 0;
    let found = false;
    while (i < values.length && values[i] < k / 2 && !found) {
        found = !!searchBST(root, k - values[i]);
        i++;
    }
    return found;
};

module.exports = { searchBST, findTwoSumIVInBST };
