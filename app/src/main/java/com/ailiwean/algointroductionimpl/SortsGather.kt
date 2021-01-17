package com.ailiwean.algointroductionimpl

/**
 * @Package:        com.ailiwean.algointroductionimpl
 * @ClassName:      SortsGather
 * @Description:
 * @Author:         SWY(https://github.com/ailiwean)
 * @CreateDate:     2020/10/29 11:21 AM
 */

/***
 * 插入排序
 */
fun innerSort(values: IntArray): IntArray {
    if (values.size < 2)
        return values
    for (i in 1 until values.size) {
        val cur = values[i]
        var curInd = i
        while (curInd > 0 && values[curInd - 1] > cur) {
            values[curInd] = values[curInd - 1]
            curInd--
        }
        values[curInd] = cur
    }
    return values
}


/***
 * 快速排序
 */
fun quickSort(values: IntArray): IntArray {
    return quickSort(values, 0, values.size - 1)
}

fun quickSort(values: IntArray, left: Int, right: Int): IntArray {
    if (values.size < 2)
        return values
    if (left >= right)
        return values
    val pivot = values[left]
    //左边为中轴，从右边开始读数
    var leftIndex = left
    var rightIndex = right
    while (true) {
        //从右边寻找小于pivot的
        while (leftIndex != rightIndex && values[rightIndex] > pivot)
            rightIndex--
        if (leftIndex == rightIndex)
            break
        //右边找到则放在左边
        values[leftIndex] = values[rightIndex]
        leftIndex++
        //从左边寻找大于pivot的放在右边
        while (leftIndex != rightIndex && values[leftIndex] < pivot)
            leftIndex++
        if (leftIndex == rightIndex)
            break
        //左边找到则放在右边
        values[rightIndex] = values[leftIndex]
        rightIndex--
    }
    //leftIndex与rightIndex重叠的下标为中轴的位置
    values[leftIndex] = pivot
    //递归再次排序中轴左右两边
    quickSort(values, left, leftIndex - 1)
    quickSort(values, rightIndex + 1, right)
    return values
}

fun IntArray.toPrint(desc: String) {
    println(desc)
    forEach {
        print(" $it , ")
    }
}

fun main() {
    val array = IntArray(100000)
    array.forEachIndexed { index, _ ->
        array[index] = (Math.random() * 100000).toInt()
    }
    val array2 = array.clone()
    var starTime = System.currentTimeMillis()
    innerSort(array)
    println("插入排序耗时${System.currentTimeMillis() - starTime}")
    starTime = System.currentTimeMillis()
    quickSort(array2)
    println("快速排序耗时${System.currentTimeMillis() - starTime}")
}


