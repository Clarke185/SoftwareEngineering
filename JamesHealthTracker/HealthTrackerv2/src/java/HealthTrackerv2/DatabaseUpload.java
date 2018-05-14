
package HealthTrackerv2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author James Clarke - jamesmichaelclarke@hotmail.co.uk//jclarke2@uea.ac.uk
 */
@WebServlet("/databaseUploadServlet")
@MultipartConfig(maxFileSize = 16177215)//16MB
public class DatabaseUpload extends HttpServlet {
    
    //Connection Settings
    String URL = "jdbc:postgresql://localhost:5432/HealthTracker";
    String USERNAME = "postgres";
    String PASSWORD = "";
    
    //File limitations and settings (for server).
    private boolean isMultipart;
    private String filePath;
    private final int maxFileSize = 16177215; //16MB
    private int maxMemSize = 4000 * 1024;
    private File file;

    /**
     * Initialises the file path.
     */
    public void init() {
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");
    }
    
    public void doPost(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException{
        String userName = new String();
        
        userName = request.getParameter("username");
        System.out.println(userName);
        
        InputStream is = null; //stream for the file
        
        Part filePart = request.getPart("file");
        //Debugging information
//        System.out.println("Name: " + filePart.getName());
//        System.out.println("Size: " + filePart.getSize());
//        System.out.println("Type: " + filePart.getContentType());

        is = filePart.getInputStream();
        
        Connection conn = null;
        String message = null;
        
        /**
         * Try statement for uploading image information to Database.
         */
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            PreparedStatement statement = conn.prepareStatement("UPDATE userinfo SET userimg = ? WHERE username = ?");
            if(is != null){
                byte[] isAsBytes = IOUtils.toByteArray(is);
                statement.setBytes(1, isAsBytes);
            }
            statement.setString(2, userName);
            
            int row = statement.executeUpdate();
            if(row > 0){
                message = "File uploaded  successfully.";
            }
            statement.close();
            
            // Check that we have a file upload request
            isMultipart = ServletFileUpload.isMultipartContent(request);
            response.setContentType("text/html");
            java.io.PrintWriter out = response.getWriter();

            if (!isMultipart) {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>No file uploaded</p>");
                out.println("</body>");
                out.println("</html>");
                return;
            }
            
        } catch(SQLException e){
            message = "Error: " + e.getMessage();
            e.printStackTrace();
        } finally {
            if(conn != null){
                try{
                    conn.close();
                } catch(SQLException e){
                    message = "Error: " + e.getMessage();
                    e.printStackTrace();
                }
            }
            request.setAttribute("Message", message);
            
            getServletContext().getRequestDispatcher("/uploadMessage.jsp").forward
                (request, response);
            
            
        }
        /**
         * Try statement for uploading image to Apache Tomcat server.
         */
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // maximum size that will be stored in memory
            factory.setSizeThreshold(maxMemSize);

            // Location to save data that is larger than maxMemSize.
            factory.setRepository(new File("c:\\temp"));

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // maximum file size to be uploaded.
            upload.setSizeMax(maxFileSize);
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();

            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath + fileName.substring(
                                fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath + fileName.substring(
                                fileName.lastIndexOf("\\") + 1));
                    }
                    fi.write(file);
                    
                }
                
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    /*
     * Preventative measure as only a post method should be used with this
     * Servlet.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        throw new ServletException("GET method used with "
                + getClass().getName() + ": POST method required.");
    }
    
    
}
