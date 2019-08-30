package com.hope.smarthome.utils

/**
 * @ClassName: ChinNumDemo
 * @Description: 作用描述
 * @Author: CHIA
 * @CreateDate: 2019/8/19 15:03
 */
class ChinNumDemo {

    private val chnNumChar = arrayOf("零", "一", "二", "三", "四", "五", "六", "七", "八", "九")
    private val chnUnitSection = arrayOf("", "万", "亿", "万亿")//节权位
    private val chnUnitChar = arrayOf("", "十", "百", "千")//节内数字权位

    private val chnValuePair = arrayOf(
        Unit("十", 10, false),
        Unit("百", 100, false),
        Unit("千", 1000, false),
        Unit("万", 10000, true),
        Unit("亿", 100000000, true)
    )

    fun numberToChinese(num: Long): String {
        var num = num
        if (num == 0L) {
            return chnNumChar[0]
        }
        val sb = StringBuilder()
        var unitPos = 0//节的位置
        var needZero = false
        while (num > 0) { //重复这一步，直到num等于零为止
            //首先要对阿拉伯数字分节，并确定节权位名称
            // num 对 10000 取模可得到一个section ，
            val section = (num % 10000).toInt()
            // 将这个 section 转成中文数字，然后根据节的位置补上节权位，即可完成一个节的中文数字转换
            val sectionStr = sectionToChinese(section)
            if (needZero) {
                sb.insert(0, chnNumChar[0])
            }
            if ("" != sectionStr) {
                sb.insert(0, sectionStr + chnUnitSection[unitPos])
            }
            num /= 10000
            unitPos++//移位
            //如果这个section小于1000， 则下个section前要补零
            needZero = section in 1..999
        }
        return sb.toString()
    }

    private fun sectionToChinese(section: Int): String {
        var section = section
        val sb = StringBuilder()
        var unitPos = 0
        var needZero = false//是否需要补零，默认false，因为末尾0不需要补零
        while (section > 0) {
            val c = section % 10
            needZero = when (c) {
                0 -> {//该位数字为零
                    if (needZero) {
                        sb.insert(0, chnNumChar[c])
                    }
                    false//不需要冲重复补零
                }
                else -> {
                    sb.insert(0, chnNumChar[c] + chnUnitChar[unitPos])
                    true
                }
            }
            unitPos++//移位
            section /= 10
        }
        return sb.toString()
    }

    fun chineseToNumber(ch: String): Long {
        var result: Long = 0
        val chars = ch.toCharArray()
        var number = 0
        var sectionVal: Long = 0//临时保存每个节权位出现之前的小节的值
        for (i in chars.indices) {
            val c = chars[i] + ""
            if (chnNumChar[0] == c) {
                continue
            }
            val num = chineseToValue(c)
            if (num > 0) { //是数值
                number = num
                if (i == chars.size - 1) {//已经是最后一个字符了
                    sectionVal += number.toLong()
                    result += sectionVal
                }
            } else { //是单位
                val unit = chineseToUnit(c) ?: continue
                if (unit.secUnit) {//是节权位说明一个节已经结束
                    result += (sectionVal + number) * unit.value
                    sectionVal = 0
                } else {
                    sectionVal += (number * unit.value).toLong()
                }
                number = 0
                if (i == chars.size - 1) {//已经是最后一个字符了
                    result += sectionVal
                }
            }
        }
        return result
    }

    private fun chineseToValue(c: String): Int {
        for (i in chnNumChar.indices) {
            if (c == chnNumChar[i]) {
                return i
            }
        }
        return -1
    }

    private fun chineseToUnit(c: String): Unit? {
        for (unit in chnValuePair) {
            if (unit.name == c) {
                return unit
            }
        }
        return null
    }

    internal class Unit(
        var name: String,
        var value: Int, //10的倍数值
        var secUnit: Boolean//是否是节权位
    )

}
