package com.example.budgettrackermysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.budgettrackermysql.data.BudgetTrackerDao;
import com.example.budgettrackermysql.model.BudgetTracker;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NewBudgetEntry extends AppCompatActivity {

    private EditText enterID;
    private EditText enterDate;
    private EditText enterStoreName;
    private EditText enterProductName;
    private EditText enterProductType;
    private EditText enterPrice;
    private Button saveInfoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_budget_entry);
        BudgetTracker budgetTracker = new BudgetTracker();

//        enterID.setText(budgetTracker.getId());

//        enterID = Integer.parseInt(findViewById(R.id.enter_id));
        enterID = findViewById(R.id.enter_id);
        enterDate = findViewById(R.id.enter_date);
        enterStoreName = findViewById(R.id.enter_store_name);
        enterProductName = findViewById(R.id.enter_product_name);
        enterProductType = findViewById(R.id.enter_product_type);
        enterPrice = findViewById(R.id.enter_price);
        saveInfoButton = findViewById(R.id.save_button);

        enterID.setText(budgetTracker.getId());

        saveInfoButton.setOnClickListener(v -> {
            BudgetTrackerDao btDao = new BudgetTrackerDao();

//            BudgetTracker btDto = new BudgetTracker(enterID, enterDate, enterStoreName, enterProductName, enterProductType, enterPrice);
            BudgetTracker btDto = new BudgetTracker();
            String strEnterID = enterID.getText().toString();
            btDto.setId(Integer.parseInt(strEnterID));

            String strEnterDate = enterDate.getText().toString();
            try {
                Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(strEnterDate);
                btDto.setDate(date1);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String strEnterStoreName = enterStoreName.getText().toString();
            btDto.setStoreName(strEnterStoreName);

            String strEnterProductName = enterProductName.getText().toString();
            btDto.setStoreName(strEnterProductName);

            String strEnterProductType = enterProductType.getText().toString();
            btDto.setStoreName(strEnterProductType);

            String strEnterPrice = enterPrice.getText().toString();
            btDto.setPrice(Integer.parseInt(strEnterPrice));

            try {
                int rowsCount = btDao.insertBudgetTrackerDB(btDto);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        });


    }
}