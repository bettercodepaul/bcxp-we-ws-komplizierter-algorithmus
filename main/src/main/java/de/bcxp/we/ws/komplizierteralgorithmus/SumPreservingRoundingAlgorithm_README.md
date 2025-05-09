
# SumPreserving Rounding Algorithm

## Description

The **SumPreserving Rounding Algorithm** is an algorithm that rounds floating-point numbers in such a way that the sum of the rounded values equals the sum of the original floating-point numbers (if the original sum is already an integer). This is particularly useful in applications where it is important to retain the total sum despite rounding. The algorithm uses a *mathematically justified rounding strategy*, which is particularly relevant for planning systems and industrial applications.

### How it Works

1. **Input**: A list of floating-point numbers (e.g., `1.6, 2.7, 3.3`).
2. **Rounding**: Each value is rounded to the nearest whole number, while monitoring the total sum of the rounded values.
3. **Sum**: If the sum of the rounded values differs from the originally intended rounded sum, the difference is distributed across the values to reach the exact sum.

### Goal

The main goal of this algorithm is to ensure that after rounding, the *sum of the rounded values matches the desired sum exactly*. The total sum of the input values is used as the basis.

---

## Implementation

The algorithm is implemented through a method `roundPreserveSum(List<Double> input)`. Here's the basic flow of the algorithm:

1. **Rounding the Values**: First, the floating-point numbers are rounded individually using `Math.round()` to the nearest whole number.
2. **Sum Calculation**: The sum of the rounded values is computed.
3. **Calculating the Difference**: If the sum of the rounded values does not match the intended rounded sum, the difference is calculated.
4. **Distributing the Difference**: The difference is distributed across the values to achieve the exact desired sum. This distribution happens by incrementing or decrementing the rounded values.

---

## Example Applications

### Example 1: Positive Numbers

**Input**:

```java
List<Double> input = Arrays.asList(1.6, 1.7, 1.8);
```

**Process**:

- The sum of the input values is `1.6 + 1.7 + 1.8 = 5.1`.
- After rounding each value: `1.6` rounds to `2`, `1.7` rounds to `2`, and `1.8` rounds to `2`.
- The sum of the rounded values: `2 + 2 + 2 = 6`.
- The actual rounding of the total value would be `Math.round(5.1) = 6`.
- **Result**: `Sum of the rounded values = 6`.

### Example 2: Negative Numbers

**Input**:

```java
List<Double> input = Arrays.asList(-1.6, -1.7, -1.8);
```

**Process**:

- The sum of the input values is `-1.6 + -1.7 + -1.8 = -5.1`.
- After rounding each value: `-1.6` rounds to `-2`, `-1.7` rounds to `-2`, and `-1.8` rounds to `-2`.
- The sum of the rounded values: `-2 + -2 + -2 = -6`.
- The actual rounding of the total value would be `Math.round(-5.1) = -5`.
- **Result**: The rounding is adjusted to correct the difference from `-6` to `-5`.

---

## Potential Paradoxes and Edge Cases

### Paradox 1: **Integer Inputs**
If all input values are already integers (e.g., `1.0, 2.0, 3.0`), no changes are made to the values, and the algorithm simply returns the original sum.

**Input**:

```java
List<Double> input = Arrays.asList(1.0, 2.0, 3.0);
```

**Result**: Since the sum is already an integer, it remains unchanged: `1 + 2 + 3 = 6`.

### Paradox 2: **Very Small Decimal Numbers**
Small decimal values (e.g., `0.001`, `0.002`, `0.003`) may lead to rounding that results in an incorrect total sum when the original sum is very close to `0`. In these cases, it may be necessary to adjust the total sum, which must be distributed accordingly.

**Input**:

```java
List<Double> input = Arrays.asList(0.001, 0.002, 0.003);
```

**Result**: This input may round the sum to `0`, but it may also require **distribution of the difference** to achieve the **exact sum**.

---

## Comparison with Other Rounding Algorithms

### 1. **Standard Rounding (Math.round())**

- **Standard rounding** follows the traditional rules where values are rounded up or down (values of 0.5 or greater are rounded up).
- **Issue**: It does not guarantee that the total sum remains intact after rounding. Rounding individual values may result in an inaccurate total sum when multiple values are rounded.

### 2. **Truncation (Flooring)**

- **Truncation (Flooring)** simply cuts off the decimal part and returns only the integer.
- **Issue**: This method is problematic for the intended requirement, as it distorts the total sum and does not guarantee the correct sum of the values.

### 3. **Ceiling Rounding (Math.ceil())**

- **Ceiling rounding** always rounds up to the next whole number, regardless of the decimal part.
- **Issue**: This method may lead to overestimation of the total sum and is not ideal when the exact total sum must be retained.

---

## Conclusion

The **SumPreserving Rounding Algorithm** ensures that after rounding, the total sum of the rounded numbers matches the desired sum exactly. This is achieved through a combination of **standard rounding** and **dynamic difference distribution**. This algorithm is particularly useful in applications where an exact total sum is required after rounding, such as in financial and production planning systems.

