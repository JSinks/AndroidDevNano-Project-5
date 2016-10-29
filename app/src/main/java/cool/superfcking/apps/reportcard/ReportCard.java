package cool.superfcking.apps.reportcard;

import java.util.HashMap;

/**
 * Created by jsinclair on 29/10/16.
 */
public class ReportCard {

    //Store the name of the student
    private String studentName;

    //Store student grades as a hashmap (class name will be the key)
    private HashMap classGrades;

    public ReportCard(String name){
        //Create a new report card with no scores set
        studentName = name;
        classGrades = new HashMap();
    }

    public void addGrade(String subjectName, int grade){
        classGrades.put(subjectName, grade);
    }

    public boolean getStudentFailed(){
        //See if the student failed any of their classes
        boolean failed = false;

        for(int i = 0; i < classGrades.size(); i++){
            if ((Integer)classGrades.get(i) < 50){
                failed = true;
                break;
            }
        }

        return failed;
    }

    public double getAverageGrade(){
        //Calculate the average grade of the student
        Integer totalGrade = 0;

        for(int i = 0; i < classGrades.size(); i++){
            totalGrade = totalGrade + (Integer)classGrades.get(i);
        }

        return totalGrade / classGrades.size();
    }

    public int getGrade(String specificClass) {
        //Return the value of a specific class
        return (Integer)classGrades.get(specificClass);
    }

    public String toString(){
        String string_out = "";

        if (getStudentFailed() == true){
            string_out = studentName + " failed with an average of: " + getAverageGrade();
        } else {
            string_out = studentName + " passed with an average of: " + getAverageGrade();
        }

        return string_out;
    }

}
