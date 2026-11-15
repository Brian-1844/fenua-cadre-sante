package pf.fenua.cadre;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/** Enveloppe Android : affiche la version en ligne (GitHub Pages), donc toujours à jour.
 *  Sans réseau au tout premier lancement, elle affiche la copie embarquée dans l'APK. */
public class MainActivity extends Activity {
    private WebView web;
    private String home;
    private boolean fallback = false;

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        home = getString(R.string.app_url);
        web = new WebView(this);
        setContentView(web);
        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setDatabaseEnabled(true);
        s.setMediaPlaybackRequiresUserGesture(false);
        s.setUserAgentString(s.getUserAgentString() + " CadreFenuaApp/1");
        web.setWebViewClient(new WebViewClient() {
            @Override public boolean shouldOverrideUrlLoading(WebView v, WebResourceRequest r) {
                Uri u = r.getUrl();
                String url = u.toString();
                if (url.startsWith(home) || url.startsWith("file:///android_asset/")) return false;
                try { startActivity(new Intent(Intent.ACTION_VIEW, u)); } catch (Exception e) { /* aucun navigateur */ }
                return true;
            }
            @Override public void onReceivedHttpError(WebView v, WebResourceRequest r, android.webkit.WebResourceResponse resp) {
                // Adresse introuvable (dépôt pas encore en ligne) : copie embarquée.
                if (r.isForMainFrame() && !fallback && resp.getStatusCode() >= 400) {
                    fallback = true;
                    v.loadUrl("file:///android_asset/www/index.html");
                }
            }
            @Override public void onReceivedError(WebView v, WebResourceRequest r, WebResourceError e) {
                if (r.isForMainFrame() && !fallback) {
                    fallback = true;
                    v.loadUrl("file:///android_asset/www/index.html");
                }
            }
        });
        if (b != null) web.restoreState(b); else web.loadUrl(home);
    }

    @Override protected void onSaveInstanceState(Bundle out) { super.onSaveInstanceState(out); web.saveState(out); }

    @Override public void onBackPressed() {
        if (web.canGoBack()) web.goBack(); else super.onBackPressed();
    }
}
