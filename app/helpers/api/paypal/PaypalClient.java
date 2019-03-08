package helpers.api.paypal;

import com.sismics.sapparot.function.CheckedConsumer;
import com.sismics.sapparot.function.CheckedFunction;
import com.sismics.sapparot.okhttp.OkHttpHelper;
import helpers.api.paypal.service.WebhookService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import play.Play;

import static org.mockito.Mockito.mock;

/**
 * @author jtremeaux
 */
public class PaypalClient {
    private OkHttpClient client;

    private static PaypalClient paypalClient;

    private WebhookService webhookService;

    public static PaypalClient get() {
        if (paypalClient == null) {
            paypalClient = new PaypalClient();
        }
        return paypalClient;
    }

    public PaypalClient() {
        client = createClient();
        if (isMock()) {
            webhookService = mock(WebhookService.class);
        } else {
            webhookService = new WebhookService(this);
        }
    }

    private boolean isMock() {
        return Boolean.parseBoolean(Play.configuration.getProperty( "paypal.mock", "false"));
    }

    private static OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    public String getPaypalUrl() {
        return Play.configuration.getProperty("paypal.url");
    }

    public String getUrl(String url) {
        return getPaypalUrl() + url;
    }

    public OkHttpClient getClient() {
        return client;
    }

    public WebhookService getWebhookService() {
        return webhookService;
    }

    public <T> T execute(Request request, CheckedFunction<Response, T> onSuccess, CheckedConsumer<Response> onFailure) {
        return OkHttpHelper.execute(getClient(), request, onSuccess, onFailure);
    }
}
