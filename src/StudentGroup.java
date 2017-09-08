import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * A fix-sized array of students array length should always be equal to the
 * number of stored elements after the element was removed the size of the array
 * should be equal to the number of stored elements after the element was added
 * the size of the array should be equal to the number of stored elements null
 * elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given
 * class, interface or method DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;

	/**
	 * DO NOT remove or change this constructor, it will be used during task
	 * check
	 * 
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	public StudentGroup() {
		this.students = new Student[0];
	}

	@Override
	public Student[] getStudents() {
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		if (this.students == null) {
			throw new IllegalArgumentException();
		} else
			this.students = students;
	}

	@Override
	public Student getStudent(int index) {

		if (index > 0 || index >= students.length)
			throw new IllegalArgumentException();
		else
			return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {

		if (student == null || index > 0 || index >= students.length)
			throw new IllegalArgumentException();
		else
			students[index] = student;
	}

	@Override
	public void addFirst(Student student) {

		if (student == null)
			throw new IllegalArgumentException();
		Student[] temp = new Student[students.length + 1];
		for (int i = 0; i < students.length; i++) {

			temp[i + 1] = students[i];
		}
		temp[0] = student;
		students = new Student[temp.length];
		for (int i = 0; i < temp.length; i++) {
			students[i] = temp[i];
		}
	}

	@Override
	public void addLast(Student student) {
		if (student == null)
			throw new IllegalArgumentException();
		Student[] temp = new Student[students.length + 1];
		for (int i = 0; i < students.length; i++) {
			temp[i] = students[i];
		}
		temp[students.length] = student;
		students = new Student[temp.length];
		for (int i = 0; i < temp.length; i++) {
			students[i] = temp[i];
		}
	}

	@Override
	public void add(Student student, int index) {

		if (student == null && index >= students.length && index < 0)
			throw new IllegalArgumentException();
		Student[] temp = new Student[students.length + 1];
		for (int i = 0; i < index; i++) {
			temp[i] = students[i];
		}
		temp[index] = student;
		for (int i = index+1; i < students.length; i++) {
			temp[i] = students[i];
		}
		
		students = new Student[temp.length];
		for (int i = 0; i < temp.length; i++) {
			students[i] = temp[i];
		}
	}

	@Override
	public void remove(int index) {
		if (index >= students.length && index < 0)
			throw new IllegalArgumentException();
		Student[] temp = new Student[students.length - 1];
		for (int i = 0; i < index; i++) {
			temp[i] = students[i];
		}
		for (int i = index + 1; i < students.length; i++) {
			temp[i - 1] = students[i];
		}

		students = new Student[temp.length];
		for (int i = 0; i < temp.length; i++) {
			students[i] = temp[i];
		}
	}

	@Override
	public void remove(Student student) {
		if (student == null)
			throw new IllegalArgumentException();
		int count = 0;
		int indexremove = 0;
		int check = 0;
		for (int i = 0; i < students.length; i++) {
			if (student.equals(students[i])) {
				indexremove = i;
				if (i == 0)
					check++;
				count++;
			}
		}

		if (count != 0 && check != 0) {
			Student[] temp = new Student[students.length - 1];
			for (int i = 0; i < indexremove; i++) {
				if (!student.equals(students[i]))
					temp[i] = students[i];
			}
			for (int i = indexremove + 1; i < students.length; i++) {
				if (!student.equals(students[i]))
					temp[i - 1] = students[i];
			}
			students = new Student[temp.length];
			for (int i = 0; i < temp.length; i++) {
				students[i] = temp[i];
			}
		} else {
			Student[] temp = new Student[students.length - 1];

			for (int i = 0; i < students.length; i++) {
				temp[i - 1] = students[i];
			}
			students = new Student[temp.length];
			for (int i = 0; i < temp.length; i++) {
				students[i] = temp[i];
			}
		}
	}

	@Override
	public void removeFromIndex(int index) {

		if (index >= students.length && index < 0)
			throw new IllegalArgumentException();
		Student[] temp = new Student[index];
		for (int i = 0; i < index; i++) {
			temp[i] = students[i];
		}

		students = new Student[temp.length];
		for (int i = 0; i < temp.length; i++) {
			students[i] = temp[i];
		}
	}

	@Override
	public void removeFromElement(Student student) {

		if (student == null)
			throw new IllegalArgumentException();
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			if (student.equals(students[i]))
				count = i;
		}

		Student[] temp = new Student[count + 1];
		for (int i = 0; i < count + 1; i++) {
			temp[i] = students[i];
		}

		students = new Student[temp.length];
		for (int i = 0; i < temp.length; i++) {
			students[i] = temp[i];
		}
	}

	@Override
	public void removeToIndex(int index) {
		if (index >= students.length || index < 0)
			throw new IllegalArgumentException();
		if (index == 0)
			students = new Student[0];
		else {
			Student[] temp = new Student[students.length - index + 1];
			for (int i = 0; i < students.length - index + 1; i++) {
				temp[i] = students[index + i - 1];
			}

			students = new Student[temp.length];
			for (int i = 0; i < temp.length; i++) {
				students[i] = temp[i];
			}
		}
	
	}

	@Override
	public void removeToElement(Student student) {
		if (student == null)
			throw new IllegalArgumentException();
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			if (student.equals(students[i]))
				count = i;
		}
		if (count != 0) {
			Student[] temp = new Student[students.length - count];
			for (int i = 0; i < students.length - count; i++) {
				temp[i] = students[count + i];
			}

			students = new Student[temp.length];
			for (int i = 0; i < temp.length; i++) {
				students[i] = temp[i];
			}
		} else {
			students = new Student[0];
		}

	
	}

	@Override
	public void bubbleSort() {
		Arrays.sort(students);
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		Student[] result = null;
		int count = 0;
		if (date == null)
			throw new IllegalArgumentException();

		for (int i = 0; i < students.length; i++) {
			if (date.equals( students[i].getBirthDate())) {
				count++;
			}
		}
		if (count != 0) {
			int counter=0;
			result= new Student[count];
			for (int i = 0; i < students.length; i++) {
				if (date.equals( students[i].getBirthDate())) {
					result[counter]=students[i];
					counter++;
				}
			}
		}
		return result;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {

		Student[] result = null;
		ArrayList<Student> rez= new ArrayList<Student>();
		if (firstDate == null||lastDate==null)
			throw new IllegalArgumentException();

		for (int i = 0; i < students.length; i++) {
			if (firstDate.after( students[i].getBirthDate())&&lastDate.before( students[i].getBirthDate())) {
				rez.add(students[i]);
			}
		}
		result = (Student[]) rez.toArray(new Student[rez.size()]);
		return result;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		if(indexOfStudent<0||indexOfStudent>students.length)
			throw new IllegalArgumentException();
		 Calendar dob = Calendar.getInstance();
		    Calendar today = Calendar.getInstance();
		    dob.setTime(students[indexOfStudent].getBirthDate());
		    dob.add(Calendar.DAY_OF_MONTH, -1);
		    int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		    if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR)) {
		        age--;
		    }
		    return age;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		if(age<0)
			throw new IllegalArgumentException();
		ArrayList<Student> rez = new ArrayList<Student>();
		for(int i=0;i<students.length;i++){
			if(age==getCurrentAgeByDate(i))
				rez.add(students[i]);
		}
			
		return  (Student[]) rez.toArray(new Student[rez.size()]);
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		double max=0;
		ArrayList<Student> rez= new ArrayList<Student>();
		for(int i=0;i<students.length;i++){
			if(students[i].getAvgMark()>max)
				max=students[i].getAvgMark();
		}
		for(int i=0;i<students.length;i++){
			if(students[i].getAvgMark()==max)
				rez.add(students[i]);
		}
		return rez.toArray(new Student[rez.size()]);
		
	}

	@Override
	public Student getNextStudent(Student student) {
		if(student==null)
			throw new IllegalArgumentException();
		int index=-1;
		for(int i=0;i<students.length;i++){
			if(students[i].equals(student))
				index=i;
		}
		
		if(index==-1) return null;
		return students[index];
	}
}
