package javapackage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentDao {

	public static int save(Student s){
		int status=0;
		try{
			Connection con=AccountantDao.getCon();
			PreparedStatement ps=con.prepareStatement("insert into feereport_student(name,email,course,vize,final,proje,address,city,state,country,contactno) values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,s.getName());
			ps.setString(2,s.getEmail());
			ps.setString(3, s.getCourse());
			ps.setInt(4,s.getVize());
			ps.setInt(5,s.getFinall());
			ps.setInt(6,s.getProje());
			ps.setString(7,s.getAddress());
			ps.setString(8,s.getCity());
			ps.setString(9,s.getState());
			ps.setString(10,s.getCountry());
			ps.setString(11,s.getContactno());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int update(Student s){
		int status=0;
		try{
			Connection con=AccountantDao.getCon();
			PreparedStatement ps=con.prepareStatement("update feereport_student set name=?,email=?,course=?,vize=?,final=?,proje=?,address=?,city=?,state=?,country=?,contactno=? where rollno=?");
			ps.setString(1,s.getName());
			ps.setString(2,s.getEmail());
			ps.setString(3, s.getCourse());
			ps.setInt(4,s.getVize());
			ps.setInt(5,s.getFinall());
			ps.setInt(6,s.getProje());
			ps.setString(7,s.getAddress());
			ps.setString(8,s.getCity());
			ps.setString(9,s.getState());
			ps.setString(10,s.getCountry());
			ps.setString(11,s.getContactno());
			ps.setInt(12,s.getRollno());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static List<Student> view(){
		List<Student> list=new ArrayList<Student>();
		try{
			Connection con=AccountantDao.getCon();
			PreparedStatement ps=con.prepareStatement("select * from feereport_student");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Student s=new Student();
				s.setRollno(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setCourse(rs.getString("course"));
				s.setVize(rs.getInt("vize"));
				s.setFinall(rs.getInt("final"));
				s.setProje(rs.getInt("proje"));
				s.setAddress(rs.getString("address"));
				s.setCity(rs.getString("city"));
				s.setState(rs.getString("state"));
				s.setCountry(rs.getString("country"));
				s.setContactno(rs.getString("contactno"));
				list.add(s);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static Student getStudentByRollno(int rollno){
		Student s=new Student();
		try{
			Connection con=AccountantDao.getCon();
			PreparedStatement ps=con.prepareStatement("select * from feereport_student where rollno=?");
			ps.setInt(1,rollno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				s.setRollno(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setCourse(rs.getString("course"));
				s.setVize(rs.getInt("vize"));
				s.setFinall(rs.getInt("final"));
				s.setProje(rs.getInt("proje"));
				s.setAddress(rs.getString("address"));
				s.setCity(rs.getString("city"));
				s.setState(rs.getString("state"));
				s.setCountry(rs.getString("country"));
				s.setContactno(rs.getString("contactno"));
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return s;
	}
	public static List<Student> due(){
		List<Student> list=new ArrayList<Student>();
		try{
			Connection con=AccountantDao.getCon();
			PreparedStatement ps=con.prepareStatement("select * from feereport_student where proje>0");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Student s=new Student();
				s.setRollno(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setCourse(rs.getString("course"));
				s.setVize(rs.getInt("vize"));
				s.setFinall(rs.getInt("final"));
				s.setProje(rs.getInt("proje"));
				s.setAddress(rs.getString("address"));
				s.setCity(rs.getString("city"));
				s.setState(rs.getString("state"));
				s.setCountry(rs.getString("country"));
				s.setContactno(rs.getString("contactno"));
				list.add(s);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
}
