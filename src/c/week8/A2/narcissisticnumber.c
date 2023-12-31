/*The following code generates all possible 4 digit armstrong numbers ( numbers whose each digit respectively in the power of
n where n == to the number length is equal to the digit it self )

Basic, for loop including a while loop fetches a number from 1000 = 9999 and compares the sum of each digit to the overall sum of the number
 ******************************** Right below the initial code , within comments i have also
  included a different version that executes way faster
*/

#include <stdio.h>
#include <math.h>

int main()
{
    int n, nc, sum;
    for (n = 1000; n <= 9999; n++)
    {
        nc = n;
        sum = 0;
        while (nc != 0)
        {
            int d = nc % 10;
            int r = pow(d, 4);
            sum += r;
            nc /= 10;
        }

        if (n == sum)
        {
            printf("Armstrong number generated : %d \n", n);
        }
    }
}

// Written below is a version that increases the execution speed

/*int main()
{
    int n, nc, sum;
    int powers[10];

    //Given that the power of numbers is always going to be 4 , we can simply store the fourth power of 1-9
    for(int i = 0; i < 10; i++) {
        powers[i] = i * i * i * i;
    }

    for(n = 1000; n <= 9999; n++) {
        nc = n;
        sum = 0;
        while (nc != 0)
        {
            int d = nc % 10;
            sum += powers[d];
            if(sum > n) {
                break; //if n is smaller than sum there is no need to continue the loop since there is no possible way for the number to be an armstrong one
            }
            nc /= 10;
        }

        if(n == sum)
        {
            printf("Armstrong number generated: %d\n", n);
        }
    }

*/