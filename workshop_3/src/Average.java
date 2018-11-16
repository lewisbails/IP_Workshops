public class Average implements Grader {

    public static int grade(Student student, String myClass){
        if (student.getClasses().contains(myClass)){
            int sum = 0;
            for (int score : student.getGrades(myClass)){
                sum+=score;
            }
            return sum/student.getGrades(myClass).size();
        }
        return 0;
    }
}
