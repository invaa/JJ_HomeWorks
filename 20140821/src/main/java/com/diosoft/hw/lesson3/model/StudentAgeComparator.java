package main.java.com.diosoft.hw.lesson3.model;

/**
 * Allows to compare two <code>Student</code> objects by age
 *
 * @author a.zamkovyi
 * @version 0.0.1
 */

import java.util.Comparator;


public class StudentAgeComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {

        if (!(o1 instanceof Student) || !(o2 instanceof Student)) {
            throw new RuntimeException("Wrong argument type when comparing two Student obejcts!");
        } //end if

        Student s1 = (Student) o1;
        Student s2 = (Student) o2;

        if (s1.equals(s2)) {
            return 0;
        } //end if

        if (s1.getAge() == s2.getAge()) {
            return 0;
        } else if (s1.getAge() > s2.getAge()) {
            return 1;
        } else {
            return -1;
        } //end if
    }
}
