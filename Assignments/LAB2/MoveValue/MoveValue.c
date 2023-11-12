#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void moveElementsToEnd(int arr[], int length, int value) 
{
    int nonValueCount = 0;  

    for (int i = 0; i < length; i++) 
	{
        if (arr[i] != value) 
		{
            arr[nonValueCount] = arr[i];
            nonValueCount++;
        }
    }

    for (int i = nonValueCount; i < length; i++) 
	{
        arr[i] = value;
    }
}

int main() 
{
    char input[1024];
    int arr[500];
    int length = 0;
    int specifiedValue;

    fgets(input, sizeof(input), stdin);
    scanf("%d", &specifiedValue);

    char* token = strtok(input, "[,]\n ");
    while (token != NULL) 
	{
        arr[length] = atoi(token);
        length++;
        token = strtok(NULL, "[,]\n ");
    }

    moveElementsToEnd(arr, length, specifiedValue);

    printf("[");
    for (int i = 0; i < length; i++)
	{
        printf("%d", arr[i]);
        if (i < length - 1) 
		{
            printf(", ");
        }
    }
    printf("]");
    return 0;
}
