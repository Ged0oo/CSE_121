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

StackReturn_t StackInit(Stack_t* _stack);
StackReturn_t StackFull(Stack_t* _stack);
StackReturn_t StackEmpty(Stack_t* _stack);
StackReturn_t StackPush(Stack_t* _stack, StackEntry_t  _entry);
StackReturn_t StackPup(Stack_t* _stack, StackEntry_t *_entry);



#endif // !__STACK_ARRAY_H__
