package com.athuang.studentmanager;

import com.athuang.studentmanager.Student;

public class ArrayUtils {
    private ArrayUtils(){

    }

    public static int findIndexById(Student[] students, int id, int count){
        for (int i = 0; i < count; i++) {
            if (Integer.valueOf(id).equals(students[i].getId())){
                return i;
            }

        }
        return -1;
    }
}
