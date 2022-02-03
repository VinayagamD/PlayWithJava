package com.vinaylogics.junit5.dynamictests;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicDemoTests {

    @TestFactory
    Collection<DynamicTest> dynamicTestsWithCollection() {
        return Arrays.asList(
                DynamicTest.dynamicTest("Add test",
                        () -> assertEquals(2, Math.addExact(1, 1))),
                DynamicTest.dynamicTest("Multiply Test",
                        () -> assertEquals(4, Math.multiplyExact(2, 2))));
    }
    @TestFactory
    Iterable<DynamicTest> dynamicTestsWithIterable() {
        return Arrays.asList(
                DynamicTest.dynamicTest("Add test",
                        () -> assertEquals(2, Math.addExact(1, 1))),
                DynamicTest.dynamicTest("Multiply Test",
                        () -> assertEquals(4, Math.multiplyExact(2, 2))));
    }

    @TestFactory
    Iterator<DynamicTest> dynamicTestsWithIterator() {
        return Arrays.asList(
                        DynamicTest.dynamicTest("Add test",
                                () -> assertEquals(2, Math.addExact(1, 1))),
                        DynamicTest.dynamicTest("Multiply Test",
                                () -> assertEquals(4, Math.multiplyExact(2, 2))))
                .iterator();
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromIntStream() {
        return IntStream.iterate(0, n -> n + 2).limit(10)
                .mapToObj(n -> DynamicTest.dynamicTest("test" + n,
                        () -> assertEquals(0, n % 2)));
    }


    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {

        // sample input and output
        List<String> inputList = Arrays.asList(
                "www.somedomain.com", "www.anotherdomain.com", "www.yetanotherdomain.com");
        List<String> outputList = Arrays.asList(
                "154.174.10.56", "211.152.104.132", "178.144.120.156");

        // input generator that generates inputs using inputList
        /*...code here...*/
        Iterator<String> inputGenerator = inputList.iterator();

        // a display name generator that creates a
        // different name based on the input
        /*...code here...*/
        Function<String, String> displayNameGenerator
                = (input) -> "Resolving: " + input;

        // the test executor, which actually has the
        // logic to execute the test case
        /*...code here...*/
        DomainNameResolver resolver = new DomainNameResolver();
        ThrowingConsumer<String> testExecutor = (input) -> {
            int id = inputList.indexOf(input);

            assertEquals(outputList.get(id), resolver.resolveDomain(input));
        };
        // combine everything and return a Stream of DynamicTest
        /*...code here...*/
        return DynamicTest.stream(
                inputGenerator, displayNameGenerator, testExecutor);
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStreamInJava8() {

        DomainNameResolver resolver = new DomainNameResolver();

        List<String> domainNames = Arrays.asList(
                "www.somedomain.com", "www.anotherdomain.com", "www.yetanotherdomain.com");
        List<String> outputList = Arrays.asList(
                "154.174.10.56", "211.152.104.132", "178.144.120.156");

        return domainNames.stream()
                .map(dom -> DynamicTest.dynamicTest("Resolving: " + dom,
                        () -> {int id = domainNames.indexOf(dom);

                            assertEquals(outputList.get(id), resolver.resolveDomain(dom));
                        }));
    }
}
