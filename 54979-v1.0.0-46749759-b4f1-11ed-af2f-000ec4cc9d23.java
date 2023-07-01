/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__listen_tcp_07.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sinks-07.tmpl.java
*/
/*
* @description
* CWE: 470 Unsafe Reflection
* BadSource: listen_tcp Read data using a listening tcp connection
* GoodSource: Hardcoded class to load
* Sinks:
*    GoodSink: instantiate only certain fixed classes
*    BadSink : instantiate arbitrary class
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

import java.util.logging.Logger;

public class CWE470_Unsafe_Reflection__listen_tcp_07 extends AbstractTestCase
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    public void bad() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* Read data using a listening tcp connection */
            ServerSocket listener = null;
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* read input from socket */
                listener = new ServerSocket(39543);
                sock = listener.accept();
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
                finally {
                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        log_bad.warning("Error closing listener");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = "Testing.test";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
            !data.equals("Test.test"))
            {
                return;
            }

            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_five==5 to private_five!=5 */
    private void goodG2B1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* Read data using a listening tcp connection */
            ServerSocket listener = null;
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* read input from socket */
                listener = new ServerSocket(39543);
                sock = listener.accept();
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
                finally {
                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        log_bad.warning("Error closing listener");
                    }
                }
            }
        }
        else {

            data = "Testing.test";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
            !data.equals("Test.test"))
            {
                return;
            }

            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            data = "Testing.test";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log_bad = Logger.getLogger("local-logger");

            data = ""; /* init data */

            /* Read data using a listening tcp connection */

            ServerSocket listener = null;
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                /* read input from socket */
                listener = new ServerSocket(39543);
                sock = listener.accept();

                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
                finally {
                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        log_bad.warning("Error closing listener");
                    }
                }
            }

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
            !data.equals("Test.test"))
            {
                return;
            }

            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_five==5 to private_five!=5 */
    private void goodB2G1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* Read data using a listening tcp connection */
            ServerSocket listener = null;
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* read input from socket */
                listener = new ServerSocket(39543);
                sock = listener.accept();
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
                finally {
                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        log_bad.warning("Error closing listener");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = "Testing.test";

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {

            if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
            !data.equals("Test.test"))
            {
                return;
            }

            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* Read data using a listening tcp connection */
            ServerSocket listener = null;
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* read input from socket */
                listener = new ServerSocket(39543);
                sock = listener.accept();
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
                finally {
                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        log_bad.warning("Error closing listener");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = "Testing.test";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
                    !data.equals("Test.test"))
            {
                return;
            }
            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
