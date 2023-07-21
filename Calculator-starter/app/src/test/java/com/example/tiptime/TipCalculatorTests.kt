import com.example.tiptime.calculateTip
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
       val tip =  calculateTip(10.00,20.00,false)
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        assertEquals(tip,expectedTip)
    }
}