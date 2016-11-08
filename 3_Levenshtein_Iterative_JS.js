function initialMatrix(sizeA, sizeB) {
    // See Java version for method comments
	var matrix = [],
        i,
        j;
    for (i = 0; i <= sizeA; i += 1) {
        matrix[i] = [];
        for (j = 0; j <= sizeB; j += 1) {
            matrix[i][j] = i === 0 || j === 0 ? Math.max(i, j) : 0;
        }
    }
    return matrix;
}

function isEmpty(str) {
    return str.length === 0;
}

function distance(a, b) {
    var cost = initialMatrix(a.length, b.length),
        i,
        j;
    function deletion() {
        return cost[i][j + 1] + 1;
    }
    function insertion() {
        return cost[i + 1][j] + 1;
    }
    function substitution() {
        return cost[i][j] + 1;
    }
    function noOperation() {
        return cost[i][j];
    }
    function calculateCost() {
        if (a.charAt(i) === b.charAt(j)) {
            return noOperation();
        }
        return Math.min(substitution(), insertion(), deletion());
    }
    for (i = 0; i < a.length; i += 1) {
        for (j = 0; j < b.length; j += 1) {
            cost[i + 1][j + 1] = calculateCost();
        }
    }
    return cost[a.length][b.length];
}

function getLevenshteinDistance(stringA, stringB) {
    var a = stringA,
        b = stringB;
    if (isEmpty(a)) {
        return b.length;
    }
    if (isEmpty(b)) {
        return a.length;
    }
    if (a === b) {
        return 0;
    }
    return distance(a, b);
}