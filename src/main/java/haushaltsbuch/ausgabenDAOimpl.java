package haushaltsbuch;

import java.util.*;

public class ausgabenDAOimpl implements ausgabenDAO {
	
   //list is working as a database
   List<ausgaben> ausgaben;

   public ausgabenDAOimpl(){
	  ausgaben = new ArrayList<ausgaben>();
	  ausgaben ausgabe1 = new ausgaben();
	  ausgaben.add(ausgabe1);
   }
   @Override
   public void deleteStudent(Student student) {
      students.remove(student.getRollNo());
      System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
   }

   //retrive list of students from the database
   @Override
   public List<Student> getAllStudents() {
      return students;
   }

   @Override
   public Student getStudent(int rollNo) {
      return students.get(rollNo);
   }

   @Override
   public void updateStudent(Student student) {
      students.get(student.getRollNo()).setName(student.getName());
      System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
   }
@Override
public ausgaben getExp() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public List<ausgaben> getAllExp() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public boolean insertExp(ausgaben ausgaben) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean updateExp(ausgaben ausgaben) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean deleteExp(ausgaben ausgaben) {
	// TODO Auto-generated method stub
	return false;
}
}