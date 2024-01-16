// This program demonstrates the use of pointers to swap the values of two numbers.
//Basic revision exercise for an exam.
#include <stdio.h>

// Function prototype for the swap function, which takes two pointers to float.
void swap(float *num1, float *num2);

int main()
{
    // Declare two float variables and two pointers to float.
    float n1, n2;
    float *pt1, *pt2;

    // Set the pointers to point to the float variables.
    pt1 = &n1;
    pt2 = &n2;

    // Prompt the user to enter two numbers.
    printf("Do provide two numbers  ");
    // Read the numbers into the float variables.
    scanf("%f%f", &n1, &n2);
    // Print the values of the numbers before the swap.
    printf("Before the change n1 = %.2f\nn2 = %.2f\n", *pt1, *pt2);

    // Call the swap function to swap the values of the numbers.
    swap(pt1, pt2);
    // Print the values of the numbers after the swap.
    printf("After the change n1 = %.2f\nn2 = %.2f", *pt1, *pt2);
}

// The swap function takes two pointers to float.
// It swaps the values of the floats that the pointers point to.
void swap(float *num1, float *num2)
{
    // Declare a temporary float variable to hold one of the values during the swap.
    float temp;
    // Store the value of the first float in the temporary variable.
    temp = *num1;
    // Copy the value of the second float to the first float.
    *num1 = *num2;
    // Copy the value from the temporary variable to the second float.
    *num2 = temp;
}