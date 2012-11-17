package com.example.sequence;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class Menu_Activity extends Activity implements OnClickListener, OnCheckedChangeListener{

	
	boolean red, yellow, blue;
	int RED, YELLOW, BLUE, answer1, answer2, answer3, x1, x2, x3;
	RadioGroup rgColors;
	Button btnSubmit, btnNext;
	ImageButton row1col1, row1col2, row1col3, ans1, ans2, ans3;
	MediaPlayer m;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levelone);
        red = false;
        yellow = false;
        blue = false;
        
        RED = 1;
        YELLOW = 2;
        BLUE = 3;
        
        rgColors = (RadioGroup) findViewById(R.id.radioGroup1);
        rgColors.setOnCheckedChangeListener(this);
        row1col1 = (ImageButton) findViewById(R.id.b1);
        row1col1.setOnClickListener(this);
        row1col2 = (ImageButton) findViewById(R.id.b2);
        row1col2.setOnClickListener(this);
        row1col3 = (ImageButton) findViewById(R.id.b3);
        row1col3.setOnClickListener(this);
        
        ans1 = (ImageButton) findViewById(R.id.a1);
        ans2 = (ImageButton) findViewById(R.id.a2);
        ans3 = (ImageButton) findViewById(R.id.a3);
        
        btnSubmit = (Button) findViewById(R.id.submit);
        btnSubmit.setOnClickListener(this);
        btnNext = (Button) findViewById(R.id.toleveltwo);
        btnNext.setEnabled(false);
        btnSubmit.setOnClickListener(this);
        randomAns();  
    }

    
    private void randomAns() {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		int x = rnd.nextInt(3 - 1 + 1) + 1;
		int y = rnd.nextInt(3 - 1 + 1) + 1;
		int z = rnd.nextInt(3 - 1 + 1) + 1;
		if(x == RED){
			x1 = RED;
		}
		else if(x == YELLOW){
			x1 = YELLOW;
		}
		else {
			x1 = BLUE;
		}
		if(y == RED){
			x2 = RED;
		}
		else if(y == YELLOW){
			x2 = YELLOW;
		}
		else {
			x2 = BLUE;
		}
		if(z == RED){
			x3 = RED;
		}
		else if(z == YELLOW){
			x3 = YELLOW;
		}
		else {
			x3 = BLUE;
		}
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu_, menu);
        return true;
    }

	public void onCheckedChanged(RadioGroup arg0, int i) {
		// TODO Auto-generated method stub
		switch(i){
		case R.id.red:
			red = true;
			yellow = false;
			blue = false;
			break;
		case R.id.yellow:
			yellow = true;
			red = false;
			blue = false;
			break;
		case R.id.blue:
			blue = true;
			red = false;
			yellow = false;
			break;
		}
		return;
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.b1:
			if(red == true){
				row1col1.setBackgroundResource(R.drawable.red);
				answer1 = RED;
			}
			if(yellow == true){
				row1col1.setBackgroundResource(R.drawable.yellow);
				answer1 = YELLOW;
			}
			if(blue == true){
				row1col1.setBackgroundResource(R.drawable.blue);
				answer1 = BLUE;
			}
			break;
		case R.id.b2:
			if(red == true){
				row1col2.setBackgroundResource(R.drawable.red);
				answer2 = RED;
			}
			if(yellow == true){
				row1col2.setBackgroundResource(R.drawable.yellow);
				answer2 = YELLOW;
			}
			if(blue == true){
				row1col2.setBackgroundResource(R.drawable.blue);
				answer2 = BLUE;
			}
			break;
		case R.id.b3:
			if(red == true){
				row1col3.setBackgroundResource(R.drawable.red);
				answer3 = RED;
			}
			if(yellow == true){
				row1col3.setBackgroundResource(R.drawable.yellow);
				answer3 = YELLOW;
			}
			if(blue == true){
				row1col3.setBackgroundResource(R.drawable.blue);
				answer3 = BLUE;
			}
			break;
		case R.id.submit:
			if(answer1 == x1 && answer2 == x2 && answer2 == x3){
				AlertDialog alertDialog = new AlertDialog.Builder(this).create();
				alertDialog.setTitle("Congratulations!");
				alertDialog.setMessage("You beat level 1.");
				alertDialog.show();
				showAns();
				btnNext.setEnabled(true);
			}
			else
			{
				AlertDialog alertDialog = new AlertDialog.Builder(this).create();
				alertDialog.setTitle("Incomplete!");
				alertDialog.setMessage("Try Again.");
				alertDialog.show();
				
				
				//test
			}
			break;
		case R.id.toleveltwo:
			
			break;
		}
		return;
	}


	private void showAns() {
		// TODO Auto-generated method stub
		if(answer1 == RED){
			ans1.setBackgroundResource(R.drawable.red);
		}
		else if(answer1 == YELLOW){
			ans1.setBackgroundResource(R.drawable.yellow);
		}
		else{
			ans1.setBackgroundResource(R.drawable.blue);
		}
		if(answer2 == RED){
			ans2.setBackgroundResource(R.drawable.red);
		}
		else if(answer2 == YELLOW){
			ans2.setBackgroundResource(R.drawable.yellow);
		}
		else{
			ans2.setBackgroundResource(R.drawable.blue);
		}
		if(answer3 == RED){
			ans3.setBackgroundResource(R.drawable.red);
		}
		else if(answer3 == YELLOW){
			ans3.setBackgroundResource(R.drawable.yellow);
		}
		else{
			ans3.setBackgroundResource(R.drawable.blue);
		}
	}


}
