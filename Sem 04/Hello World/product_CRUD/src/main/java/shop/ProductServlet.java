package shop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
@MultipartConfig
public class ProductServlet extends HttpServlet {
    private List<Product> productList;

    @Override
    public void init() throws ServletException {
        super.init();
        productList = new ArrayList<>();
        productList.add(new Product(1, "Apple AirTag", 28.903, "images/airtag.jpeg"));
        productList.add(new Product(2, "Apple Magic Keyboard", 99.51, "images/keyboard.jpeg"));
        productList.add(new Product(3, "Apple Watch Band", 49.9, "images/watchband.jpeg"));
        productList.add(new Product(4, "Apple Watch Series 8", 329.00, "images/applewatch.jpeg"));
        productList.add(new Product(5, "Apple 2021 iMac ", 1271.60, "images/imac.jpeg"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int id = productList.size() + 1;

        Part filePart = request.getPart("image");

        String fileName = getFileName(filePart);

        String uploadDirectory = getServletContext().getRealPath("/images");

        String filePath = uploadFile(filePart, fileName, uploadDirectory);
        String fileURL = "images/" + fileName;


        Product newProduct = new Product(id, name, price, fileURL);
        productList.add(newProduct);

        response.sendRedirect("products");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = getProductById(id);

        request.setAttribute("products", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(request, response);
    }
""
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        Product productToUpdate = getProductById(id);
        productToUpdate.setName(name);
        productToUpdate.setPrice(price);


        Part filePart = request.getPart("image");
        if (filePart != null && filePart.getSize() > 0) {

            deleteImage(productToUpdate.getImageUrl(), request);

            String fileName = getFileName(filePart);

            String uploadDirectory = getServletContext().getRealPath("/images");

            String filePath = uploadFile(filePart, fileName, uploadDirectory);

            String fileURL = "images/" + fileName;

            productToUpdate.setImageUrl(fileURL);
        }

        response.sendRedirect("products");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product productToDelete = getProductById(id);

        if (productToDelete != null) {

            deleteImage(productToDelete.getImageUrl(), request);

            productList.remove(productToDelete);
        }
        response.sendRedirect("products");
    }

    private Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    private void deleteImage(String imageUrl, HttpServletRequest request) {
        String uploadDirectory = request.getServletContext().getRealPath("") + File.separator + "images";
        String imagePath = uploadDirectory + File.separator + imageUrl;

        File imageFile = new File(imagePath);
        if (imageFile.exists()) {
            imageFile.delete();
        }
    }

    private String uploadFile(Part filePart, String fileName, String uploadDirectory)
            throws IOException {
        String filePath = uploadDirectory + File.separator + fileName;

        try (InputStream inputStream = filePart.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[8192];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
        return filePath;
    }

    private String getFileName(Part part) {
        String contenDisposition = part.getHeader("content-disposition");
        String[] elments = contenDisposition.split(";");

        for (String element : elments) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf("=") + 1).trim().replace("\"", "");
            }
        }
        return "";
    }
}






