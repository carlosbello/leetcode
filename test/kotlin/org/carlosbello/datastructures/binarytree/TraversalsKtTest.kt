package org.carlosbello.datastructures.binarytree

import junit.framework.TestCase

class TraversalsKtTest : TestCase() {
    /**
     *  1
     *   \
     *    2
     *   /
     *  3
     */
    private val tree = TreeNode(1, null, TreeNode(2, TreeNode(3)))

    fun testPreorderTraversal() {
        // given
        val expectedTraversal = listOf(1, 2, 3)

        // when
        val traversal = preorderTraversal(tree)

        // then
        assertEquals(expectedTraversal, traversal)
    }

    fun testInorderTraversal() {
        // given
        val expectedTraversal = listOf(1, 3, 2)

        // when
        val traversal = inorderTraversal(tree)

        // then
        assertEquals(expectedTraversal, traversal)
    }

    fun testPostorderTraversal() {
        // given
        val expectedTraversal = listOf(3, 2, 1)

        // when
        val traversal = postorderTraversal(tree)

        // then
        assertEquals(expectedTraversal, traversal)
    }

    fun testLevelOrderTraversalWhenNullTree() {
        // given
        val tree = null
        val expectedTraversal = emptyList<List<Int>>()

        // when
        val traversal = levelOrderTraversal(tree)

        // then
        assertEquals(expectedTraversal, traversal)
    }

    fun testLevelOrderTraversalWhenSomeTree() {
        // given
        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15  7
         */
        val tree = TreeNode(3,
            TreeNode(9),
            TreeNode(20,
                TreeNode(15), TreeNode(7)
            )
        )
        val expectedTraversal = listOf(
            listOf(3),
            listOf(9, 20),
            listOf(15, 7)
        )

        // when
        val traversal = levelOrderTraversal(tree)

        // then
        assertEquals(expectedTraversal, traversal)
    }
}
