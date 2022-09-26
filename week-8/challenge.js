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

function getFactors(n) {
  factor1 = -1;
  for(let i = 2; i < n;i ++) {
    if (n % i == 0) {
      factor1 = i;
      factor2 = n/i;
      break;
    }
  }
  // base case, if this is prime, return 1 for count
  if(factor1 == -1) return [n];
  else return [...getFactors(factor1), ...getFactors(factor2)];
  
}

function numFactors(n) {
factors = getFactors(n);
// let unique = [factors[0]];
// for(let i = 1; i < factors.length; i ++) {
//   if(factors[i] != factors[i-1]) unique.push(factors[i]);
// }
return factors.length
}

console.log(getFactors(99))
console.log(numFactors(99));
console.log(countKprimes(2,0,100));

// while loops