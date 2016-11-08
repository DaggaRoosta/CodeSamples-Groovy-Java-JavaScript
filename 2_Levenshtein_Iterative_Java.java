final get_levenshtein_distance = { CharSequence StringA, CharSequence StringB ->
    # Take the lengths of both strings and add one to each
	int lenA = StringA.length() + 1
    int lenB = StringB.length() + 1
	
	# Create two integer arrays of the length equal to lenA 
    int[] cost = new int[lenA]
    int[] new_cost = new int[lenA]
	
	# Populate the cost array with integer sequence from 0 to lenA; leave the new_cost array empty for now
    for (int i = 0; i < lenA; i++) {
        cost[i] = i
    }
	
	# Iterating the value of j from 1 to (lenB-1), and for each value of j (e.g., each letter in StringB)...
    int j = 1
    while ( j < lenB) {
	
		# Populate the first spot in the new_cost array with j...
        new_cost[0] = j
		
		# Then iterate the value of i from 1 to (lenA-1) (e.g., each letter in StringA).
        for (int i = 1; i < lenA; i++) {
		
			# If the letter in StringA matches the letter in StringB, assign "match" a value of 0, otherwise 1
            int match = (StringA.charAt(i - 1) == StringB.charAt(j - 1)) ? 0 : 1
			
			# Figure out the minimum cost to make the letters match, plus the stored cost-to-date, and store that as new_cost[i]
            int cost_replace = cost[i - 1] + match
            int cost_insert = cost[i] + 1
            int cost_delete = new_cost[i - 1] + 1
            new_cost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace)
        }
		
		#Swap the newly stored new_cost[i] for cost[i] and move on to the next iteration of j 
        int[] swap = cost; cost = new_cost; new_cost = swap
        j++
    }
	
	#After all iteration is complete, the last number in the cost array will be the minimum cost to edit StringA to StringB
    return cost[lenA - 1]
}