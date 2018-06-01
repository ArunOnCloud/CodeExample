package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuSolution {

	public static void main(String[] args) {
		SudokuSolution sudokuSolution=new SudokuSolution();
       char[][] board= {{'.','.','9','7','4','8','.','.','.'},
    		   {'7','.','.','.','.','.','.','.','.'},
    		   {'.','2','.','1','.','9','.','.','.'},
    		   {'.','.','7','.','.','.','2','4','.'},
    		   {'.','6','4','.','1','.','5','9','.'},
    		   {'.','9','8','.','.','.','3','.','.'},
    		   {'.','.','.','8','.','3','.','2','.'},
    		   {'.','.','.','.','.','.','.','.','6'},
    		   {'.','.','.','2','7','5','9','.','.'}};
       for(int i=0;i<9;i++)
       {
    	   for(int j=0;j<9;j++)
    	   {
    		   System.out.print(board[i][j]+ " ");
    	   }
    	   System.out.println();
       }
       char[][] board1= {{'9','.','9','7','4','8','.','.','.'},
    		   {'7','.','.','.','.','.','.','.','.'},
    		   {'.','2','.','1','.','9','.','.','.'},
    		   {'.','.','7','.','.','.','2','4','.'},
    		   {'.','6','4','.','1','.','5','9','.'},
    		   {'.','9','8','.','.','.','3','.','.'},
    		   {'.','.','.','8','.','3','.','2','.'},
    		   {'.','.','.','.','.','.','.','.','6'},
    		   {'.','.','.','2','7','5','9','.','.'}};
       System.out.println(sudokuSolution.checkBox(board1, 0, 0));
       sudokuSolution.solveSudoku(board);
       
	}
	
	public void printBoard(char[][] board)
	{
		for(int i=0;i<9;i++)
	       {
	    	   for(int j=0;j<9;j++)
	    	   {
	    		   System.out.print(board[i][j]+ " ");
	    	   }
	    	   System.out.println();
	       }
	}
	
	
	
	public void solveSudoku(char[][] board)
	{
		//char[][] boardUtil=board.clone();
		char[][] boardUtil=new char[9][9];
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
				boardUtil[i][j]=board[i][j];
		}
		//solveSudokuUtil(board, boardUtil);
		//solveUtil(board,boardUtil);
		util(board,0);
		printBoard(board);
		//printBoard(boardUtil);
		System.out.println(checkBox(boardUtil, 1, 1));
	}
	boolean util(char[][] board,int ind)
    {
        //System.out.println("ind:"+ind);
        if(ind == 81)
        {
            return true;
        }else
        {
            //System.out.println("ind1:"+ind);
            int r=ind/9;
            int c=ind%9;
            if(board[r][c]!='.')
            {
                return util(board,ind+1);
            }
            for(int i=1;i<=9;i++)
            {
                Integer temp=i;
                char ch=temp.toString().charAt(0);
                //System.out.println("ch:"+ch);
                if(board[r][c] == '.')
                {
                    board[r][c] =ch;
                    if(isSafe( board,r,c))
                    {
                       // System.out.println("is safe ch:"+ch);
                         if(util(board,ind+1) )
                       {
                           return true;
                       }else
                       {
                           board[r][c] = '.';
                       }
                    }else
                    {
                         board[r][c] = '.';
                    }
                  
                }
                
            }
            return false;
            
        }
    }
	int ind=0;
	public boolean solveSudokuUtil(char[][] board,char[][] boardUtil)
	{
		boolean result=false;
		int count=0;
		int r=ind/9;
		int c=ind%9;
		if(ind>=81)
		{
			return false;
		}
		System.out.println("r:"+r+ " c:"+c);
		if(boardUtil[r][c] == '.')
		{
			for(int i=1;i<10;i++)
			{
			
				int val= (int)(board[r][c]-'0');
				boardUtil[r][c]= (char)(i + (int)'0');
				System.out.println("r:"+r+ " c:"+c);
				System.out.println("i:"+i);
				if(isSafe(boardUtil, r, c))
				{
					if(solveSudokuUtil(board, boardUtil))
					{
						return true;
					}else
					{
						ind--;
						boardUtil[r][c]='.';
					}
				}
				if(i==9)
				{
					boardUtil[r][c]='.';
				}
								
			}
		}else
		{
			if(ind<81)
			{
				return solveSudokuUtil(board,boardUtil);
			}
		}
		
		
		/*for(int i=r;i<board.length;i++)
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
		*/
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
     
	public boolean checkBox(char[][] board,int r,int c)
	{
		int i=(r/3) * 3;
		int j=(c/3) * 3;
		int i1=i+3;
		int j1=j+3;
		Set<Integer> set=new HashSet<Integer>();
		for(int m=i;m<i1;m++)
		{
			for(int n=j;n<j1;n++)
			{
				if(board[m][n] != '.')
			     {
					int val= (int)(board[m][n]-'0');
					if(set.contains(val))
					{
						return false;
					}else
					{
						set.add(val);
					}
				}
			}
		}
		return true;
		
	}
	public boolean isSafe(char[][] board,int r,int c )
	{
		return checkBox(board, r, c) && checkColumn(board, r, c) && checkRow(board, r, c);
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
    
	public boolean solveUtil(char[][] board,char[][] boardUtil){
		if(ind>=81)
		{
			return true;
		}else 
		{	
			int r=ind/9;
			int c=ind%9;
			if(ind == 15)
			{
				//System.out.println();
			}
			if(boardUtil[r][c] == '.')
			{
				for(int i=1;i<=9;i++)
				{
					Integer intVal=i;
					
					char ch=intVal.toString().charAt(0);
					boardUtil[r][c]=ch;
					if(isSafe(boardUtil, r, c)){
						ind++;
						if(solveUtil(board, boardUtil))
						{
							//ind++;
							return true;
						}else
						{
							//ind--;
							//boardUtil[r][c] = '.';
							//return false;
						}
					}else
					{
						
					}
				}
				if((9*r +c) == 15)
				{
					//System.out.println();
				}
				boardUtil[r][c] = '.';
				ind--;
				return false;
				
			}else
			{
			  ind++;
			  if(solveUtil(board, boardUtil))
			  {
				  return true;
			  }else
			  {
				  ind--;
				  return false;
			  }
			  //return solveUtil(board, boardUtil); 
			}
		}
	}

}
