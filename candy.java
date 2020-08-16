/**
 * Intuition: 2 passes: 1st pass check if the prev ele is smaller than curr and add candies
 *                      2nd pass chk if the next ele is smaller than the current then max of next ele candies+1 or current ele candies
 * Imp: these passes CAN'T be done other way round : like initally chkg forward ele and then 2nd pass, cumn from backward checking forward elements.
 * Time: O(n) n-length of the ratings array
 * Space: O(n)
 */
public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }
}