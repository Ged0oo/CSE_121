#include "QueueArray.h"


QueueReturn_t QueueArrayInit(Queue_t* _queue)
{
	QueueReturn_t ret = QUEUE_OK;
	if (NULL == _queue)
	{
		ret = QUEUE_NULL;
	}
	else
	{
		_queue->front = 0;
		_queue->rear = -1;
		_queue->size = 0;
		ret = QUEUE_OK;
	}
	return ret;
}


QueueReturn_t QueueArrayFull(Queue_t* _queue)
{
	QueueReturn_t ret = QUEUE_OK;
	if (NULL == _queue)
	{
		ret = QUEUE_NULL;
	}
	else
	{
		if (MaxQueue == _queue->size)
		{
			ret = QUEUE_FULL;
		}
		else
		{
			ret = QUEUE_OK;
		}
	}
	return ret;
}


QueueReturn_t QueueArrayEmpty(Queue_t* _queue)
{
	QueueReturn_t ret = QUEUE_OK;
	if (NULL == _queue)
	{
		ret = QUEUE_NULL;
	}
	else
	{
		if (0 == _queue->size)
		{
			ret = QUEUE_EMPTY;
		}
		else
		{
			ret = QUEUE_OK;
		}
	}
	return ret;
}


QueueReturn_t QueueArrayAppend(Queue_t* _queue, QueueEntry_t  _entry)
{
	QueueReturn_t ret = QUEUE_OK;
	if (NULL == _queue)
	{
		ret = QUEUE_NULL;
	}
	else if (QUEUE_FULL == QueueArrayFull(_queue))
	{
		ret = QUEUE_FULL;
	}
	else
	{
		if ((MaxQueue - 1) == (_queue->rear))
		{
			_queue->rear = 0;
		}
		else
		{
			_queue->rear += 1;
		}
		_queue->entry[_queue->rear] = _entry;
		_queue->size += 1;
		ret = QUEUE_OK;
	}
	return ret;
}


QueueReturn_t QueueArrayServe(Queue_t* _queue, QueueEntry_t* _entry)
{
	QueueReturn_t ret = QUEUE_OK;
	if (NULL == _queue)
	{
		ret = QUEUE_NULL;
	}
	else if (QUEUE_EMPTY == QueueArrayEmpty(_queue))
	{
		ret = QUEUE_EMPTY;
	}
	else
	{
		*_entry = _queue->entry[_queue->front];

		if ((MaxQueue - 1) == (_queue->rear))
		{
			_queue->front = 0;
		}
		else
		{
			_queue->front += 1;
		}
		_queue->size -= 1;
		ret = QUEUE_OK;
	}
	return ret;
}


QueueReturn_t QueueArrayTop(Queue_t* _queue, QueueEntry_t* _entry)
{

}


QueueReturn_t QueueArraySize(Queue_t* _queue, int* _size)
{
	QueueReturn_t ret = QUEUE_OK;
	if (NULL == _queue)
	{
		ret = QUEUE_NULL;
	}
	else if (QUEUE_EMPTY == QueueArrayEmpty(_queue))
	{
		ret = QUEUE_EMPTY;
	}
	else
	{
		*_size = _queue->size;
		ret = QUEUE_OK;
	}
	return ret;
}


QueueReturn_t QueueArrayClear(Queue_t* _queue)
{
	QueueReturn_t ret = QUEUE_OK;
	if (NULL == _queue)
	{
		ret = QUEUE_NULL;
	}
	else if (QUEUE_EMPTY == QueueArrayEmpty(_queue))
	{
		ret = QUEUE_EMPTY;
	}
	else
	{
		_queue->front = 0;
		_queue->rear = -1;
		_queue->size = 0;
		ret = QUEUE_OK;
	}
	return ret;
}


QueueReturn_t QueueArrayDisplay(Queue_t* _queue)
{
	QueueReturn_t ret = QUEUE_OK;
	if (NULL == _queue)
	{
		ret = QUEUE_NULL;
	}
	else if (QUEUE_EMPTY == QueueArrayEmpty(_queue))
	{
		ret = QUEUE_EMPTY;
	}
	else
	{
		int counter = _queue->front;
		int size = 0;
		printf("\nQueue Display\n[ ");
		for (counter; size < _queue->size; size++)
		{
			printf(" %s ", _queue->entry[counter]);
			if ((MaxQueue - 1) == counter)
			{
				counter = 0;
			}
			else
			{
				counter += 1;
			}
		}
		printf(" ]\n");
		ret = QUEUE_OK;
	}
	return ret;
}


QueueReturn_t QueueArrayTraverse(Queue_t* _queue, void (*pvisit)(QueueEntry_t))
{
	QueueReturn_t ret = QUEUE_OK;
	if (NULL == _queue)
	{
		ret = QUEUE_NULL;
	}
	else if (QUEUE_EMPTY == QueueArrayEmpty(_queue))
	{
		ret = QUEUE_EMPTY;
	}
	else
	{
		int counter = _queue->front;
		int size = 0;
		for (counter; size < _queue->size; size++)
		{
			(*pvisit)(_queue->entry[counter]);
			if ((MaxQueue - 1) == counter)
			{
				counter = 0;
			}
			else
			{
				counter += 1;
			}
		}
		ret = QUEUE_OK;
	}
	return ret;
}

