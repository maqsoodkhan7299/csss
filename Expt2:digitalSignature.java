import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import sun.misc.BASE64Encoder;

class Expt2b
{
public static void main(String[] args) throws Exception
	{
	KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
	kpg.initialize(1024);
	KeyPair keyPair = kpg.genKeyPair();
	byte[] data = "test".getBytes("UTF8");
	Signature sig = Signature.getInstance("MD5WithRSA");
	sig.initSign(keyPair.getPrivate());
	sig.update(data);
	byte[] signatureBytes = sig.sign();
	System.out.println();
	System.out.println("Singature:" );
	System.out.println(new BASE64Encoder().encode(signatureBytes));
	sig.initVerify(keyPair.getPublic()); sig.update(data);
	System.out.println();
	System.out.println(sig.verify(signatureBytes));
	}
}
