package shop.ui.Data;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;




public class ApiService 
{
    
public static int registerUser(String firstName, String lastName, String email, String password) 
     {
        try {
            URL url = new URL("http://localhost:8080/api/users/register");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInput = "{"
                    + "\"firstName\":\"" + firstName + "\","
                    + "\"lastName\":\"" + lastName + "\","
                    + "\"email\":\"" + email + "\","
                    + "\"password\":\"" + password + "\""
                    + "}";

            OutputStream os = conn.getOutputStream();
            os.write(jsonInput.getBytes());
            os.flush();
            os.close();

            return conn.getResponseCode();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

  public static User loginUser(String email, String password) 
  {
    try {
        URL url = new URL("http://localhost:8080/auth/login");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String json = "{"
                + "\"email\":\"" + email + "\","
                + "\"password\":\"" + password + "\""
                + "}";

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        os.close();

        if (conn.getResponseCode() == 200) {

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            String response = br.readLine();

            System.out.println(response);

            String firstName = response.split("\"firstName\":\"")[1].split("\"")[0];
            String lastName = response.split("\"lastName\":\"")[1].split("\"")[0];
            String emailRes = response.split("\"email\":\"")[1].split("\"")[0];
            String passwordRes = response.split("\"password\":\"")[1].split("\"")[0];

            return new User(firstName, lastName, emailRes, passwordRes);
        }

        return null;

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

public static int deleteUser(String email, String password) 
{
    try {
        URL url = new URL("http://localhost:8080/api/users/delete");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("DELETE");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String json = "{"
                + "\"email\":\"" + email + "\","
                + "\"password\":\"" + password + "\""
                + "}";

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        os.close();

        return conn.getResponseCode();

    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    }
}

public static int addProduct(
        String name,
        String description,
        double price,
        int categoryId,
        String image
) {

    try {

        URL url =
                new URL("http://localhost:8080/products/add");

        HttpURLConnection conn =
                (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");

        conn.setRequestProperty(
                "Content-Type",
                "application/json"
        );

        conn.setDoOutput(true);

        String jsonInput = "{"
                + "\"name\":\"" + name + "\","
                + "\"description\":\"" + description + "\","
                + "\"price\":" + price + ","
                + "\"categoryId\":" + categoryId + ","
                + "\"image\":\"" + image + "\""
                + "}";

        OutputStream os = conn.getOutputStream();

        os.write(jsonInput.getBytes());

        os.flush();

        os.close();

        return conn.getResponseCode();

    } catch (Exception e) {

        e.printStackTrace();

        return -1;
    }
}
public static ArrayList<String> getProducts() {

    ArrayList<String> products = new ArrayList<>();

    try {

        URL url = new URL("http://localhost:8080/products/all");

        HttpURLConnection conn =
                (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

        StringBuilder response = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            response.append(line);
        }

        br.close();

        String data = response.toString();

        data = data.replace("[", "").replace("]", "");

    
        String[] items = data.split("\",\"");

        for (String item : items) {

        
            item = item.replace("\"", "");
            // id - name - desc - price - image

            products.add(item);
        }

    } catch (Exception e) 
    {
        e.printStackTrace();
    }

    return products;
}

//test youssef Category

    public static int addCategory(
            String name,
            String image,
            int categoryId
            ) {

        try {

            URL url =
                    new URL("http://localhost:8080/category/add");

            HttpURLConnection conn =
                    (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");

            conn.setRequestProperty(
                    "Content-Type",
                    "application/json"
            );

            conn.setDoOutput(true);

            String jsonInput = "{"
                    + "\"name\":\"" + name + "\","
                    + "\"image\":\"" + image + "\","
                    + "\"categoryId\":\"" + categoryId + "\""
                    + "}";

            OutputStream os = conn.getOutputStream();

            os.write(jsonInput.getBytes());

            os.flush();

            os.close();

            return conn.getResponseCode();

        } catch (Exception e) {

            e.printStackTrace();

            return -1;
        }
    }


    public static ArrayList<String> getcategory() {

        ArrayList<String> categories = new ArrayList<>();

        try {

            URL url = new URL("http://localhost:8080/category/all");

            HttpURLConnection conn =
                    (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(conn.getInputStream())
                    );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            br.close();

            String data = response.toString();

            data = data.replace("[", "").replace("]", "");


            String[] items = data.split("\",\"");

            for (String item : items) {


                item = item.replace("\"", "");


                categories.add(item);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return categories;
    }

    public static void deleteProduct(long id) {
        try {
            URL url = new URL("http://localhost:8080/products/delete?id=" + id);

            HttpURLConnection conn =
                    (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("DELETE");

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                System.out.println(response.toString());
            } else {
                System.out.println("Delete failed");
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteCategory(int id) {
        try {
            URL url = new URL("http://localhost:8080/category/delete?id=" + id);

            HttpURLConnection conn =
                    (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("DELETE");

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                System.out.println(response.toString());
            } else {
                System.out.println("Delete failed");
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
