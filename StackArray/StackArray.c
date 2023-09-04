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
		return STACK_OK;
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
	else if (_stack->top < -1)
	{
		return STACK_NOT_INTIALIZED;
	}
	else if (STACK_FULL == StackFull(_stack))
	{
		return STACK_FULL;
	}
	else 
	{	
		_stack->top += 1;
		_stack->entry[_stack->top] = _entry;	
		return STACK_OK;
	}
}


StackReturn_t StackPup(Stack_t* _stack, StackEntry_t* _entry)
{
	if (NULL == _stack)
	{
		return STACK_NULL;
	}
	else if (_stack->top < -1)
	{
		return STACK_NOT_INTIALIZED;
	}
	else if (STACK_EMPTY == StackFull(_stack))
	{
		return STACK_EMPTY;
	}
	else
	{
		*_entry = _stack->entry[_stack->top];
		_stack->top -= 1;
		return STACK_OK;
	}
}


StackReturn_t StackTop(Stack_t* _stack, StackEntry_t* _entry)
{
	if (NULL == _stack) 
	{
		return STACK_NULL;
	}
	else if (_stack->top < -1)
	{
		return STACK_NOT_INTIALIZED;
	}
	else if (STACK_EMPTY == StackFull(_stack))
	{
		return STACK_EMPTY;
	}
	else
	{
		*_entry = _stack->entry[-- _stack->top];
		return STACK_OK;
	}
}


StackReturn_t StackSize(Stack_t* _stack, int* _size)
{
	if (NULL == _stack)
	{
		return STACK_NULL;
	}
	else if (_stack->top < -1)
	{
		return STACK_NOT_INTIALIZED;
	}
	else
	{
		*_size = _stack->top + 1;
		return STACK_OK;
	}
}


StackReturn_t StackClear(Stack_t* _stack)
{
	if (NULL == _stack)
	{
		return STACK_NULL;
	}
	else if (_stack->top < -1)
	{
		return STACK_NOT_INTIALIZED;
	}
	else
	{
		_stack->top = -1;
		return STACK_OK;
	}
}


StackReturn_t StackTraverse(Stack_t* _stack, void (*pvisit)(StackEntry_t))
{
	if (NULL == _stack)
	{
		return STACK_NULL;
	}
	else if (_stack->top < -1)
	{
		return STACK_NOT_INTIALIZED;
	}
	else if (STACK_EMPTY == StackFull(_stack))
	{
		return STACK_EMPTY;
	}
	else
	{
		for (int i = _stack->top; i >= 0; i--)
			(*pvisit)(_stack->entry[i]);
		return STACK_OK;
	}
}

