#ifndef __LIST_ARRAY_H__
#define __LIST_ARRAY_H__

#include <stdio.h>
#include <stdlib.h>

#define MaxList		100

typedef void* ListEntry_t;

typedef struct list
{
	int size;
	ListEntry_t entry[MaxList];
}List_t;

typedef enum
{
	LIST_OK = 0,
	LIST_NULL,
	LIST_FULL,
	LIST_EMPTY,
	LIST_NOT_INTIALIZED
}ListReturn_t;

ListReturn_t ListArrayInit(List_t* _list);
ListReturn_t ListArrayFull(List_t* _list);
ListReturn_t ListArrayEmpty(List_t* _list);
ListReturn_t ListArrayInsert(List_t* _list, ListEntry_t  _entry);
ListReturn_t ListArrayRetrieve(List_t* _list, ListEntry_t* _entry);

ListReturn_t ListArrayTop(List_t* _list, ListEntry_t* _entry);
ListReturn_t ListArraySize(List_t* _list, int* _size);
ListReturn_t ListArrayClear(List_t* _list);
ListReturn_t ListArrayDisplay(List_t* _list);
ListReturn_t ListArrayTraverse(List_t* _list, void (*pvisit)(ListEntry_t));


#endif // !__LIST_ARRAY_H__
