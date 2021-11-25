// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and 
// choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

// Algorithm: 
//  1.Set the prices[0] will be the bought value, ans variable with 0 value 
//  2. Then loop through array, if the the value is more than bought, compare the profit with the ans. if less than, set ans
//     to that profit
//  3. else set bought to that next value


public class Best_Time_to_Buy_and_Sell_Stock_121 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int bought = prices[0];

        for(int i = 1; i < prices.length; i++) {
            if (bought < prices[i]) {
                if (ans < prices[i] - bought) {
                    ans = prices[i]- bought;
                }
            } else bought = prices[i];
        }
        return ans;
    }

    
}
