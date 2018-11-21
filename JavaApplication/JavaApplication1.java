/*
 * 후기 작성시 커서의 위치를 '후기 입력 :'뒤로 이동 후 작성하시오.
 * 알집에 첨부된 txt파일(student_no, passwd, test_○-○)을 현재 package 폴더에 모두 옮긴 후 실행하시오.
 */
package project;

import java.io.*;
import java.util.Scanner;

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
	}//로그인 시 학번과 비밀번호가 맞는지 확인

	static int readNoOfInfo(String fname) {
		FileReader fr = null;
		BufferedReader br = null;

		int i = 0;
		try {
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
			
			String stemp = br.readLine();
			while (stemp != null) {
				i++;
				stemp = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return i;
	}//학번, 비밀번호 개수 반환

	static String[] readinfo(String fname) {
		FileReader fr = null;
		BufferedReader br = null;
		
		int no = readNoOfInfo(fname);
		
		int i = 0;
		String[] str = new String[no];
		try {
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
			
			String stemp = br.readLine();
			while (stemp != null) {
				str[i++] = stemp;
				stemp = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}//학번, 패스워드가 입력된 파일 읽어서 배열로 반환

	static void saveinfo(String fname, String[] ndata) {
		FileWriter fr = null;
		BufferedWriter br = null;

		try {
			fr = new FileWriter(fname);
			br = new BufferedWriter(fr);
			
			for (int i = 0; i < ndata.length; i++) {
				br.write(ndata[i]);
				br.newLine();
			}
			
			br.close();
		} catch (IOException e) {
			System.err.println("File saving error!!");
			System.exit(0);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}//새 학번, 비밀번호 저장

	static int readdata(String str) {
		System.out.print(str);
		Scanner scan = new Scanner(System.in);
		String stemp = scan.nextLine();
		int ntemp = Integer.parseInt(stemp);
		
		return ntemp;
		
	}//선택하고자 하는 항목을 받음

	static int menu_1() {
		String stemp = "*********************************";
		stemp += "\n*\t1. 수강후기 조회\t\t*";
		stemp += "\n*\t2. 수강후기 작성\t\t*";
		stemp += "\n*\t3. 비밀번호 변경\t\t*";
		stemp += "\n*\t4. 종료\t\t\t*";
		stemp += "\n*********************************";
		System.out.println(stemp);
		
		int ntemp = readdata("이용하시려는 메뉴의 번호를 입력하세요. : ");
		return ntemp;
	}//메인 메뉴

	static int menu_2() {
		String stemp = "*********************************";
		stemp += "\n*\t1. 회로이론1\t\t*";
		stemp += "\n*\t2. 논리회로\t\t*";
		stemp += "\n*\t3. 전자장1\t\t\t*";
		stemp += "\n*\t4. 자바프로그래밍\t\t*";
		stemp += "\n*\t5. 전자공학실험1\t\t*";
		stemp += "\n*********************************";
		System.out.println(stemp);
		
		int ntemp = readdata("조회/작성하려는 과목번호 선택(이전화면으로 돌아가려면 6)? ");
		return ntemp;
	}//후기 조회 과목 메뉴

	static int menu_3(int no) {
		String stemp = "*********************************";
		if (no == 1) {
			stemp += "\n*\t1. 이슬비\t\t\t*";
			stemp += "\n*\t2. 오지랍\t\t\t*";
			stemp += "\n*\t3. 강하다\t\t\t*";
		} else if (no == 2) {
			stemp += "\n*\t1. 김논리\t\t\t*";
			stemp += "\n*\t2. 박회로\t\t\t*";
			stemp += "\n*\t3. 김치국\t\t\t*";
		} else if (no == 3) {
			stemp += "\n*\t1. 최전자\t\t\t*";
			stemp += "\n*\t2. 장자전\t\t\t*";
			stemp += "\n*\t3. 오늘도\t\t\t*";
		} else if (no == 4) {
			stemp += "\n*\t1. 일지매\t\t\t*";
			stemp += "\n*\t2. 홍길동\t\t\t*";
			stemp += "\n*\t3. 임꺽정\t\t\t*";
		} else if (no == 5) {
			stemp += "\n*\t1. 이전자\t\t\t*";
			stemp += "\n*\t2. 박공학\t\t\t*";
			stemp += "\n*\t3. 김실험\t\t\t*";
		}
		stemp += "\n*********************************";
		System.out.println(stemp);
		
		int ntemp = readdata("조회/작성하려는 교수님에 해당하는번호 입력(이전화면으로 돌아가려면 4)? ");
		return ntemp;
	}//후기 조회 교수님 메뉴 

	static void showfile(String fname) {
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
			String stemp = null;
			
			System.out.println("\n\n*********************************");
			while ((stemp = br.readLine()) != null)
				System.out.println(stemp);
			System.out.println("*********************************\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ee) {
				ee.printStackTrace();
			}
		}
	}//후기 조회할 파일 출력

	static boolean changePW(String no, String pw) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학번을 입력하시오: ");
		String strNo = scanner.nextLine();
		
		System.out.print("비밀번호를 입력하시오(4자리 숫자): ");
		String strPW = scanner.nextLine();
		
		
		boolean bflag = false;
		if (strNo.equals(no) == true && strPW.equals(pw) == true) {
			System.out.print("새로운 비밀번호를 입력하시오(4자리 숫자): ");
			String strNewPW = scanner.nextLine();
			
			String fname_no = "student_no.txt";
			int ntemp = readNoOfInfo(fname_no);
			
			String[] studentNo = new String[ntemp];
			String[] passwd = new String[ntemp];
			studentNo = readinfo(fname_no);
			
			String fname_pw = "passwd.txt";
			passwd = readinfo(fname_pw);
			
			for (int i = 0; i < ntemp; i++) {
				if (studentNo[i].equals(strNo) == true) {
					passwd[i] = strNewPW;
					break;
				}
			}
			
			saveinfo(fname_pw, passwd);
			
			bflag = true;
		}
		return bflag;
	}//비밀번호 변경

	public static void main(String[] args) {
		
		int loginN = 0;
		String fname = "student_no.txt";
		int no = readNoOfInfo(fname);
		
		String[] studentNo = new String[no];
		String[] passwd = new String[no];
		studentNo = readinfo(fname);
		
		fname = "passwd.txt";
		passwd = readinfo(fname);
		
		System.out.print("************경북대학교 수강 후기 조회 프로그램입니다***********");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\n신규 이용자는 1, 기존 이용자는 2를 입력: ");
		String mmm = scanner.nextLine();
		int nnn = Integer.parseInt(mmm);
		
		System.out.print("학번을 입력하시오: ");
		String strNo = scanner.nextLine();
		
		System.out.print("비밀번호를 입력하시오(4자리 숫자): ");
		String strPW = scanner.nextLine();
		//초기 로그인 화면
		
		if (nnn == 1) {
			int nolength = studentNo.length;
			
			String[] aaa1 = new String[no + 1];
			String[] aaa2 = new String[no + 1];
			for (int i = 0; i < no; i++) {
				aaa1[i] = studentNo[i];
				aaa2[i] = passwd[i];
			}
			aaa1[no] = strNo;
			aaa2[no] = strPW;
			
			fname = "student_no.txt";
			saveinfo(fname, aaa1);
			
			fname = "passwd.txt";
			saveinfo(fname, aaa2);
		}//신규 이용자일 시 학번, 비밀번호 등록
		else if(nnn==2){
        	while(true){
        		boolean bflag=login_process(studentNo,passwd,strNo,strPW);
                if(bflag){
                    System.out.println("\n\t로그인 되었습니다!\n");
                    break;
                }
                else{
                	loginN++;
                    System.out.printf("%d번 실패하셨습니다.(5번 실패시 프로그램이 종료됩니다.)\n", loginN);
                    System.out.print("학번을 입력하시오: ");
                    strNo=scanner.nextLine();
                    
                    System.out.print("비밀번호를 입력하시오(4자리 숫자): ");
                    strPW=scanner.nextLine();
                    if(loginN==4){
                    	System.out.println("실패 허용 횟수를 초과하였습니다. 프로그램이 종료됩니다.");
                    	System.exit(0);
                    }
                }

        	}
        	
                   }

		else
			System.exit(0);
		//기존 이용자일 시 학번과 비밀번호가 일치하는지 확인
		while (true) {
			int ntemp = menu_1();
			int ntemp2 = 0;
			String subject = "";
			String prof = "";
			String subjectCode = "test_";
			while (true) {
				switch (ntemp) {
				case 1:
					ntemp2 = menu_2();

					
					switch (ntemp2) {
					case 1:
						subject = "회로이론 1";
						break;
					case 2:
						subject = "논리회로";
						break;
					case 3:
						subject = "전자장1";
						break;
					case 4:
						subject = "자바프로그래밍";
						break;
					case 5:
						subject = "전자공학실험1";
						break;
					}
					break;
				case 2:
					ntemp2 = menu_2();

					
					switch (ntemp2) {
					case 1:
						subject = "회로이론 1";
						break;
					case 2:
						subject = "논리회로";
						break;
					case 3:
						subject = "전자장1";
						break;
					case 4:
						subject = "자바프로그래밍";
						break;
					case 5:
						subject = "전자공학실험1";
						break;
					}
					break;
				case 3:
					boolean bflag = changePW(strNo, strPW);
					if (bflag) {
						System.out.println("\n비밀번호가 정상적으로 변경되었습니다.");
						break;
					} else
						System.out.println("\n학번과 비밀번호를 확인 후 다시 시도하여 주십시오.");
					bflag = changePW(strNo, strPW);
					break;
				case 4:
					System.exit(0);
				}
				if (ntemp == 3 || ntemp2 == 6)
					break;
				int ntemp3 = 0;
				while (true) {
					ntemp3 = menu_3(ntemp2);
					
					if (ntemp3 == 4) {
						break;
					}
					

					
					switch (ntemp2) {
					case 1:
						switch (ntemp3) {
						case 1:
							prof = "이슬비";
							subjectCode += "1-1.txt";
							break;
						case 2:
							prof = "오지랍";
							subjectCode += "1-2.txt";
							break;
						case 3:
							prof = "강하다";
							subjectCode += "1-3.txt";
							break;
						}
						break;
					case 2:
						switch (ntemp3) {
						case 1:
							prof = "김논리";
							subjectCode += "2-1.txt";
							break;
						case 2:
							prof = "박회로";
							subjectCode += "2-2.txt";
							break;
						case 3:
							prof = "김치국";
							subjectCode += "2-3.txt";
							break;
						}
						break;
					case 3:
						switch (ntemp3) {
						case 1:
							prof = "최전자";
							subjectCode += "3-1.txt";
							break;
						case 2:
							prof = "장자전";
							subjectCode += "3-2.txt";
							break;
						case 3:
							prof = "오늘도";
							subjectCode += "3-3.txt";
							break;
						}
						break;
					case 4:
						switch (ntemp3) {
						case 1:
							prof = "일지매";
							subjectCode += "4-1.txt";
							break;
						case 2:
							prof = "홍길동";
							subjectCode += "4-2.txt";
							break;
						case 3:
							prof = "임꺽정";
							subjectCode += "4-3.txt";
							break;
						}
						break;
					case 5:
						switch (ntemp3) {
						case 1:
							prof = "이전자";
							subjectCode += "5-1.txt";
							break;
						case 2:
							prof = "박공학";
							subjectCode += "5-2.txt";
							break;
						case 3:
							prof = "김실험";
							subjectCode += "5-3.txt";
							break;
						}
						break;
					}
					String stemp = "과목명 : " + subject;
					stemp += "\n교  수 : " + prof;
					stemp += "\n파일명 : " + subjectCode;
					
					System.out.println(stemp);
					if (ntemp == 1)
						showfile(subjectCode);
					else {
						System.out.print("후기 입력(Ex. 개념 중심으로 자세히 설명해 주시고 과제도 적당합니다. 시험은 조금 어려운 편입니다(*****) ): ");
						Scanner scan = new Scanner(System.in);
						String sc = scan.nextLine();
						
						File f = new File(subjectCode);
						String[] stringtemp;
						
						int nnnn = 0;
						boolean fileexistornot = false;
						if (f.exists()) {
							fileexistornot = true;
							
							FileReader frfr = null;
							BufferedReader brbr = null;
							try {
								frfr = new FileReader(subjectCode);
								brbr = new BufferedReader(frfr);
								String strstr = brbr.readLine();
								while (strstr != null) {
									++nnnn;
									strstr = brbr.readLine();
								}
								brbr.close();
							} catch (IOException e) {
								System.err.println("IO error!!");
							}
						}
						
						stringtemp = new String[nnnn + 10];
						
						FileReader fil = null;
						BufferedReader buf = null;
						
						try {
							fil = new FileReader(subjectCode);
							buf = new BufferedReader(fil);
							
							for (int i = 0; i < nnnn; i++)
								stringtemp[i] = buf.readLine();
							
							buf.close();
						} catch (IOException e) {
							System.err.println("BufferedReader() error!!");
						}
						
						FileWriter ffw = null;
						BufferedWriter fbw = null;
						
						try {
							ffw = new FileWriter(subjectCode);
							fbw = new BufferedWriter(ffw);
							
							if (fileexistornot) {
								for (int i = 0; i < nnnn; i++) {
									fbw.write(stringtemp[i]);
									fbw.newLine();
								}
							}
							
							fbw.write(sc);
							fbw.newLine();
							
							fbw.close();
						} catch (IOException e) {
							System.err.println("IOException error!!");
						}
					}
					

					subjectCode = "test_" + String.valueOf(ntemp2) + "-";
					break;
				}
				break;
			}
		}
	}
}
