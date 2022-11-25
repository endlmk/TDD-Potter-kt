import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PotterTest : FunSpec ({

    test("no discount") {
        Potter.price(arrayOf(1)) shouldBe 8
        Potter.price(arrayOf(2)) shouldBe 8
        Potter.price(arrayOf(3)) shouldBe 8
        Potter.price(arrayOf(4)) shouldBe 8
        Potter.price(arrayOf(5)) shouldBe 8
        Potter.price(arrayOf(1, 1, 1)) shouldBe 24
    }
})
