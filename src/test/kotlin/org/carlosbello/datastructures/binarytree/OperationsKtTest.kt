package org.carlosbello.datastructures.binarytree

import org.carlosbello.mapFunctionToTestCases
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

typealias TreeBuilderFunction = (IntArray, IntArray) -> TreeNode?

internal class OperationsKtTest {

    @ParameterizedTest(name = "Test {0} given {1} and {2}")
    @MethodSource("buildFromInorderAndPostorderTestCases")
    fun buildFromInorderAndPostOrder(buildFromInorderAndPostOrderFn: TreeBuilderFunction, inorder: IntArray, postorder: IntArray, expectedTree: TreeNode?) {
        // when
        val tree = buildFromInorderAndPostOrderFn(inorder, postorder)

        // then
        assertEquals(expectedTree, tree)
    }

    @ParameterizedTest(name = "Test {0} given {1} and {2}")
    @MethodSource("buildFromPreorderAndInorderTestCases")
    fun buildFromPreorderAndInorder(buildFromPreorderAndInorderFn: TreeBuilderFunction, preorder: IntArray, inorder: IntArray, expectedTree: TreeNode?) {
        // when
        val tree = buildFromPreorderAndInorderFn(preorder, inorder)

        // then
        assertEquals(expectedTree, tree)
    }

    companion object {
        /**
         * 3
         */
        private val expectedSingleNodeTree = TreeNode(3)
        private val preorderSingleNodeTree = listOf(3).toIntArray()
        private val inorderSingleNodeTree = listOf(3).toIntArray()
        private val postorderSingleNodeTree = listOf(3).toIntArray()

        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */
        private val expectedTree1 = TreeNode(3,
            TreeNode(9),
            TreeNode(20, TreeNode(15), TreeNode(7))
        )
        private val preorderTree1 = listOf(3, 9, 20, 15, 7).toIntArray()
        private val inorderTree1 = listOf(9, 3, 15, 20, 7).toIntArray()
        private val postorderTree1 = listOf(9, 15, 7, 20, 3).toIntArray()

        /**
         *      3
         *     / \
         *   20  9
         *  /  \
         * 15   7
         */
        private val expectedTree2 = TreeNode(3,
            TreeNode(20, TreeNode(15), TreeNode(7)),
            TreeNode(9)
        )
        private val preorderTree2 = listOf(3, 20, 15, 7, 9).toIntArray()
        private val inorderTree2 = listOf(15, 20, 7, 3, 9).toIntArray()
        private val postorderTree2 = listOf(15, 7, 20, 9, 3).toIntArray()

        @JvmStatic
        fun buildFromInorderAndPostorderTestCases(): Stream<Arguments> =
            mapFunctionToTestCases(
                listOf(::buildFromInorderAndPostorder1, ::buildFromInorderAndPostorder2, ::buildFromInorderAndPostorder3),
                listOf(
                    arrayOf(IntArray(0), IntArray(0), null),
                    arrayOf(inorderSingleNodeTree, postorderSingleNodeTree, expectedSingleNodeTree),
                    arrayOf(inorderTree1, postorderTree1, expectedTree1),
                    arrayOf(inorderTree2, postorderTree2, expectedTree2)
                ))

        @JvmStatic
        fun buildFromPreorderAndInorderTestCases(): Stream<Arguments> =
            mapFunctionToTestCases(
                listOf(::buildFromPreorderAndInorder1, ::buildFromPreorderAndInorder2, ::buildFromPreorderAndInorder3),
                listOf(
                    arrayOf(IntArray(0), IntArray(0), null),
                    arrayOf(preorderSingleNodeTree, inorderSingleNodeTree, expectedSingleNodeTree),
                    arrayOf(preorderTree1, inorderTree1, expectedTree1),
                    arrayOf(preorderTree2, inorderTree2, expectedTree2)
                ))
    }
}