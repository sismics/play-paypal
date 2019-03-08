package helpers.api.paypal.service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import helpers.api.paypal.PaypalClient;
import helpers.api.paypal.model.WebhookData;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author jtremeaux
 */
public class WebhookService {
    public PaypalClient paypalClient;

    public WebhookService(PaypalClient paypalClient) {
        this.paypalClient = paypalClient;
    }

    /**
     * Unmarshall the Webhook data.
     *
     * @return The webhook data
     */
    public WebhookData processWebhook(InputStream is) {
        Reader reader = new InputStreamReader(is);
        return new Gson().fromJson(new JsonReader(reader), WebhookData.class);
    }
}
