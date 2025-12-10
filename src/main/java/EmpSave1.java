import java.util.List;
import java.util.Scanner;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpSave1 {

    public static void main(String[] args) {

        // Load Hibernate Configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");   // correct path
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Scanner sc = new Scanner(System.in);
        Transaction tx;

        while (true) {
            System.out.println("\n====== Employee CRUD Menu ======");
            System.out.println("1. Insert Employee");
            System.out.println("2. Display Employee by ID");
            System.out.println("3. Delete Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();

            switch (option) {

                // INSERT EMPLOYEE
                case 1:
                    sc.nextLine();  // clear buffer
                    System.out.print("Enter Name: ");
                    String ename = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Designation: ");
                    String desig = sc.nextLine();

                    Employee emp = new Employee(0, ename, sal, desig);

                    tx = session.beginTransaction();
                    session.save(emp);
                    tx.commit();

                    System.out.println("✔ Employee Inserted Successfully.");
                    break;

                // DISPLAY EMPLOYEE BY ID
                case 2:
                    System.out.print("Enter Employee ID: ");
                    int eid = sc.nextInt();

                    Employee e = session.get(Employee.class, eid);
                    if (e != null)
                        System.out.println(e);
                    else
                        System.out.println("❌ Employee Not Found!");
                    break;

                // DELETE EMPLOYEE
                case 3:
                    System.out.print("Enter Employee ID to Delete: ");
                    int delId = sc.nextInt();

                    Employee delEmp = session.get(Employee.class, delId);
                    if (delEmp != null) {
                        tx = session.beginTransaction();
                        session.delete(delEmp);
                        tx.commit();
                        System.out.println("✔ Employee Deleted Successfully.");
                    } else {
                        System.out.println("❌ Employee Not Found!");
                    }
                    break;

                // UPDATE EMPLOYEE
                case 4:
                    System.out.print("Enter Employee ID to Update: ");
                    int updId = sc.nextInt();

                    Employee updEmp = session.get(Employee.class, updId);

                    if (updEmp != null) {

                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Salary: ");
                        double newSal = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Enter New Designation: ");
                        String newDesig = sc.nextLine();

                        updEmp.setEname(newName);
                        updEmp.setEsal(newSal);
                        updEmp.setDesig(newDesig);

                        tx = session.beginTransaction();
                        session.update(updEmp);
                        tx.commit();

                        System.out.println("✔ Employee Updated Successfully.");

                    } else {
                        System.out.println("❌ Employee Not Found!");
                    }
                    break;

                // DISPLAY ALL EMPLOYEES
                case 5:
                    Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
                    List<Employee> empList = query.list();

                    System.out.println("\n******** All Employees ********");
                    for (Employee e1 : empList) {
                        System.out.println(e1);
                    }
                    System.out.println("********************************");
                    break;

                // EXIT PROGRAM
                case 6:
                    System.out.println("Exiting...");
                    session.close();
                    sf.close();
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid Option! Try Again.");
            }
        }
    }
}
