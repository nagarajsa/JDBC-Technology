package Student_info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Crud_operations {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSPIDERS", "root", "root");

		boolean flag = true;
		while (flag) {
			System.out.println("***********-------------WELCOME TO STUDENT INFORMATION APPLICATION-----------------***********");
			System.out.println("SELECT YOUR OPTION'S IN GIVEN BELLOW");
			System.out.println(" 1].ADD STUDENTS\n 2].UPDATE JAVA MOCK RATE\n 3].UPDATE SQL MOCK RATE\n 4].UPDATE WEB MOCK RATE\n 5].FETCH STUDENT DATA BY ID\n 6].FETCH ALL STUDENT DATA\n 7].REMOVE STUDENT BY ID\n 8].EXIST");
			System.out.println("------------------------------------------------------------");
			System.out.println();
			int opt = sc.nextInt();
			switch (opt) {
			case 1: // Add Students
			{
				PreparedStatement ps = con.prepareStatement("insert into Mock_Details values(?, ?, ?, ?, ?)");
				System.out.println("Enter your ID:");
				int ID = sc.nextInt();
				System.out.println("Enter your NAME:");
				String NAME = sc.next();
				System.out.println("Enter your JAVA_MOCK_RATE:");
				int JAVA_MOCK_RATE = sc.nextInt();
				System.out.println("Enter your SQL_MOCK_RATE:");
				int SQL_MOCK_RATE = sc.nextInt();
				System.out.println("Enter your WEB_MOCK_RATE:");
				int WEB_MOCK_RATE = sc.nextInt();
				ps.setInt(1, ID);
				ps.setString(2, NAME);
				ps.setInt(3, JAVA_MOCK_RATE);
				ps.setInt(4, SQL_MOCK_RATE);
				ps.setInt(5, WEB_MOCK_RATE);
				System.out.println("Data added Successfully....!");
				System.out.println("Please Check Status in Database...!");
				ps.executeUpdate();
			}
				break;

			case 2: // Update Java Mock Rate
			{
				PreparedStatement ps = con.prepareStatement("update Mock_Details set JAVA_MOCK_RATE=? where ID=?");
				System.out.println("Enter your new JAVA_MOCK_RATE:");
				int JAVA_MOCK_RATE = sc.nextInt();
				System.out.println("Enter the ID:");
				int ID = sc.nextInt();
				ps.setInt(1, JAVA_MOCK_RATE);
				ps.setInt(2, ID);
				System.out.println("Mock rate Updated...!");
				System.out.println("Please Check Status in Database...!");
				ps.executeUpdate();
			}
				break;

			case 3: // Update SQL Mock Rate
			{
				PreparedStatement ps1 = con.prepareStatement("update Mock_Details set SQL_MOCK_RATE=? where ID=?");
				System.out.println("Enter your new SQL_MOCK_RATE:");
				int SQL_MOCK_RATE = sc.nextInt();
				System.out.println("Enter the ID:");
				int ID1 = sc.nextInt();
				ps1.setInt(1, SQL_MOCK_RATE);
				ps1.setInt(2, ID1);
				System.out.println("Mock rate Updated...!");
				System.out.println("Please Check Status in Database...!");
				ps1.executeUpdate();
			}
				break;

			case 4: // Update WEB Mock Rate
			{
				PreparedStatement ps2 = con.prepareStatement("update Mock_Details set WEB_MOCK_RATE=? where ID=?");
				System.out.println("Enter your new WEB_MOCK_RATE:");
				int WEB_MOCK_RATE = sc.nextInt();
				System.out.println("Enter the ID:");
				int ID2 = sc.nextInt();
				ps2.setInt(1, WEB_MOCK_RATE);
				ps2.setInt(2, ID2);
				System.out.println("Mock rate Updated...!");
				System.out.println("Please Check Status in Database...!");
				ps2.executeUpdate();
			}
				break;

			case 5: // fetch the student by ID
			{
				PreparedStatement ps3 = con.prepareStatement("select * from Mock_Details where id=?");
				System.out.println("Enter the ID:");
				int ID3 = sc.nextInt();
				ps3.setInt(1, ID3);
				ResultSet rs = ps3.executeQuery();
				rs.next();
				System.out.println("Student data fetched Successfully....!");
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " "+ rs.getInt(5));
				ps3.execute();
			}
				break;

			case 6: // Fetch all students data
			{
				PreparedStatement ps4 = con.prepareStatement("select * from Mock_Details");
				ResultSet rs1 = ps4.executeQuery();
				System.out.println("Displaying All Students data");
				while (rs1.next()) {
					System.out.println(rs1.getInt(1) + " " + rs1.getString(2) + " " + rs1.getInt(3) + " "
							+ rs1.getInt(4) + " " + rs1.getInt(5));
				}
				ps4.execute();
			}
				break;

			case 7:// remove student by id
			{
				PreparedStatement ps5 = con.prepareStatement("delete from Mock_Details where id=?");
				System.out.println("Enter the ID:");
				int ID4 = sc.nextInt();
				ps5.setInt(1, ID4);
				System.out.println("Data deleted Successfully...!");
				System.out.println("Please Check Status in Database...!");
				ps5.executeUpdate();
			}
				break;

			case 8: // Exist
			{
				flag = false;
				System.out.println(
						"---------------------Thank you for Using Student Application-------------------------");
			}
				break;

			default: {
				System.out.println("Sorry...! you entered Invallid Option");
				System.out.println("Please Enter given Options.");
				System.out.println("---------THANK YOU----------");
			}

				con.close();
			}
			System.out.println(" ");
		}

	}

}
