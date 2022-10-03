package Entity;

import java.util.concurrent.*;
import java.sql.*;

import com.accenture.bean.Employee;
import com.accenture.connection.ConnectionFactory;

public class EmployeeCRUD {

	public ResultSet select(Connection connection) {
		
			String SQL = "SELECT * FROM employee";
			ResultSet rs = null;
			
	        try (   Statement stmt = connection.createStatement();
	                ResultSet result = stmt.executeQuery(SQL)) {
	        	rs = result;
	            rs.next();
	            
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }

	        return rs;
		
	}
	
	public long insert(Employee employee, Connection conn) {
		
		String SQL = "INSERT INTO employee(eid, job, name, project, rollout, salary, pid) "
                + "VALUES(?,?,?,?,?,?,?)";

        long id = 0;

        try (PreparedStatement pstmt = conn.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

        	pstmt.setString(1, employee.getEid());
            pstmt.setString(2, employee.getJob());
            pstmt.setString(3, employee.getName());
            pstmt.setString(4, employee.getProject());
            pstmt.setString(5, employee.getRollout());
            pstmt.setDouble(6, employee.getSalary());
            pstmt.setInt(7, employee.getPid());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
		
	}
	
	public int update(Employee employee, Connection conn) {
		
		String SQL = "UPDATE employee "
                + "SET eid = ? "
                + "SET job = ? "
                + "SET name = ? "
                + "SET project = ? "
                + "SET rollout = ? "
                + "SET salary = ? "
                + "WHERE pid = ?";

        int affectedrows = 0;

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, employee.getEid());
            pstmt.setString(2, employee.getJob());
            pstmt.setString(3, employee.getName());
            pstmt.setString(4, employee.getProject());
            pstmt.setString(5, employee.getRollout());
            pstmt.setDouble(6, employee.getSalary());
            pstmt.setInt(7, employee.getPid());

            affectedrows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedrows;
		
	}
	
	public int delete(long id, Connection conn) {
	
		String SQL = "DELETE FROM employee WHERE pid = ?";

        int affectedrows = 0;

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setLong(1, id);

            affectedrows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedrows;
		
	}
	
}
