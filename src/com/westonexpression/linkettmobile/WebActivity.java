package com.westonexpression.linkettmobile;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.westonexpressions.linkettmobile.R;

public class WebActivity extends Activity {

	private WebView webView;
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webcontent);
		
		webView = (WebView) findViewById(R.id.webView);	
//		webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
		webView.setWebChromeClient(new WebChromeClient() {});
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);
		webView.setInitialScale(50);
		webView.getSettings().setDefaultZoom(ZoomDensity.FAR);
		webView.loadUrl("http://westonexpressions.co");	
		
		webView.setWebViewClient(new WebViewClient(){

		    @Override
		    public boolean shouldOverrideUrlLoading(WebView view, String url){
		      view.loadUrl(url);
		      return true;
		    }
		});
	}
	
	 @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	        if(event.getAction() == KeyEvent.ACTION_DOWN){
	            switch(keyCode)
	            {
	            case KeyEvent.KEYCODE_BACK:
	                if(webView.canGoBack() == true){
	                	webView.goBack();
	                }else{
	                    finish();
	                }
	                return true;
	            }

	        }
	        return super.onKeyDown(keyCode, event);
	    }
}
