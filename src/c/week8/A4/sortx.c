/*
The only difference between this and the previous version of the bubble sorting algorithm is the optimization we've added. 
We terminate (break) any loop that doesn't make any changes to the order of the numbers as they are initially positioned. 
This prevents unnecessary iterations and can significantly improve performance when sorting nearly sorted or already sorted arrays.
*/

#include "i2p.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void sort(int array[], int size)
{
    for(int i = 0; i < size - 1; i++)
    {
        int swapped = 0;
        for(int j = 0; j < size - i - 1; j++)
        {
            if(array[j] > array[j+1])
            {
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                swapped = 1;
            }
        }
        if(swapped == 0)
            break;
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
