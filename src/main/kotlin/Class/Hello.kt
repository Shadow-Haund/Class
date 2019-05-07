package Class

val allowedRazm = listOf("г", "кг", "ц", "т", "мм", "см", "дм", "м", "км", "с", "мин", "ч", "день", "мес", "год")

fun Disc(str: String): Disc {
    val list = str.split(" ")
    if (list.size != 2) throw IllegalArgumentException()
    val num = list.first()
    val razm = list.last()
    if (razm !in allowedRazm) throw IllegalArgumentException()
    else return Disc(num.toDouble(), razm)
}

class Disc(val num: Double, val str: String) {

    operator fun plus(other: Disc): Disc {
        if (!checkDisc() || str != other.str) throw IllegalArgumentException()
        else return Disc(num + other.num, str)
    }

    operator fun minus(other: Disc): Disc {
        if (!checkDisc() || str != other.str) throw IllegalArgumentException()
        else return Disc(num - other.num, str)
    }

    operator fun times(other: Disc): Disc {
        if (!checkDisc() || str != other.str) throw IllegalArgumentException()
        else return Disc(num * other.num, str)
    }

    operator fun times(other: Double): Disc = Disc(num * other, str)

    operator fun div(other: Disc): Disc {
        if (!checkDisc() || str != other.str) throw IllegalArgumentException()
        else return Disc(num / other.num, str)
    }

    operator fun div(other: Double): Disc = Disc(num / other, str)

    fun checkDisc(): Boolean {
        return str in allowedRazm
    }

    override fun equals(other: Any?): Boolean {
        return if (other !is Disc) false
        else num == other.num && str == other.str
    }

    override fun toString(): String = "$num $str"
}

fun mainOperations(recieve: String) {
    val d1 = Disc("12 кг")
    val d2 = Disc("15 кг")
    println(d1 + d2)
    return
    /*val one = Disc(0.0, "")
    var other = Disc(0.0, "")
    if (!recieve.matches(Regex("""\s*\d+[.]?\d*\s+[а-яА-ЯёЁ]+(\s+[-+*~=]\s+\d+[.]?\d*\s+[а-яА-ЯёЁ]+)+\s*""")))
        return
    val parsLine = recieve.split("\\s+").toMutableList()
    val size = parsLine.size
    val nums = parsLine.filterIndexed { index, _ -> index % 3 == 0 }
    val sizes = parsLine.filterIndexed { index, _ -> index % 3 == 1 }
    val operations = parsLine.filterIndexed { index, _ -> index % 3 == 2 }
    if (sizes.toSet().size != 1) return
    try {
        val discs = nums.mapIndexed { index, s -> Disc(s.toDouble(), sizes[index]) }.toMutableList()
        var res = discs.first()
        discs.removeAt(0)
        for (i in 0 until discs.size) {
            val op = operations[i]
            when (op) {
                "+" -> res += discs[i]
                "-" -> res -= discs[i]
                "*" -> res *= discs[i]
                "/" -> res /= discs[i]
            }
        }
    } catch (e: Exception) {
        println("Incorrect aruments")
    }*/
}


fun main(args: Array<String>) {
    mainOperations("")
}

