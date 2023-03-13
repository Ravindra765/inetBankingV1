package listeners;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class Login {
@Test
void loginByEmail() {
System.out.println("Login by Email");
Assert.assertEquals("ABC", "ABC"); //true
}
@Test
void loginByFacebook() {
	System.out.println("Login by Facebook");
	Assert.assertEquals("ABC", "ABCD");
}
}
