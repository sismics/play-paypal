package helpers.api.paypal.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author jtremeaux
 */
public class Resource {

    public String id;

    public String state;

    public Amount amount;

    @SerializedName("payment_mode")
    public String paymentMode;

    @SerializedName("protection_eligibility")
    public String protectionEligibility;

    @SerializedName("protection_eligibility_type")
    public String protectionEligibilityType;

    @SerializedName("transaction_fee")
    public TransactionFee transactionFee;

    @SerializedName("create_time")
    public String createTime;

    @SerializedName("update_time")
    public String updateTime;

    public List<Link> links;

    @SerializedName("soft_descriptor")
    public String softDescriptor;

}

