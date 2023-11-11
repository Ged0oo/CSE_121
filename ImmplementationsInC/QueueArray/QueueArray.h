#ifndef __QUEUE_ARRAY_H__
#define __QUEUE_ARRAY_H__

#include <stdio.h>
#include <stdlib.h>

#define MaxQueue		100

typedef void* QueueEntry_t;

typedef struct queue
{
	int front;
	int rear;
	int size;
	QueueEntry_t entry[MaxQueue];
}Queue_t;

typedef enum
{
	QUEUE_OK = 0,
	QUEUE_NULL,
	QUEUE_FULL,
	QUEUE_EMPTY,
	QUEUE_NOT_INTIALIZED
}QueueReturn_t;

QueueReturn_t QueueArrayInit(Queue_t* _queue);
QueueReturn_t QueueArrayFull(Queue_t* _queue);
QueueReturn_t QueueArrayEmpty(Queue_t* _queue);
QueueReturn_t QueueArrayAppend(Queue_t* _queue, QueueEntry_t  _entry);
QueueReturn_t QueueArrayServe(Queue_t* _queue, QueueEntry_t* _entry);

QueueReturn_t QueueArrayTop(Queue_t* _queue, QueueEntry_t* _entry);
QueueReturn_t QueueArraySize(Queue_t* _queue, int* _size);
QueueReturn_t QueueArrayClear(Queue_t* _queue);
QueueReturn_t QueueArrayDisplay(Queue_t* _queue);
QueueReturn_t QueueArrayTraverse(Queue_t* _queue, void (*pvisit)(QueueEntry_t));


#endif //__QUEUE_ARRAY_H__