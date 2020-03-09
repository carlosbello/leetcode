package org.carlosbello.datastructures.binarytree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class OperationsKtTest {

    @ParameterizedTest(name = "buildFromPreorderAndPostOrder given {0} and {1}")
    @MethodSource("buildFromInorderAndPostorderTestCases")
    fun buildFromInorderAndPostOrder(inorder: IntArray, postorder: IntArray, expectedTree: TreeNode?) {
        // when
        val tree = buildFromInorderAndPostorder(inorder, postorder)

        // then
        assertEquals(expectedTree, tree)
    }

    @ParameterizedTest(name = "buildFromPreorderAndInorder given {0} and {1}")
    @MethodSource("buildFromPreorderAndInorderTestCases")
    fun buildFromPreorderAndInorder(preorder: IntArray, inorder: IntArray, expectedTree: TreeNode?) {
        // when
        val tree = buildFromPreorderAndInorder(preorder, inorder)

        // then
        assertEquals(expectedTree, tree)
    }

    companion object {
        /**
         * 3
         */
        val expectedSingleNodeTree = TreeNode(3)
        val preorderSingleNodeTree = listOf(3).toIntArray()
        val inorderSingleNodeTree = listOf(3).toIntArray()
        val postorderSingleNodeTree = listOf(3).toIntArray()

        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */
        val expectedTree1 = TreeNode(3,
            TreeNode(9),
            TreeNode(20, TreeNode(15), TreeNode(7))
        )
        val preorderTree1 = listOf(3, 9, 20, 15, 7).toIntArray()
        val inorderTree1 = listOf(9, 3, 15, 20, 7).toIntArray()
        val postorderTree1 = listOf(9, 15, 7, 20, 3).toIntArray()

        /**
         *      3
         *     / \
         *   20  9
         *  /  \
         * 15   7
         */
        val expectedTree2 = TreeNode(3,
            TreeNode(20, TreeNode(15), TreeNode(7)),
            TreeNode(9)
            )
        val preorderTree2 = listOf(3, 20, 15, 7, 9).toIntArray()
        val inorderTree2 = listOf(15, 20, 7, 3, 9).toIntArray()
        val postorderTree2 = listOf(15, 7, 20, 9, 3).toIntArray()

        @JvmStatic
        fun buildFromInorderAndPostorderTestCases(): Stream<Arguments> =
            Stream.of(
                Arguments.of(IntArray(0), IntArray(0), null),
                Arguments.of(inorderSingleNodeTree, postorderSingleNodeTree, expectedSingleNodeTree),
                Arguments.of(inorderTree1, postorderTree1, expectedTree1),
                Arguments.of(inorderTree2, postorderTree2, expectedTree2)
            )

        @JvmStatic
        fun buildFromPreorderAndInorderTestCases(): Stream<Arguments> =
            Stream.of(
                Arguments.of(IntArray(0), IntArray(0), null),
                Arguments.of(preorderSingleNodeTree, inorderSingleNodeTree, expectedSingleNodeTree),
                Arguments.of(preorderTree1, inorderTree1, expectedTree1),
                Arguments.of(preorderTree2, inorderTree2, expectedTree2)
            )
    }
}