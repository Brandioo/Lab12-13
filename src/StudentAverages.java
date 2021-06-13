//Brand BINF-A

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentAverages {

    static class Student implements Comparable<Student> {
        String name, surname;
        double average;
        int cnt = 0, sum = 0;

        Student(String n, String s, ArrayList<Integer> a) {
            name = n;
            surname = s;
            for (int i = 0; i < a.size(); i++) {
                sum += a.get(i);
                cnt++;
            }
            average = (double) sum / cnt;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", average=" + average +
                    '}';
        }

        public int compareTo(Student student) {
            if (this.average < student.average) return 1;
            else if (this.average > student.average) return -1;
            else return 0;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String name, surname;
        Student[] StudentList = new Student[n];
        ArrayList<Integer> list = new ArrayList<>();

        int grade;
        for (int i = 0; i < n; i++) {
            name = sc.next();
            surname = sc.next();
            for (int j = 0; j < 4; j++) {
                grade = sc.nextInt();
                list.add(grade);
            }
            StudentList[i] = new Student(name, surname, list);
            list.clear();
        }
        System.out.println("Before sorting: ");
        for (int i = 0; i < StudentList.length; i++)
            System.out.println(StudentList[i]);

        Arrays.sort(StudentList);

        System.out.println("\nAfter sorting: ");
        for (int i = 0; i < n; i++)
            System.out.println(StudentList[i]);
    }
}

