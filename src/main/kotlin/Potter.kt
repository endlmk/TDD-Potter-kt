import kotlin.math.min

class Potter {
    companion object {
        fun price(books: Array<Int>): Any {
            val numBooks = IntArray(5)
            for(b in books) {
                numBooks[b]++
            }
            numBooks.sort()

            val pairsOfFive = numBooks[0]
            val pairsOfFour = numBooks[1] - numBooks[0]
            val pairsOfThree = numBooks[2] - numBooks[1]
            val pairsOfTwo = numBooks[3] - numBooks[2]
            val singleBooks = numBooks[4] - numBooks[3]

            // replace pairs because two pairs of four is cheaper than a pair of five and a pair of three
            val replacePairsToTwoFours = min(pairsOfFive, pairsOfThree)
            val replacedPairsOfFive = pairsOfFive - replacePairsToTwoFours
            val replacedPairsOfFour = pairsOfFour + replacePairsToTwoFours * 2
            val replacedPairsOfThree = pairsOfThree - replacePairsToTwoFours

            return 8 * singleBooks +
                    (8 * 2 * 0.95) * pairsOfTwo +
                    (8 * 3 * 0.9) * replacedPairsOfThree +
                    (8 * 4 * 0.8) * replacedPairsOfFour +
                    (8 * 5 * 0.75) * replacedPairsOfFive
        }
    }

}