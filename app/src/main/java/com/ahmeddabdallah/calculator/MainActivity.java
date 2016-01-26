package com.ahmeddabdallah.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.*;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity
{
	private EditText NumberScr;
	private ButtonClickListener BtnClick = new ButtonClickListener();
	double number;
	public static double result;
	int decimalValue;
	boolean decimalMode;
	long Real, FloatN;
	int opID;


	@Override
	protected void onCreate (Bundle savedInstanceState)
	{

		this.number = 0;
		this.result = number;
		this.decimalValue = 0;
		this.decimalMode = false;
		opID = 0;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.NumberScr = (EditText) findViewById(R.id.editText);

		this.NumberScr.setText("0");

		int idList[] = {R.id.bClear, R.id.bRemainder, R.id.bAnswer, R.id.bDivide, R.id.bMultiply,
				R.id.bSubtract, R.id.b0, R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6,
				R.id.b7, R.id.b8, R.id.b9, R.id.bDot, R.id.bAdd};

		for (int id : idList) {
			View V = findViewById(id);
			V.setClickable(true);
			V.setOnClickListener(BtnClick);
		}
	}


	public void InsertNumber (int numberInserted)
	{

		if (!decimalMode) {
			Real = Real * 10 + numberInserted;
			NumberScr.setText(Long.toString(Real));

		} else {
			decimalValue++;
			FloatN = FloatN * 10 + numberInserted;
			NumberScr.setText(Long.toString(Real) + "." + Long.toString(FloatN));
		}

		number = Real + FloatN / 10 ^ decimalValue;


	}

	public void setDecimalMode (boolean decimalState)
	{
		this.decimalMode = decimalState;
	}

	@Override
	public boolean onCreateOptionsMenu (Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected (MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public void math (int opID)
	{
		switch (opID) {
			case 1: // Add
				result += number;
				break;
			case 2: // Divide
				result /= number;
				break;
			case 3: //Subtract
				result -= number;
				break;
			case 4: // Multiply
				result *= number;
				break;
			case 5: // Remainder
				result %= number;
				break;
		}

	}

	private class ButtonClickListener implements OnClickListener
	{
		public void onClick (View V)
		{
			switch (V.getId()) {
				case R.id.bClear:
					NumberScr.setText("0");
					Real = 0;
					FloatN = 0;
					setDecimalMode(false);
					decimalValue = 0;
					opID = 0;
					break;
				case R.id.b1:
					InsertNumber(1);
					break;
				case R.id.b2:
					InsertNumber(2);
					break;
				case R.id.b3:
					InsertNumber(3);
					break;
				case R.id.b4:
					InsertNumber(4);
					break;
				case R.id.b5:
					InsertNumber(5);
					break;
				case R.id.b6:
					InsertNumber(6);
					break;
				case R.id.b7:
					InsertNumber(7);
					break;
				case R.id.b8:
					InsertNumber(8);
					break;
				case R.id.b9:
					InsertNumber(9);
					break;
				case R.id.b0:
					InsertNumber(0);
					break;
				case R.id.bDot:
					if (!decimalMode) {
						setDecimalMode(true);
						NumberScr.setText(Long.toString(Real) + ".");
					}
					break;
				case R.id.bAdd:
					if (opID == 0) {
						opID = 1;
						result = number;
						number = 0;
						Real = 0;
						FloatN = 0;
						NumberScr.setText("+");
						setDecimalMode(false);
						decimalValue = 0;
					}
					break;
				case R.id.bDivide:
					if (opID == 0) {
						opID = 2;
						result = number;
						number = 0;
						Real = 0;
						FloatN = 0;
						NumberScr.setText("/");
						setDecimalMode(false);
						decimalValue = 0;
					}
					break;
				case R.id.bSubtract:
					if (opID == 0) {
						opID = 3;
						result = number;
						number = 0;
						Real = 0;
						FloatN = 0;
						NumberScr.setText("-");
						setDecimalMode(false);
						decimalValue = 0;
					}
					break;
				case R.id.bMultiply:
					if (opID == 0) {
						opID = 4;
						result = number;
						number = 0;
						Real = 0;
						FloatN = 0;
						NumberScr.setText("*");
						setDecimalMode(false);
						decimalValue = 0;
					}
					break;

				case R.id.bRemainder:
					if (opID == 0) {
						opID = 5;
						result = number;
						number = 0;
						Real = 0;
						FloatN = 0;
						NumberScr.setText("%");
						setDecimalMode(false);
						decimalValue = 0;
					}
					break;
				case R.id.bAnswer:
					math(opID);
					//NumberScr.setText(Double.toString(result));
					Intent i = new Intent(MainActivity.this,AnswerActivity.class);
					String Answer = Double.toString(result);
					i.putExtra("Answer",Answer);
					startActivity(i);
					break;

			}

		}
	}
}
