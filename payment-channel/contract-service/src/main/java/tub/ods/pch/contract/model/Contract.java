package tub.ods.pch.contract.model;

import org.web3j.abi.datatypes.generated.Bytes32;

public class Contract {
    private int startDate;
    private int channelTimeout;
    private String channelRecipient;
    private String channelSender;
    private Bytes32 roots;

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
    public Bytes32 getRoots() {
        return roots;
    }

    public void setRoots(Bytes32 address) {
        this.roots = roots;
    }

    public Contract createContract(Contract newContract) {
        return null;
    }
}
