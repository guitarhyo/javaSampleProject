package com.ztest;

public class study01 {

	public static void main(String[] args) {
		/**1~9 숫자가 1번씩
		 * 		[]+[]+[]=18
		 * 		[]+[]+[]=15
		 * 		[]+[]+[]=12
		 * +
		 * ---------------
		 * 			2556
		 */
		Question_N01();
		
		/**1~9 숫자가 1번씩
		 * 		[]     []     []
		 *     -- +  -- +  --    = 1
		 *    [][]   [][]   [][]
		 */
		Question_N02();
	
		
	}

		private static void Question_N01() {
			int arr1[] = outNumAdd(18);///함수에서 결과가져오기
			int arr2[] = outNumAdd(15);
			int arr3[] = outNumAdd(12);
			
			System.out.println("문제 1번 답!!");
			boolean joongbokCheck = true;
			for (int i = 0; i < arr1.length; i++) {
				for (int j = 0; j < arr2.length; j++) {
					for (int k = 0; k < arr3.length; k++) {
						int ret = arr1[i]+arr2[j]+arr3[k];
						if(ret == 2556){
							
							String joongbok = String.valueOf(arr1[i])+String.valueOf(arr2[j])+String.valueOf(arr3[k]);
//							System.out.println(joongbok);
							    joongbokCheck = true;
							    LOOP1 : for (int l = 0; l < joongbok.length()-1; l++) {
							       char cNum = joongbok.charAt(l);
							       int checkNum = 0 ;
							       for (int num = l+1; num < joongbok.length(); num++) {
							         char dupNum = joongbok.charAt(num);
							          if(cNum == dupNum){
							             checkNum++;
							          }
							          if(checkNum > 0){
							             joongbokCheck = false;
							             break LOOP1;
							          }
							       }
							   }
							

							   
							if(joongbokCheck){
								System.out.println(arr1[i]);
								System.out.println(arr2[j]);
								System.out.println(arr3[k]);
							}
							
						}
					}
				}
			}

			
		}


		//해당 파라미터에 대하여 셋(1~9)을더한 숫자 합이 같은 경우의 숫자 배열 리턴
		public static int[] outNumAdd(int num){
			int[] arr = new int[3];
			int[] retArr = {};
			int[] tempArr = {};
			String str = "";
			
			for (int i = 1; i < 10; i++) {
				for (int j = 1; j < 10; j++) {
					for (int k = 1; k < 10; k++) {
						
							if((i+j+k) == num){
								arr[0]  = i;
								arr[1]  = j;
								arr[2]  = k;
								str = "";
								StringBuffer strBuf = new StringBuffer();
								
								for(int arri = 0; arri < arr.length; arri++){
									strBuf.append(arr[arri]);
									//str += ""+arr[arri];//이거보다는 버퍼가 효율적이다.
								}
								str = strBuf.toString() ;
								int ret =Integer.parseInt(str);
								
								tempArr = new int[tempArr.length+1];
								for (int l = 0; l < retArr.length; l++) {
									tempArr[l] = retArr[l];
								}
								tempArr[tempArr.length-1] =ret; 
								retArr = tempArr;
								
										
							}
							
					}
				}
			}
			
			
			return retArr;
			
		}	
	
	private static void Question_N02() {
		System.out.println("문제 2번 답!!");

		float temp;
		String[] ret = null;
		String[] tempRet = null;
		
		for (int i = 1; i < 10; i++) {
			for (int j= 12; j < 99; j++) {
				if(j%10==0 || j%11==0){
					continue;
				}
				temp = (float)i/(float)j;
				if((float)1 > temp){
					String str = ""+i+""+j;
					if(ret != null && ret.length >0){
						tempRet = ret;
						ret = new String[tempRet.length+1];
						for (int j2 = 0; j2 < tempRet.length; j2++) {
							ret[j2] = tempRet[j2];
						}
						ret[ret.length-1] =str;
					}else{
						ret = new String[1];
						ret[0] = str;
					}
					
				}
			}
		}
		
int count = 0;
		for (int i = 0; i < ret.length; i++) {
			for (int j = 0; j < ret.length; j++) {
				for (int k = 0; k < ret.length; k++) {
					float boonsu1 = (float)Integer.parseInt(ret[i].substring(0,1))/(float)Integer.parseInt(ret[i].substring(1));
					float boonsu2 = (float)Integer.parseInt(ret[j].substring(0,1))/(float)Integer.parseInt(ret[j].substring(1));
					float boonsu3 = (float)Integer.parseInt(ret[k].substring(0,1))/(float)Integer.parseInt(ret[k].substring(1));
					
					
					
					if((boonsu1+boonsu2+boonsu3)==(float)1){
						count++;
						String boonsuStrSum = ret[i]+ret[j]+ret[k];
						boolean joongbokCheck2 = true;
					    LOOP1 : for (int l = 0; l < boonsuStrSum.length()-1; l++) {
						       char cNum = boonsuStrSum.charAt(l);
						       for (int num = l+1; num < boonsuStrSum.length(); num++) {
						         char dupNum = boonsuStrSum.charAt(num);
						          if(cNum == dupNum){
						        	 
						        	  joongbokCheck2 = false;
						        	  break LOOP1;
						          }
						       }
						}
						
						if(joongbokCheck2){
							 System.out.println("["+ret[i].substring(0,1)+"]"+"/["+ret[i].substring(1)+"]+"+"["+ret[j].substring(0,1)+"]"+"/["+ret[j].substring(1)+"]+"+"["+ret[k].substring(0,1)+"]"+"/["+ret[k].substring(1)+"]");
						}
						 
					}
				}
			}
		}
		System.out.println("갯수는["+count+"]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
	}
	




}
