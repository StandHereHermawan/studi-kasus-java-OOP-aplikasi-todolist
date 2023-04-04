package repository;

import entity.ToDoList;

public class ToDoListRepositoryImpl implements ToDoListRepository {

    public ToDoList[] data = new ToDoList[10];

    public ToDoList[] getAll() {
        return data;
    }

    public boolean isFull() {
        //cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull() {
        //Jika penuh, kita resize ukuran Array 2x lipat
        if (isFull()) {
            var temp = data;
            data = new ToDoList[data.length * 2];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    public void add(ToDoList toDoList) {
        resizeIfFull();

        //tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = toDoList;
                break;
            }
        }
    }

    public boolean remove(Integer number) {
        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
