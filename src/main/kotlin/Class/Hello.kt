package Class

data class Disc(var num: Double, var str: String) {

    operator fun plus(other: Disc) = this.num + other.num
    operator fun minus(other: Disc) = this.num - other.num
    operator fun times(other: Disc) = this.num * other.num
    operator fun div(other: Disc) = this.num / other.num

    fun equalsParam(other: Disc, recieve: String): Boolean {
        if (recieve.matches(Regex("""\s*\d+[.]?\d*\s+[а-яА-ЯёЁ]+(\s+[-+*~=]\s+\d+[.]?\d*\s+[а-яА-ЯёЁ]+)+\s*"""))) {
            Regex("""\s+""").replace(recieve, " ").trim()
            val parsLine = recieve.split(" ").toMutableList()
            if ("" in parsLine) parsLine.remove("")
            val razm = mutableListOf<String>()
            val tip = mutableListOf("1")
            for (i in 1 until parsLine.size step 3)
                razm.add(parsLine[i])
            for (i in 1 until razm.size)
                if (razm[i] == razm[i - 1])
                    tip.add("1")
            val listOfWeight = listOf("г", "кг", "ц", "т")
            val listOfDistance = listOf("мм", "см", "дм", "м", "км")
            val listOfTime = listOf("с", "мин", "ч", "день", "мес", "год")
            if (razm.size != tip.size)
                return false
            if (razm[0] !in listOfDistance && razm[0] !in listOfTime && razm[0] !in listOfWeight)
                return false
        }
        return true
    }
}
fun mainOperations(recieve: String): Any {
    val one = Disc(0.0, "")
    var other = Disc(0.0, "")
    if (recieve.matches(Regex("""\s*\d+[.]?\d*\s+[а-яА-ЯёЁ]+(\s+[-+*~=]\s+\d+[.]?\d*\s+[а-яА-ЯёЁ]+)+\s*"""))) {
        Regex("""\s+""").replace(recieve, " ").trim()
        val parsLine = recieve.split(" ").toMutableList()
        if ("" in parsLine) parsLine.remove("")
        one.num = parsLine[0].toDouble()
        one.str = parsLine[1]
        var numRez = 0.0
        for (i in 4 until parsLine.size step 3) {
            other.num = parsLine[i - 1].toDouble()
            other.str = parsLine[i]
            if (one.equalsParam(other, " 5 г + 5 г + 5 г + 5 г"))

            when (parsLine[2]) {
                "+" -> one.num = one.num.plus(parsLine[3].toDouble())
                "-" -> one.num = one.num.minus(parsLine[3].toDouble())
                "*" -> one.num = one.num.times(parsLine[3].toDouble())
                "~" -> one.num = one.num.div(parsLine[3].toDouble())
                "=" -> return one.num == parsLine[3].toDouble()
            }
        }
        /*    if (condition == "+" && one.str == another.str)
            numRez = one.addition(another)
        if (condition == "-" && one.str == another.str)
            numRez = one.subtraction(another)
        if (condition == "/")
            numRez = one.division(another)
        if (condition == "*")
            numRez = one.multiplication(another)
        if (condition == "~" && one.str == another.str)
            numRez = one.divisionWithDisc(another)
        if (condition == "=" && one.str == another.str) {
            bool = one.comparison(another)
            return bool
        }
        */
        /*val subRez: String
        if ('.' in numRez) {
            subRez = numRez.substring(0, numRez.indexOf('.', 0) + 4)
            return "$subRez ${one.str}"
        }*/
        numRez = ((one.num * 1000).toInt().toDouble() / 1000)
        return "$numRez ${one.str}"
    } else throw IllegalArgumentException("Неверный формат ввода")
}



fun main(args: Array<String>) {
    println("Hello, World")
}

