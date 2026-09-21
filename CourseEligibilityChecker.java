enum CourseType {
    CORE,
    ELECTIVE,
    LAB
}

enum StudentLevel {
    FRESHMAN,
    SOPHOMORE,
    SENIOR
}

public class CourseEligibilityChecker {

    public static void main(String[] args) {

        StudentLevel level = StudentLevel.SOPHOMORE;
        CourseType course = CourseType.CORE;
        int assignmentScore = 82;
        int bonusPoints = 17;

        int maxCourses = 0;
        int finalScore;
        boolean isEligible;

        // 1. ARITHMETIC OPERATOR: Calculate finalScore
        finalScore = assignmentScore + (bonusPoints % 5);

        // 2. SWITCH STATEMENT: Determine the maxCourses based on StudentLevel
        switch (level) {
            case FRESHMAN:
                maxCourses = 4;
                break;
            case SOPHOMORE:
                maxCourses = 5;
                break;
            case SENIOR:
                maxCourses = 6;
                break;
            default:
                maxCourses = 3; // Safety default
        }

        // 3. IF-ELSE/LOGICAL OPERATORS: Determine eligibility
        if (level != StudentLevel.FRESHMAN && assignmentScore >= 70) {
            isEligible = true;
        } else {
            isEligible = false;
        }

        // --- Output ---
        System.out.println("--- Course Management System Check ---");
        System.out.println("Student Level: " + level);
        System.out.println("Course Type: " + course);
        System.out.println("Final Score: " + finalScore);
        System.out.println("Max Courses Allowed: " + maxCourses);
        System.out.println("Eligibility Status: " + (isEligible ? "YES" : "NO"));
    }
}