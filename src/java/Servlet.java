import java.io.IOException;
import java.text.NumberFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String errors = "";

        try {
            String operator = request.getParameter("Signo");
            String primerTermino = request.getParameter("primerTermino");
            String segundoTermino;
            StringBuilder operacionr = new StringBuilder();
            operacionr = operacionr.append(primerTermino).append(" ").append(operator);

            double a = 0;
            double b = 0;
            double resultado = 0;

            try {
                a = Double.valueOf(primerTermino.replace(',', '.'));
            } catch (NumberFormatException nex) {
                throw new IllegalArgumentException("Ingrese un numero en la primer casilla", nex);
            }

            if (operator.equals("+")
                || operator.equals("-")
                || operator.equals("*")
                || operator.equals("/")
                || operator.equals("\\")) {
                try {
                    segundoTermino = request.getParameter("segundoTermino");
                    operacionr.append(" ").append(segundoTermino);
                    b = Double.valueOf(segundoTermino.replace(',', '.'));
                } catch (NumberFormatException nfe) {
                    throw new IllegalArgumentException("Ingrese un numero en la segunda casilla", nfe);
                }

                if (operator.equals("+")) {
                    resultado = a + b;
                } else if (operator.equals("-")) {
                    resultado = a - b;
                } else if (operator.equals("*")) {
                    resultado = a * b;
                } else if ((operator.equals("/"))) {
                    resultado = a / b;
                }
            } else {
                throw new IllegalArgumentException("");
            }

              
            NumberFormat numberFormat = NumberFormat.getNumberInstance();
            numberFormat.setMaximumFractionDigits(5);

            String reslt;
            reslt = String.valueOf(numberFormat.format(resultado));
            request.setAttribute("resultado", reslt);
            request.setAttribute("operacionr", operacionr.append(" ="));

        } catch (NullPointerException npe) {
            errors = npe.getMessage();
        } catch (IllegalArgumentException iae) {
            errors = iae.getMessage();
        }

        request.setAttribute("", errors);

        RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
        view.forward(request, response);

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
        return "";
    }
}
