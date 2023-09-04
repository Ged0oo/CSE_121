#include <stdio.h>
#include "StackArray/StackArray.h"

void disStack(StackEntry_t st)
{
	printf(" %s ", st);
}

void main(void)
{
	Stack_t stack;
	StackReturn_t ret;
	StackEntry_t st = NULL;

	ret = StackArrayInit(&stack);
	ret = StackArrayEmpty(&stack);
	
	ret = StackArrayPush(&stack, "Mabrock");
	ret = StackArrayPush(&stack, "Nagy");
	ret = StackArrayPush(&stack, "Mohamed");

	ret = StackArrayEmpty(&stack);

	ret = StackArrayTraverse(&stack, disStack);
	printf("\n");

	ret = StackArrayPup(&stack, &st);

	ret = StackArrayDisplay(&stack);
}
