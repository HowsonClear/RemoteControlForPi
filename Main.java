import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Main {

    private static String Tweet_Type = "Service call";
    private static String Thing_ID = "Hao01";
    private static String Space_ID = "HaoSpace01";
    private static String Ip = "192.168.0.171";
    private static int port = 6668;

    public static void main(String[] args) throws JSONException, IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Please select services you want to use. ");
            System.out.println("We have: Get_Temperature_C, Get_Humidity, Get_Soil_State, Light_Time, Tap_Times. You can input END to stop program");
            String select = sc.nextLine();
            switch (select) {
                case "Get_Temperature_C":
                    Get_Temperature_C();
                    break;
                case "Get_Humidity":
                    Get_Humidity();
                    break;
                case "Get_Soil_State":
                    Get_Soil_State();
                    break;
                case "Light_Time":
                    System.out.println("Please specify how many seconds you want for the light");
                    Light_Time(Integer.valueOf(sc.nextLine()));
                    break;
                case "Tap_Times":
                    System.out.println("Please specify how many seconds you want to tap the button");
                    Tap_Times(Integer.valueOf(sc.nextLine()));
                    break;
                case "END":
                    System.out.println("Stop the program");
                    return;
                default:
                    System.out.println("Please re-select appropriate service!\n");
            }
        }
    }
    private static void Get_Temperature_C() throws IOException, JSONException {
        Socket socket = new Socket(Ip, port);
        JSONObject json = new JSONObject();
        json.put("Tweet Type", Tweet_Type);
        json.put("Thing ID", Thing_ID);
        json.put("Space ID", Space_ID);
        json.put("Service Name", "Get_Temperature_C");
        json.put("Service Inputs", "()");
        OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        output.write(json.toString());
        output.flush();
        StringBuilder builder = new StringBuilder();
        while (true) {
            String curLine = br.readLine();
            if (curLine == null)
                break;
            builder.append(curLine).append(System.lineSeparator());
        }
        String tweet = builder.toString();
        String result = tweet.substring(tweet.indexOf("Service Result") + 19, tweet.length() - 4);
        System.out.println("Current Temperature in Celsius is: " + Integer.valueOf(result) + "\n");
        br.close();
        output.close();
        socket.close();
    }
    private static void Get_Humidity() throws IOException, JSONException {
        Socket socket = new Socket(Ip, port);
        JSONObject json = new JSONObject();
        json.put("Tweet Type", Tweet_Type);
        json.put("Thing ID", Thing_ID);
        json.put("Space ID", Space_ID);
        json.put("Service Name", "Get_Humidity");
        json.put("Service Inputs", "()");
        OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        output.write(json.toString());
        output.flush();
        StringBuilder builder = new StringBuilder();
        while (true) {
            String curLine = br.readLine();
            if (curLine == null)
                break;
            builder.append(curLine).append(System.lineSeparator());
        }
        String tweet = builder.toString();
        String result = tweet.substring(tweet.indexOf("Service Result") + 19, tweet.length() - 4);
        System.out.println("Current Humidity is " + Integer.valueOf(result) + "%\n");
        br.close();
        output.close();
        socket.close();
    }
    private static void Get_Soil_State() throws IOException, JSONException {
        Socket socket = new Socket(Ip, port);
        JSONObject json = new JSONObject();
        json.put("Tweet Type", Tweet_Type);
        json.put("Thing ID", Thing_ID);
        json.put("Space ID", Space_ID);
        json.put("Service Name", "Get_Soil_State");
        json.put("Service Inputs", "()");
        OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        output.write(json.toString());
        output.flush();
        StringBuilder builder = new StringBuilder();
        while (true) {
            String curLine = br.readLine();
            if (curLine == null)
                break;
            builder.append(curLine).append(System.lineSeparator());
        }
        String tweet = builder.toString();
        String result = tweet.substring(tweet.indexOf("Service Result") + 19, tweet.length() - 4);
        if (Integer.valueOf(result) == 1)
            System.out.println("Your plant need water!\n");
        else
            System.out.println("Your plant do not need water currently\n");
        br.close();
        output.close();
        socket.close();
    }
    private static void Light_Time(int second) throws IOException, JSONException {
        Socket socket = new Socket(Ip, port);
        JSONObject json = new JSONObject();
        json.put("Tweet Type", Tweet_Type);
        json.put("Thing ID", Thing_ID);
        json.put("Space ID", Space_ID);
        json.put("Service Name", "Light_Time");
        json.put("Service Inputs", "(" + second + ")");
        OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        output.write(json.toString());
        output.flush();
        StringBuilder builder = new StringBuilder();
        while (true) {
            String curLine = br.readLine();
            if (curLine == null)
                break;
            builder.append(curLine).append(System.lineSeparator());
        }
        String tweet = builder.toString();
        System.out.println("Lighting time over\n");
        br.close();
        output.close();
        socket.close();
    }
    private static void Tap_Times(int second) throws IOException, JSONException {
        Socket socket = new Socket(Ip, port);
        JSONObject json = new JSONObject();
        json.put("Tweet Type", Tweet_Type);
        json.put("Thing ID", Thing_ID);
        json.put("Space ID", Space_ID);
        json.put("Service Name", "Tap_Times");
        json.put("Service Inputs", "(" + second + ")");
        OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        output.write(json.toString());
        output.flush();
        StringBuilder builder = new StringBuilder();
        while (true) {
            String curLine = br.readLine();
            if (curLine == null)
                break;
            builder.append(curLine).append(System.lineSeparator());
        }
        String tweet = builder.toString();
        String result = tweet.substring(tweet.indexOf("Service Result") + 19, tweet.length() - 4);
        System.out.println("You taped " + Integer.valueOf(result) + " times during these seconds\n");
        br.close();
        output.close();
        socket.close();
    }

}
