#include <stdio.h>
#include "QueueLinked/QueueLinked.h"

int main()
{
    QueueLinked_t queue;
    QueueLinkedReturn_t ret = QUEUE_LINKED_OK;
    QueueEntry_t qu ;
    int size=0;

    ret = QueueLinkedInit(&queue);
    ret = QueueLinkedEmpty(&queue);

    ret = QueueLinkedAppend(&queue, 3);
    ret = QueueLinkedAppend(&queue, 6);
    ret = QueueLinkedAppend(&queue, 8);

    printf("\nHello World\n");
    return 0;
}
