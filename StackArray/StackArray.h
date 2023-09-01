#ifndef __STACK_ARRAY_H__
#define __STACK_ARRAY_H__

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

#endif // !__STACK_ARRAY_H__
