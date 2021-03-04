package com.smoothstack.week.two.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// respond to requests at the /login path
@WebServlet("/login")
public class Login extends HttpServlet {

  @Override
  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    // Get the 'username' and 'password' parameters from a form POST submission
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    // set response type to HTML
    response.setContentType("text/html");
    // create PrintWriter to compose HTML response
    PrintWriter printWriter = response.getWriter();
    // HTML top half
    printWriter.print(
      "<html><head><title>SmoothStack Login</title></head><body>"
    );
    if (username == null || password == null) {
      // if the user does not submit a username and password
      // return 400 Bad Request
      response.setStatus(400);
      printWriter.print(
        "<b>Invalid information, please <a href='/login'>try again.</a></b>"
      );
    } else if (username.equals("robertmaes") && password.equals("robertmaes")) {
      // if the user submits the correct username and password
      // return 200 OK
      response.setStatus(200);
      printWriter.print("<b>Congratulations! You have been logged in.</b>");
    } else {
      // if the user submits an incorrect username or password
      // return 401 Unauthorized
      response.setStatus(401);
      printWriter.print(
        "<b>Invalid information, please <a href='/login'>try again.</a></b>"
      );
    }
    // HTML bottom half
    printWriter.print("</body></html>");
    // close printWriter and send response
    printWriter.close();
  }
}
