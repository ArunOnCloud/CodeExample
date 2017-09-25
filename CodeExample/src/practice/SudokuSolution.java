package practice;

import java.util.HashMap;
import java.util.Map;

public class SudokuSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void solveSudoku(char[][] board)
	{
		char[][] boardUtil=board.clone();
		solveSudokuUtil(board, boardUtil, 0, 0);
	}
	
	public boolean solveSudokuUtil(char[][] board,char[][] boardUtil,int r,int c)
	{
		boolean result=false;
		int count=0;
		
		for(int i=r;i<board.length;i++)
		{
			int m=0;
		    if(count==0)
		    {
		    	m=c;
		    }
			for(int j=m;j<board.length;j++)				
			{
				int possibleValue=1;
				if(board[i][j]== '.')
				{
					for(int ind=1;ind<10;ind++)
					{
						boardUtil[i][j]= (char)(ind + (int)'0');
						if(checkRow(boardUtil, i, j) && checkColumn(boardUtil, i, c))
						{	
							if(solveSudokuUtil(board, boardUtil, i, j))
							{
								return true;
							}
						}
					}
				}
				
			}
			count++;
		}
		
		return false;
		
		
	}
	public boolean checkRow(char[][] board,int r,int c)
	{
		boolean result=true;
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<board[r].length;i++)
		{
			if(board[r][i]!='.')
			{
				int val= (int)(board[r][i]-'0');
				if(map.containsKey(val))
				{
					result=false;
					
					break;
					
				}else
				{
					map.put(val, 1);
				}
			}
			
		}
		
		
		return result;
		
	}
	public boolean checkColumn(char[][] board,int r,int c)
	{
		boolean result=true;
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<board[r].length;i++)
		{
			if(board[i][c]!='.')
			{
				int val= (int)(board[i][c]-'0');
				if(map.containsKey(val))
				{
					result=false;
					
					break;
					
				}else
				{
					map.put(val, 1);
				}
			}
			
		}
		
		
		return result;
		
	}

	public boolean validateBoard(char[][] board)
	{
		boolean result=true;
		for(int i=0;i<board[0].length;i++)
		{
			if(!checkColumn(board, 0, i))
			{
			   return false;	
			}
		}
		for(int i=0;i<board[0].length;i++)
		{
			if(!checkRow(board, i, 0))
			{
			   return false;	
			}
		}
		return true;
	}


}
