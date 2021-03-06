pragma solidity >=0.4.22 <=0.6.0;

contract BlindAuction {

    struct Bid {                   
        bytes32 blindedBid;
        uint deposit;
    }

    // state will be set by beneficiary 
    // 初始化 -> 投標 -> 揭露結果 -> 結束競標
    enum Phase {Init, Bidding, Reveal, Done}  
    Phase public state = Phase.Init; 

    address payable beneficiary; //owner  
    mapping(address => Bid) bids;  


    address public highestBidder; 
    uint public highestBid = 0;   
    
    mapping(address => uint) depositReturns; 


    //modifiers
    modifier validPhase(Phase reqPhase) 
    { require(state == reqPhase); 
      _; 
    } 

   modifier onlyBeneficiary()
   { require(msg.sender == beneficiary); 
      _;
   }

    constructor() public {    
        beneficiary = msg.sender;
        state = Phase.Bidding;
    }

    function changeState(Phase x) public onlyBeneficiary {
        if (x < state ) revert();
        state = x;
    }
    
    // 競標環節中，競標者存入一些錢，並把想要出價的競標金額和自己設定的一次性密碼用 keccak256 hash 起來
    function bid(bytes32 blindBid) public payable validPhase(Phase.Bidding) {  
        bids[msg.sender] = Bid({
            blindedBid: blindBid,
            deposit: msg.value
        });
    }

    /*
    *   揭露環節中，競標者會各自去揭露，並用 keccak256 來確認是否和之前填入的金額是一樣的
    *   如果一樣就去 placebid
    *   出價為最高時，會退款 = 存入的錢 - 出價
    *   並且把之前最高的人的錢存到 depositReturns，讓他們可以退款
    *   出價不是最高時，會退款 = 存入的錢
    */
    function reveal(uint value, bytes32 secret) public validPhase(Phase.Reveal){
        uint refund = 0;

        Bid storage bidToCheck = bids[msg.sender];
        if (bidToCheck.blindedBid == keccak256(abi.encodePacked(value, secret))) {
            refund += bidToCheck.deposit;
            if (bidToCheck.deposit >= value) {
                if (placeBid(msg.sender, value)) {
                    refund -= value;
                }
            }
        }      
        msg.sender.transfer(refund);
    }

    // 揭露環節
    function placeBid(address bidder, uint value) internal 
            returns (bool success)
    {
        if (value <= highestBid) {
            return false;
        }
        if (highestBidder != address(0)) {
            // Refund the previously highest bidder.
            depositReturns[highestBidder] += highestBid;
        }
        highestBid = value;
        highestBidder = bidder;
        return true;
    }


    // 取回不是最高出價的錢
    function withdraw() public {   
        uint amount = depositReturns[msg.sender];
        require (amount > 0);
        depositReturns[msg.sender] = 0;
        msg.sender.transfer(amount);
    }
    
    
    // 結束競標，並把錢轉給beneficiary
    function auctionEnd() public validPhase(Phase.Done) {
        beneficiary.transfer(highestBid);
    }
}

    
    
