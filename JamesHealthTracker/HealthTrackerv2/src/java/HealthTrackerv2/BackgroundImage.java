/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthTrackerv2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author James Clarke - jamesmichaelclarke@hotmail.co.uk
 */
public class BackgroundImage extends HttpServlet {
    private String filePath;
    
    public void init() {
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        File downloadFile = new File(filePath + "background.png");
        FileInputStream inStream = new FileInputStream(downloadFile);
        ServletOutputStream out;
        out = response.getOutputStream();
        
        BufferedInputStream bin = new BufferedInputStream(inStream);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        
        int ch = 0;
        while((ch=bin.read()) != -1){
            bout.write(ch);
        }
        bin.close();
        inStream.close();
        bout.close();
        out.close();
    }
    
}
