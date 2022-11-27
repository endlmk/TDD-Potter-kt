import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PotterTest : FunSpec ({

    test("no discount") {
        Potter.price(arrayOf(0)) shouldBe 8
        Potter.price(arrayOf(1)) shouldBe 8
        Potter.price(arrayOf(2)) shouldBe 8
        Potter.price(arrayOf(3)) shouldBe 8
        Potter.price(arrayOf(4)) shouldBe 8
        Potter.price(arrayOf(1, 1, 1)) shouldBe 24
    }

    test("discount for different books") {
        Potter.price(arrayOf(1, 2)) shouldBe 8 * 2 * 0.95
        Potter.price(arrayOf(1, 2, 3)) shouldBe 8 * 3 * 0.9
        Potter.price(arrayOf(0, 1, 2, 3)) shouldBe 8 * 4 * 0.8
        Potter.price(arrayOf(0, 1, 2, 3, 4)) shouldBe 8 * 5 * 0.75
    }

    test("several discounts") {
        Potter.price(arrayOf(0, 0, 1)) shouldBe 8 * 2 * 0.95 + 8
        Potter.price(arrayOf(0, 0, 1, 1)) shouldBe (8 * 2 * 0.95) * 2
        Potter.price(arrayOf(0, 0, 1, 2, 2, 3)) shouldBe (8 * 4 * 0.8) + (8 * 2 * 0.95)
        Potter.price(arrayOf(0, 1, 1, 2, 3, 4)) shouldBe (8 * 5 * 0.75) + 8
    }
})
