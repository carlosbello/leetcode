// eslint-disable-next-line no-unused-vars
const TreeNode = require('./tree-node');

/**
 * 250. Count Univalue Subtrees https://leetcode.com/problems/count-univalue-subtrees/
 *
 * @param {TreeNode} root
 * @returns {Number}
 */
const countUnivalSubtrees = root => {
    /**
     * @param {TreeNode} root
     * @returns {[Number, Boolean]}
     * */
    const univalSubtrees = root => {
        if (!root) {
            return [0, true];
        }
        const [leftCount, isLeftUnival] = univalSubtrees(root.left);
        const [rightCount, isRightUnival] = univalSubtrees(root.right);
        const isUnival =
            isLeftUnival &&
            isRightUnival &&
            (!root.left || root.left.val === root.val) &&
            (!root.right || root.right.val === root.val);
        return [leftCount + rightCount + (isUnival ? 1 : 0), isUnival];
    };

    return univalSubtrees(root)[0];
};

module.exports = { countUnivalSubtrees };
