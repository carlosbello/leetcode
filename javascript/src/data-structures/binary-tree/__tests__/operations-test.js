const test = require('ava');
const { searchBST, findTwoSumIVInBST } = require('../operations');
const TreeNode = require('../tree-node');

// @ts-ignore
test('searchBST return null given null root', t => {
    t.is(searchBST(null, 5), null);
});

// @ts-ignore
test('searchBST return null given value is not found', t => {
    // given
    const tree = new TreeNode(4, new TreeNode(3), new TreeNode(6));

    // then
    t.is(searchBST(tree, 5), null);
});

// @ts-ignore
test('searchBST return subtree given existing value', t => {
    // given
    const tree = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));

    // then
    t.deepEqual(searchBST(tree, 2), new TreeNode(2, new TreeNode(1), new TreeNode(3)));
});

// @ts-ignore
test('findTwoSumIVInBST', t => {
    // given
    const bst1 = new TreeNode(
        5,
        new TreeNode(3, new TreeNode(2), new TreeNode(4)),
        new TreeNode(6, null, new TreeNode(7))
    );
    const bst2 = new TreeNode(1);

    // then
    t.is(findTwoSumIVInBST(bst1, 9), true);
    t.is(findTwoSumIVInBST(bst1, 28), false);
    t.is(findTwoSumIVInBST(bst2, 2), false);
});
