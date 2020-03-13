const test = require('ava');
const { preorderTraversal } = require('../traversals');
const { TreeNode } = require('../tree-node');

/**
 *  1
 *   \
 *    2
 *   /
 *  3
 */
const tree1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3)));

const preorderTraversalTest = (t, givenTree, expectedTraversal) => {
    // when
    const traversal = preorderTraversal(givenTree);

    // then
    t.deepEqual(expectedTraversal, traversal);
};
preorderTraversalTest.title = (t, givenTree, expectedTraversal, givenTreeRepresentation) =>
    `Test preorderTraversal returns [${expectedTraversal}] given tree ${givenTreeRepresentation}`;

test(preorderTraversalTest, tree1, [1, 2, 3], '[3, 9, null, null, 20, 15, 17]');
