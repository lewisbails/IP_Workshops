import java.util.Collections;
import java.util.List;

public class Median implements Grader {

    public static int grade(Student student, String myClass){
        if (student.getClasses().contains(myClass)){
            List<Integer> grades = student.getGrades(myClass);
            Collections.sort(grades);
            int size = grades.size();
            return (size%2==0) ? (grades.get(size/2)+grades.get(size/2 -1))/2 : grades.get(size/2);
        }
        return 0;
    }
}
