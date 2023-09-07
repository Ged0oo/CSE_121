#include <stdio.h>
#include "StackArray/StackArray.h"
#include "StackLinked/StackLinked.h"


void disStack(StackEntry_t entry)
{
	printf("  %s  ", entry);
}


void main(void)
{
	StackLinked_t stack;
	StackReturn_t ret;
	StackEntry_t entry;
	StackEntry_t top;
	int size = 0;

	ret = StackLinkedInit(&stack);
	ret = StackLinkedEmpty(&stack);

	ret = StackLinkedPush(&stack, "Mabrock");
	ret = StackLinkedPush(&stack, "Nagy");
	ret = StackLinkedPush(&stack, "Mohamed");

	ret = StackLinkedTraverse(&stack, disStack);
}

