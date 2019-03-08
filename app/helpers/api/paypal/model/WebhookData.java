package helpers.api.paypal.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * @author jtremeaux
 */
public class WebhookData {
    public String id;

    @SerializedName("event_version")
    public String eventVersion;

    @SerializedName("create_time")
    public Date createTime;

    @SerializedName("resource_type")
    public String resourceType;

    @SerializedName("event_type")
    public String eventType;

    public String summary;

    public Resource resource;

    public List<Link> links;
}
