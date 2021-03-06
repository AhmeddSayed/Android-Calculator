package com.ahmeddabdallah.calculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class AnswerActivity extends ActionBarActivity
{
	private EditText ResultsText;

	@Override
	protected void onCreate (Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		setContentView(R.layout.activity_answer);


		ResultsText = (EditText) findViewById(R.id.editText2);
		ResultsText.setText(intent.getStringExtra("Answer"));
	}


	@Override
	public boolean onCreateOptionsMenu (Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_answer, menu);
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
}
