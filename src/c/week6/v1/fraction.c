/* 
This program contains two main functions:
1. readExpression: This function is responsible for getting input from the user. It reads the operation and two fractions.
2. displayExpression: This function is responsible for calculating the result of the operation on the two fractions and presenting this result to the user.
*/

#include <stdio.h>
#include "i2p.h"

// Function prototypes
void displayExpression(char op, int n1, int d1, int n2, int d2);


int main()
{
    // Declare variables for operation and fractions
    char op;
    int n1, d1, n2, d2;

    // Read operation and fractions from user
    readExpression(&op, &n1, &d1, &n2, &d2);

    // Display the expression
    displayExpression(op, n1, d1, n2, d2);
}

// Function to display the expression and calculate the result
void displayExpression(char op, int n1, int d1, int n2, int d2)
{
    printf("Expression to evaluate is %c %d %d %d %d", op, n1, d1, n2, d2);

    int x = (n1 * d2) + (d1 * n2);
    int z = (n1 * d2) - (d1 * n2);
    int y = d1 * d2;
    int o = n1 * n2;
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
    switch (op)
    {
    case '+':
        printf("The result is : \n%d/%d + %d/%d = %d/%d", n1, d1, n2, d2, num0, denum0);
        break;
    case '-':
        printf("The result is %d/%d", num1, denum0);
        break;
    case '*':
        printf("The result is %d/%d", num2, denum0);
    case '/':
        if (n2 != 0)
        {
            int div_num = n1 * d2;
            int div_den = d1 * n2;
            for (c = 1; c <= div_num && c <= div_den; ++c)
            {
                if (div_num % c == 0 && div_den % c == 0)
                    gcd = c;
            }
            int div_result_num = div_num / gcd;
            int div_result_den = div_den / gcd;
            printf("\nThe result is : \n%d/%d / %d/%d = %d/%d", n1, d1, n2, d2, div_result_num, div_result_den);
        }
        else
        {
            printf("\nError: Division by zero is not allowed.\n");
        }
        break;
    default:
        printf("\nUnknown operation '%c'.", op);
        break;
    }
}