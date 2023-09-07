#include <stdio.h>
#include "StackArray/StackArray.h"
#include "StackLinked/StackLinked.h"


void main(void)
{
	StackLinked_t stack;
	StackReturn_t ret;
	StackEntry_t entry;
	StackEntry_t top;

	ret = StackLinkedInit(&stack);

	ret = StackLinkedEmpty(&stack);

	ret = StackLinkedPush(&stack, 7);
	ret = StackLinkedTop(&stack, &top);

	ret = StackLinkedPush(&stack, 25);
	ret = StackLinkedTop(&stack, &top);

	ret = StackLinkedPush(&stack, 2);
	ret = StackLinkedTop(&stack, &top);


	ret = StackLinkedPop(&stack, &entry);
	ret = StackLinkedTop(&stack, &top);

	ret = StackLinkedPop(&stack, &entry);
	ret = StackLinkedTop(&stack, &top);

	ret = StackLinkedPop(&stack, &entry);
	ret = StackLinkedTop(&stack, &top);

	ret = StackLinkedPop(&stack, &entry);
	ret = StackLinkedTop(&stack, &top);

	ret = StackLinkedPop(&stack, &entry);
	ret = StackLinkedTop(&stack, &top);

	ret = StackLinkedEmpty(&stack);

	printf("\nHello_World\n");
}

