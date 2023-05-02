package com.epam.uni;

import com.epam.uni.format.CommandFormatter;
import com.epam.uni.util.method.MethodDescription;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * main application class
 *
 * @author bakhridinova
 */

@Component
public class BedclothesAndDishwashersApplication {
    private static final String QUIT_DESCRIPTION =
            "quit";
    private static final String QUIT_COMMAND =
            "q";
    private static final String WELCOME_PAGE_PATH =
            "src/main/resources/static/welcome_page.txt";
    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext("com.epam.uni");

    public static void main(String[] args) {
        BedclothesAndDishwashersApplication application
                = new BedclothesAndDishwashersApplication();
        application.run();
    }

    private void run() {
        try {
            Files.readAllLines(Paths.get(WELCOME_PAGE_PATH))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(CommandFormatter.header());
        Map<String, Method> methodCommands = new HashMap<>();
        context.getBeansWithAnnotation(Controller.class).values().stream()
                .flatMap(controller -> Arrays.stream(controller.getClass().getMethods()))
                .filter(method1 -> method1.isAnnotationPresent(MethodDescription.class)).toList().stream()
                .map(method -> {
                    MethodDescription annotation = method.getAnnotation(MethodDescription.class);
                    methodCommands.put(annotation.command(), method);
                    return annotation;})
                .map(annotation -> CommandFormatter.format(annotation.value(), annotation.command()))
                .sorted().forEach(System.out::print);
        System.out.print(CommandFormatter.format(QUIT_DESCRIPTION, QUIT_COMMAND));
        System.out.println(CommandFormatter.footer());

        while (true) {
            Scanner scanner = context.getBean(Scanner.class);
            String command = scanner.next();
            if (command.equals(QUIT_COMMAND)) {
                System.out.println("it was nice to be with you ^^");
                break;
            }

            if (methodCommands.containsKey(command)) {
                Method method = methodCommands.get(command);
                ReflectionUtils.invokeMethod(method, context.getBean(method.getDeclaringClass()));
            } else {
                throw new UnsupportedOperationException("operation " + command + " is not supported");
            }
        }
    }
}
