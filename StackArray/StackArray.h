#ifndef __STACK_ARRAY_H__
#define __STACK_ARRAY_H__

#include <stdio.h>

#define NULL			(void*)0
#define MaxStack		100

typedef void* StackEntry_t;

typedef struct
{
	int top;
	StackEntry_t entry[MaxStack];
}Stack_t;

typedef enum
{
	STACK_OK = 0,
	STACK_NULL,
	STACK_FULL,
	STACK_EMPTY,
	STACK_NOT_INTIALIZED
}StackReturn_t;

StackReturn_t StackArrayInit(Stack_t* _stack);
StackReturn_t StackArrayFull(Stack_t* _stack);
StackReturn_t StackArrayEmpty(Stack_t* _stack);
StackReturn_t StackArrayPush(Stack_t* _stack, StackEntry_t  _entry);
StackReturn_t StackArrayPup(Stack_t* _stack, StackEntry_t *_entry);

StackReturn_t StackArrayTop(Stack_t* _stack, StackEntry_t* _entry);
StackReturn_t StackArraySize(Stack_t* _stack, int* _size);
StackReturn_t StackArrayClear(Stack_t* _stack);
StackReturn_t StackArrayDisplay(Stack_t* _stack);
StackReturn_t StackArrayTraverse(Stack_t* _stack, void (*pvisit)(StackEntry_t));


#endif // !__STACK_ARRAY_H__
