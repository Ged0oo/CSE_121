#include "ListArray.h"

ListReturn_t ListArrayInit(List_t* _list)
{
	ListReturn_t ret = LIST_OK;
	if (NULL == _list)
	{
		ret = LIST_NULL;
	}
	else
	{
		_list->size = 0;
		ret = LIST_OK;
	}
	return ret;
}


ListReturn_t ListArrayFull(List_t* _list)
{
	ListReturn_t ret = LIST_OK;
	if (NULL == _list)
	{
		ret = LIST_NULL;
	}
	else
	{
		if (_list->size >= MaxList)
			ret = LIST_FULL;
		else
			ret = LIST_OK;
	}
	return ret;
}


ListReturn_t ListArrayEmpty(List_t* _list)
{
	ListReturn_t ret = LIST_OK;
	if (NULL == _list)
	{
		ret = LIST_NULL;
	}
	else
	{
		if (0 ==_list->size)
			ret = LIST_EMPTY;
		else
			ret = LIST_OK;
	}
	return ret;
}


ListReturn_t ListArrayInsert(List_t* _list, ListEntry_t  _entry)
{

}


ListReturn_t ListArrayRetrieve(List_t* _list, ListEntry_t* _entry)
{

}


ListReturn_t ListArrayTop(List_t* _list, ListEntry_t* _entry)
{

}


ListReturn_t ListArraySize(List_t* _list, int* _size)
{
	ListReturn_t ret = LIST_OK;
	if (NULL == _list)
	{
		ret = LIST_NULL;
	}
	else
	{
		*_size = _list->size;
		ret = LIST_OK;
	}
	return ret;
}


ListReturn_t ListArrayClear(List_t* _list)
{
	ListReturn_t ret = LIST_OK;
	if (NULL == _list)
	{
		ret = LIST_NULL;
	}
	else if (LIST_EMPTY == ListArrayEmpty(_list))
	{
		ret = LIST_EMPTY;
	}
	else
	{
		_list->size = 0;
		ret = LIST_OK;
	}
	return ret;
}


ListReturn_t ListArrayDisplay(List_t* _list)
{

}


ListReturn_t ListArrayTraverse(List_t* _list, void (*pvisit)(ListEntry_t))
{
	ListReturn_t ret = LIST_OK;
	if (NULL == _list)
	{
		ret = LIST_NULL;
	}
	else if (_list->size < -1)
	{
		ret = LIST_NOT_INTIALIZED;
	}
	else if (LIST_EMPTY == ListArrayFull(_list))
	{
		ret = LIST_EMPTY;
	}
	else
	{
		for (int i = _list->size; i >= 0; i--)
			(*pvisit)(_list->entry[i]);
		ret = LIST_OK;
	}
	return ret;
}
