package com.vinaylogics.junit5.extension;

import com.vinaylogics.junit5.registerextension.LoggingExtension;
import com.vinaylogics.junit5.registerextension.RegisterExtensionSampleExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class RegisterExtensionTest {

    @RegisterExtension
    static RegisterExtensionSampleExtension staticExtension = new RegisterExtensionSampleExtension("static version");

    @RegisterExtension
    RegisterExtensionSampleExtension instanceLevelExtension = new RegisterExtensionSampleExtension("instance version");

    @Test
    public void demoTest() {
        Assertions.assertEquals("instance version", instanceLevelExtension.getType());
    }
}
