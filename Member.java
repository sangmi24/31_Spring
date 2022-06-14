package com.kh.spring.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * * Lombok(롬복)
 * - 자동 코드 완성 라이브러리
 * - 반복되는 getter, setter , toString , 생성자 등의 메소드 작성 코드를 줄여주는 라이브러리
 * 
 * * Lombok 설치 방법
 * 1. 라이브러리 다운 후 적용 (Maven pom.xml)
 * 2. 다운로드 된 jar 파일을 찾아서 실행( 작업 할 IDE 를 선택)
 * 3. IDE 재 실행
 * 
 * * Lombok 사용시 주의사항
 * - 명명법 때문에 팀원이 전부 사용할건지 안할건지 룰을 맞춰줘야 함
 * - 명명법 때문에 필드명의 가장 앞 단어가 외자가 되면 안됨
 *  ex) userNo(O) => uNo(X) => setUNo() / getUNo() => 우리의 명명법, EL도 이 명명법을 사용해서 getter 호출
 *                          => setuNo() / getuNO() => Lombok 의 표기법
 *      userName(o) uName(x)
 */

@NoArgsConstructor//기본생성자
@AllArgsConstructor //모든 필드를 매개변수로 갖는 생성자
@Setter // setter 메소드들
@Getter // getter 메소드들
@ToString // toString 메소드
public class Member {

	private String userId; //USER_ID
	private String userPwd; //USER_PWD
	private String userName; //USER_NAME
	private String email; //EMAIL
	private String gender; //GENDER
	//private int age; //AGE
	private String age; //400에러 해결방법
	private String phone; //PHONE
	private String address; //ADDRESS
	private Date enrollDate; //ENROLL_DATE
	private Date modifyDate; //MODIFY_DATE
	private String status; //STATUS
	
	
}
