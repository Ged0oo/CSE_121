#include <stdio.h>
#include "StackArray/StackArray.h"
#include "StackLinked/StackLinked.h"


void main(void)
{
	StackLinked_t stack;
	StackReturn_t ret;
	StackEntry_t entry;

	ret = StackLinkedInit(&stack);

	ret = StackLinkedEmpty(&stack);

	ret = StackLinkedPush(&stack, 7);
	ret = StackLinkedPush(&stack, 25);
	ret = StackLinkedPush(&stack, 2);

	ret = StackLinkedPup(&stack, &entry);
	ret = StackLinkedPup(&stack, &entry);
	ret = StackLinkedPup(&stack, &entry);

	ret = StackLinkedPup(&stack, &entry);
	ret = StackLinkedPup(&stack, &entry);

	ret = StackLinkedEmpty(&stack);

	printf("\nHello_World\n");
}

