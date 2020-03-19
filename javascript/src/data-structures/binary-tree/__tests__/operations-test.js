const test = require('ava');
const { searchBST } = require('../operations');
const TreeNode = require('../tree-node');

// @ts-ignore
test('searchBST return null given null root', t => {
    t.is(searchBST(null, 5), null);
});

// @ts-ignore
test('searchBST return null given value is not found', t => {
    const tree = new TreeNode(4, new TreeNode(3), new TreeNode(6));
    t.is(searchBST(tree, 5), null);
});

// @ts-ignore
test('searchBST return subtree given existing value', t => {
    const tree = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
    t.deepEqual(searchBST(tree, 2), new TreeNode(2, new TreeNode(1), new TreeNode(3)));
});
