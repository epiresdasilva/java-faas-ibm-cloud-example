package br.com.evandropires.cloudant;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by evandro on 15/05/18.
 */
@RunWith(JUnit4.class)
public class CloudantCredentialsTest {

    @Test
    public void getCredentials() {
        Assert.assertNotNull(new CloudantCredentials().getCredentials());
    }

    @Test(expected = NullPointerException.class)
    public void getCredentialsError() {
        Assert.assertEquals("", new CloudantCredentials(null).getCredentials());
    }

}
