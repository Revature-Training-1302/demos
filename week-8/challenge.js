function countKprimes(k, start, nd) {
    sols = [];
    for(let i = start;i <= nd; i ++) {
      if(numFactors(i) == k) {
        sols.push(i);
      }
    }
  return sols;
}
function puzzle(s) {
    // your code
}

function numFactors(n) {
    console.log("n: " + n);
    factor = -1;
    for(let i = 2; i < n;i ++) {
      if (n % i == 0) {
        factor = i;
        break;
      }
    }
    console.log('factor: ' + factor);
    console.log('n/factor: ' + n/factor);
    // base case, if this is prime, return 1 for count
    if(factor == -1) return 1;
    else return numFactors(factor) + numFactors(n/factor);
    
  }
console.log(numFactors(99));


// while loops