package org.carlosbello.datastructures.binarytree

import kotlin.math.max

/**
 * Maximum Depth of Binary Tree https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/
 */
fun maxDepth(root: TreeNode?): Int =
    root?.let {
        max(maxDepth(root.left), maxDepth(root.right)) + 1
    } ?: 0

/**
 * Symmetric Tree https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
 *
 * Recursive solution: A tree is symmetric if list of children values is equal to itself reversed and
 * their children node list is symmetric
 */
fun isSymmetric1(root: TreeNode?): Boolean {
    fun nodeListIsSymmetric(nodeList: List<TreeNode?>): Boolean {
        val listValues = nodeList.map { it?.`val` }
        return listValues.isEmpty() || listValues == listValues.reversed() &&
            nodeListIsSymmetric(
                nodeList.fold(listOf()) { children, node ->
                    children + (node?.let { listOf(node.left, node.right) } ?: listOf())
                }
            )
    }
    return root?.let {
        nodeListIsSymmetric(listOf(root))
    } ?: true
}

/**
 * Symmetric Tree https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
 *
 * The tree is symmetric if every level in the tree is equal the itself reversed
 */
fun isSymmetric2(root: TreeNode?): Boolean =
    levelOrderTraversalIncludingNulls(root).all { level -> level == level.reversed() }

/**
 * Symmetric Tree https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
 *
 * Same as isSymmetric2 but stop processing the tree when a not symmetric level is found
 */
fun isSymmetric2a(root: TreeNode?): Boolean =
    root?.let {
        var toVisit = listOf<TreeNode?>(root)
        var isSymmetric = true
        while (isSymmetric && toVisit.isNotEmpty()) {
            val levelValues = toVisit.map { it?.`val` }
            isSymmetric = levelValues == levelValues.reversed()
            toVisit = if (isSymmetric) toVisit.filterNotNull().fold(listOf(), { nodeList, treeNode ->
                nodeList + listOf(treeNode.left, treeNode.right)
            }) else listOf()
        }
        isSymmetric
    } ?: true

/**
 * Symmetric Tree https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
 *
 * Recursive solution: A tree is symmetric if their children are symmetric and two nodes are symmetric if the
 * left child of the first is symmetric with the right child of the second, and vice-versa
 */
fun isSymmetric3(root: TreeNode?): Boolean {
    fun areSymmetric(root1: TreeNode?, root2: TreeNode?): Boolean =
        root1 == null && root2 == null || root1?.`val` == root2?.`val` &&
                areSymmetric(root1?.left, root2?.right) && areSymmetric(root1?.right, root2?.left)

    return root == null || areSymmetric(root.left, root.right)
}
