#include <stdio.h>
#include "QueueArray/QueueArray.h"

int main()
{
    Queue_t queue;
    QueueReturn_t ret = QUEUE_OK;
    QueueEntry_t qu ;
    int size=0;

    ret = QueueArrayInit(&queue);
    ret = QueueArrayFull(&queue);
    ret = QueueArrayEmpty(&queue);

    ret = QueueArrayAppend(&queue, 2);
    ret = QueueArrayAppend(&queue, 7);
    ret = QueueArrayAppend(&queue, 5);
    ret = QueueArrayAppend(&queue, 3);

    ret = QueueArrayTop(&queue, &qu);
    ret = QueueArraySize(&queue, &size);

    ret = QueueArrayClear(&queue);

    ret = QueueArrayFull(&queue);
    ret = QueueArrayEmpty(&queue);

    ret = QueueArrayServe(&queue, &qu);
    ret = QueueArrayServe(&queue, &qu);

    ret = QueueArrayTop(&queue, &qu);

    printf("\nHello World\n");
    return 0;
}
