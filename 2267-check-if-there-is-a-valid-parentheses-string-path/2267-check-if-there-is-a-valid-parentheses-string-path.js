var hasValidPath = function (grid) {
  const m = grid.length;
  const n = grid[0].length;
  const length = m + n - 1;

  if (length % 2 === 1 || grid[0][0] !== "(" || grid[m - 1][n - 1] !== ")") {
    return false;
  }

  const dp = Array(n).fill(0n);

  for (let row = 0; row < m; row++) {
    for (let col = 0; col < n; col++) {
      let reachable = 0n;
      if (row > 0) reachable |= dp[col];
      if (col > 0) reachable |= dp[col - 1];
      if (row === 0 && col === 0) reachable = 1n;

      dp[col] = grid[row][col] === "(" ? reachable << 1n : reachable >> 1n;
    }
  }

  return (dp[n - 1] & 1n) !== 0n;
};