import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UnivercityService <T extends Entity>{
    T table;
    public UnivercityService(T table){
        this.table=table;
    }

    public void add(T table){
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into "+ table.toString() +"(fname,lname) VALUES(?,?)")) {
            preparedStatement.setString(1,table.getFname());
            preparedStatement.setString(2,table.getLname());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("can not add this record");
        }
    }
    public void delete(int id,T t){
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from "+table.toString()+" where id=?")) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("can not delete this record");
        }
    }
    public void Display() {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from "+ table.toString());
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
            System.out.println("There is a problem");
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
            System.out.println("There is a problem");
        }
    }
    public void selectTeacher(int studentId,int teacherId){
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student_teacher(student_id,teacher_id) VALUES(?,?)")) {
            preparedStatement.setInt(1,studentId);
            preparedStatement.setInt(2,teacherId);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("There is a problem");
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
            System.out.println("There is a problem");
        }
    }
    public void edit(String fname,String lname,int where,T t){
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("UPDATE "+table.toString()+" set fname=?,lname=? where ID=?")) {
            preparedStatement.setString(1,fname);
            preparedStatement.setString(2,lname);
            preparedStatement.setInt(3,where);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("There is a problem");
        }
    }

}