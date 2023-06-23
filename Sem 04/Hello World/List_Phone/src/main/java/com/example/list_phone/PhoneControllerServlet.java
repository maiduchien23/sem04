package com.example.list_phone;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import javax.annotation.Resource;
import javax.sql.DataSource;

import java.io.IOException;

import java.util.List;

@WebServlet("/PhoneControllerServlet")
public class PhoneControllerServlet  extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PhoneDbUtil phoneDbUtil;
    @Resource(name = "jdbc/exam-phone")
    private DataSource dataSource;


    @Override
    public void init() throws ServletException {
        super.init();

        try {

            phoneDbUtil = new PhoneDbUtil(dataSource);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "list";
            }
            switch (theCommand) {
                case "ADD":
                    addPhone(request, response);
                    break;
                case "LOAD":
                    loadPhone(request, response);
                    break;

                case "DELETE":
                    deletePhone(request, response);
                    break;
                default:
                    listPhones(request, response);
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listPhones(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Phone> phones = phoneDbUtil.getPhones();

        request.setAttribute("PHONE_LIST", phones);

        RequestDispatcher dispatcher = request.getRequestDispatcher("list-phone.jsp");
        dispatcher.forward(request, response);
    }

    private void deletePhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String thePhoneId = request.getParameter("id");

        phoneDbUtil.deletePhone(thePhoneId);

        listPhones(request, response);
    }



    public void loadPhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String thePhoneId = request.getParameter("id");

        Phone thePhone = phoneDbUtil.getPhone(thePhoneId);

        request.setAttribute("THE_PHONE", thePhone);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-phone.jsp");
        dispatcher.forward(request, response);
    }

    public void addPhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        Phone thePhone = new Phone(name, brand, price, description);

        phoneDbUtil.addPhone(thePhone);

        response.sendRedirect(request.getContextPath() + "/PhoneControllerServlet");
    }

}