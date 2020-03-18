const test = require('ava');
const TreeNode = require('../tree-node');
const { countUnivalSubtrees } = require('../properties');

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
