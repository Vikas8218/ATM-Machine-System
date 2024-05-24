package Com.coding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/atm";
    private static final String username = "root";
    private static final String password = "vikas1234";
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean detailsadd(Homepage u) {
        try {
            String sql = "INSERT INTO Details(name, CardNo, PIN) VALUES (?, ?, ?)";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getCardNo());
            ps.setInt(3, u.getPIN()); 
            int ar = ps.executeUpdate();
            return ar > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static Homepage login(String cardno, int PIN) {
        Homepage m = null;
        try {
            String sql = "SELECT * FROM Details WHERE cardno=? AND pin=?";
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, cardno);
            pst.setInt(2, PIN);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                m = new Homepage();
                m.setName(rs.getString(2));
                m.setCardNo(rs.getString(3)); 
                m.setPIN(rs.getInt(4));
                m.setId(rs.getInt(1));
                m.setBalance(rs.getInt(5));
            }
            rs.close();
            pst.close();
            getConnection().close();
            return m;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return m;
    }
    // deposit amo
	public static boolean depositamo(Homepage u) {
		
		  try {
	            String sql = "UPDATE details SET balance=? WHERE id=?;";
	            PreparedStatement ps = getConnection().prepareStatement(sql);
	            ps.setInt(1,u.getBalance());
	            ps.setInt(2,u.getId());
	            int ar = ps.executeUpdate();
	            return ar > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}
	public static boolean updatePin(Homepage u) {
	    try {
	        String sql = "UPDATE details SET PIN=? WHERE id=?;";
	        PreparedStatement ps = getConnection().prepareStatement(sql);
	        ps.setInt(1, u.getPIN());
	        ps.setInt(2, u.getId());
	        int rowsAffected = ps.executeUpdate();
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	}
