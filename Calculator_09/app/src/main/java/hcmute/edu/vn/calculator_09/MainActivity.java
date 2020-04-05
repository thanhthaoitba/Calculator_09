package hcmute.edu.vn.calculator_09;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private String numText,sign;
    private double currentNum,previousNum, result;
    private  boolean Flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView) findViewById(R.id.screen);
        numText = "";
}

    public void  onClick(View view){
        try{
            Button button = (Button)view;
            numText+=button.getText().toString();

            if(Flag == true) currentNum = Double.parseDouble(numText);
            else previousNum = Double.parseDouble(numText);
            screen.setText(numText);
            Flag = false;
        }catch (Exception Ex){
            numText = numText.substring(0,numText.length()-1);
        Toast.makeText(this,"Err",Toast.LENGTH_SHORT).show();
    }

    }
    public void onClickSign(View view){
        Button button = (Button)view;
        sign=button.getText().toString();
        screen.setText(sign);
        numText = "";
        Flag = true;
    }
    public void onClickRefresh(View view){
        screen.setText("");
        currentNum = 0;
        previousNum = 0;
    }
    public  void onClickCalculate(View view){
        //Tính toán here
        try {
            if(sign.equals("+")) {
                result = previousNum + currentNum ;
            }
            screen.setText(String.valueOf(result));
            numText = "";
        }
        catch (Exception ex){
            Toast.makeText(this,"Err",Toast.LENGTH_SHORT).show();
        }
    }
}
