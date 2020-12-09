import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Student student=new Student();
        Teacher teacher=new Teacher();
        UnivercityService<Student> studentUnivercityService=new UnivercityService<>(student);
        UnivercityService<Teacher> teacherUnivercityService=new UnivercityService<>(teacher);
        String ask="";
        System.out.println(" ====================================");
        System.out.println("| What operation do you want to do?  |");
        System.out.println("|      1-----add     Student         |");
        System.out.println("|      2-----add     Teacher         |");
        System.out.println("|      3-----Edit    Student         |");
        System.out.println("|      4-----Edit    Teacher         |");
        System.out.println("|      5-----Delete  Student         |");
        System.out.println("|      6-----Delete  Teacher         |");
        System.out.println("|      7-----student Display         |");
        System.out.println("|      8-----teacher Display         |");
        System.out.println("|      9-student_teacher Display     |");
        System.out.println("|      10----select  Teacher         |");
        System.out.println("|      11----student    List         |");
        System.out.println("|      12---------exit               |");
        System.out.println(" ====================================");
      do{

          System.out.println("What operation do you want to do? ");
          ask=scanner.next();
          switch (ask){
              case "1":
                  System.out.println("fname : ");
                  String fname=scanner.next();
                  System.out.println("lname : ");
                  String lname=scanner.next();
                  Student student2=new Student(fname,lname);
                  studentUnivercityService.add(student2);
                  break;
              case "2" :
                  System.out.println("fname : ");
                  String fnamet=scanner.next();
                  System.out.println("lname : ");
                  String lnamet=scanner.next();
                  Teacher teacher2=new Teacher(fnamet,lnamet);
                  teacherUnivercityService.add(teacher2);
                  break;
              case "3" :
                  System.out.println("where : enter id");
                  int where= scanner.nextInt();
                  System.out.println("set fname :");
                  String firstname=scanner.next();
                  System.out.println("set lname");
                  String lastname=scanner.next();
                  studentUnivercityService.edit(firstname,lastname,where,student);
                  break;
              case "4" :
                  System.out.println("where : enter id");
                  int whereteacher= scanner.nextInt();
                  System.out.println("set fname :");
                  String firstname2=scanner.next();
                  System.out.println("set lname");
                  String lastname2=scanner.next();
                  teacherUnivercityService.edit(firstname2,lastname2,whereteacher,teacher);
                  break;
              case "5" :
                  System.out.println("enter student id");
                  int id=scanner.nextInt();
                  studentUnivercityService.delete(id,student);
                  break;
              case "6" :
                  System.out.println("enter teacher id");
                  int idteacher=scanner.nextInt();
                 teacherUnivercityService.delete(idteacher,teacher);
                  break;
              case "7" :
                  studentUnivercityService.Display();
                  break;
              case "8" :
                  teacherUnivercityService.Display();
                  break;
              case "9" :
                  studentUnivercityService.student_teacherDisplay();
                  break;
              case "10" :
                  teacherUnivercityService.Display();
                  System.out.println("enter your id :");
                  int studentId=scanner.nextInt();
                  System.out.println("enter teacher id :");
                  int teacherId=scanner.nextInt();
                  teacherUnivercityService.selectTeacher(studentId,teacherId);
                  break;
              case "11" :
                  System.out.println("enter teacher id :");
                  int teacher_id=scanner.nextInt();
                  teacherUnivercityService.studentList(teacher_id);
                  break;
          }
          System.out.println("=====================================");
      }while (!ask.equals("12"));
    }
}
