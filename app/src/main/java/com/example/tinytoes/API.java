package com.example.tinytoes;

import android.os.AsyncTask;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.example.tinytoes.EyeDetectionScreen;

public class API {
    String result = "";
    ApiCallBack apiCallBack;
    public API(){

    }
    public void setApiCallBack(ApiCallBack apiCallBack){
        this.apiCallBack = apiCallBack;
    }
    String getResult(){
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... params) {


                Python py = Python.getInstance();
                PyObject obj = py.getModule("API_Function");

                String url = "http://saqib0494.pythonanywhere.com//sleepy/";
                String file_path = "F:/temp.jpg";
                PyObject temp  = obj.callAttr("API_Call",url,file_path);

                // Do some long-running operation with the two parameters
//            String result = param1 + " " + param2;

                return "temp.toString()";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                result = "temp";
                apiCallBack.displayresult(result);
//            r_text.setText("All good here");
//                Toast.makeText(EyeDetectionScreen.this,"Perfect", Toast.LENGTH_SHORT).show();
            }
        }.execute();
        return result;
    }
    public interface ApiCallBack{
        void displayresult(String result);
    }
}

