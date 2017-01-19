import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	Connection con = null;

	public static void main(String[] args) {
		
		Main m = new Main();
		ResultSet r = m.getUnfinished();
		m.printResult(r);
		
		System.out.println(m.updateCustomer("Lastname", "Niemand", 51));
		
		//Parser.input(m);

		/*ResultSet r = m.getPayments();
		m.printResult(r);*/
		try {
			m.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * establishes connection to DB
	 */
	public Main() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			return;
		}

		con = null;

		try {
			con = DriverManager
					.getConnection(
							"jdbc:hsqldb:file:C:\\Users\\Morpheus\\Documents\\JavaTuts\\Datenhaltung; shutdown=true",
							"root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet getUnfinished()
	{
		return executeSQL("SELECT * "
				+ "FROM Customer "
				+ "WHERE Firstname IS NULL OR Lastname IS NULL OR Street IS NULL OR City IS NULL");
	}
	
	public boolean updateCustomer(String spalte, String newValue, int id)
	{
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE Customer SET " + spalte + " = ? WHERE ID = ?");
			
			ps.setString(1, newValue);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	/**
	 * resolves Customer's fullname to Customer ID
	 */
	public int getCustomerID(String firstname, String lastname)
			throws SQLException {
		String sql = "SELECT ID, Firstname, Lastname FROM Customer";
		ResultSet r = executeSQL(sql);
		while (r.next()) {
			if (firstname.equals(r.getString(2))
					&& lastname.equals(r.getString(3))) {
				return r.getInt(1);
			}
		}
		return -1;
	}

	/**
	 * Adds a new bill to the DB
	 */
	public boolean buy(String firstname, String lastname, int betrag)
	{
		try {
			return this.buy(this.getCustomerID(firstname, lastname), betrag);
		} catch (SQLException e) {
			return false;
		}
	}
	
	/**
	 * Adds a new bill to the DB
	 * @return 
	 */
	public boolean buy(int customer, int betrag) {
		if(customer == -1)
		{
			return false;
		}
		
		PreparedStatement prep = null;

		String sql = "INSERT INTO Rechnung (CustomerID, BETRAGE) VALUES(?,?)";

		try {
			prep = con.prepareStatement(sql);
			prep.setInt(1, customer);
			prep.setInt(2, betrag);
			prep.executeUpdate();
			prep.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Gibt alle Rechnungen mit Kunden aus
	 */
	public ResultSet getPayments()
	{
		return executeSQL("SELECT Firstname, Lastname, Betrage "
				+ "FROM Customer "
				+ "INNER JOIN Rechnung "
				+ "ON Customer.ID = Rechnung.CustomerID");
	}
	
	/**
	 * Inserts new Customer to the end of the DB
	 */
	public void insertCustomer(String firstname, String lastname,
			String street, String city) {
		ResultSet r = executeSQL("SELECT * FROM Customer");
		int index = 0;
		try {
			while (r.next()) {
				if (r.getInt(1) > index) {
					index = r.getInt(1);
					System.out.println(r.getString(1));
				}
			}
			index++;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			r.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement prep = null;
		try {
			String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?)";
			prep = con.prepareStatement(sql);
			prep.setInt(1, index);
			prep.setString(2, firstname);
			prep.setString(3, lastname);
			prep.setString(4, street);
			prep.setString(5, city);
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				prep.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * returns a ResultSet as result of a SQL query
	 */
	private ResultSet executeSQL(String sql) {
		try {
			Statement stmt = con.createStatement();

			ResultSet res = stmt.executeQuery(sql);
			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * prints a ResultSet to the command line
	 */
	public void printResult(ResultSet r) {
		try {
			while (r.next()) {
				int maxColumns = r.getMetaData().getColumnCount();
				String print = "";
				for (int i = 1; i <= maxColumns; i++) {
					print += r.getMetaData().getColumnName(i);
					print += " = ";
					print += r.getString(i);
					print += ",";
				}
				System.out.println(print);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * prints all customers
	 */
	public void selectAll() {
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM Customer";

			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				String id = res.getString(1);
				String firstname = res.getString(2);
				String lastname = res.getString(3);
				System.out.println(id + ", " + firstname + " " + lastname);
			}

			res.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
