package com.example.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;

import com.example.fragment.HomeFragment;
import com.example.fragment.MenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

	private SlidingMenu sm;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setBehindContentView(R.layout.menu);
		setContentView(R.layout.content);

		sm = getSlidingMenu();
		sm.setMode(SlidingMenu.LEFT);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setShadowWidth(R.dimen.shadow_width);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		MenuFragment menuFragment = new MenuFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, menuFragment, "Menu").commit();

		HomeFragment homeFragment = new HomeFragment();
		getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
				homeFragment).commit();
	}
	
	public MenuFragment getMenuFragment(){
		return (MenuFragment) getSupportFragmentManager().findFragmentByTag("Menu");
	}

	public void switchFragment(Fragment f) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, f).commit();
		sm.toggle();
	}
}