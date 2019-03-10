package Class

import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testForMainOperations(){
        assertEquals("20.0 г", mainOperations(" 5 г + 5 г + 5 г + 5 г"))
        assertEquals("14539.718 кг", mainOperations(" 231.2458 кг * 62.8756 кг"))
        assertEquals("7.0 г", mainOperations("70 г - 63 г"))
        assertEquals("28.0 кг", mainOperations("7 кг * 4 кг"))
        assertEquals("7.0 кг", mainOperations("35 кг ~ 5 кг"))
        assertEquals(false, mainOperations("7 кг = 4 кг"))
        assertEquals(true, mainOperations("4 кг = 4 кг"))
    }
}
