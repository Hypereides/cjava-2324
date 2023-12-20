
/*Provided code does the following things:
        Asks the user to enter 2 different values which are assigned to  different variables,
        i) Small bottle count
        ii) Large bottle count
        iii) Calculates the total value of both products
        iv) Applies a discount depending on the quantity of the products or the price of the products
*/


#include <stdio.h>

int main()
{
    int count_small_bottles, count_large_bottles; // count_small_bottles is set to be the count of a small bottle while count_large_bottles is the count of a large bottle
    float small = 0.008;                          // small bottle cost
    float large = 0.02;                           // large bottle cost
    printf("How many large bottles would you like to order\n");
    scanf("%d", &count_large_bottles);
    printf("How many small bottles would you like to order\n");
    scanf("%d", &count_small_bottles);

    if (count_small_bottles < 0 || count_large_bottles < 0)
    {
        printf("Do consider providing a positive number greater than or equal to 0 (bottle count)");
    }
    else
    {
        float sum = count_small_bottles * small + count_large_bottles * large;
        // if the total count is between 200 and 600 Euros or total bottles exceed 3000 apply an 8% discount
        if (sum > 200 && sum <= 600 || count_small_bottles + count_large_bottles > 3000)
        {
            sum = 0.92 * sum;
        }
        else if (sum > 600) // if the total bottle count is greater than 600 apply a 20% discount
        {
            sum = 0.80 * sum;
        }
        printf("\nTotal value %.2f 'Euros'", sum);
    }
}
