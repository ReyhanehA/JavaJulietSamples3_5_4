/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__getQueryStringServlet_45.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 470 Unsafe Reflection
 * BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
 * GoodSource: Hardcoded class to load
 * Sinks:
 *    GoodSink: instantiate only certain fixed classes
 *    BadSink : instantiate arbitrary class
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

import javax.servlet.http.*;
import java.util.StringTokenizer;
import java.sql.*;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE470_Unsafe_Reflection__getQueryStringServlet_45 extends AbstractTestCaseServlet
{

    private String bad_data;
    private String goodG2B_data;
    private String goodB2G_data;

    private void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = bad_data;

        Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
        Object instance = c.newInstance();

        IO.writeLine(instance.toString());

    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");
        data = "";

        /* parse the query string for value of 'id' */
        String id_str = null;
        StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
        while (st.hasMoreTokens())
        {
            String token = st.nextToken();
            int i = token.indexOf("=");
            if ((i > 0) && (i < (token.length() - 1)) && (token.substring(0, i).equals("id")))
            {
                id_str = token.substring(i + 1);
                break;
            }
        }

        if (id_str != null)
        {
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            try
            {
                int id = Integer.parseInt(id_str);
                conn = IO.getDBConnection();
                statement = conn.prepareStatement("select * from pages where id=?");
                /* FLAW: no check to see whether the user has privileges to view the data */
                statement.setInt(1, id);
                rs = statement.executeQuery();
                data = rs.toString();
            }
            catch( SQLException se )
            {
                log_bad.warning("Error");
            }
            finally
            {
                /* clean up database objects */
                try {
                    if( rs != null )
                    {
                        rs.close();
                    }
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error closing rs");
                }
                finally {
                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        log_bad.warning("Error closing statement");
                    }
                    finally {
                        try {
                            if( conn != null )
                            {
                                conn.close();
                            }
                        }
                        catch( SQLException se)
                        {
                            log_bad.warning("Error closing conn");
                        }
                    }
                }
            }
        }

        bad_data = data;
        bad_sink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    private void goodG2B_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodG2B_data;

        Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
        Object instance = c.newInstance();

        IO.writeLine(instance.toString());

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = "Testing.test";

        goodG2B_data = data;
        goodG2B_sink(request, response);
    }

    private void goodB2G_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodB2G_data;

        if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
        !data.equals("Test.test"))
        {
            return;
        }

        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString());

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");
        data = "";

        /* parse the query string for value of 'id' */
        String id_str = null;
        StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
        while (st.hasMoreTokens())
        {
            String token = st.nextToken();
            int i = token.indexOf("=");
            if ((i > 0) && (i < (token.length() - 1)) && (token.substring(0, i).equals("id")))
            {
                id_str = token.substring(i + 1);
                break;
            }
        }

        if (id_str != null)
        {
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            try
            {
                int id = Integer.parseInt(id_str);
                conn = IO.getDBConnection();
                statement = conn.prepareStatement("select * from pages where id=?");
                /* FLAW: no check to see whether the user has privileges to view the data */
                statement.setInt(1, id);
                rs = statement.executeQuery();
                data = rs.toString();
            }
            catch( SQLException se )
            {
                log_bad.warning("Error");
            }
            finally
            {
                /* clean up database objects */
                try {
                    if( rs != null )
                    {
                        rs.close();
                    }
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error closing rs");
                }
                finally {
                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        log_bad.warning("Error closing statement");
                    }
                    finally {
                        try {
                            if( conn != null )
                            {
                                conn.close();
                            }
                        }
                        catch( SQLException se)
                        {
                            log_bad.warning("Error closing conn");
                        }
                    }
                }
            }
        }

        goodB2G_data = data;
        goodB2G_sink(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}
