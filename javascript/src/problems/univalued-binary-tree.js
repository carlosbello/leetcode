// eslint-disable-next-line no-unused-vars
const TreeNode = require('../data-structures/binary-tree/tree-node');

/**
 * 965. Univalued Binary Tree [easy] https://leetcode.com/problems/univalued-binary-tree/
 * @param {TreeNode} root
 * @return {boolean}
 */
const isUnivalTree = root => {
    const isUT = (r) => 
        !r || r.val === root.val && isUT(r.left) && isUT(r.right);
    
    return isUT(root);
};

module.exports = { isUnivalTree };