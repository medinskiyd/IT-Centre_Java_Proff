package week1.ArrayList;


/**
 * Created by Дмитрий on 18.01.14.
 * Написать собственную, непараметризированную реализацию класса ArrayList (MyArrayList)

 Реализовать методы

 add( E)
 add(index, E)
 remove(index)
 set(index, e)
 int indexOf( E)
 boolean contains( E) - выясняет есть ли такой элемент в списке
 int size()
 void clear() - удаляет все элементы из списка
 boolean equals(MyArrayList) - сравнивает два списка
 */

public class MyArrayList {

    private int newArrayEl; // Символ 1 строки.
    private int arrayLength = 100; // Размер 1 строки.
    private int string [] = new int[this.arrayLength]; // Строка.
    int i; // для счетчика 1.
    private int indexEl; // Индеск элемента.
    public int addString [] = new int[this.arrayLength + 1]; // Строка с добавленным элементом.
    public int StringDelEl [] = new int[this.arrayLength]; // Строка с удаленным элементом.

    //Метод записыает размер 1 массива.
    public void setStringLength(int stringLength) {
        this.arrayLength = stringLength;
    }

    //Метод возращает размер 1 массива.
    public int getStringLength() {
        return this.arrayLength;
    }

    //Присвоение элементу массива значения.
    public void setEl(int newArrayEl) {
        this.string[i] = newArrayEl;
    }

    //Чтение элемента массива.
    public int getEl() {
        return this.string[i];
    }

    // Добавление элемента в строку.
    public void addEl (int newEl) {
        for (int i = 0; i < this.arrayLength+1; i++) {

            if (i < this.arrayLength) {
                this.addString[i] = this.string[i];
            }
            if (i == this.arrayLength) {
                this.addString[this.arrayLength] = newEl;
            }
        }
    }

    //Чтение элемента массива после добавления элемента.
    public int getEl2() {
        return this.addString[i];
    }

    // Поиск индекса элемента.
    public int indexOf (int el) {

        for (int i = 0; i < this.arrayLength+1; i++) {

            if (this.addString[i] == el) {
                this.indexEl = i;
            }
        }
        return this.indexEl;
    }

    // Удалить элемент строки.
    public void delEl (int NumDelel) {

        for (int i = 0; i < this.arrayLength; i++) {

            if (i < NumDelel-1) {
                StringDelEl[i] = addString[i];
            } else if (i >= NumDelel-1) {
                StringDelEl[i] = addString[i+1];
            }
        }
    }

    //Чтение элемента массива после удаления элемента.
    public int getAfterDel() {
        return this.StringDelEl[i];
    }

}

