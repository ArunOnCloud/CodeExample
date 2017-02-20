package practice;

public class ZemosoSecond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1200;
		int[] arr=new int[10];
		for(int i=0;i<10;i++)
			arr[i]=0;
		Integer num=n;
		String s=num.toString();
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			arr[(int)(c-'0')]++;
		}
		int dist=0;
		for(int i=0;i<10;i++)
		{
			if(arr[i]>0)
			{
				dist++;
			}
		}
		int res=fact(s.length());
		for(int i=0;i<10;i++)
		{
			if(arr[i]>0)
			{
				res=(res/fact(arr[i]));
			}
		}
		int dis=dist-1;
		int sub=0;
		
		if(arr[0]>0)
		{
			for(int i=0;i<arr[0];i++)
			{
				sub+=fact(dis);
			}
//			sub=fact(s.length()-1);
//			for(int i=0;i<10;i++)
//			{
//				if(arr[i]>0 && i!=0)
//				{
//					sub=(sub/fact(arr[i]));
//				}
//				if(arr[i]>0 && i==0)
//				{
//					sub=(sub/fact(arr[i]-1));
//				}
//			}
			
		}
		res=res-sub;
		System.out.println(res);

	}
	public static int fact(int n)
	{
		if(n==0 || n==1)
			return 1;
		int res=1;
		for(int i=1;i<=n;i++)
		{
			res=res*i;
		}
		return res;
			
	}

}
