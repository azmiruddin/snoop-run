pragma solidity ^0.4.22;

contract MerkleContract {
    address public channelSender;
    address  public channelRecipient;
    uint public startDate;
    uint public channelTimeout;
    bytes32 public roots;

    constructor (address to, uint _timeout, bytes32 _root) public payable {
        require(msg.value>0);
        channelRecipient = to;
        channelSender = msg.sender;
        startDate = now;
        channelTimeout = _timeout;
        roots = _root;
    }
    function AddBalance(bytes32 _newRoot) public payable {
        if (roots < _newRoot)
            roots = keccak256(abi.encodePacked(roots, _newRoot));
        else
            roots = keccak256(abi.encodePacked(_newRoot, roots));
    }
    function CloseChannel(uint256 _amount, bytes32[] memory proof) public  {
        require(msg.sender==channelRecipient);
        bytes32 computedHash = keccak256(abi.encodePacked(_amount));
        require(verifyMerkle(roots, computedHash, proof));
        channelRecipient.transfer(_amount);
        selfdestruct(channelSender);
    }
    function verifyMerkle (bytes32 root, bytes32 leaf, bytes32[] memory proof) public pure returns (bool) {
        bytes32 computedHash = leaf;
        for (uint256 i = 0; i < proof.length; i++) {
            if (computedHash < proof[i])
                computedHash = keccak256(abi.encodePacked(computedHash, proof[i]));
            else
                computedHash = keccak256(abi.encodePacked(proof[i], computedHash));
        }
        return computedHash==root;
    }
    function ChannelTimeout() public {
        require(now >= startDate + channelTimeout);
        selfdestruct(channelSender);
    }
}