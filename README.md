JavaApplication1.java
======================

JavaApplication1.java는 경북대학교 학생들이 본인이 듣고자 하는 강의 혹은 후기가 궁금한 교수님의 강좌에 대하여 과거 수강생들이 직접 작성한 생생한 후기를 조회하여 볼 수 있도록 하며 동시에 이용자들이 지속적으로 후기를 등록하는 것도 가능한 프로그램 입니다. Eclipse를 통해 java로 구현되어 있습니다.


## 기본 동작
![login](https://user-images.githubusercontent.com/44903476/48906972-8733c200-eea9-11e8-94f4-f95e68b85896.png)
* 프로그램을 실행하면 이와 같이 화면이 구성된다. 처음 신규이용자인지 기존이용자인지를 선택 한 후 신규이용자인 경우 학번과 비밀번호를 입력하여 계정을 새로 생성 할 수 있으며 기존이용자인 경우 등록되어있는 학번과 비밀번호를 입력 한 후 로그인 할 수 있다.

![menu](https://user-images.githubusercontent.com/44903476/48907014-a599bd80-eea9-11e8-9703-088d00e5a665.png)
* 로그인을 하고 나면 메인 메뉴가 나오게 되고 메인메뉴에서 원하는 메뉴의 번호를 선택한다. 위 그림에서는 예로 수강후기 조회를 선택하였다.





## 코드 설명

- 로그인 시 입력한 학번과 비밀번호가 파일에 등록되어있는 것과 같은지 확인하는 코드는 다음과 같다.
```
public class JavaApplication1 {
	static boolean login_process(String[] a, String[] b, String strNo, String strPW) {
		boolean bflag = false;
		int i = 0;
		while (i < a.length) {
			if ((strNo.equals(a[i]) == true) && (strPW.equals(b[i]) == true)) {
				bflag = true;
				break;
			}
			i++;
		}
		return bflag;
	}
  ```
 -> 기본적인 구조는 로그인 시 학번과 비밀번호가 맞는지 확인


 


## student_no.txt

이 파일은 프로그램에서 신규이용자 등록 시 입력한 학번이 저장되는 파일입니다.


## password.txt

이 파일은 프로그램에서 신규이용자 등록 시 입력한 비밀번호가 저장되는 파일입니다.


## test_1-1.txt ~ test_5-3.txt

이 파일들은 프로그램을 테스트 하기 위하여 임의로 작성하여 첨부한 파일입니다.
