package shop.ui.Data;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
}