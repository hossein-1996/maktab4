import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UnivercityService {

   public void addStudent(Student student){
       try(Connection connection = ConnectionFactory.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement
                   ("insert into student(fname,lname) VALUES(?,?)")) {
           preparedStatement.setString(1,student.getFname());
           preparedStatement.setString(2,student.getLname());
           preparedStatement.executeUpdate();
       } catch (SQLException sqlException) {
           sqlException.printStackTrace();
       }
   }
    public void addTeacher(Teacher teacher){
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into teacher(fname,lname) VALUES(?,?)")) {
            preparedStatement.setString(1,teacher.getFname());
            preparedStatement.setString(2,teacher.getLname());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public void deleteStudent(int id){
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id=?")) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
                sqlException.printStackTrace();
        }
    }
    public void deleteTeacher(int id){
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("delete from teacher where id=?")) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public void studentDisplay() {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                System.out.print("id : " + resultSet.getInt("id"));
                System.out.print("\t");
                System.out.print("fname : " + resultSet.getString("fname"));
                System.out.print("\t");
                System.out.print("lname : " + resultSet.getString("lname"));
                System.out.println();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public void teacherDisplay() {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from teacher");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                System.out.print("id : " + resultSet.getInt("id"));
                System.out.print("\t");
                System.out.print("fname : " + resultSet.getString("fname"));
                System.out.print("\t");
                System.out.print("lname : " + resultSet.getString("lname"));
                System.out.println();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public void student_teacherDisplay() {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from student_teacher");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                System.out.print("student_id : " + resultSet.getInt("student_id"));
                System.out.print("\t");
                System.out.print("teacher_id : " + resultSet.getInt("teacher_id"));
                System.out.println();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public void selectTeacher(int studentId,int teacherId){
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student_teacher(student_id,teacher_id) VALUES(?,?)")) {
            preparedStatement.setInt(1,studentId);
            preparedStatement.setInt(2,teacherId);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public void studentList(int teacherId){
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("SELECT student.ID,student.fname,student.lname,student_teacher.teacher_id " +
                             "from student_teacher " +
                             "join student on student.ID=student_teacher.student_id" +
                             " where student_teacher.teacher_id=?")){
             preparedStatement.setInt(1,teacherId);
             ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("ID : " + resultSet.getInt("ID"));
                System.out.print("\t");
                System.out.print("fname : " + resultSet.getString("fname"));
                System.out.print("\t");
                System.out.print("lname : " + resultSet.getString("lname"));
                System.out.print("\t");
                System.out.print("teacher_id : " + resultSet.getInt("teacher_id"));
                System.out.println();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public void editStudent(String fname,String lname,int where){
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("UPDATE student set fname=?,lname=? where ID=?")) {
            preparedStatement.setString(1,fname);
            preparedStatement.setString(2,lname);
            preparedStatement.setInt(3,where);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public void editTeacher(String fname,String lname,int where){
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE teacher set fname=?,lname=? where ID=?")) {
            preparedStatement.setString(1,fname);
            preparedStatement.setString(2,lname);
            preparedStatement.setInt(3,where);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

