package hr.istrability.foreground_service_bug;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView; // Declare WebView instance variable

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), true); // Example: if you don't want edge-to-edge
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.webView); // Find the WebView by its ID

        // Enable JavaScript (optional, but many sites need it)
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        // Set a WebViewClient to handle page navigation within the WebView
        // Without this, links might open in the device's default browser app
        myWebView.setWebViewClient(new WebViewClient());

        // Or load local HTML content:
        myWebView.loadData("<html><body><h1>Hello, WebView!</h1></body></html>", "text/html", "UTF-8");
    }

}