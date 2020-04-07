package hcmute.edu.vn.calculator_09;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private String numText,sign,equation ="";
    private double  result = 0,num;
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

            numText += button.getText().toString();
            equation+=button.getText().toString();
            //check
            num = Double.valueOf(numText);
            screen.setText(numText);
        }catch (Exception Ex){
            equation = equation.substring(0,equation.length()-1);
        Toast.makeText(this,"Invalid decimal format!",Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickSign(View view){
        Button button = (Button)view;
        sign=button.getText().toString();
        screen.setText(sign);
        equation+=sign;
        numText ="";
    }
    public void onClickRefresh(View view){
        result = 0;
        equation = "";
        numText ="";
        screen.setText("");
    }
    public double Calculate(String equation){
            equation = equation.replace("-", "+-");
            String[] parts = equation.split("(?=[/*+])|(?<=[/*+])");
            result = Double.parseDouble(parts[0]);
            for (int i = 1; i < parts.length; i += 2) {
                String operand = parts[i];
                double val = Double.parseDouble(parts[i+1]);
                switch (operand) {
                    case "*" :
                        result *= val;
                        break;
                    case "/" :
                        result /= val;
                        break;
                    case "+":
                        result+=val;
                        break;
                }
            }
            return result;
    }
    public  void onClickCalculate(View view){
        //Tính toán here

        try {
            //screen.setText(String.valueOf(Calculate(equation)) );
            screen.setText(Calculate(equation)+"");
            numText = "";
        }catch (Exception ex){
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }
}
