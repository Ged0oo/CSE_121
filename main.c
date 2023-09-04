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

	ret = StackInit(&stack);

	ret = StackPush(&stack, "Mabrock");
	ret = StackPush(&stack, "Nagy");
	ret = StackPush(&stack, "Mohamed");

	ret = StackTraverse(&stack, disStack);
	printf("\n");

	ret = StackPup(&stack, &st);

	ret = StackTraverse(&stack, disStack);
	printf("\n");
}
