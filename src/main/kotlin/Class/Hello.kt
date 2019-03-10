package Class

data class Disc(var num: Double, var str: String) {
    fun addition(another: Disc): Double = num + another.num

    fun subtraction(another: Disc): Double = num - another.num

    fun multiplication(another: Disc): Double = num * another.num

    fun division(another: Disc): Double = num / another.num

    fun divisionWithDisc(another: Disc): Double = num / another.num

    fun comparison(another: Disc): Boolean = num == another.num


}


fun mainOperations(recieve: String): Any {
    val one = Disc(0.0, "")
    if (recieve.matches(Regex("""\s*\d+[.]?\d*\s+[а-яА-ЯёЁ]+(\s+[-+*~=]\s+\d+[.]?\d*\s+[а-яА-ЯёЁ]+)+\s*"""))) {
        Regex("""\s+""").replace(recieve, " ").trim()
        val parsLine = recieve.split(" ").toMutableList()
        if ("" in parsLine) parsLine.remove("")
        one.num = parsLine[0].toDouble()
        one.str = parsLine[1]
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
        if (razm.size != tip.size) {
            throw IllegalArgumentException("Размерности не соответствуют друг другу")
        }
        if (razm[0] !in listOfDistance && razm[0] !in listOfTime && razm[0] !in listOfWeight) {
            throw IllegalArgumentException("Не указана размерность")
        }
        var numRez = 0.0
        when (parsLine[2]) {
            "+" -> one.num = one.num.plus(parsLine[3].toDouble() + parsLine[6].toDouble() + parsLine[9].toDouble())
            "-" -> one.num = one.num.minus(parsLine[3].toDouble())
            "*" -> one.num = one.num.times(parsLine[3].toDouble() )
            "~" -> one.num = one.num.div(parsLine[3].toDouble())
            "=" -> return one.num == parsLine[3].toDouble()
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

