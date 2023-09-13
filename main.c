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

    ret = QueueLinkedTop(&queue, &qu);

    ret = QueueLinkedServe(&queue, &qu);
    ret = QueueLinkedServe(&queue, &qu);

    ret = QueueLinkedTop(&queue, &qu);

    printf("\nHello World\n");
    return 0;
}
