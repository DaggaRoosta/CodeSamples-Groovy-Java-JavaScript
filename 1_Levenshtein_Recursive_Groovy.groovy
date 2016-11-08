def edit_distance(string_A, string_B) {
	// First define three resolution cases
    if (string_A == string_B) {
        return 0
    }
    if (string_A.size() == 0) {
        return string_B.size()
    }
    if (string_B.size() == 0) {
        return string_A.size()
    }
	
	// Now define recursive cases
	// If first letters are identical, the difference is whatever is required to edit the rest of the strings
    if (string_A.charAt(0) == string_B.charAt(0)) {
        return edit_distance(string_A.substring(1), string_B.substring(1))
    }
	
	// If the first letters are not identical, all possible solutions can proceed with one of three steps:
	//      change the first letter of A to that of B,
	//      remove first letter of A, or
	//      remove first letter of B.
	// So now we define the distance remaining after these three possible edits:
    def alpha = edit_distance(string_A.substring(1), string_B.substring(1))
    def beta = edit_distance(string_A, string_B.substring(1))
    def ceta = edit_distance(string_A.substring(1), string_B)
	
	// Then return a distance of 1 edit plus shortest distance of the three
    def shortest = [alpha, beta, ceta].min()
    return shortest + 1
}