package Backtracking;
public class Soduku {

public static boolean  isSafe(int soduku[][],int row,int col,int digit){

    //column 

    for(int i=0;i<=8;i++){
       if(soduku[i][col] == digit){
        return false;
       }
    }

    // ROW

    for(int j=0;j<=8;j++){
        if(soduku[row][j] == digit){
         return false;
        }
     }


     // Grid

     int sr =(row/3)*3;
     int sc =(col/3)*3;

     // 3 X 3 GRID

     for(int i=sr;i<sr+3;i++){
        for(int j=sc;j<sc+3;j++){
            if(soduku[i][j]==digit){
                return false;
            }

        }
     }

return true;

}



public static boolean  Soduku_logix(int soduku[][],int row,int col){

        // base case 
        if(row == 9 && col == 0){
            return true;
        }
       

        //Recusrsion

        int nextROW = row;
        int nextCOL = col+1;

        if(col+1 == 9){
            nextROW=row+1;
            nextCOL =0;
         }
         
         if(soduku[row][col]!=0){
            return Soduku_logix(soduku, nextROW, nextCOL);
         }

         for(int digit=1; digit<=9; digit++){
            if(isSafe(soduku,row,col,digit)){
                soduku[row][col]=digit;

                if(Soduku_logix(soduku,nextROW,nextCOL)){ 
                return true;   
            }       
            soduku[row][col]=0;
        }
    }
    return false;
}

public static void  printsoduku(int soduku[][]) {
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            System.out.print(soduku[i][j]+ " ");
        }
       System.out.println();
    }
    
}

public static void main(String []args){
            int soduku[][]={{5,0,1,2,0,0,0,0,6},
                            {0,4,0,8,0,0,9,2,0},
                            {0,6,0,0,0,0,0,0,1},
                            {0,0,0,0,2,0,0,9,8},
                            {0,0,0,7,0,3,0,0,0},
                            {2,7,0,0,1,0,0,0,0},
                            {4,0,0,0,0,0,0,1,0},
                            {0,5,3,0,0,2,0,8,0},
                            {6,0,0,0,0,9,2,0,3}};

                        if(Soduku_logix(soduku, 0, 0)){
                            System.out.println("Solutio exists");
                            printsoduku(soduku);
                        }
                        else{
                            System.out.println("solution does not exists");
                        }


}
}