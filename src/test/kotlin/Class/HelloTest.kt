package Class

import org.junit.Test
import kotlin.test.assertEquals

class Test {

    fun testArOper(d1: Disc, d2: Disc, other: Double, op: String, expected: Disc) {
        when (op) {
            "+" -> assertEquals(expected, d1 + d2)
            "-" -> assertEquals(expected, d1 - d2)
            "*" -> assertEquals(expected, d1 * d2)
            "/" -> assertEquals(expected, d1 / d2)
            "|" -> assertEquals(expected, d1 * other)
            "_" -> assertEquals(expected, d1 / other)
        }
    }

    @Test
    fun testPlus(){
        testArOper(Disc(1.0, "кг"), Disc(2.0, "кг"),0.0, "+", Disc(3.0, "кг"))
    }
    @Test
    fun testMinus(){
        testArOper(Disc(15.0, "кг"), Disc(2.0, "кг"),0.0, "-", Disc(13.0, "кг"))
    }
    @Test
    fun testTimes(){
        testArOper(Disc(5.0, "кг"), Disc(2.0, "кг"),0.0, "*", Disc(10.0, "кг"))
    }
    @Test
    fun testDiv(){
        testArOper(Disc(10.0, "кг"), Disc(2.0, "кг"),0.0, "/", Disc(5.0, "кг"))
    }
    @Test
    fun testTimesNum(){
        testArOper(Disc(3.0, "кг"), Disc(0.0, ""), 15.0, "|", Disc(45.0, "кг"))
    }
    @Test
    fun testDivNum(){
        testArOper(Disc(8.0, "кг"), Disc(0.0, ""), 2.0, "_", Disc(4.0, "кг"))
    }
    @Test
    fun testEquals(){
        val d1 = Disc(5.0, "кг")
        val d2 = Disc(5.0, "кг")
        val d3 = Disc(10.0, "кг")
        assertEquals(d3, d1 + d2)
    }

}
