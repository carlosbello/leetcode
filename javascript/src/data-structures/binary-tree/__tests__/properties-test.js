const test = require('ava');
const TreeNode = require('../tree-node');
const { countUnivalSubtrees, isSameTree, isSubtree } = require('../properties');

// @ts-ignore
test('countUnivalSubtrees returns 0 when null', t => {
    // when
    const count = countUnivalSubtrees(null);

    // then
    t.is(count, 0);
});

// @ts-ignore
test('countUnivalSubtrees returns 1 when single node tree', t => {
    // when
    const count = countUnivalSubtrees(new TreeNode(1));

    // then
    t.is(count, 1);
});

// @ts-ignore
test('countUnivalSubtrees returns expected count', t => {
    // given
    const expectedCount = 4;
    const tree = new TreeNode(
        5,
        new TreeNode(1, new TreeNode(5), new TreeNode(5)),
        new TreeNode(5, null, new TreeNode(5))
    );

    // when
    const count = countUnivalSubtrees(tree);

    // then
    t.is(count, expectedCount);
});

// @ts-ignore
test('isSameTree returns true given both trees are null', t => {
    t.is(true, isSameTree(null, null));
});

// @ts-ignore
test('isSameTree returns false given one of the trees is null', t => {
    t.is(false, isSameTree(null, new TreeNode(1)));
    t.is(false, isSameTree(new TreeNode(1), null));
});

// @ts-ignore
test('isSameTree returns true given same trees', t => {
    // given
    const tree1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    const tree2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));

    // then
    t.is(true, isSameTree(tree1, tree2));
});

// @ts-ignore
test('isSameTree returns false given reversed trees', t => {
    // given
    const tree1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    const tree1reversed = new TreeNode(1, new TreeNode(3), new TreeNode(2));
    const tree2 = new TreeNode(1, new TreeNode(2));
    const tree2reversed = new TreeNode(1, null, new TreeNode(2));

    // then
    t.is(false, isSameTree(tree1, tree1reversed));
    t.is(false, isSameTree(tree2, tree2reversed));
});

// @ts-ignore
test('isSameTree returns false given almost same trees', t => {
    // given
    const tree1 = new TreeNode(4, new TreeNode(1, new TreeNode(0)), new TreeNode(3));
    const tree2 = new TreeNode(4, new TreeNode(1), new TreeNode(2));

    // then
    t.is(false, isSameTree(tree1, tree2));
});

// @ts-ignore
test('isSameTree returns false given same roots, different distributions', t => {
    // given
    const tree1 = new TreeNode(10, new TreeNode(5), new TreeNode(15));
    const tree2 = new TreeNode(10, new TreeNode(5, null, new TreeNode(15)));

    // then
    t.is(false, isSameTree(tree1, tree2));
});

// @ts-ignore
test('isSubtree returns true given equal trees', t => {
    // given
    const tree1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    const tree2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));

    // then
    t.is(true, isSubtree(tree1, tree2));
});

// @ts-ignore
test('isSubtree returns true given subtree', t => {
    // given
    const tree1 = new TreeNode(3, new TreeNode(4, 1, 2), new TreeNode(5));
    const tree2 = new TreeNode(4, 1, 2);

    // then
    t.is(true, isSubtree(tree1, tree2));
});

// @ts-ignore
test('isSubtree returns false given partial-subtree', t => {
    // given
    const tree1 = new TreeNode(3, new TreeNode(4, 1, new TreeNode(2, null, 0)), new TreeNode(5));
    const tree2 = new TreeNode(4, 1, 2);

    // then
    t.is(false, isSubtree(tree1, tree2));
});
