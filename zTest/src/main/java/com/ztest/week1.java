package com.ztest;

public class week1 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	
		System.out.println("Hello Java");
		Question_N01();
		Question_N02();
	}
	
	private static void Question_N02() {

		int count = 0;
		int a,b,c,d,e,f,g,h,i = 0;
		// a/(10d+e) +b/(10f+g)+ c/(10h+i) = 1
		
		for(a = 1; a<10; a++)
		{
			for(b = 1; b<10; b++)
			{
				for(c = 1; c<10; c++)
				{
					for(d = 1; d<10; d++)
					{
						for(e = 1; e<10; e++)
						{
							for(f = 1; f<10; f++)
							{
								for(g = 1; g<10; g++)
								{
									for(h = 1; h<10; h++)
									{
										for(i = 1; i<10; i++)
										{
											if(a!=b && a!=c && a!=d && a!=e && a!=f && a!=g && a!=h && a!=i &&
											   b!=c && b!=d && b!=e && b!=f && b!=g && b!=h && b!=i &&
											   c!=d && c!=e && c!=f && c!=g && c!=h && c!=i &&
											   d!=e && d!=f && d!=g && d!=h && d!=i &&
											   e!=f && e!=g && e!=h && e!=i &&
											   f!=g && f!=h && f!=i &&
											   g!=h && g!=i &&
											   h!=i)
											{
												if(a*(10*f+g)*(10*h+i)+b*(10*d+e)*(10*h+i)+c*(10*d+e)*(10*f+g) == (10*d+e)*(10*f+g)*(10*h+i))
												{
													count+=1;
													System.out.println("SUCCESS TO FIND Number(N0.2)");
													System.out.println(a+""+b+""+c+""+d+""+e+""+f+""+g+""+h+""+i);
												}
												
											}
											else
											{
												//count+=1;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
	}

	public static void Question_N01()
	{
		int count=0;
		int a,b,c,d,e,f,g,h,i = 0;
		//a+b+c = 18
		//d+e+f = 15
		//g+h+i = 12
		//100*(a+d+g) + 10*(b+e+h) + c+f+i = 2556
		//adg != 1,2,3,4,5
		
		for(a = 1; a<10; a++)
		{
			for(b = 1; b<10; b++)
			{
				for(c = 1; c<10; c++)
				{
					for(d = 1; d<10; d++)
					{
						for(e = 1; e<10; e++)
						{
							for(f = 1; f<10; f++)
							{
								for(g = 1; g<10; g++)
								{
									for(h = 1; h<10; h++)
									{
										for(i = 1; i<10; i++)
										{
											if(a!=b && a!=c && a!=d && a!=e && a!=f && a!=g && a!=h && a!=i &&
											   b!=c && b!=d && b!=e && b!=f && b!=g && b!=h && b!=i &&
											   c!=d && c!=e && c!=f && c!=g && c!=h && c!=i &&
											   d!=e && d!=f && d!=g && d!=h && d!=i &&
											   e!=f && e!=g && e!=h && e!=i &&
											   f!=g && f!=h && f!=i &&
											   g!=h && g!=i &&
											   h!=i)
											{
												//a+b+c = 18
												//d+e+f = 15
												//g+h+i = 12
												if(a+b+c ==18 && d+e+f ==15 && g+h+i ==12)
												{
													if(100*(a+d+g) + 10*(b+e+h) + c+f+i == 2556)
													{
														count+=1;
														System.out.println("SUCCESS TO FIND Number(N0.1)");
														System.out.println(100*a+10*b+c);
														System.out.println(100*d+10*e+f);
														System.out.println(100*g+10*h+i);
													}
													
												}
												
											}
											
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

}
