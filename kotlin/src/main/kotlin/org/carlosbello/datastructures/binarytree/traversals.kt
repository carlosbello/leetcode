package org.carlosbello.datastructures.binarytree

/**
 * 144. Binary Tree Preorder Traversal [medium] https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
fun preorderTraversal(root: TreeNode?): List<Int> =
    root?.let {
        listOf(root.`val`) + preorderTraversal(root.left) + preorderTraversal(root.right)
    } ?: listOf()

/**
 * 94. Binary Tree Inorder Traversal [medium] https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
fun inorderTraversal(root: TreeNode?): List<Int> =
    root?.let {
        inorderTraversal(root.left) + listOf(root.`val`) + inorderTraversal(root.right)
    } ?: listOf()

/**
 * 145. Binary Tree Postorder Traversal [hard] https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
fun postorderTraversal(root: TreeNode?): List<Int> =
    root?.let {
        postorderTraversal(root.left) + postorderTraversal(root.right) + listOf(root.`val`)
    } ?: listOf()

/**
 * 102. Binary Tree Level Order Traversal [medium] https://leetcode.com/problems/binary-tree-level-order-traversal/
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
