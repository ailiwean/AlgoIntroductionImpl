package com.ailiwean.algointroductionimpl

/**
 * @Package:        com.ailiwean.algointroductionimpl
 * @ClassName:      SortsGather
 * @Description:
 * @Author:         SWY(https://github.com/ailiwean)
 * @CreateDate:     2020/10/29 11:21 AM
 */
fun innerSort(vararg values: Int): IntArray {
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

fun main() {
    innerSort(2, 4, 5, 2, 4, 1, 3, 4, 5, 5, 4, 3, 2)
        .forEach {
            print(it)
        }
}


