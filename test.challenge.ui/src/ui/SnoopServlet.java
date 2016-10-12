package ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.BubbleSort;
import root.BucketSort;
import root.ISort;

/**
 * Servlet implementation class SnoopServlet
 */
public class SnoopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SnoopServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtaining the information from the user.
		String intervalMin = (String) request.getParameter("interval-min");
		String intervalMax =  (String) request.getParameter("interval-max");
		String size =  request.getParameter("size");
		
		// Parsing and validation of the data
		int intervalMinInt = -1;
		int intervalMaxInt = -1;
		int sizeInt = -1;
		
		try{
			intervalMinInt = Integer.parseInt(intervalMin);
			intervalMaxInt = Integer.parseInt(intervalMax);
			sizeInt = Integer.parseInt(size);
		}catch(NumberFormatException e){
			// Deal with the exception. Send the user to an error page! The numbers are not numbers.
			request.setAttribute("error.message", "All data must be provided!" );
			request.getRequestDispatcher("/showError.jsp").forward(request,response);
			return;
		}
		
		if(intervalMinInt >= intervalMaxInt){
			// Deal with the error. Send the user to an error page! The interval should be valid. 
			request.setAttribute("error.message", "You should provide a valid interval!" );
			request.getRequestDispatcher("/showError.jsp").forward(request,response);
			return;
		}
		
		if(sizeInt < 0){
			// Deal with the error. Send the user to an error page! The size of the array should be a positive value. 
			request.setAttribute("error.message", "The size of the array should be a possitive number!" );
			request.getRequestDispatcher("/showError.jsp").forward(request,response);
			return;
		}else{
			// All data is correct. Let's generate the array and return it
			String algorithm = (String) request.getParameter("algorithm");
			String answer = "";
			ISort sortAlgorithm = null;
			
			if(algorithm.equals("bubble")){
				sortAlgorithm = new BubbleSort();
				answer = sortAlgorithm.createSortedArray(intervalMinInt, intervalMaxInt, sizeInt).toString();
				
			}else if(algorithm.equals("bucket")){
				sortAlgorithm = new BucketSort();
				answer = sortAlgorithm.createSortedArray(intervalMinInt, intervalMaxInt, sizeInt).toString();
			}
			
			request.setAttribute("user.array", answer );
			request.getRequestDispatcher("/showArray.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}