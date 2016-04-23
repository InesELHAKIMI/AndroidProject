package tn.ines.fashinistaapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


/**
 * Created by micro on 13/04/2016.
 */
public class BackgroundTask extends AsyncTask<String,Void,String> {

    AlertDialog alertDialog;
    Context ctx;

    BackgroundTask(Context cnx){ this.ctx=cnx;}

    @Override
    protected void onPreExecute(){
        alertDialog = new AlertDialog.Builder(ctx).create();
       // alertDialog.setTitle("Login Information....");
    }

    @Override
    protected String doInBackground(String... params)
    {   String reg_url="http://10.0.3.2:8080/webapp/register.php";
        String login_url="http://10.0.3.2:8080/webapp/login.php";

        String methode =params[0];
        if(methode.equals("register"))
        {
            String Login=params[1];
            String Motpasse=params[2];

            try {
                     URL url =new URL(reg_url);
                     HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                     httpURLConnection.setRequestMethod("POST");
                     httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("Login","UTF-8")+"="+URLEncoder.encode(Login,"UTF-8")+"&"+URLEncoder.encode("Motpasse","UTF-8")+"="+URLEncoder.encode(Motpasse,"UTF-8")
                        ;
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                httpURLConnection.disconnect();
                return "Registration Success...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }

        }else if (methode.equals("Login")) {
            String Login = params[1];
            String Motpasse = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("Login", "UTF-8") + "=" + URLEncoder.encode(Login, "UTF-8") + "&" +
                        URLEncoder.encode("Motpasse", "UTF-8") + "=" + URLEncoder.encode(Motpasse, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return "Login success...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values){
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result){

        if (result.equals("Registration Success...")) {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();

        }
        else
        {
            alertDialog.setMessage(result);
            alertDialog.show();

        }



    }


}
