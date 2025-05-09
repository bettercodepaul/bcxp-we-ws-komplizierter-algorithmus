# Probabilistic Rounder

The probabilistic rounder implements a stochastic rounding method that maintains the expected value of the input number.

## Algorithm

Given an input number x ∈ ℝ:

1. Calculate ⌊x⌋ (floor value)
2. Calculate fractional part f = x - ⌊x⌋
3. Generate random value r ∈ [0,1)
4. Output:

```
round(x) = ⌊x⌋ + 1   if r < f
round(x) = ⌊x⌋       if r ≥ f
```

## Expected Value

For any input x, the expected value E[round(x)] is:

```
E[round(x)] = f · (⌊x⌋ + 1) + (1-f) · ⌊x⌋ = x
```

## Example

For input x = 3.7:
- ⌊x⌋ = 3
- f = 0.7
- Probability of rounding to 4: 70%
- Probability of rounding to 3: 30%
- Expected value: 0.7 × 4 + 0.3 × 3 = 3.7