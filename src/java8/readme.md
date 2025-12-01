# What's new in Java 8

This short README summarizes the most important additions and changes introduced in Java 8, with tiny examples to get you started.

## Highlights

- Lambda expressions — concise function literals that reduce boilerplate and enable functional-style operations.
- Functional interfaces — single-abstract-method interfaces (use `@FunctionalInterface` to signal intent).
- Method references — shorthand for lambdas (e.g., `String::toUpperCase`).
- Streams API — declarative, fluent processing of sequences with operations like `map`, `filter`, `flatMap`, `reduce` and easy parallelism.
- Primitive streams — `IntStream`, `LongStream`, `DoubleStream` to avoid boxing overhead.
- Collectors — utilities for reductions and mutable reductions (`toList`, `toMap`, `groupingBy`, `partitioningBy`, `joining`).
- Optional — a container object to represent nullable values and encourage explicit handling of absence.
- java.time (JSR-310) — a modern, immutable date/time API (`LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`, `Instant`, `Duration`, `Period`).
- Default and static methods in interfaces — add behavior to interfaces without breaking existing implementations.
- CompletableFuture & improved concurrency utilities — async composition and non-blocking flows.
- Nashorn JavaScript engine — embedding and running JavaScript from the JVM.
- Utility additions — `Arrays.parallelSort`, `Base64` encoding/decoding, `Comparator` helpers, `ConcurrentHashMap` improvements.

---

## Quick examples

### 1) Lambdas, method references and Streams

This example filters names longer than 3 characters, converts them to uppercase, and joins them into a single string. It also demonstrates an `IntStream` usage.

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("anna", "bob", "carol", "dave");

        String result = names.stream()
            .filter(s -> s.length() > 3)   // lambda
            .map(String::toUpperCase)      // method reference
            .collect(Collectors.joining(","));

        System.out.println(result); // CAROL,DAVE

        int totalLength = names.stream()
            .mapToInt(String::length)    // IntStream avoids boxing
            .sum();

        System.out.println(totalLength); // 14
    }
}
```

### 2) Optional — avoid null checks

```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> maybe = Optional.ofNullable(getName());

        // provide default, transform and consume
        String result = maybe.map(String::toUpperCase)
                             .orElse("UNKNOWN");

        System.out.println(result);
    }

    static String getName() { return null; }
}
```

### 3) java.time — the modern Date/Time API

```java
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());

        System.out.println("Today: " + today);
        System.out.println("Now: " + now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}
```

---

## Common migration notes & tips

- Use `@FunctionalInterface` to mark intent when creating single-method interfaces.
- Prefer `Stream` operations for collection processing — they read declaratively and are easy to parallelize with `.parallelStream()` (but always measure before switching to parallel).
- Replace old `Date`/`Calendar` usages with `java.time` classes for clearer, immutable operations.
- Use `Optional` for return types where `null` is a meaningful absence, but avoid wrapping fields or collections unnecessarily.
- Watch for checked exceptions inside lambda bodies — you may need helper wrappers or to rework the lambda into a method reference to a method that handles exceptions.

---

## Further reading

- Oracle Java 8 release notes and tutorials
- JSR-310 (java.time) specification and user guide
- Streams and lambda cookbook (examples and best practices)



// End of file

