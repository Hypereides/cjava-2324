/*The following code uses bubble sort to sort an array of strings in alphabetical order 
2 different functions are being used , one is sorting the array and the other one is responsible for printing it once it is sorted 
the code is yet again using the swapped technique to improve execution time (stops the sorting early if the array is already sorted.) */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void sort(char words[10][100], int size)
{
    char temp[100];
    for (int i = 0; i < size - 1; i++)
    {
        int swapped = 0;
        for (int j = 0; j < size - i - 1; j++)
        {
            if (strcmp(words[j], words[j + 1]) > 0)
            {
                strcpy(temp, words[j]);
                strcpy(words[j], words[j + 1]);
                strcpy(words[j + 1], temp);
                swapped = 1;
            }
        }
        if (swapped == 0)
            break;
    }
}

void printwords(char words[10][100], int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("%s\n", words[i]);
    }
}

int main()
{
    char words[10][100] =
        {
            "apple", "banana", "cherry", "date", "elderberry",
            "fig", "grape", "honeydew", "iceberg", "jackfruit"};
    int size = sizeof(words) / sizeof(words[0]);
    sort(words, size);
    printwords(words, size);
}