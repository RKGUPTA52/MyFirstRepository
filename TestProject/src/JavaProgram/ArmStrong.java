package JavaProgram;
/*
 * An Armstrong number is a positive m-digit number that is equal to the sum of
 *  the mth powers of their digits. It is also known as pluperfect, or Plus 
 *  Perfect, or Narcissistic number. It is an OEIS sequence A005188. Let’s 
 *  understand it through an example.

Armstrong Number Example
1: 11 = 1
2: 21 = 2
3: 31 = 3
153: 13 + 53 + 33 = 1 + 125+ 27 = 153
125: 13 + 23 + 53 = 1 + 8 + 125 = 134 (Not an Armstrong Number)
1634: 14 + 64 + 34 + 44 = 1 + 1296 + 81 + 256 = 1643
 */
import java.util.Scanner;
public class ArmStrong 
{
    public static void main(String[] args) 
    {
        int n, count = 0, a, b, c, sum = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter any integer you want to check:");
        n = s.nextInt();
        a = n;
        c = n;
        while(a > 0)
        {
            a = a / 10;
            count++;
        }
        while(n > 0)
        {
            b = n % 10;
            sum = (int) (sum+Math.pow(b, count));
            n = n / 10;
        }
        if(sum == c)
        {
            System.out.println("Given number is Armstrong");
        }
        else
        {
            System.out.println("Given number is not Armstrong");
        }    
    }
}