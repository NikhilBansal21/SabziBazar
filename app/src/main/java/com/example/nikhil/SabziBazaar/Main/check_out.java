package com.example.nikhil.SabziBazaar.Main;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.nikhil.SabziBazaar.Database.DatabaseHelper;
import com.example.nikhil.SabziBazaar.R;
import com.example.nikhil.SabziBazaar.Database.ProductSet;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by nikhilbansal on 12/08/16.
 */
public class check_out extends Activity {

    Button tfs;
    TableLayout tbl;
    Context context=this;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_out);

        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(getApplicationContext());

        tfs= (Button) findViewById(R.id.btn_submit);
        tbl= (TableLayout) findViewById(R.id.tableLayout);

        ArrayList<ProductSet> allProducts = databaseHelper.queryAllProducts();

        if(allProducts != null && allProducts.size() > 0) {
            for(ProductSet productSet : allProducts) {
                tbl.addView(getTableRow(productSet));
            }

            ProductSet productSet = databaseHelper.getTotalProduct();
            if(productSet != null) {
                productSet.name = "Total";
                tbl.addView(getTableRow(productSet));
            }
        }

        tfs.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //dialog box
            final Dialog dialog =new Dialog(context);
            dialog.setContentView(R.layout.custom_dialogbox);
            dialog.setTitle("SabziBazar Shopping Zone ");

            //setting the custom layout components
            TextView text = (TextView) dialog.findViewById(R.id.text);
            text.setText("Thankyou for Shopping..Have a nice day!!");

            ImageView image = (ImageView) dialog.findViewById(R.id.image);
            image.setImageResource(R.drawable.smiley);
            Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);

            // if button is clicked, redirect to start

            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(check_out.this,MainActivity.class);
                    startActivity(i);
                    DatabaseHelper.getInstance(getApplicationContext()).delete();


                }
        });

            dialog.show();
        }
        });
    }

    private TableRow getTableRow(ProductSet productSet) {
        TableRow tableRow = new TableRow(tbl.getContext());
        tableRow.setWeightSum(2);

        TableRow.LayoutParams cellParams = new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        cellParams.weight = 1;
        TextView tvName = new TextView(tbl.getContext());
        tvName.setGravity(Gravity.CENTER);
        tvName.setText(productSet.name);

        tableRow.addView(tvName, cellParams);

        cellParams = new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        cellParams.weight = 1;
        TextView tvPrice = new TextView(tbl.getContext());
        tvPrice.setGravity(Gravity.CENTER);
        tvPrice.setText(productSet.price);

        tableRow.addView(tvPrice, cellParams);

        return tableRow;
    }
}
