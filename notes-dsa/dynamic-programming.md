# Dynamic Programming

# Table of Contents

## Dynamic Programming
- Break a big problem into subproblems
- Solve each subproblem once
- Save results to avoid recomputation

## Pattern

### 0/1 Knapsack
**Key Idea:**
- Choose between taking or not taking an item.
- Binary decisions at each step: include or exclude.

**Typical Problems:**
- Subset Sum
- Partition Equal Subset Sum
- 0/1 Knapsack

**State Variables:**
- Usually index (current item) and remaining capacity.

Transition Formula:
dp[i][w] = max(dp[i-1][w], value[i] + dp[i-1][w - weight[i]])

✅ If there is "choose" or "skip" in a problem, it's probably 0/1 Knapsack style.

### Unbounded Knapsack
**Key Idea:**
- You can use the same item multiple times.

**Typical Problems:**
- Coin Change (minimum coins)
- Integer Break
- Complete Knapsack

**State Variables:**
- Usually amount or capacity only.

**Transition Formula:**
- Try including the same item again and again.

✅ If items can be "picked unlimited times," think unbounded knapsack.


### Fibonacci Sequence
**Key Idea:**
- Each state depends only on the previous one or two states.

**Typical Problems:**
- Climbing Stairs
- House Robber
- Decode Ways

**Transition Formula:**
dp[i] = dp[i-1] + dp[i-2] (or some similar linear relationship)

✅ If subproblems depend on just one or two previous steps, it's Fibonacci style.

### Longest Common Subsequence (LCS)

**Key Idea:**
- Compare two sequences and build answers from smaller prefixes.

**Typical Problems:**
- Longest Common Subsequence
- Edit Distance
- Minimum Insertions/Deletions to Make Strings Equal

**Transition Formula:**
If characters match:
dp[i][j] = dp[i-1][j-1] + 1
Else: dp[i][j] = max(dp[i-1][j], dp[i][j-1])

✅ Whenever we deal with string matching, transformation, or edits, it's usually LCS-style DP.

### Matrix DP
**Key Idea:**
- Solve problems in a 2D grid.
- Usually involves path-finding, counting, or maximum area.

**Typical Problems:**
- Unique Paths
- Minimum Path Sum
- Maximal Square
- Coin Change II (viewed as 2D sometimes)

**Transition Formula:**
- Move from left, top, or diagonally based on rules.

✅ If the problem mentions grid, matrix, maze, or movement, think Matrix DP.

### Palindromic Substring
**Key Idea:**
- Solve problems inside substrings of a single string.
- Often involves checking if substrings are palindromes.

**Typical Problems:**
- Longest Palindromic Substring
- Palindrome Partitioning
- Count Palindromic Substrings

**Transition Formula:**

If s[i] == s[j] and inner substring is a palindrome, then s[i..j] is a palindrome too.

✅ If you're checking inside a string for patterns, it's Palindrome DP.

## Bottom-Up vs Top-Down

Strategy |	Description
--- | --- |
Top-Down (Memoization) |	Write recursive code, store computed results.
Bottom-Up (Tabulation) |	Build up the table iteratively from base cases.

## Common Optimization Techniques
### Space Optimization
Many DP problems don't need the full 2D table — just the last row or last two results. E.g., reduce from O(n^2) space to O(n).

### Early Pruning
Break recursion early if a result is impossible. Example: Return instantly when the remaining sum < 0 in coin change.

### How to Spot DP Problems
- Can I define the problem as a combination of smaller subproblems?
- Are there overlapping subproblems?
- Can I reuse results instead of recomputing?
- If yes, → it's likely a DP candidate.

