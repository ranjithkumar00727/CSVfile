package com.file;

    import java.io.DataInputStream;
    import java.io.File;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.io.PrintWriter;

    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    /**
     * Servlet implementation class UploadServlet
     */
    public class Upload extends HttpServlet {
        private static final long serialVersionUID = 1L;
        PrintWriter out;
        private void setOut(PrintWriter out){
            this.out = out;
        }

        private void println(String content){
            out.print(content+"\n");
        }
        /**
     * @throws javax.servlet.ServletException
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
            setOut(response.getWriter());
            boolean done = false;
            //to get the content type information from JSP Request Header
            String contentType = request.getContentType();

            //here we are checking the content type is not equal to Null and as well as the passed data from mulitpart/form-data is greater than or equal to 0
            if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
                DataInputStream in = new DataInputStream(request.getInputStream());
                //we are taking the length of Content type data
                int formDataLength = request.getContentLength();
                byte dataBytes[] = new byte[formDataLength];
                int byteRead = 0;
                int totalBytesRead = 0;
                //this loop converting the uploaded file into byte code
                while (totalBytesRead < formDataLength) {
                    byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
                    totalBytesRead += byteRead;
                    }

                String file = new String(dataBytes);

                //for saving the file name
                String saveFile = file.substring(file.indexOf("filename=\"") + 10);
                saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
                saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));

                int lastIndex = contentType.lastIndexOf("=");
                String boundary = contentType.substring(lastIndex + 1,contentType.length());
                int pos;
                //extracting the index of file 
                pos = file.indexOf("filename=\"");
                pos = file.indexOf("\n", pos) + 1;
                pos = file.indexOf("\n", pos) + 1;
                pos = file.indexOf("\n", pos) + 1;
                int boundaryLocation = file.indexOf(boundary, pos) - 4;
                int startPos = ((file.substring(0, pos)).getBytes()).length;
                int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;

                if(saveFile.endsWith(".txt") || saveFile.endsWith(".csv")){
                    // creating a new file with the same name and writing the content in new file
                    FileOutputStream fileOut = new FileOutputStream(new File("../uploads/"+saveFile));
                    fileOut.write(dataBytes, startPos, (endPos - startPos));
                    fileOut.flush();
                    fileOut.close();
                    done = true;
                    getServletContext().setAttribute("fileName", saveFile);             
                    request.setAttribute("fileName", saveFile);
                }else{
                    request.setAttribute("error", "Unsupported file format");
                }
            }
            if(done)
                request.getRequestDispatcher("confirm.jsp").forward(request, response);
            else
                request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
