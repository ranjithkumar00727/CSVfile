
    package com.db;

    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.Statement;

    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    import com.csvreader.CsvReader;

    /**
     * Servlet implementation class UpdateDatabase
     */
    public class UpdateDB extends HttpServlet {
        private static final long serialVersionUID = 1L;

        /**
         * @see HttpServlet#HttpServlet()
         */
        public UpdateDB() {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            PrintWriter out = response.getWriter();
            try {           
                String filename = (String) getServletContext().getAttribute("fileName");
                out.println("FileName : "+filename);
                CsvReader db1 = new CsvReader("../uploads/"+filename);
                db1.readHeaders();

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task1\", \"root\", \"ranjith");
                Statement st = con.createStatement();

                while (db1.readRecord())
                {
                    String FE = db1.get("FE");
                    String TIME_STAMP = db1.get("TIME_STAMP");
                    String GUID = db1.get("GUID");
                    String SERVICE = db1.get("SERVICE");
                    String E_TYPE = db1.get("E_TYPE");
                    int TRANSACTION_ID = Integer.parseInt(db1.get("TRANSACTION_ID"));
                    String ERROR_1 = db1.get("ERROR_1");
                     
                    

                    
                    String query = "insert into db1(FE,TIME_STAMP,GUID,SERVICE,E_TYPE,TRANSACTION_ID,ERROR_1) values ("; 
                    query += FE+", '";
                    query += TIME_STAMP+"', ";
                    query += GUID+", ";
                    query += SERVICE+", '";
                    query += E_TYPE+"', ";
                    query += TRANSACTION_ID+", ";
                    query += ERROR_1+")";

                    out.println("Query : "+query);
                    st.executeUpdate(query);
                }
                out.println("Data inserted...!!");
                db1.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
        }

    }

