/*The following code generates all possible 4 digit armstrong numbers ( numbers whose each digit respectively in the power of 
n where n == to the number length is equal to the digit it self )

Basic for loop including a while loop fetches a number from 1000 = 9999 and compares the sum of each digit to the overall sum of the number 

*/


#include <stdio.h>
#include <math.h>

int main()
{
    int n, nc, sum;
    for(n = 1000; n <=9999; n++) {
        nc = n;
        sum =0;
        while (nc != 0)
        {
            int d = nc % 10;
            int r = pow(d,4);
            sum += r;
            nc /=10;
        }
        
        if(n == sum)
        {
            printf("Armstrong number generated : %d \n", n);
        }
    }
}