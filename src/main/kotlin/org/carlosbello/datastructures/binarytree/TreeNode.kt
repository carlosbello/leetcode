package org.carlosbello.datastructures.binarytree

/**
 * Adapted to the definition from Leecode.com exercise examples
 *
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 */
data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)
