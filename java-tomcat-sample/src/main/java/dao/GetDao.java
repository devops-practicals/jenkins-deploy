/*
The Data Access Object (DAO) pattern is a structural pattern that allows to isolate the application/business layer from the persistence layer (usually a relational database ) using an abstract API.
*/

package dao;

/*
The Function Definitions are present in the mysql-connector-java-8.0.24.jar which is download as a part of <dependency> in pom.xml
*/
import java.sql.*;
/*
The Function Definitions are present in the model/Users.java file in the Project Directory.
*/
import model.Users;

public class GetDao
{
	public Users getUser(int emp_no)
	{
		Users a = new Users();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String ssm_parameter_name = "SSM_PARAMETER_NAME";
			Connection con = DriverManager.getConnection("jdbc:mysql://java-tomcat-db.ckvfpsbhonew.us-east-1.rds.amazonaws.com:3306/db","admin","AWSDevOps#123");
			// Connection con = DriverManager.getConnection("jdbc:mysql://DB_HOSTNAME_HERE:3306/db","root","DB_PASSWORD_HERE");
			/*
				db_endpoint=java ssm.getparameter('SDLC_ENV_rds_creds')
				db_username=java ssm.getparameter('SDLC_ENV_rds_creds')
				db_password=java ssm.getparameter('SDLC_ENV_rds_creds')
				Replace the code to retrieve the db_hostname, db_user, db_password from SSM Parameter Store
				Replace the code to retrieve the db_hostname, db_user, db_password from Secret Manager
			Connection con = DriverManager.getConnection(db_endpoint,db_username,db_password);
   			String ssm_parameter_name = os.getenv("SSM_PARAMETER_NAME");
			*/
			Statement st = con.createStatement();
			// ResultSet rs = st.executeQuery("select * from employees where emp_no=" + emp_no);
			ResultSet rs = st.executeQuery("SELECT employees.emp_no,employees.first_name, employees.last_name, titles.title, employees.hire_date, titles.from_date, titles.to_date FROM employees left JOIN titles ON employees.emp_no=titles.emp_no where employees.emp_no=" + emp_no);
			if(rs.next())
			{
				a.setEmpno(rs.getInt("emp_no"));
				a.setFirstname(rs.getString("first_name"));
				a.setLastname(rs.getString("last_name"));
				a.setTitle(rs.getString("title"));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return a;
	}
}
