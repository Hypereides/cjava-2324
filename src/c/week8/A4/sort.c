/*We are going to be utilizing the rand function to generate random numbers as shown below
and sorting them by using a basic bubble sort algorithm 
 */

#include "i2p.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void sort(int array[], int size)
{
    for (int i = 0; i < size - 1; i++)
    {
        for (int j = 0; j < size - i - 1; j++)
        {
            if (array[j] > array[j + 1])
            {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}
void printArray(int array[], int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("%d ", array[i]);
    }
}
int main()
{
    srand(time(0));
    int array[15];
    for (int x = 0; x < 15; ++x)
    {
        array[x] = rand();
    }
    int size = sizeof(array) / sizeof(array[0]); //it compares the size of the array in bits to the size of a single element of the array thus calculating the amount of elements , given that the value is always going to be 15 in this case it can be omitted 
    sort(array, size);
    printArray(array, size);
    return 0;
}
