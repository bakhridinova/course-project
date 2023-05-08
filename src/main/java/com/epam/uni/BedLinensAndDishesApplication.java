package com.epam.uni;

import com.epam.uni.util.annotation.MethodDescription;
import com.epam.uni.util.format.impl.CommandFormatter;
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
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * main application class
 *
 * @author bakhridinova
 */

@Component
public class BedLinensAndDishesApplication {
    private static final String QUIT_DESCRIPTION =
            "quit";
    private static final String QUIT_COMMAND =
            "q";
    private static final String WELCOME_PAGE_PATH =
            "src/main/resources/static/welcome_page.txt";
    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext("com.epam.uni");

    public static void main(String[] args) {
        BedLinensAndDishesApplication application
                = new BedLinensAndDishesApplication();
        application.run();
    }

    private void run() {
        String lastLine;
        try {
            List<String> lines = Files.readAllLines(Paths.get(WELCOME_PAGE_PATH));
            lastLine = lines.remove(lines.size() - 1);
            lines.forEach(System.out::println);
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
        System.out.println();

        Scanner scanner = context.getBean(Scanner.class);
        while (true) {
            String command = scanner.next().toLowerCase();
            if (command.equalsIgnoreCase(QUIT_COMMAND)) {
                System.out.println(lastLine);
                break;
            }

            if (methodCommands.containsKey(command)) {
                Method method = methodCommands.get(command);
                ReflectionUtils.invokeMethod(method, context.getBean(method.getDeclaringClass()));
                System.out.println();
            } else {
                System.out.println("operation " + command + " is not supported");
                System.out.print("supported operations are: " );
                methodCommands.keySet()
                        .forEach(c -> System.out.print(c + ", "));
                System.out.println(QUIT_COMMAND);
                System.out.println();
            }
        }
    }
}
