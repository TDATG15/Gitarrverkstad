package uploadImage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 100, maxRequestSize = 1024 * 1024 * 250)

public class UploadServlet extends HttpServlet {

private static final String SAVE_DIR = "images";

 

 protected void processRequest(HttpServletRequest request, HttpServletResponse response)

 throws ServletException, IOException {

  response.setContentType("text/html;charset=UTF-8");

  try (PrintWriter out = response.getWriter()) {


   try {

    String savePath = System.getProperty("user.DIR") + File.separator + SAVE_DIR;
   
    
    File fileSaveDir = new File(savePath);
    
    if (!fileSaveDir.exists()) {

        fileSaveDir.mkdir();
    }

    String name = request.getParameter("name");
    Part part = request.getPart("file");
    
    String fileName = extractFileName(part);
    out.println(fileName);
    out.println("\n" + name);
    
    InputStream in = part.getInputStream();
    
    Files.copy(in, new File(savePath + File.separator + fileName).toPath());
    
    //part.write(upfilePath + File.separator + fileName);
    //System.out.print(upfilePath);
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    String url="jdbc:derby://andersverkstad.zapto.org:1527/sample";
    Connection con = DriverManager.getConnection(url);

    // query to insert name and image name
    PreparedStatement ps = con.prepareStatement("Insert Into image(path)values (?)");
    String filePath = fileSaveDir + File.separator + fileName;
    ps.setString(1, filePath);
    ps.executeUpdate();

   } catch (IOException | ClassNotFoundException | SQLException | ServletException ex) {

    out.println("error" + ex);

   }

  }

 }

 // the extractFileName() is method used to extract the file name

 private String extractFileName(Part part) {

  String contentDisp = part.getHeader("content-disposition");

  String[] items = contentDisp.split(";");

  for (String s: items) {

   if (s.trim().startsWith("filename")) {

    return s.substring(s.indexOf("=") + 2, s.length() - 1);

   }

  }

  return "";

 }

 @Override

 protected void doGet(HttpServletRequest request, HttpServletResponse response)

 throws ServletException, IOException {

  processRequest(request, response);

 }

 @Override

 protected void doPost(HttpServletRequest request, HttpServletResponse response)

 throws ServletException, IOException {

  processRequest(request, response);

 }

 @Override

 public String getServletInfo() {

   return "Short description";

  } // </editor-fold>

}
    /*

    You need this loop if you submitted more than one file

    for (Part part : request.getParts()) {

    String fileName = extractFileName(part);

    part.write(savePath + File.separator + fileName);

    }*/
