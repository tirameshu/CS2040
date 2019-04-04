/*
 * Name       : Wang Xinman 
 * Matric No. : A0180257E
 * Plab Acct. : -
 */
import java.util.*;

public class Classphoto {
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		TreeSet<Student> students = new TreeSet<>();
		PriorityQueue<Student> queue = new PriorityQueue<>();
		Student rar = new Student("Rar", 0, 0);
		students.add(rar);
		queue.offer(rar);

		int n = sc.nextInt(); //number of students
		int index = 0;
		for (int i = 0; i < n; i++) {
			index++;
			String name = sc.next();
			long height = sc.nextLong();
			Student student = new Student(name, height, index);
			Student pre = students.lower(student);
			System.out.println(pre.name);
			students.add(student);
			queue.add(student);
		}

		int size = queue.size();
		for (int j = 0; j < size - 1; j++) {
			System.out.print(queue.poll().name + " ");
		}
		System.out.println(queue.poll().name);
	}
	public static void main(String[] args) {
		Classphoto newClassphoto = new Classphoto();
		newClassphoto.run();
	}
}

class Student implements Comparable<Student> {
	String name;
	long height;
	int index;

	public Student(String name, long height, int index) {
		this.name = name;
		this.height = height;
		this.index = index;
	}

	public int compareTo(Student other) {
		if (this.height == other.height) {
			return other.index - this.index;
		}
		return Long.compare(this.height, other.height);
	}
}
