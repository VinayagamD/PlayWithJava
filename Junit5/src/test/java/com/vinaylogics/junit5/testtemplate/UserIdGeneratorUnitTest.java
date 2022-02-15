package com.vinaylogics.junit5.testtemplate;

import com.vinaylogics.junit5.templates.UserIdGenerator;
import com.vinaylogics.junit5.templates.UserIdGeneratorImpl;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserIdGeneratorUnitTest {

    @TestTemplate
    @ExtendWith(UserIdGeneratorTestInvocationContextProvider .class)
    public void testWhenIdRequested_thenUserIdIsReturnedInCorrectFormat(UserIdGeneratorTestCase testCase){
        UserIdGenerator userIdGenerator = new UserIdGeneratorImpl(testCase.isFeatureEnabled());

        String actualUserId = userIdGenerator.generate(testCase.getFirstName(), testCase.getLastName());

        assertEquals(actualUserId,testCase.getExpectedUserId());
    }
}
