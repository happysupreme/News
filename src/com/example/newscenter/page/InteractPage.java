package com.example.newscenter.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.base.BasePage;

public class InteractPage extends BasePage {

	public InteractPage(Context context) {
		super(context);
	}

	@Override
	public View initView(LayoutInflater inflater) {
		TextView view = new TextView(context);
		view.setText("hudong");
		return view;
	}

	@Override
	public void initData() {
		System.out.println("hudong init");
	}

}