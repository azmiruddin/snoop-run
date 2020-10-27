package tub.ods.pch.contract.channel;

import java.math.BigInteger;
import java.util.List;

import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Uint;
import org.web3j.abi.datatypes.generated.Uint256;

public class ChannelData {
    public Address address;
    public BigInteger _amount;
    public Uint settleTimeout;
    public long opened;
    public long closed;
    public long settled;
    public Address closingAddress;
    public Address sender;
    public Address receiver;
    public Uint256 balance;

    public StateUpdate sender_update;
    public StateUpdate receiver_update;

    public ChannelData() {
    }

    public class StateUpdate {
        public BigInteger _amount;
    }

    opened = ((Uint)data.get(0)).getValue().longValueExact();
    closed = ((Uint) data.get(1)).getValue().longValueExact();
    settled = ((Uint) data.get(2)).getValue().longValueExact();
    closingAddress = ((Address) data.get(3));
    sender = ((Address) data.get(5));
    receiver = ((Address) data.get(6));
    balance = ((Uint256) data.get(7));
    sender_update = new StateUpdate();
    sender_update._amount = (BigInteger) data.get(8);
    receiver_update = new StateUpdate();
    receiver_update._amount = (BigInteger) data.get(9);
}
