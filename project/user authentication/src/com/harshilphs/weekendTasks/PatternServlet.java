package com.harshilphs.weekendTasks;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pattern")
public class PatternServlet extends HttpServlet {
	
	public void rowLogic(int i, int k,PrintWriter out) {
		if(k == (((i * 2) -1)/2)+1) {
    		out.print("*");
    	} else {
    		if(k==(((i * 2) -1)/2)+2 || k==(((i * 2) -1)/2)) {
    			out.print(2);
    		}
    		else {
        		if(i%2 != 0) {
        			out.print("#");
        		}
        		else {
        			if(k%2 != 0) {
            			out.print(i);
        			} else {
        				out.print("#");
        			}
        		}
        	}
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		  for (int i=1; i<=4; i++) 
	        { 
	            // Print space in decreasing order 
	            for (int j=4; j>i; j--)
	            {
	                out.print(" ");
	            }
	            // Print star in increasing order
	            for (int k=1; k<=(i * 2) -1; k++) 
	            {  	
	            	rowLogic(i,k,out);
	            } 
	            out.println(); 
	        } 
	        
	        
	        for (int i=4-1; i>=1; i--)
	        {
	         // Print space in increasing order
	            for (int j=4-1; j>=i; j--)
	            {
	                out.print(" ");
	            }
	            // Print star in decreasing order
	            for (int k=1; k<=(i * 2) -1; k++)
	            {
	            	rowLogic(i,k,out);
	            }
	            
	            out.println();
	        }
	}

}
