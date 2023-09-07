#include <stdio.h>
#include "StackArray/StackArray.h"
#include "StackLinked/StackLinked.h"


void main(void)
{
	StackLinked_t stack;
	StackReturn_t ret;
	StackEntry_t entry;
	StackEntry_t top;
	int size = 0;

	ret = StackLinkedInit(&stack);
	ret = StackLinkedEmpty(&stack);

	ret = StackLinkedPush(&stack, 7);
	ret = StackLinkedPush(&stack, 25);
	ret = StackLinkedPush(&stack, 2);

	ret = StackLinkedSize(&stack, &size);

	ret = StackLinkedClear(&stack);

	ret = StackLinkedSize(&stack, &size);

	printf("\nHello_World\n");
}

