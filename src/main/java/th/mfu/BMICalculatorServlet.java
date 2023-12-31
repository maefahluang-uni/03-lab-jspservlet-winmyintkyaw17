package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        //TODO: calculate bmi
        double weightD = Double.parseDouble(weight);
        double heightD = Double.parseDouble(height);
        int bmi = (int) Math.round(weightD /(heightD*heightD));
        String result;
        //TODO: determine the built from BMI
            if (bmi<18.5){
                result ="underweight";
            }
            else if(bmi>=18.5 && bmi <25){
                result ="normal";
            }
            else if (bmi>=25 && bmi <30){
                result ="overweight";
            }
            else if(bmi>=30 && bmi<35){
                result ="obese";
            }
            else {
                result ="extremely obese";
            }
      
        //TODO: add bmi and built to the request's attribute
                request.setAttribute("bmi",bmi);
                request.setAttribute("result",result);
                request.getRequestDispatcher("bmi_result.jsp").forward(request,response);
        //TODO: forward to jsp
           
    }
    
}
