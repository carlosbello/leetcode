package org.carlosbello.datastructures.binarytree

/**
 * Binary Tree Preorder Traversal https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
 */
fun preorderTraversal(root: TreeNode?): List<Int> =
    root?.let {
        listOf(root.`val`) + preorderTraversal(root.left) + preorderTraversal(root.right)
    } ?: listOf()

/**
 * Binary Tree Inorder Traversal https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/929/
 */
fun inorderTraversal(root: TreeNode?): List<Int> =
    root?.let {
        inorderTraversal(root.left) + listOf(root.`val`) + inorderTraversal(root.right)
    } ?: listOf()

/**
 * Binary Tree Postorder Traversal https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/
 */
fun postorderTraversal(root: TreeNode?): List<Int> =
    root?.let {
        postorderTraversal(root.left) + postorderTraversal(root.right) + listOf(root.`val`)
    } ?: listOf()

/**
 * Binary Tree Level Order Traversal https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/
 */
fun levelOrderTraversal(root: TreeNode?): List<List<Int>> =
    root?.let {
        var toVisit = listOf(root)
        val result = MutableList<List<Int>>(0) { listOf() }
        while (toVisit.isNotEmpty()) {
            result.add(toVisit.map { it.`val` })
            toVisit = toVisit.fold(listOf(), { nodeList, treeNode ->
                nodeList + listOfNotNull(treeNode.left, treeNode.right)
            })
        }
        result
    } ?: emptyList()

/**
 * Return the list of value by level, including nulls in not available values.
 *
 * For example, given the tree:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15  7
 *  levelOrderTraversal(tree) = [[3], [9, 20], [15, 7]]
 *  but
 *  levelOrderTraversalIncludingNulls(tree) = [[3], [9, 20], [null, null, 15, 7], [null, null, null, null]]
 */
fun levelOrderTraversalIncludingNulls(root: TreeNode?): List<List<Int?>> =
    root?.let {
        var toVisit = listOf<TreeNode?>(root)
        val result = MutableList<List<Int?>>(0) { listOf() }
        while (toVisit.isNotEmpty()) {
            result.add(toVisit.map { it?.`val` })
            toVisit = toVisit.filterNotNull().fold(listOf(), { nodeList, treeNode ->
                nodeList + listOf(treeNode.left, treeNode.right)
            })
        }
        result
    } ?: emptyList<List<Int?>>()
