package tub.ods.pch.contract.model;

public class Contractmerkle {
    private int startDate;
    private int channelTimeout;
    private String channelRecipient;
    private String channelSender;
    private String roots;

    public int getChannelTimeout() {
        return channelTimeout;
    }

    public void setChannelTimeoutTimeout(int channelTimeout) {
        this.channelTimeout = channelTimeout;
    }

    public int getStartDate(){return startDate;}

    public void setStartDate(int startDate){
        this.startDate = startDate;
    }

    public String getChannelRecipient() {
        return channelRecipient;
    }

    public void setChannelRecipient(String channelRecipient) {
        this.channelRecipient = channelRecipient;
    }


    public String getChannelSender() {
        return channelSender;
    }

    public void setChannelSender(String channelSender) {
        this.channelSender = channelSender;
    }


    //it should be converted to string I think
    public String getRoots() {
        return roots;
    }

    public void setRoots(String address) {
        this.roots = roots;
    }

    public Contractmerkle createContract(Contractmerkle newContract) {
        return null;
    }
}
