JavaApplication1.java
======================

JavaApplication1.java는 경북대학교 학생들이 본인이 듣고자 하는 강의 혹은 후기가 궁금한 교수님의 강좌에 대하여 과거 수강생들이 직접 작성한 생생한 후기를 조회하여 볼 수 있도록 하며 동시에 이용자들이 지속적으로 후기를 등록하는 것도 가능한 프로그램 입니다. Eclipse를 통해 java로 구현되어 있습니다.


## 기본 기능 설명
![login](https://user-images.githubusercontent.com/44903476/48906972-8733c200-eea9-11e8-94f4-f95e68b85896.png)
* 프로그램을 실행하면 이와 같이 화면이 구성된다. 처음 신규이용자인지 기존이용자인지를 선택 한 후 신규이용자인 경우 학번과 비밀번호를 입력하여 계정을 새로 생성 할 수 있으며 새로 생성하게 되면 학번은 student_no.txt파일, 비밀번호는 passwd.txt파일에 추가된다. 기존이용자인 경우 등록되어있는 학번과 비밀번호를 입력 한 후 로그인 할 수 있다. 또한 비밀번호를 5번 이상 잘못 입력할 시에는 프로그램이 종료된다.

![menu](https://user-images.githubusercontent.com/44903476/48907014-a599bd80-eea9-11e8-9703-088d00e5a665.png)
* 로그인을 하고 나면 메인 메뉴가 나오게 되고 메인메뉴에서 원하는 메뉴의 번호를 선택한다. 위 그림에서는 예로 수강후기 조회를 선택하였다.

![ex](https://user-images.githubusercontent.com/44903476/48907137-f3162a80-eea9-11e8-8d4d-b3cc7469158a.png)
* 과목의 목록이 나오고 그 중 원하는 과목의 번호를 입력한다. 그러면 그 과목을 개설한 교수님들의 목록이 나오고 후기를 보고자 하는 교수님의 번호를 입력한다. 그러면 test_1-1.txt~test_5-3.txt 중 그에 해당하는 과목, 교수님의 수강후기가 저장되어있는 파일 안의 내용들이 출력 된다. 처음화면으로 돌아가려면 1을 입력하면 되고 메인화면으로 돌아가게 된다.

![insert](https://user-images.githubusercontent.com/44903476/48909916-f0b7ce80-eeb1-11e8-95d3-f553dc666bb4.png)
* 초기메뉴에서 수강후기 작성을 선택하게 되면 조회와 같이 과목과 교수님을 선택하게 되고 선택 한 후 1에서 5점 사이의 평점을 주고 후기를 남길 수 있다. 후기를 남기게 되면 후기는 test_1-1.txt~test_5-3.txt 파일 중 그에 해당하는 파일에 평점과 함께 저장된다. 평점은 1에서 5점에 해당하는 ★의 갯수로 변환되어 저장된다. 

![change](https://user-images.githubusercontent.com/44903476/48910431-49d43200-eeb3-11e8-9bd9-4cc3256b6d31.png)
* 메인메뉴에서 비밀번호 변경을 선택하게 되면 비밀번호를 변경할 수 있다. 초기 비밀번호를 입력하여야 하고 입력한 초기 비밀번호가 passwd.txt에 저장되어있는 것과 일치하지 않으면 잘못입력되었음을 알려주며 재입력 하도록 한다. 제대로 된 초기 비밀번호를 입력하면 비밀번호를 변경 할 수 있게 되고 변경된 비밀번호는 passwd.txt파일에 저장되어있던 이전 비밀번호 대신 저장된다.

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
  ````
student_no.txt와 passwd.txt파일에 저장된 정보들을 배열로 변환한 data를 비교하였다. while문을 이용하여 일치하는 경우 true값을 출력하고 그렇지 않으면 i(틀린횟수)를 1씩 증가시키도록 하였다.

> While문




 


## student_no.txt

이 파일은 프로그램에서 신규이용자 등록 시 입력한 학번이 저장되는 파일입니다.


## password.txt

이 파일은 프로그램에서 신규이용자 등록 시 입력한 비밀번호가 저장되는 파일입니다.


## test_1-1.txt ~ test_5-3.txt

이 파일들은 각 과목별 교수님의 수강후기가 저장되는 파일입니다. 여기서 test_A-B.txt에서 A는 과목의 번호이고 B는 교수님의 번호입니다.
