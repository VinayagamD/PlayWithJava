package com.vinaylogics.junit5.testtemplate;

import org.junit.jupiter.api.extension.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Stream;

public class UserIdGeneratorTestInvocationContextProvider  implements TestTemplateInvocationContextProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserIdGeneratorTestInvocationContextProvider.class);

    @Override
    public boolean supportsTestTemplate(ExtensionContext context) {
        return true;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
        boolean featureDisabled = false;
        boolean featureEnabled = true;

        return Stream.of(
                featureDisabledContext(
                        new UserIdGeneratorTestCase(
                                "Given feature switch disabled When user name is John Smith Then generated userid is JSmith",
                                featureDisabled,
                                "John",
                                "Smith",
                                "JSmith")),
                featureEnabledContext(
                        new UserIdGeneratorTestCase(
                                "Given feature switch enabled When user name is John Smith Then generated userid is baelJSmith",
                                featureEnabled,
                                "John",
                                "Smith",
                                "checkptJSmith"))
        );
    }



    private TestTemplateInvocationContext featureDisabledContext(UserIdGeneratorTestCase userIdGeneratorTestCase) {
        return new TestTemplateInvocationContext() {
            @Override
            public String getDisplayName(int invocationIndex) {
                return userIdGeneratorTestCase.getDisplayName();
            }

            @Override
            public List<Extension> getAdditionalExtensions() {
                return List.of(
                        new GenericTypedParameterResolver(userIdGeneratorTestCase),
                        new DisabledOnQAEnvironmentExtension(),
                        (BeforeAllCallback) context -> System.out.println("BeforeEachCallback:Enabled context"),
                        (AfterEachCallback) context -> System.out.println("AfterEachCallback:Enabled context")
                );
            }
        };
    }

    private TestTemplateInvocationContext featureEnabledContext(UserIdGeneratorTestCase userIdGeneratorTestCase) {
        return new TestTemplateInvocationContext() {
            @Override
            public String getDisplayName(int invocationIndex) {
                return userIdGeneratorTestCase.getDisplayName();
            }

            @Override
            public List<Extension> getAdditionalExtensions() {
                return List.of(
                        new GenericTypedParameterResolver(userIdGeneratorTestCase),
                        new DisabledOnQAEnvironmentExtension(),
                        (BeforeEachCallback) extensionContext -> LOGGER.debug("BeforeEachCallback:Enabled context"),
                        (AfterEachCallback) extensionContext -> LOGGER.debug("AfterEachCallback:Enabled context"));
            }
        };

    }


}
