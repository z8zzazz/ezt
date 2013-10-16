/*
 *
 * ezt revision 0110
 *
 * https://github.com/z8zzazz
 *
 * z8zzazz@gmail.com
 *
 * License: http://www.gnu.org/licenses/gpl.html GPL version 2 or higher
 *
 */

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.lang.Long;
import java.lang.String;

public class ezt
{

	private int keyLength = 64;	

	private BigInteger token;
	private BigInteger tokenA;
	private BigInteger tokenB;
	private BigInteger xor;
	private BigInteger x_key;

	private Random rand;

	private Scanner stdin;
	
	public ezt()
	{
			stdin = new Scanner(System.in);
	}
	
	public static void main(String[] args)
	{
		
		ezt e = new ezt();
		e.run();
		
	}
	
	private void run()
	{
			System.out.println("\n"
			                 + "     ezt : easy tripcode"
			                 + " [http://github.com/z8zzazz]\n"
			                 + "     [z8zzazz@gmail.com]     \n");
			System.out.println("Create a new key pair? TRUE/FALSE");
			
			if(stdin.nextBoolean())
			{
				this.createMessage();
				return;
			} else
				this.confirmMessage();
				
	}
	
	private void confirmMessage()
	{
		System.out.println("\n\nPlease enter the value of Token A _____ (ta)");
		tokenA = new BigInteger(stdin.next());
		
		System.out.println("Please enter the value of Crypted Token (ct)");
		x_key = new BigInteger(stdin.next());
		
		System.out.println("Please enter the value of Token B _____ (tb)");
		tokenB = new BigInteger(stdin.next());
		
		System.out.println("Please enter the value of Magic _______ (mm)");
		xor = new BigInteger(stdin.next());

		token = new BigInteger(tokenA.toString() + tokenB.toString());
		
		System.out.println("\n              STATISTICS             ");
		System.out.println("______________________________________\n");
		System.out.println("token A         (ta) : " + tokenA.toString());
		System.out.println("token B         (tb) : " + tokenB.toString());
		System.out.println("magic           (mm) : " + xor.toString());
		System.out.println("crypted token   (ct) : " + x_key.toString());
		
		System.out.println("\n\nVERDICT ______________________________\n");
		System.out.println("Identity status: "
						+	(token.toString()).equals(x_key.xor(xor).toString()) + "\n");
		
		System.out.println("full token      (ft) : " + 
token.toString());
		System.out.println("decrypted token (dt) : " + x_key.xor(xor).toString());
		
		System.out.println("\nThe two numbers above should match if the identity is the same\n");
	}

	private void createMessage()
	{
		
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		tokenA 	= new BigInteger(keyLength, rand);
		tokenB 	= new BigInteger(keyLength, rand);
		xor 		= new BigInteger(keyLength * 2, rand);
		
		token = new BigInteger(tokenA.toString() + tokenB.toString());
		
		System.out.println("\n              STATISTICS             ");
		System.out.println("______________________________________\n");
		System.out.println("token A         (ta) : " + tokenA.toString());
		System.out.println("token B         (tb) : " + tokenB.toString());
		System.out.println("full token      (ft) : " + token.toString());
		System.out.println("magic           (mm) : " + xor.toString());
		
		x_key 	= new BigInteger(token.xor(xor).toString());
		
		System.out.println("crypted token   (ct) : " + x_key.toString());
		System.out.println("decrypted token (dt) : " + x_key.xor(xor).toString());
		
		System.out.println("\nYou must chain your posts together.\n"
							+ "You MUST create a new key system every TWO posts.\n"
							+ "In every first post of your two post pair, "
							+ "include this info:\n");
							
		System.out.println("(ta)" + tokenA.toString());
		System.out.println("(ct)" + x_key.toString());
		
		System.out.println("\nIn your second post, include this info:\n");
		
		System.out.println("(tb)" + tokenB.toString());
		System.out.println("(mm)" + xor.toString() + "\n");
		
		System.out.println("After you have posted this last bit, you must create\n"
							  + "a new (ta) and (ct) and figure out how to chain your\n"
							  + "posts together. NEVER EVER RE-USE ANY NUMBER."); 
	}
	
}
