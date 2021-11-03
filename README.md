# task2.2sem
 Аналог пузырьковой сортировки для очереди (вспомогательные списки / массивы / очереди не применять). Подсказка: Внутренний цикл пузырьковой сортировки можно представить следующим алгоритмом: извлекается элемент из очереди и запоминается в переменной tmp. Далее (выполняется n-1 раз, n – кол-во элементов в очереди) извлекается элемент из очереди, сравнивается c tmp: меньшее значение записывается в очередь, большее запоминается в tmp. В результате в tmp остается наибольший элемент, который записывается в очередь (в конец). Аналогично ищется 2-ой по величине элемент (кол-во итераций n-2), записывается в конец очереди, а затем из начала очереди в конец переписывается наибольший элемент. И т.д. Сложность алгоритма будет O(n2)
