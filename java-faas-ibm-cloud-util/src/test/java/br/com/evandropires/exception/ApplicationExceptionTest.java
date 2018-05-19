package br.com.evandropires.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by evandro on 15/05/18.
 */
@RunWith(JUnit4.class)
public class ApplicationExceptionTest {

    @Test(expected = ApplicationException.class)
    public void simpleConstructor() throws ApplicationException {
        throw new ApplicationException();
    }

    @Test(expected = ApplicationException.class)
    public void messageConstructor() throws ApplicationException {
        throw new ApplicationException("Some message");
    }

    @Test(expected = ApplicationException.class)
    public void messageAndCauseConstructor() throws ApplicationException {
        throw new ApplicationException("Some message", new NullPointerException());
    }

    @Test(expected = ApplicationException.class)
    public void causeConstructor() throws ApplicationException {
        throw new ApplicationException(new NullPointerException());
    }

}
