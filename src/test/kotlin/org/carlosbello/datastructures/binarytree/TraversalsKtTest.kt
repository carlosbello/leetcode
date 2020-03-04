package org.carlosbello.datastructures.binarytree

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class TraversalsKtTest {

    @ParameterizedTest(name = "Test {0} returns {1} when {3}")
    @MethodSource("traversalTestCases")
    fun testTraversal(traversalFn: (TreeNode?) -> List<Int>, expectedTraversal: List<Int>, givenTree: TreeNode?) {
        // when
        val traversal = traversalFn(givenTree)

        // then
        assertEquals(expectedTraversal, traversal)
    }

    @ParameterizedTest(name = "Test {0} returns {1} when {3}")
    @MethodSource("levelOrderTraversalTestCases")
    fun testLevelOrderTraversal(levelOrderTraversalFn: (TreeNode?) -> List<List<Int>>, expectedTraversal:List<List<Int>>, givenTree: TreeNode?) {
        // when
        val traversal = levelOrderTraversalFn(givenTree)

        // then
        assertEquals(expectedTraversal, traversal)
    }

    companion object {
        /**
         *  1
         *   \
         *    2
         *   /
         *  3
         */
        val tree1 = TreeNode(1, null, TreeNode(2, TreeNode(3)))
        val tree1Representation = "[1, null, 2, 3, null]"

        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15  7
         */
        val tree2 = TreeNode(3,
            TreeNode(9),
            TreeNode(20,
                TreeNode(15), TreeNode(7)
            )
        )
        val tree2Representation = "[3, 9, null, null, 20, 15, 17]"


        @JvmStatic
        fun traversalTestCases(): Stream<Arguments> =
            Stream.of(
                Arguments.of(::preorderTraversal, listOf(1, 2, 3), tree1, tree1Representation),
                Arguments.of(::inorderTraversal, listOf(1, 3, 2), tree1, tree1Representation),
                Arguments.of(::postorderTraversal, listOf(3, 2, 1), tree1, tree1Representation)
            )

        @JvmStatic
        fun levelOrderTraversalTestCases(): Stream<Arguments> =
            Stream.of(
                Arguments.of(::levelOrderTraversal, emptyList<List<Int>>(), null, "null"),
                Arguments.of(::levelOrderTraversal, listOf(
                    listOf(3),
                    listOf(9, 20),
                    listOf(15, 7)
                ), tree2, tree2Representation),
                Arguments.of(::levelOrderTraversalIncludingNulls, emptyList<List<Int>>(), null, "null"),
                Arguments.of(::levelOrderTraversalIncludingNulls, listOf(
                    listOf(3),
                    listOf(9, 20),
                    listOf(null, null, 15, 7),
                    listOf(null, null, null, null)
                ), tree2, tree2Representation)
            )
    }
}
