/* 
The following code performs basic mathematical operations (addition, subtraction, multiplication) between fractions.
It uses a custom library provided at https://file.io/jTymj1buZQoh.
The program prompts the user to provide an operation of their choice (+, -, *) using the struct Expression, and two fractions.
It then calculates and prints the result of the operation.
*/

#include "i2p.h"
#include <stdio.h>
int main()
{
    Expression operation;
    printf("Provide an operation\n");
    scanf(" %c", &operation.operator); // space to prevent any buffering by skipping any whitespace characters like \n
    printf("Provide a numerator for the first number\n");
    scanf("%d", &operation.op1.ar);
    printf("Provide a numerator for the second number\n");
    scanf("%d", &operation.op2.ar);
    printf("Provide a denominator for the first number\n");
    scanf("%d", &operation.op1.par);
    printf("Provide a denominator for the second number\n");
    scanf("%d", &operation.op2.par);
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
    default: 
    break;
    }
}
