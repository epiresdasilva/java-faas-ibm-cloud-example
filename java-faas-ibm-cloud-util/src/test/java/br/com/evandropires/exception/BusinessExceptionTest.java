package br.com.evandropires.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by evandro on 15/05/18.
 */
@RunWith(JUnit4.class)
public class BusinessExceptionTest {

    @Test(expected = BusinessException.class)
    public void simpleConstructor() throws BusinessException {
        throw new BusinessException();
    }

    @Test(expected = BusinessException.class)
    public void messageConstructor() throws BusinessException {
        throw new BusinessException("Some message");
    }

    @Test(expected = BusinessException.class)
    public void messageAndCauseConstructor() throws BusinessException {
        throw new BusinessException("Some message", new NullPointerException());
    }

    @Test(expected = BusinessException.class)
    public void causeConstructor() throws BusinessException {
        throw new BusinessException(new NullPointerException());
    }

}
