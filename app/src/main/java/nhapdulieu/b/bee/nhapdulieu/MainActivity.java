package nhapdulieu.b.bee.nhapdulieu;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edtfirstname , edtlastname , edtbirthday, edtaddress, edtemail;
    CheckBox cbxagree ;
    Button btnbirthday , btnregister;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ControlButton();


    }

    private void ControlButton() {

        //button select birthday
        btnbirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DATE);

                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                calendar.set(year,month,day);
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
                                edtbirthday.setText(simpleDateFormat.format(calendar.getTime()));
                            }
                        }, year, month, dayOfMonth);
//                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();

            }
        });

        //button register
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtfirstname.getText().length() != 0 && edtlastname.getText().length() != 0 && edtbirthday.getText().length() != 0 &&edtaddress.getText().length() != 0 &&edtemail.getText().length() != 0 && cbxagree.isChecked() ){
                    Toast toast = Toast.makeText(MainActivity.this,"Succeed !! Thank for register !!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    Toast toast1 = Toast.makeText(MainActivity.this , "You enter the missing form ! Please fill it out  ",Toast.LENGTH_SHORT);
                    toast1.show();
                }

            }
        });
    }

    private void Anhxa(){

        edtfirstname = (EditText)findViewById(R.id.edtfirstname);
        edtlastname = (EditText)findViewById(R.id.edtlastname);
        edtbirthday = (EditText)findViewById(R.id.edtbirthday);
        edtaddress = (EditText)findViewById(R.id.edtaddress);
        edtemail = (EditText)findViewById(R.id.edtemail);

        btnbirthday = (Button)findViewById(R.id.btnbirthday);
        btnregister = (Button)findViewById(R.id.btnregister);


    }
}
