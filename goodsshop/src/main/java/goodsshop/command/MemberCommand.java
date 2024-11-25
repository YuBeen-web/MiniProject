package goodsshop.command;

import java.util.Date;

import lombok.Data;

@Data
public class MemberCommand {
	String memberNum;
	String memberId;
	String memberPw;
	String memberPwCon;
	String memberName;
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	String memberPhone;
	String gender;
	Date memberBirth;
	String memberEmail;
	Date memberRegist;
}
