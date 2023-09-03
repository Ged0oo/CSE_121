#include "StackArray.h"

StackReturn_t StackInit(Stack_t* _stack)
{
	if (NULL == _stack)
	{
		return STACK_NULL;
	}
	else
	{
		_stack->top = -1;
	}
	
}


StackReturn_t StackFull(Stack_t* _stack)
{
	if (NULL == _stack)
	{
		return STACK_NULL;
	}
	else
	{
		if (_stack->top >= MaxStack)
			return STACK_FULL;
	}
}


StackReturn_t StackEmpty(Stack_t* _stack)
{
	if (NULL == _stack)
	{
		return STACK_NULL;
	}
	else
	{
		if (_stack->top == -1)
			return STACK_EMPTY;
	}
}



