
class `121-Best-Time-to-Buy-and-Sell-Stocks` {
    fun maxProfit(prices: IntArray): Int {
        var buy = prices[0]
        var maxDiff = 0
        for (i in 1 until prices.size) {
            buy = buy.coerceAtMost(prices[i])
            maxDiff = maxDiff.coerceAtLeast(prices[i] - buy)
        }
        return maxDiff
    }
}

fun main() {
    val result = `121-Best-Time-to-Buy-and-Sell-Stocks`().maxProfit(intArrayOf(1,2,3,4,5,6,7,0,10))
    println(result)
}
