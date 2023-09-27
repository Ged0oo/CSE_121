#include "ListLinked.h"

ListLinkedReturn_t ListLinkedInit(ListLinked_t* _list)
{
	ListLinkedReturn_t ret = LIST_LINKED_OK;
	if (NULL == _list)
	{
		ret = LIST_LINKED_NULL;
	}
	else
	{
		_list->head = NULL;
		_list->size = 0;
		ret = LIST_LINKED_OK;
	}
	return ret;
}


ListLinkedReturn_t ListLinkedFull(ListLinked_t* _list)
{

}


ListLinkedReturn_t ListLinkedEmpty(ListLinked_t* _list)
{

}


ListLinkedReturn_t ListLinkedInsert(ListLinked_t* _list, ListLinkedEntry_t  _entry, int _index)
{

}


ListLinkedReturn_t ListLinkedRetrieve(ListLinked_t* _list, ListLinkedEntry_t* _entry, int _index)
{

}


ListLinkedReturn_t ListLinkedDelete(ListLinked_t* _list, ListLinkedEntry_t* _entry, int _index)
{

}


ListLinkedReturn_t ListLinkedReplace(ListLinked_t* _list, ListLinkedEntry_t* _entry, int _index)
{

}


ListLinkedReturn_t ListLinkedSize(ListLinked_t* _list, int* _size)
{

}


ListLinkedReturn_t ListLinkedClear(ListLinked_t* _list)
{

}


ListLinkedReturn_t ListLinkedDisplay(ListLinked_t* _list)
{

}


ListLinkedReturn_t ListLinkedTraverse(ListLinked_t* _list, void (*pvisit)(ListLinkedEntry_t))
{

}