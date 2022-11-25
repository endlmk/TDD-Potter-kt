class Potter {
    companion object {
        fun price(books: Array<Int>): Any {
            val numBooks = mutableMapOf<Int, Int>()
            for(b in books) {
                numBooks.put(b, numBooks[b]?.plus(1) ?: 1)
            }
            if(numBooks.size == 2) {
                return 8 * 2 * 0.95
            }
            if(numBooks.size == 3) {
                return 8 * 3 * 0.9
            }
            if(numBooks.size == 4) {
                return 8 * 4 * 0.8
            }
            if(numBooks.size == 5) {
                return 8 * 5 * 0.75
            }
            return 8 * books.size
        }
    }

}