package org.carlosbello.datastructures.binarytree

/**
 * Construct Binary Tree from Inorder and Postorder Traversal https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Note: The problem statement says we can assume that duplicates do not exist in the tree.
 */
fun buildFromInorderAndPostorder(inorder: IntArray, postorder: IntArray) : TreeNode? =
    if (inorder.isEmpty())
        null
    else {
        val rootValue = postorder.last()
        val indexOfRootValue = inorder.indexOf(rootValue)
        val leftInorderSubtree = inorder.slice((0 until indexOfRootValue)).toIntArray()
        val rightInorderSubtree = inorder.slice(indexOfRootValue+1..inorder.lastIndex).toIntArray()
        val leftPostorderSubtree = postorder.slice(0..leftInorderSubtree.lastIndex).toIntArray()
        val rightPostorderSubtree = postorder.slice(leftPostorderSubtree.size until postorder.lastIndex).toIntArray()
        TreeNode(rootValue,
            buildFromInorderAndPostorder(leftInorderSubtree, leftPostorderSubtree),
            buildFromInorderAndPostorder(rightInorderSubtree, rightPostorderSubtree)
        )
    }

/**
 * Construct Binary Tree from Preorder and Inorder Traversal https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Note: The problem statement says we can assume that duplicates do not exist in the tree.
 */
fun buildFromPreorderAndInorder(preorder: IntArray, inorder: IntArray): TreeNode? =
    if (inorder.isEmpty())
        null
    else {
        val rootValue = preorder.first()
        val indexOfRootValue = inorder.indexOf(rootValue)
        val leftInorderSubtree = inorder.slice((0 until indexOfRootValue)).toIntArray()
        val rightInorderSubtree = inorder.slice(indexOfRootValue+1..inorder.lastIndex).toIntArray()
        val leftPreorderSubtree = preorder.slice(1..leftInorderSubtree.size).toIntArray()
        val rightPreorderSubtree = preorder.slice(leftPreorderSubtree.size+1..preorder.lastIndex).toIntArray()
        TreeNode(rootValue,
            buildFromPreorderAndInorder(leftPreorderSubtree, leftInorderSubtree),
            buildFromPreorderAndInorder(rightPreorderSubtree, rightInorderSubtree)
        )
    }
