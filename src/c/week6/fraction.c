/*
This program performs arithmetic operations on fractions. It uses structures to represent fractions and returns them from functions.

The program includes a function called `readExpression` that prompts the user to enter an operation and two fractions. Each fraction consists of a numerator and a denominator. The operation and fractions are stored in an `Expression` structure, which is then returned by the function.

In the `main` function, the `readExpression` function is called to read the operation and fractions from the user. The fractions are then used to perform various calculations:

1. `x` is calculated as the cross-multiplication of the numerators and denominators of the two fractions, which is equivalent to adding the products of the diagonals in a fraction addition operation.
2. `z` is calculated similarly to `x`, but with a subtraction operation instead of addition.
3. `y` is the product of the denominators of the two fractions, which is the denominator in the result of a fraction multiplication or division operation.
4. `o` is the product of the numerators of the two fractions, which is the numerator in the result of a fraction multiplication operation.

After these calculations, the program calculates the greatest common divisor (GCD) of `x` and `y` using a loop. This GCD is used to simplify the fractions resulting from the operations.

Finally, the program calculates the simplified numerators (`num0`, `num1`, `num2`) and denominator (`denum0`) of the fractions resulting from the operations.
*/

#include <stdio.h>
#include "i2p.h"

// This function reads an operation and two fractions from the user.
Expression readExpression()
{
    Expression a;
    printf("Provide an operation");
    scanf("%c", &a.operator);
    printf("Numerator 0 is: \n");
    scanf("%d", &a.op1.ar);
    printf("Deumerator 0  is: \n");
    scanf("%d", &a.op1.par);
    printf("Numerator 1 is: \n");
    scanf("%d", &a.op2.ar);
    printf("Deumerator 1 is: \n");
    scanf("%d", &a.op2.par);
    return a;
}

int main()
{
    Expression operation = readExpression();
    int x = (operation.op1.ar * operation.op2.par) + (operation.op1.par * operation.op2.ar);
    int z = (operation.op1.ar * operation.op2.par) - (operation.op1.par * operation.op2.ar);
    int y = operation.op1.par * operation.op2.par;
    int o = operation.op1.ar * operation.op2.ar;
    int c, gcd;
    for (c = 1; c <= x && c <= y; ++c)
    {
        if (x % c == 0 && y % c == 0)
            gcd = c;
    }

    int num0 = x / gcd;
    int denum0 = y / gcd;
    int num1 = z / gcd;
    int num2 = o / gcd;
    switch (operation.operator)
    {
    case '+':
        printf("The result is : \n%d/%d + %d/%d = %d/%d", operation.op1.ar, operation.op1.par, operation.op2.ar, operation.op2.par, num0, denum0);
        break;
    case '-':
        printf("The result is %d/%d", num1, denum0);
        break;
    case '*':
        printf("The result is %d/%d", num2, denum0);
    case '/':
        if (operation.op2.ar != 0)
        {
            int div_num = operation.op1.ar * operation.op2.par;
            int div_den = operation.op1.par * operation.op2.ar;
            for (c = 1; c <= div_num && c <= div_den; ++c)
            {
                if (div_num % c == 0 && div_den % c == 0)
                    gcd = c;
            }
            int div_result_num = div_num / gcd;
            int div_result_den = div_den / gcd;
            printf("\nThe result is : \n%d/%d / %d/%d = %d/%d", operation.op1.ar, operation.op1.par, operation.op2.ar, operation.op2.par, div_result_num, div_result_den);
        }
        else
        {
            printf("\nError: Division by zero is not allowed.\n");
        }
        break;
    default:
        printf("\nUnknown operation '%c'.", operation.operator);
        break;
    }
}
