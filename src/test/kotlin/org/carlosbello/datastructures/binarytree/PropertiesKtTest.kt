package org.carlosbello.datastructures.binarytree

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class PropertiesKtTest {
    @Test
    fun maxDepth() {
        // given
        /**
         *    3
         *   / \
         *  9  20
         *    /  \
         *   15   7
         */
        val tree = TreeNode(3,
            TreeNode(9),
            TreeNode(20,
                TreeNode(15), TreeNode(7)
            )
        )
        val expectedMaxDepth = 3

        // when
        val depth = maxDepth(tree)

        // then
        assertEquals(expectedMaxDepth, depth)
    }

    @ParameterizedTest(name = "Test {0} returns {1} when {3}")
    @MethodSource("isSymmetricTestCases")
    fun isSymmetric(
        isSymetricFn: (TreeNode?) -> Boolean,
        expectedIsSymmetric: Boolean,
        givenTree: TreeNode?,
        treeType: String
    ) {
        // when
        val treeIsSymmetric = isSymetricFn(givenTree)

        // then
        assertEquals(expectedIsSymmetric, treeIsSymmetric)
    }

    @ParameterizedTest(name = "Test hasPathSum returns {1} when given sum is {0}")
    @MethodSource("hasPathSumTestCases")
    fun hasPathSum(givenSum: Int, expectedHasPathSum: Boolean) {
        // given
        /**
         *       5
         *      / \
         *     4   8
         *    /   / \
         *   11  13  4
         *  /  \      \
         * 7    2      1
         */
        val tree = TreeNode(5,
            TreeNode(4,
                TreeNode(11,
                    TreeNode(7), TreeNode(2))
            ),
            TreeNode(8,
                TreeNode(13),
                TreeNode(4, null, TreeNode(1))
            )
        )

        // when
        val hasPathSum = hasPathSum(tree, givenSum)

        // then
        assertEquals(expectedHasPathSum, hasPathSum)
    }

    companion object {
        /**
         *     1
         *    / \
         *   2   2
         *  / \ / \
         * 3  4 4  3
         */
        val symmetricTree = TreeNode(1,
            TreeNode(2,
                TreeNode(3), TreeNode(4)
            ),
            TreeNode(2,
                TreeNode(4), TreeNode(3)
            )
        )

        /**
         *     1
         *    / \
         *   2   2
         *    \   \
         *    3    3
         */
        val notSymmetricTree = TreeNode(1,
            TreeNode(2,
                null, TreeNode(3)
            ),
            TreeNode(2,
                null, TreeNode(3)
            )
        )

        @JvmStatic
        fun isSymmetricTestCases(): Stream<Arguments> =
            Stream.of(
                Arguments.of(::isSymmetric1, true, null, "null"),
                Arguments.of(::isSymmetric1, true, symmetricTree, "symmetric"),
                Arguments.of(::isSymmetric1, false, notSymmetricTree, "not symmetric"),
                Arguments.of(::isSymmetric2, true, null, "null"),
                Arguments.of(::isSymmetric2, true, symmetricTree, "symmetric"),
                Arguments.of(::isSymmetric2, false, notSymmetricTree, "not symmetric"),
                Arguments.of(::isSymmetric2a, true, null, "null"),
                Arguments.of(::isSymmetric2a, true, symmetricTree, "symmetric"),
                Arguments.of(::isSymmetric2a, false, notSymmetricTree, "not symmetric"),
                Arguments.of(::isSymmetric3, true, null, "null"),
                Arguments.of(::isSymmetric3, true, symmetricTree, "symmetric"),
                Arguments.of(::isSymmetric3, false, notSymmetricTree, "not symmetric")
            )

        @JvmStatic
        fun hasPathSumTestCases(): Stream<Arguments> =
            Stream.of(
                Arguments.of(Int.MIN_VALUE, false),
                Arguments.of(22, true),
                Arguments.of(18, true),
                Arguments.of(Int.MAX_VALUE, false)
            )
    }
}