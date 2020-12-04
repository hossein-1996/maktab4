import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        UnivercityService univercityService=new UnivercityService();
      String ask="";
        System.out.println("What operation do you want to do? ");
        System.out.println(" 1-add     Student");
        System.out.println(" 2-add     Teacher");
        System.out.println(" 3-Edit    Student");
        System.out.println(" 4-Edit    Teacher");
        System.out.println(" 5-Delete  Student");
        System.out.println(" 6-Delete  Teacher");
        System.out.println(" 7-student Display");
        System.out.println(" 8-teacher Display");
        System.out.println(" 9-student_teacher Display ");
        System.out.println(" 10-select Teacher");
        System.out.println(" 11-student   List");
        System.out.println(" 12-exit");
      do{

          ask=scanner.next();
          switch (ask){
              case "1":
                  System.out.println("fname : ");
                  String fname=scanner.next();
                  System.out.println("lname : ");
                  String lname=scanner.next();
                  Student student=new Student(fname,lname);
                  univercityService.addStudent(student);
                  break;
              case "2" :
                  System.out.println("fname : ");
                  String fnamet=scanner.next();
                  System.out.println("lname : ");
                  String lnamet=scanner.next();
                  Teacher teacher=new Teacher(fnamet,lnamet);
                  univercityService.addTeacher(teacher);
                  break;
              case "3" :
                  System.out.println("where : enter id");
                  int where= scanner.nextInt();
                  System.out.println("set fname :");
                  String firstname=scanner.next();
                  System.out.println("set lname");
                  String lastname=scanner.next();
                  univercityService.editStudent(firstname,lastname,where);
                  break;
              case "4" :
                  System.out.println("where : enter id");
                  int whereteacher= scanner.nextInt();
                  System.out.println("set fname :");
                  String firstname2=scanner.next();
                  System.out.println("set lname");
                  String lastname2=scanner.next();
                  univercityService.editTeacher(firstname2,lastname2,whereteacher);
                  break;
              case "5" :
                  System.out.println("enter student id");
                  int id=scanner.nextInt();
                  univercityService.deleteStudent(id);
                  break;
              case "6" :
                  System.out.println("enter teacher id");
                  int idteacher=scanner.nextInt();
                  univercityService.deleteTeacher(idteacher);
                  break;
              case "7" :
                  univercityService.studentDisplay();
                  break;
              case "8" :
                  univercityService.teacherDisplay();
                  break;
              case "9" :
                  univercityService.student_teacherDisplay();
                  break;
              case "10" :
                  univercityService.teacherDisplay();
                  System.out.println("enter your id :");
                  int studentId=scanner.nextInt();
                  System.out.println("enter teacher id :");
                  int teacherId=scanner.nextInt();
                  univercityService.selectTeacher(studentId,teacherId);
                  break;
              case "11" :
                  System.out.println("enter teacher id :");
                  int teacher_id=scanner.nextInt();
                  univercityService.studentList(teacher_id);
                  break;
          }

      }while (!ask.equals("12"));
    }
}
