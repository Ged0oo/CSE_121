#include <stdio.h>
#include "ListArray/ListArray.h"

int main()
{
    List_t list;
    ListEntry_t entry;
    ListReturn_t ret = LIST_OK;

    ret = ListArrayInit(&list);
    ret = ListArrayFull(&list);
    ret = ListArrayEmpty(&list);

    ret = ListArrayInsert(&list, 6, 0);
    ret = ListArrayInsert(&list, 1, 1);
    ret = ListArrayInsert(&list, 5, 2);
    ret = ListArrayInsert(&list, 9, 3);
    ret = ListArrayInsert(&list, 7, 4);

    printf("\nHello World\n");
    return 0;
}
