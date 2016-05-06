package automaty;

/**
 * Created by pawel on 04.05.16.
 */
public class Regula {


    int bit[] = {0,1,0,1,1,0,1,0};


    public void init(int bit[]){
        this.bit = bit;
    }

    public int check(int l, int s , int p)
    {

        if(l==1 && s==1 && p==1)
            return bit[0];

        else if(l==1 && s==1 && p==0)
            return bit[1];

        else if(l==1 && s==0 && p==1)
            return bit[2];

        else if(l==1 && s==0 && p==0)
            return bit[3];

        else if(l==0 && s==1 && p==1)
            return bit[4];

        else if(l==0 && s==1 && p==0)
            return bit[5];
        else if(l==0 && s==0 && p==1)
            return bit[6];
        else if(l==0 && s==0 && p==0)
            return bit[7];
        else return 2;
    }


}
