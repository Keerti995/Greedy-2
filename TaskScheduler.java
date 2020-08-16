/**
 * Algo: Find the maxfreq of tasks (ex: A is occuring 3 times and rest are lesser than that), using that find the count of number of tasks which ahve same frequency.
 *       the count and maxfreq is used to calculate the partition between these for ex: assuming A&B have 3 then AB_ _AB_ _AB: partitons are 2 and empty slots are 4
 *       Now using the empty, we can check if the remaining ele can be put into those or are there any empty slots left.
 *       return length of the gvn array + empty
 *  Intuition: The tasks with maximum frequency is the key for the partiton, the rest of the tasks can be accmodated within those empty slots and the slots left by the remaining length of the array
 *  Time: O(n) - populating into hashmap
 *  Space: O(1) - hashmap of size 26
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxfreq = 0;
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            hmap.put(tasks[i],hmap.getOrDefault(tasks[i],0)+1);
            if(maxfreq < hmap.get(tasks[i]))
                maxfreq = hmap.get(tasks[i]);
        }

        int partition = maxfreq - 1;
        int count = 0;
        for(int k : hmap.values()){
            if(k == maxfreq)
                count++;
        }
        int empty = n*partition - ((count-1)*(maxfreq-1));
        int left = Math.max(0,(empty-(tasks.length-count*maxfreq)));
        return tasks.length+left;
    }
}