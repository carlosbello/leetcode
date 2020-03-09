package org.carlosbello.datastructures.binarytree

/**
 * Construct Binary Tree from Inorder and Postorder Traversal https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Note: The problem statement says we can assume that duplicates do not exist in the tree.
 *
 * @see buildFromInorderAndPostorder2 For a first optimization eliminating a repeated task
 * @see buildFromInorderAndPostorder3 For a second optimization avoiding the creation of copies of subtrees traversals
 */
fun buildFromInorderAndPostorder1(inorder: IntArray, postorder: IntArray) : TreeNode? =
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
            buildFromInorderAndPostorder1(leftInorderSubtree, leftPostorderSubtree),
            buildFromInorderAndPostorder1(rightInorderSubtree, rightPostorderSubtree)
        )
    }

/**
 * Same as {@link buildFromInorderAndPostorder1} but pre-calculating the indexes of each node value
 */
fun buildFromInorderAndPostorder2(inorder: IntArray, postorder: IntArray) : TreeNode? {
    val inorderValueIndexMap = inorder.withIndex().associate { it.value to it.index }

    fun buildFromInorderAndPostorder(inorder: IntArray, postorder: IntArray) : TreeNode? =
        if (inorder.isEmpty())
            null
        else {
            val rootValue = postorder.last()
            val indexOfRootValue = inorderValueIndexMap.getOrDefault(rootValue, -1) - inorderValueIndexMap.getOrDefault(inorder.first(), -1)
            val leftInorderSubtree = inorder.slice((0 until indexOfRootValue)).toIntArray()
            val rightInorderSubtree = inorder.slice(indexOfRootValue+1..inorder.lastIndex).toIntArray()
            val leftPostorderSubtree = postorder.slice(0..leftInorderSubtree.lastIndex).toIntArray()
            val rightPostorderSubtree = postorder.slice(leftPostorderSubtree.size until postorder.lastIndex).toIntArray()
            TreeNode(rootValue,
                buildFromInorderAndPostorder(leftInorderSubtree, leftPostorderSubtree),
                buildFromInorderAndPostorder(rightInorderSubtree, rightPostorderSubtree)
            )
        }

    return buildFromInorderAndPostorder(inorder, postorder)
}

/**
 * Same as {@link buildFromInorderAndPostorder2} but avoiding slicing arrays to obtain the subtrees
 */
fun buildFromInorderAndPostorder3(inorder: IntArray, postorder: IntArray) : TreeNode? {
    val inorderValueIndexMap = inorder.withIndex().associate { it.value to it.index }
    fun sizeOf(subtreeRange: Pair<Int, Int>): Int = subtreeRange.second - subtreeRange.first

    fun buildFromInorderAndPostorder(inorderSubtree: Pair<Int, Int>, postorderSubtree: Pair<Int, Int>) : TreeNode? =
        if (inorderSubtree.first > inorderSubtree.second)
            null
        else {
            val rootValue = postorder[postorderSubtree.second]
            val indexOfRootValue = inorderValueIndexMap.getOrDefault(rootValue, -1)
            val leftInorderSubtree = Pair(inorderSubtree.first, indexOfRootValue - 1)
            val rightInorderSubtree = Pair(indexOfRootValue + 1, inorderSubtree.second)
            val leftPostorderSubtree = Pair(postorderSubtree.first, postorderSubtree.first + sizeOf(leftInorderSubtree))
            val rightPostorderSubtree = Pair(leftPostorderSubtree.second + 1, postorderSubtree.second - 1)
            TreeNode(rootValue,
                buildFromInorderAndPostorder(leftInorderSubtree, leftPostorderSubtree),
                buildFromInorderAndPostorder(rightInorderSubtree, rightPostorderSubtree)
            )
        }

    return buildFromInorderAndPostorder(Pair(0, inorder.lastIndex), Pair(0, postorder.lastIndex))
}

/**
 * Construct Binary Tree from Preorder and Inorder Traversal https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Note: The problem statement says we can assume that duplicates do not exist in the tree.
 *
 * @see buildFromPreorderAndInorder2 For a first optimization eliminating a repeated task
 * @see buildFromPreorderAndInorder3 For a second optimization avoiding the creation of copies of subtrees traversals
 */
fun buildFromPreorderAndInorder1(preorder: IntArray, inorder: IntArray): TreeNode? =
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
            buildFromPreorderAndInorder1(leftPreorderSubtree, leftInorderSubtree),
            buildFromPreorderAndInorder1(rightPreorderSubtree, rightInorderSubtree)
        )
    }

/**
 * Same as {@link buildFromPreorderAndInorder} but pre-calculating the indexes of each node value
 */
fun buildFromPreorderAndInorder2(preorder: IntArray, inorder: IntArray): TreeNode? {
    val inorderValueIndexMap = inorder.withIndex().associate { it.value to it.index }

    fun buildFromPreorderAndInorder(preorder: IntArray, inorder: IntArray): TreeNode? =
        if (inorder.isEmpty())
            null
        else {
            val rootValue = preorder.first()
            val indexOfRootValue = inorderValueIndexMap.getOrDefault(rootValue, -1) - inorderValueIndexMap.getOrDefault(inorder.first(), -1)
            val leftInorderSubtree = inorder.slice((0 until indexOfRootValue)).toIntArray()
            val rightInorderSubtree = inorder.slice(indexOfRootValue+1..inorder.lastIndex).toIntArray()
            val leftPreorderSubtree = preorder.slice(1..leftInorderSubtree.size).toIntArray()
            val rightPreorderSubtree = preorder.slice(leftPreorderSubtree.size+1..preorder.lastIndex).toIntArray()
            TreeNode(rootValue,
                buildFromPreorderAndInorder(leftPreorderSubtree, leftInorderSubtree),
                buildFromPreorderAndInorder(rightPreorderSubtree, rightInorderSubtree)
            )
        }

    return buildFromPreorderAndInorder(preorder, inorder)
}

/**
 * Same as {@link buildFromPreorderAndInorder2} but avoiding slicing arrays to obtain the subtrees
 */
fun buildFromPreorderAndInorder3(preorder: IntArray, inorder: IntArray) : TreeNode? {
    val inorderValueIndexMap = inorder.withIndex().associate { it.value to it.index }
    fun sizeOf(subtreeRange: Pair<Int, Int>): Int = subtreeRange.second - subtreeRange.first

    fun buildFromPreorderAndInorder(preorderSubtree: Pair<Int, Int>, inorderSubtree: Pair<Int, Int>) : TreeNode? =
        if (inorderSubtree.first > inorderSubtree.second)
            null
        else {
            val rootValue = preorder[preorderSubtree.first]
            val indexOfRootValue = inorderValueIndexMap.getOrDefault(rootValue, -1)
            val leftInorderSubtree = Pair(inorderSubtree.first, indexOfRootValue - 1)
            val rightInorderSubtree = Pair(indexOfRootValue + 1, inorderSubtree.second)
            val leftPreorderSubtree = Pair(preorderSubtree.first + 1, preorderSubtree.first + 1 + sizeOf(leftInorderSubtree))
            val rightPreorderSubtree = Pair(leftPreorderSubtree.second + 1, preorderSubtree.second)
            TreeNode(rootValue,
                buildFromPreorderAndInorder(leftPreorderSubtree, leftInorderSubtree),
                buildFromPreorderAndInorder(rightPreorderSubtree, rightInorderSubtree)
            )
        }

    return buildFromPreorderAndInorder(Pair(0, preorder.lastIndex), Pair(0, inorder.lastIndex))
}
