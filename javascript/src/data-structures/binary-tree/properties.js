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

/**
 * 100. Same Tree https://leetcode.com/problems/same-tree/
 *
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @returns {Boolean}
 */
const isSameTree = (p, q) =>
    (!p && !q) || (!!p && !!q && p.val === q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));

/**
 * 572. Subtree of Another Tree https://leetcode.com/problems/subtree-of-another-tree/
 * @param {TreeNode} s
 * @param {TreeNode} t
 */
const isSubtree = (s, t) =>
    isSameTree(s, t) || (!!s.left && isSubtree(s.left, t)) || (!!s.right && isSubtree(s.right, t));

module.exports = { countUnivalSubtrees, isSameTree, isSubtree };
