const test = require('ava');
const { preorderTraversal, inorderTraversal } = require('../traversals');
const { TreeNode } = require('../tree-node');

/**
 *  1
 *   \
 *    2
 *   /
 *  3
 */
const tree1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3)));
const tree1Representation = '[3, 9, null, null, 20, 15, 17]';

const traversalTest = (t, traversalFn, givenTree, expectedTraversal) => {
    // when
    const traversal = traversalFn(givenTree);

    // then
    t.deepEqual(expectedTraversal, traversal);
};
traversalTest.title = (t, traversalFn, givenTree, expectedTraversal, givenTreeRepresentation) =>
    `Test ${traversalFn.name} returns [${expectedTraversal}] given tree ${givenTreeRepresentation}`;

test(traversalTest, preorderTraversal, tree1, [1, 2, 3], tree1Representation);
test(traversalTest, inorderTraversal, tree1, [1, 3, 2], tree1Representation);
