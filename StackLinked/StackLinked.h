#ifndef __STACK_LINKED_H__
#define __STACK_LINKED_H__

#include <stdio.h>

typedef void* StackEntry_t;

typedef struct stacknode 
{
	StackEntry_t entry;
	struct stacknode* next;
}StackNode_t;

typedef struct stack 
{
	StackNode_t* top;
}StackLinked_t;

typedef enum
{
	STACK_OK = 0,
	STACK_NULL,
	STACK_FULL,
	STACK_EMPTY,
	STACK_NOT_INTIALIZED
}StackReturn_t;

StackReturn_t StackLinkedInit(StackLinked_t* _stack);
StackReturn_t StackLinkedFull(StackLinked_t* _stack);
StackReturn_t StackLinkedEmpty(StackLinked_t* _stack);
StackReturn_t StackLinkedPush(StackLinked_t* _stack, StackEntry_t  _entry);
StackReturn_t StackLinkedPup(StackLinked_t* _stack, StackEntry_t* _entry);

StackReturn_t StackLinkedTop(StackLinked_t* _stack, StackEntry_t* _entry);
StackReturn_t StackLinkedSize(StackLinked_t* _stack, int* _size);
StackReturn_t StackLinkedClear(StackLinked_t* _stack);
StackReturn_t StackLinkedDisplay(StackLinked_t* _stack);
StackReturn_t StackLinkedTraverse(StackLinked_t* _stack, void (*pvisit)(StackEntry_t));

#endif // __STACK_LINKED_H__
