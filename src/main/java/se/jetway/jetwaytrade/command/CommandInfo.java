package se.jetway.jetwaytrade.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to provide information about a command.
 * This annotation can be applied to classes representing commands.
 *
 * <p>Example Usage:</p>
 * <pre>
 * {@literal @}CommandInfo(commandName = "example", permission = "example.permission", description = "An example command.")
 * public class ExampleCommand implements CommandExecutor {
 *     // Command implementation here
 * }
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandInfo {

    /**
     * The name of the command.
     *
     * @return The command name.
     */
    String commandName();

    /**
     * The required permission to execute the command.
     *
     *
     * @return The command permission. Defaults to an empty string if not specified.
     */
    String permission() default "";

    /**
     * A brief description of what the command does.
     *
     * @return The command description. Defaults to an empty string if not specified.
     */
    String description() default "";

}
