
package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DisplayImage extends HttpServlet {
    
    Statement stmt=null;
     private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Statement stmt = null;
        ResultSet rs;
        InputStream sImage;
        response.setContentType("image/jpeg");
         try {
            
            String idString = request.getParameter("gid");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url="jdbc:derby://192.168.1.2:1527/sample;user=app;password=app;";
            Connection con = DriverManager.getConnection(url);
            con.setAutoCommit(false);
            stmt = con.createStatement();
            String strSql = "select img from guitar where gid=" + Integer.parseInt(idString);
            rs = stmt.executeQuery(strSql);
            
            if (rs.next()) {
                byte[] bytearray = new byte[1048576];
                int size = 0;
                sImage = rs.getBinaryStream(1);
                response.reset();
               
                while ((size = sImage.read(bytearray)) != -1) {
                    response.getOutputStream().
                            write(bytearray, 0, size);
                }
            }
            con.commit();
            }   catch (IOException | ClassNotFoundException | SQLException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}