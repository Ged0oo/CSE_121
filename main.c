#include <stdio.h>
#include "StackArray/StackArray.h"

void main(void)
{
	Stack_t stack;
	StackReturn_t ret;
	StackEntry_t st = NULL;

	ret = StackInit(&stack);
	ret = StackPush(&stack, 5);
	ret = StackPush(&stack, 10);
	ret = StackPush(&stack, 3);
	ret = StackPup(&stack, &st);

}
