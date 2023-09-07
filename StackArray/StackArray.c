#include "StackArray.h"

StackReturn_t StackArrayInit(Stack_t* _stack)
{
	StackReturn_t ret = STACK_OK;
	if (NULL == _stack)
	{
		ret = STACK_NULL;
	}
	else
	{
		_stack->top = -1;
		ret = STACK_OK;
	}
	return ret;
}


StackReturn_t StackArrayFull(Stack_t* _stack)
{
	StackReturn_t ret = STACK_OK;
	if (NULL == _stack)
	{
		ret = STACK_NULL;
	}
	else
	{
		if (_stack->top >= MaxStack)
			ret = STACK_FULL;
		else 
			ret = STACK_OK;
	}
	return ret;
}


StackReturn_t StackArrayEmpty(Stack_t* _stack)
{
	StackReturn_t ret = STACK_OK;
	if (NULL == _stack)
	{
		return STACK_NULL;
	}
	else
	{
		if (_stack->top == -1)
		{
			ret = STACK_EMPTY;
		}
		else
		{
			ret = STACK_OK;
		}
	}
	return ret;
}


StackReturn_t StackArrayPush(Stack_t* _stack, StackEntry_t  _entry)
{
	StackReturn_t ret = STACK_OK;
	StackReturn_t stackRet = STACK_OK;
	if(NULL == _stack)
	{
		ret = STACK_NULL;
	}
	else if (_stack->top < -1)
	{
		ret = STACK_NOT_INTIALIZED;
	}
	else if (STACK_FULL == StackArrayFull(_stack))
	{
		ret = STACK_FULL;
	}
	else 
	{	
		_stack->top += 1;
		_stack->entry[_stack->top] = _entry;	
		ret = STACK_OK;
	}
	return ret;
}


StackReturn_t StackArrayPop(Stack_t* _stack, StackEntry_t* _entry)
{
	StackReturn_t ret = STACK_OK;
	if (NULL == _stack)
	{
		ret = STACK_NULL;
	}
	else if (_stack->top < -1)
	{
		ret = STACK_NOT_INTIALIZED;
	}
	else if (STACK_EMPTY == StackArrayFull(_stack))
	{
		ret = STACK_EMPTY;
	}
	else
	{
		*_entry = _stack->entry[_stack->top];
		_stack->top -= 1;
		ret = STACK_OK;
	}
	return ret;
}


StackReturn_t StackArrayTop(Stack_t* _stack, StackEntry_t* _entry)
{
	StackReturn_t ret = STACK_OK;
	if (NULL == _stack) 
	{
		ret = STACK_NULL;
	}
	else if (_stack->top < -1)
	{
		ret = STACK_NOT_INTIALIZED;
	}
	else if (STACK_EMPTY == StackArrayFull(_stack))
	{
		ret = STACK_EMPTY;
	}
	else
	{
		*_entry = _stack->entry[-- _stack->top];
		ret = STACK_OK;
	}
	return ret;
}


StackReturn_t StackArraySize(Stack_t* _stack, int* _size)
{
	StackReturn_t ret = STACK_OK;
	if (NULL == _stack)
	{
		ret = STACK_NULL;
	}
	else if (_stack->top < -1)
	{
		ret = STACK_NOT_INTIALIZED;
	}
	else
	{
		*_size = _stack->top + 1;
		ret = STACK_OK;
	}
}


StackReturn_t StackArrayClear(Stack_t* _stack)
{
	StackReturn_t ret = STACK_OK;
	if (NULL == _stack)
	{
		ret = STACK_NULL;
	}
	else if (_stack->top < -1)
	{
		ret = STACK_NOT_INTIALIZED;
	}
	else
	{
		_stack->top = -1;
		ret = STACK_OK;
	}
	return ret;
}


StackReturn_t StackArrayTraverse(Stack_t* _stack, void (*pvisit)(StackEntry_t))
{
	StackReturn_t ret = STACK_OK;
	if (NULL == _stack)
	{
		ret = STACK_NULL;
	}
	else if (_stack->top < -1)
	{
		ret = STACK_NOT_INTIALIZED;
	}
	else if (STACK_EMPTY == StackArrayFull(_stack))
	{
		ret = STACK_EMPTY;
	}
	else
	{
		for (int i = _stack->top; i >= 0; i--)
			(*pvisit)(_stack->entry[i]);
		ret = STACK_OK;
	}
	return ret;
}


StackReturn_t StackArrayDisplay(Stack_t* _stack)
{
	StackReturn_t ret = STACK_OK;
	if (NULL == _stack)
	{
		ret = STACK_NULL;
	}
	else if (_stack->top < -1)
	{
		ret = STACK_NOT_INTIALIZED;
	}
	else if (STACK_EMPTY == StackArrayFull(_stack))
	{
		ret = STACK_EMPTY;
	}
	else
	{
		printf("\nStack Display\n[ ");
		for (int i = _stack->top; i >= 0; i--)
		{
			printf(" %s ", _stack->entry[i]);
		}
		printf(" ]\n");
		ret = STACK_OK;
	}
	return ret;
}