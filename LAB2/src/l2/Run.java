package l2;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu1 = new Student("M");
		Student stu2 = new Student("Mone");
		
		stu1.setMidtermScore(100);
		stu1.setFinalScore(100);
		
		stu2.setMidtermScore(100);
		stu2.setFinalScore(100);
		
		stu1.getAverageScore();
		stu1.getGrade();
		System.out.println(stu1.getAverageScore());
		System.out.println(stu1.getGrade());
		
		Course c1 = new Course("Java");
		c1.addStudent(stu1);
		c1.addStudent(stu2);
		
		c1.listStudent();
		c1.getCourseAverage();
		System.out.println("Course GPA Stu1 : "+c1.convertGradeToGPA(stu1));
		System.out.println("Course GPA Stu2 : "+c1.convertGradeToGPA(stu2));
		System.out.println("Course AVG Score : "+c1.getCourseAverage());
		c1.getCourseGPA();
		System.out.println("Course AVG GPA : "+c1.getCourseGPA());
		
	}

}
