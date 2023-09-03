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


StackReturn_t StackPush(Stack_t* _stack, StackEntry_t  _entry)
{
	StackReturn_t stackRet = STACK_OK;
	if(NULL == _stack)
	{
		return STACK_NULL;
	}
	else if (STACK_NOT_INTIALIZED == StackInit(_stack))
	{
		return STACK_NOT_INTIALIZED;
	}
	else if (STACK_FULL == StackFull(_stack))
	{
		return STACK_FULL;
	}
	else 
	{	
		_stack->top++;
		_stack->entry[_stack->top] = _entry;	
		return STACK_OK;
	}
}


StackReturn_t StackPup(Stack_t* _stack, StackEntry_t* _entry)
{
	if ((NULL == _stack) || (NULL == _entry))
	{
		return STACK_NULL;
	}
	else if (STACK_NOT_INTIALIZED == StackInit(_stack))
	{
		return STACK_NOT_INTIALIZED;
	}
	else if (STACK_EMPTY == StackFull(_stack))
	{
		return STACK_EMPTY;
	}
	else
	{
		_stack->top--;
		*_entry = _stack->entry[_stack->top];
		return STACK_OK;
	}
}


