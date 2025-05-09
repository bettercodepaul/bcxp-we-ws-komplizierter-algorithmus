# Online Sum-Preserving Rounding Algorithm

## Mathematical Concept

The algorithm solves the problem of rounding a sequence of real numbers while preserving their sum as closely as possible. This is particularly useful in scenarios where we need to convert decimal values to integers while maintaining their total sum.

### Key Properties

1. **Online Processing**: The algorithm processes numbers one at a time, without needing to know future inputs
2. **Sum Preservation**: The sum of rounded values closely approximates the sum of original values
3. **Minimal Error Accumulation**: The rounding error is carried forward and considered in subsequent roundings

## How It Works

1. For each new input value `x`, the algorithm:
   - Adds `x` to a running sum of original values
   - Calculates the target sum by rounding the running sum to the nearest integer
   - Determines the rounded value for `x` by taking the difference between the target sum and the previous rounded sum

### Mathematical Formula

Let:
- `S_n` be the sum of first n original values
- `R_n` be the sum of first n rounded values
- `x_n` be the nth input value
- `r_n` be the nth rounded value

Then:
```
S_n = S_(n-1) + x_n
R_n = round(S_n)
r_n = R_n - R_(n-1)
```

## Example

Consider the sequence: 1.4, 1.4, 1.4
```
Step 1: x₁ = 1.4
- S₁ = 1.4
- R₁ = round(1.4) = 1
- r₁ = 1

Step 2: x₂ = 1.4
- S₂ = 2.8
- R₂ = round(2.8) = 3
- r₂ = 3 - 1 = 2

Step 3: x₃ = 1.4
- S₃ = 4.2
- R₃ = round(4.2) = 4
- r₃ = 4 - 3 = 1
```

## Implementation Details

The Java implementation uses three instance variables:
- `runningSum`: Tracks the sum of original input values
- `roundedSum`: Maintains the sum of rounded values
- `error`: Tracks the accumulated rounding error (not directly used in current implementation)

The algorithm guarantees that the absolute difference between the sum of original values and the sum of rounded values is always less than 0.5.
